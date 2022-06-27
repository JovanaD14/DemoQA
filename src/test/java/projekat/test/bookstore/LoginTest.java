package projekat.test.bookstore;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekat.base.BasePage;

public class LoginTest extends BasePage {

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {

        loginPage.goToLoginPage();
        Thread.sleep(2000);
    }


    @Test (priority = 0)
    public void SuccessfulLogin() throws InterruptedException {
        loginPage.getUserNameField().sendKeys(loginPage.getValidUsername());
        loginPage.getPasswordField().sendKeys(loginPage.getValidPassword());
        loginPage.getLoginButton().click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),profilePage.urlProfile);
        profilePage.getLogoutButton().click();

    }

    @Test(priority = 1)
    public void InvalidUsernameValidPassword() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getUserNameField().sendKeys(loginPage.getInvalidUsername());
        loginPage.getPasswordField().sendKeys(loginPage.getValidPassword());
        loginPage.getLoginButton().click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Invalid username or password!");
    }
        @Test(priority = 2)
        public void ValidUsernameInvalidPassword() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getUserNameField().sendKeys(loginPage.getValidUsername());
        loginPage.getPasswordField().sendKeys(loginPage.getInvalidPassword());
        loginPage.getLoginButton().click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/login");
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(),"Invalid username or password!");
    }

    @Test(priority = 3)
    public void clickNewUserButton() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getNewUserButton().click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/register");
        Thread.sleep(1000);
    }

    @Test(priority = 4)
    public void UnsuccessfulLoginInvalidButton() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.getUserNameField().sendKeys(loginPage.getValidUsername());
        loginPage.getPasswordField().sendKeys(loginPage.getValidPassword());
        loginPage.getNewUserButton().click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/register");
    }


}
