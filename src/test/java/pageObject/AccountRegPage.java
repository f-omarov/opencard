package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegPage extends BasePage {

    public AccountRegPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtlastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtPhone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtPwdConfirm;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkBoxAgree;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement txtMessage;


    public void setName(String name) {
        txtFirstName.sendKeys(name);
    }

    public void setLastName(String lastName) {
        txtlastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setPhone(String phone) {
        txtPhone.sendKeys(phone);
    }

    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void confirmPwd(String password) {
        txtPwdConfirm.sendKeys(password);
    }

    public void agree() {
        checkBoxAgree.click();
    }

    public void continueBtn() {
        btnContinue.click();
    }


    public String checkSuccess() {
        try {
            return txtMessage.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
