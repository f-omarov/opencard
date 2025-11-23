package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegPage;
import pageObject.HomePage;
import baseTest.BaseClass;

public class TC01_AccountRegistration extends BaseClass {


    @Test (groups = {"Regression", "Master","Grid"})
    public void accountRegistration() {
        try {
            logger.info("***** testing started ****");


            HomePage home = new HomePage(driver);
            home.accountClick();
            home.registerClick();

            AccountRegPage regPage = new AccountRegPage(driver);
            logger.info("Providing customer details");
            regPage.setName(randomString().toUpperCase());
            regPage.setLastName(randomString().toUpperCase());
            regPage.setEmail(randomString() + "@yahoo.com");
            regPage.setPhone("+99566232123");
            String randomPassword = randomAlphaNumber();
            regPage.setPassword(randomPassword);
            regPage.confirmPwd(randomPassword);
            regPage.agree();
            regPage.continueBtn();
            String confirmMsg = regPage.checkSuccess();
            Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
        } catch (Exception e) {
            logger.error("Test failed");
            logger.debug("Debug");
            Assert.fail();
        }
    }


}
