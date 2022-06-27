package projekat.pages.bookStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import projekat.base.BasePage;

public class Login extends BasePage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public final String urlLogin = "https://demoqa.com/login";

    By usernameField = By.id("userName");
    By passwordField = By.id("password");
    By loginButton = By.id("login");
    By newUserButton = By.id("newUser");
    By errorMessage = By.cssSelector("p[class=\"mb-1\"]");


    public Login(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void goToLoginPage(){
        driver.navigate().to(urlLogin);
    }

    public String getValidUsername(){
        return "JovanaD";
    }
    public String getValidPassword(){
        return "Testdemoqa12!";
    }
    public String getInvalidUsername(){
        return "Jovana";
    }
    public String getInvalidPassword(){
        return "TEST12?";
    }
    public WebElement getUserNameField(){
        return driver.findElement(usernameField);
    }

    public WebElement getPasswordField(){
        return driver.findElement(passwordField);
    }

    public WebElement getLoginButton(){
        return driver.findElement(loginButton);
    }
    public WebElement getNewUserButton(){
        return driver.findElement(newUserButton);
    }
    public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
    }

    public void login(){
        goToLoginPage();
        getUserNameField().sendKeys(getValidUsername());
        getPasswordField().sendKeys(getValidPassword());
        getLoginButton().click();
    }


}
