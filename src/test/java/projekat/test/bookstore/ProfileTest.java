package projekat.test.bookstore;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekat.base.BasePage;

import java.util.List;

public class ProfileTest extends BasePage {



    @Test(priority = 4)
    public void logout() throws InterruptedException {
        loginPage.login();
        Thread.sleep(2000);
        profilePage.getLogoutButton().click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),loginPage.urlLogin);
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }

    @Test(priority = 0)
    public void goToStoreButton() throws InterruptedException {
        loginPage.login();
        Thread.sleep(2000);
        scrollDown(By.id("gotoStore"));
        profilePage.getGoToStoreButton().click();
        Assert.assertEquals(driver.getCurrentUrl(),bookStorePage.urlStore);
    }

    @Test(priority = 1)
    public void addBook() throws InterruptedException {
        Thread.sleep(2000);
        goToStoreButton();
        Thread.sleep(2000);
        WebElement e = bookStorePage.getLinksList().get(0);
        e.click();
        Thread.sleep(2000);
        scrollDown(By.xpath("//*[@id=\"addNewRecordButton\"]"));
        bookStorePage.getAddToCollectionButton().click();
        wdwait.until(ExpectedConditions.alertIsPresent());
        String s = driver.switchTo().alert().getText();
        System.out.println(s);
        driver.switchTo().alert().accept();
        Assert.assertTrue(s.equals("Book added to your collection.")||(s.equals("Book already present in the your collection!")));
        profilePage.goToProfilePage();
        Thread.sleep(4000);
        Assert.assertEquals(bookStorePage.getLinksList().size(),1);
    }

    @Test(priority = 2)
    public void DeleteBook() throws InterruptedException {
        addBook();
        WebElement delete = driver.findElement(By.id("delete-record-undefined"));
        delete.click();
        wdwait.until(ExpectedConditions.presenceOfElementLocated(By.id("closeSmallModal-ok")));
        Thread.sleep(2000);
        driver.findElement(By.id("closeSmallModal-ok")).click();
        wdwait.until(ExpectedConditions.alertIsPresent());
        String message = driver.switchTo().alert().getText();
        Assert.assertEquals(message, "Book deleted.");
    }






}
