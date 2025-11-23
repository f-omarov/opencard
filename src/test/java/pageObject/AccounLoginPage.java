package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccounLoginPage extends BasePage {
    public AccounLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccount;


    public  boolean verfiyAccount() {
        try {
            return myAccount.isDisplayed();
        }catch (Exception e) {
            return false;
        }
    }
}
