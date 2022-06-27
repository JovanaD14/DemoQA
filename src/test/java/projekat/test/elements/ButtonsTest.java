package projekat.test.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekat.base.BasePage;

import java.util.List;

public class ButtonsTest extends BasePage {



    @BeforeMethod
    public void beforeMethod() {
        buttonsPage.goToButtonsPage();
        wdwait.until(ExpectedConditions.urlMatches(buttonsPage.urlButtons));
    }

    @Test
    public void clickDoubleClickButton() {

        Actions actions = new Actions(driver);
        actions.moveToElement(buttonsPage.getDoubleClickButton()).doubleClick().build().perform();
        Assert.assertTrue(buttonsPage.getDoubleClickMessage().isDisplayed());
        Assert.assertEquals(buttonsPage.getDoubleClickMessage().getText(),"You have done a double click");
    }

    @Test
    public void clickRightClickButton(){

        Actions actions = new Actions(driver);
        actions.moveToElement(buttonsPage.getRightClickButton()).contextClick().build().perform();
        Assert.assertTrue(buttonsPage.getRightClickMessage().isDisplayed());
        Assert.assertEquals(buttonsPage.getRightClickMessage().getText(),"You have done a right click");
    }

    @Test
    public void clickClickButton() {

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button")).click();
        Assert.assertTrue(buttonsPage.getClickMessage().isDisplayed());
        Assert.assertEquals(buttonsPage.getClickMessage().getText(),"You have done a dynamic click");
    }


}
