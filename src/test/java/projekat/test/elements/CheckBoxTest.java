package projekat.test.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekat.base.BasePage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckBoxTest extends BasePage {
    @BeforeMethod
    public void beforeMethod(){

        checkBoxPage.goToCheckBoxPage();
        wdwait.until(ExpectedConditions.urlMatches(checkBoxPage.urlCheckBox));
    }
    @Test
    public void checkHomeOption() {

        checkBoxPage.getCheckHomeBox().click();
        checkBoxPage.getListOfCheckedOptions();
        assertEquals(checkBoxPage.getListOfCheckedOptions().size(), 17);
    }

    @Test
    public void uncheckHomeOption() {

        checkHomeOption();
        checkBoxPage.getCheckHomeBox().click();
        assertEquals(checkBoxPage.getListOfCheckedOptions().size(), 0);
    }

    @Test
    public void checkExpandButton() {

        checkBoxPage.getExpandButton().click();
        assertTrue(driver.findElement(By.cssSelector("li[class=\"rct-node rct-node-parent rct-node-expanded\"]")).isDisplayed());
    }
    @Test
    public void checkCollapseAllButton() {

        checkBoxPage.getCollapseAllButton().click();
        List<WebElement> list = driver.findElements(By.cssSelector("li[class=\"rct-node rct-node-parent rct-node-expanded\"]"));
        assertEquals(list.size(), 0);
    }

    @Test
    public void checkExpandCloseIconFirstUsage() {

        checkBoxPage.getExpandCloseIconFirstUsage().click();
        assertTrue(driver.findElement(By.cssSelector("li[class=\"rct-node rct-node-parent rct-node-expanded\"]")).isDisplayed());
    }

    @Test
    public void checkExpandCloseIconSecondUsage() {

        checkExpandCloseIconFirstUsage();
        checkBoxPage.getExpandCloseIconSecondUsage().click();
        List<WebElement> list = driver.findElements(By.cssSelector("li[class=\"rct-node rct-node-parent rct-node-expanded\"]"));
        assertEquals(list.size(), 0);
    }

    @Test
    public void checkDesktopDocumentAndDownloadsBox(){

        checkExpandCloseIconFirstUsage();
        checkBoxPage.getDesktopCheckBox().click();
        checkBoxPage.getListOfCheckedOptions();
        assertEquals(checkBoxPage.getListOfCheckedOptions().size(), 3);
        checkBoxPage.getDocumentsCheckBox().click();
        assertEquals(checkBoxPage.getListOfCheckedOptions().size(), 13);
        checkBoxPage.getDownloadsCheckBox().click();
        assertEquals(checkBoxPage.getListOfCheckedOptions().size(), 17);
        checkBoxPage.getDownloadsCheckBox().click();
        checkBoxPage.getDocumentsCheckBox().click();
        checkBoxPage.getDesktopCheckBox().click();
        assertEquals(checkBoxPage.getListOfCheckedOptions().size(), 0);
        checkBoxPage.getExpandCloseIconSecondUsage().click();
        List<WebElement> list = driver.findElements(By.cssSelector("li[class=\"rct-node rct-node-parent rct-node-expanded\"]"));
        assertEquals(list.size(), 0);
    }





}
