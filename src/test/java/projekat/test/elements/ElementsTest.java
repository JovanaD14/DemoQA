package projekat.test.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekat.base.BasePage;

public class ElementsTest extends BasePage {

@BeforeMethod
public void goToElementsPage(){
    driver.navigate().to(elementsPage.url1);
    Assert.assertEquals(driver.getCurrentUrl(),elementsPage.url1);
}

    @Test(priority = 1)
    public void goToTextBox() throws InterruptedException {
        scrollDown(By.xpath("//*[@id=\"item-0\"]"));
        Thread.sleep(2000);
        elementsPage.chooseTextBox();
        Assert.assertEquals(driver.getCurrentUrl(),textBoxPage.urlTextBox);
    }

    @Test(priority = 2)
    public void goToCheckBox(){
        elementsPage.chooseCheckBox();
        Assert.assertEquals(driver.getCurrentUrl(),checkBoxPage.urlCheckBox);
    }
    @Test(priority = 3)
    public void goToRadioButton() throws InterruptedException {
        scrollDown(By.xpath("//*[@id=\"item-2\"]"));
        Thread.sleep(2000);
        elementsPage.chooseRadioButton();
        Assert.assertEquals(driver.getCurrentUrl(),radioButtonPage.urlRadioButton);
    }
    @Test(priority = 4)
    public void goToWebTables() throws InterruptedException {
        scrollDown(By.xpath("//*[@id=\"item-3\"]"));
        Thread.sleep(2000);
        elementsPage.chooseWebTables();
        Assert.assertEquals(driver.getCurrentUrl(),webTablePage.urlWebTables);
    }
    @Test(priority = 5)
    public void goToButtons() throws InterruptedException {
        scrollDown(By.xpath("//*[@id=\"item-4\"]"));
        Thread.sleep(2000);
        elementsPage.chooseButtons();
        Assert.assertEquals(driver.getCurrentUrl(),buttonsPage.urlButtons);
    }

    @Test(priority = 6)
    public void goToLinks() throws InterruptedException {
        scrollDown(By.xpath("//*[@id=\"item-6\"]/span"));
        Thread.sleep(2000);
        elementsPage.chooseLinks();
        Assert.assertEquals(driver.getCurrentUrl(),linksPage.urlLinks);
    }

    @Test(priority = 7)
    public void goToBrokenLinksImages() throws InterruptedException {
        scrollDown(By.xpath("//*[@id=\"item-6\"]/span"));
        Thread.sleep(2000);
        elementsPage.chooseBrokenLinksImages();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/broken");
    }
    @Test(priority = 8)
    public void goToUploadDownload() throws InterruptedException {
        scrollDown(By.xpath("//*[@id=\"item-7\"]/span"));
        Thread.sleep(2000);
        elementsPage.chooseUploadDownload();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/upload-download");
    }
    @Test
    public void goToDynamicProperties() throws InterruptedException {
        scrollDown(By.xpath("//*[@id=\"item-7\"]/span"));
        Thread.sleep(2000);
        elementsPage.chooseDynamicProperties();
        Assert.assertEquals(driver.getCurrentUrl(),dynamicPropertiesPage.urlDynamicProperties);
    }




}
