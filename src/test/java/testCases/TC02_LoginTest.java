package testCases;

import baseTest.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccounLoginPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class TC02_LoginTest extends BaseClass {

    @Test(groups = {"Sanity", "Master", "Grid"})
    public void verifyLogin() {
        try {
            logger.info("Test case 2 started");

            HomePage home = new HomePage(driver);
            home.accountClick();
            home.loginClick();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmail(p.getProperty("email"));
            loginPage.setPwd(p.getProperty("password"));
            loginPage.clickLogin();

            AccounLoginPage accounLoginPage = new AccounLoginPage(driver);
            boolean verifyPage = accounLoginPage.verfiyAccount();
            Assert.assertEquals(verifyPage, true, "Login failed");

        }catch (Exception e) {
            Assert.fail();
        }
        logger.info("***** execution of test case 2 finished");
    }
}
