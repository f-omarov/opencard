package baseTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public Logger logger;
    public Properties p;


    @BeforeClass(groups = {"Sanity","Regression","Master","Grid"})
    @Parameters({"os","browser"})
    public void setup(String os, String br) throws IOException {

        FileReader newFile = new FileReader("./src/test//resources//config.properties");
        p = new Properties();
        p.load(newFile);

        logger = LogManager.getLogger(this.getClass());

        if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            if(os.equalsIgnoreCase("MacOS")) {
                capabilities.setPlatform(Platform.MAC);
            } else if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WINDOWS);
            }
            else if (os.equalsIgnoreCase("Linux")) {
                    capabilities.setPlatform(Platform.LINUX);
            }else {
                System.out.println("No matching os");
                return;
            }

            switch (br.toLowerCase()){
                case "chrome": capabilities.setBrowserName("chrome"); break;
                case "mozilla": capabilities.setBrowserName("firefox"); break;
                default:
                    System.out.println("No matching os"); return;
            }

            driver = new RemoteWebDriver(new URL(" http://localhost:4444/wd/hub"), capabilities);
        }


        if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (br.toLowerCase()) {
                case "chrome": driver = new ChromeDriver(); break;
                case "mozilla": driver = new FirefoxDriver(); break;
                default:
                    System.out.println("No matching browser"); return;
            }
        }


        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("defaultUrl"));
        driver.manage().window().maximize();
    }

    @AfterClass (groups = {"Sanity","Regression","Master","Grid"})
    public void tearDown() {
        driver.quit();
    }


    public String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }

    public String randomAlphaNumber() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        String generatedNumeric = RandomStringUtils.randomAlphanumeric(5);
        return generatedString+"@"+generatedNumeric;
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }
}
