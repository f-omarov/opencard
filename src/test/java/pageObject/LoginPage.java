package pageObject;

import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//input[@value = 'Login']")
    WebElement loginBtn;

    public void setEmail(String mail) {
        email.sendKeys(mail);
    }

    public void setPwd(String pwd) {
        password.sendKeys(pwd);
    }

    public void clickLogin() {
        loginBtn.click();
    }


}
