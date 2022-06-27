package projekat.test.bookstore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekat.base.BasePage;

import java.util.List;

public class BookstoreTest extends BasePage {

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {

        bookStorePage.goToBookStore();
        Thread.sleep(2000);
    }

    @Test
    public void testSearchBox(){

        bookStorePage.getSearchBox().sendKeys(bookStorePage.getLinkTextForSearch());
        String actual = bookStorePage.listOfFieldsInsideRow(0).get(1).getText();
        Assert.assertEquals(actual, bookStorePage.getLinkTextForSearch());
    }

    @Test
    public void chooseRowsPerPage() {

        Select numberOfRowsPerPage = new Select(bookStorePage.getRowsPerPageField());
        List<WebElement> list = numberOfRowsPerPage.getOptions();
        System.out.println(list.get(0).getText());
        for (int i = 0; i < list.size() - 1; i++) {
            numberOfRowsPerPage.selectByIndex(i);
            if (i == 0) {
                int number = Character.getNumericValue((list.get(i).getText()).charAt(0));
                Assert.assertEquals(bookStorePage.listOfRowsPerPage().size(), number);
            } else {
                int number = Integer.parseInt(list.get(i).getText().substring(0, 2));
                Assert.assertEquals(bookStorePage.listOfRowsPerPage().size(), number);
            }
        }
    }

    @Test
    public void checkBookLinks() throws InterruptedException {

        for (int i = 0; i < bookStorePage.getLinksList().size(); i++) {
            WebElement e = bookStorePage.getLinksList().get(i);
            String s1 = e.findElement(By.tagName("a")).getAttribute("href");
            e.click();
            Assert.assertEquals(driver.getCurrentUrl(), s1);
        }
    }

    @Test
    public void LinksConnectToChosenBooks() throws InterruptedException {

        for (int i = 0; i < bookStorePage.getLinksList().size(); i++) {
            WebElement e = bookStorePage.getLinksList().get(i);
            String s1 = e.findElement(By.tagName("a")).getAttribute("href");
            System.out.println(s1);
            e.click();
            Thread.sleep(2000);
            Assert.assertEquals(driver.getCurrentUrl(), s1);
            String isbn = bookStorePage.getVerificationList().get(0).getText();
            System.out.println(isbn);
            Assert.assertTrue(s1.contains(isbn));
            }
        }

    @Test
    public void testBackToStoreButton() throws InterruptedException {

        WebElement e = bookStorePage.getLinksList().get(0);
        String s = e.findElement(By.tagName("a")).getAttribute("href");
        Thread.sleep(2000);
        e.click();
        Assert.assertEquals(driver.getCurrentUrl(),s);
        scrollDown(By.xpath("//*[@id=\"addNewRecordButton\"]"));
        bookStorePage.getBackToStoreButton().click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),bookStorePage.urlStore);
    }


    }


