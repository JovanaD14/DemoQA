package projekat.test.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekat.base.BasePage;

import java.time.Duration;
import java.util.List;

public class DynamicPropertiesTest extends BasePage {

    @BeforeMethod
    public void beforeMethod(){
        dynamicPropertiesPage.goToDynamicPropertiesPage();
    }

    @Test
    public void checkTextWithRandomID() {

        dynamicPropertiesPage.getTextWithRandomID().click();
        String s1 = dynamicPropertiesPage.getTextWithRandomID().getAttribute("id");
        driver.navigate().to(dynamicPropertiesPage.urlDynamicProperties);
        String s2 = dynamicPropertiesPage.getTextWithRandomID().getAttribute("id");
        Assert.assertFalse(s1.equals(s2));
    }

    @Test
    public void checkEnableAfterButton(){

        wdwait.until(ExpectedConditions.visibilityOf(dynamicPropertiesPage.getEnableAfterButton()));
        double start = System.currentTimeMillis();
        wdwait.until(ExpectedConditions.elementToBeClickable(dynamicPropertiesPage.getEnableAfterButton()));
        double finish = System.currentTimeMillis();
        double time = finish - start;
        System.out.println(time);
        Assert.assertTrue(time>1500);
        dynamicPropertiesPage.getEnableAfterButton().click();
    }

    @Test
    public void checkVisibleAfterButton() throws InterruptedException {

        Thread.sleep(2000);
        List<WebElement>list = driver.findElements(By.id("visibleAfter"));
        Assert.assertEquals(list.size(), 0);
        double start = System.currentTimeMillis();
        wdwait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter")));
        double finish = System.currentTimeMillis();
        double time = finish - start;
        System.out.println(time);
        Assert.assertTrue(time>1500);
    }

    @Test
    public void checkColorChangeButton(){

        Assert.assertTrue(dynamicPropertiesPage.getColorChangeButton().isDisplayed());
        String s1 = dynamicPropertiesPage.getColorChangeButton().getAttribute("class");
        Assert.assertEquals(s1,"mt-4 btn btn-primary");
        wdwait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter")));
        String s2 = dynamicPropertiesPage.getColorChangeButton().getAttribute("class");
        Assert.assertEquals(s2,"mt-4 text-danger btn btn-primary");
    }
}
