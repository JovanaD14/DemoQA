package projekat.test.bookstore;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import projekat.base.BasePage;

public class BookStoreAppTest extends BasePage {

    @BeforeTest
    public void beforeTest(){

    }

    @Test
    public void clickLoginPageButton() throws InterruptedException {
        bookStoreAppPage.goToBookStoreApplication();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bookStoreAppPage.getLoginPageButton().click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/login");
    }

    @Test
    public void clickBookStoreButton() throws InterruptedException {
        bookStoreAppPage.goToBookStoreApplication();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bookStoreAppPage.getBookStoreButton().click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/books");
    }

    @Test
    public void clickProfileButton() throws InterruptedException {
        bookStoreAppPage.goToBookStoreApplication();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bookStoreAppPage.getProfileButton().click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/profile");
    }

    @Test
    public void clickBookStoreAPIButton() throws InterruptedException {
        bookStoreAppPage.goToBookStoreApplication();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bookStoreAppPage.getBookStoreAPIButton().click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/swagger/");
    }

}
