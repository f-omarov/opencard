package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement account;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement register;

    @FindBy(linkText = "Login")
    WebElement login;

    public void accountClick() {
        account.click();
    }

    public void registerClick() {
        register.click();
    }

    public void loginClick() {
        login.click();
    }
}
