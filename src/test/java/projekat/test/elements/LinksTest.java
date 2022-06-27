package projekat.test.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekat.base.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LinksTest extends BasePage {

    @BeforeMethod
   public void beforeMethod() {
        linksPage.goToLinksPage();
        wdwait.until(ExpectedConditions.urlMatches(linksPage.urlLinks));
    }

    @Test
    public void checkSimpleHomeLink() throws InterruptedException {

        linksPage.getSimpleHomeLink().click();
        Set<String> tabs = driver.getWindowHandles();
        ArrayList<String> listOfTabs = new ArrayList<>(tabs);
        driver.switchTo().window(listOfTabs.get(1));
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
        driver.switchTo().window(listOfTabs.get(0));
    }

    @Test
    public void checkDynamicHomeLink() {

        linksPage.getDynamicHomeLink().click();
        Set<String> tabs = driver.getWindowHandles();
        ArrayList<String> listOfTabs = new ArrayList<>(tabs);
        driver.switchTo().window(listOfTabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
        driver.switchTo().window(listOfTabs.get(0));
    }

    @Test
    public void checkLinksThatSendAPICall() throws InterruptedException {

        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < linksPage.getListOfLinksThatSendAnAPICall().size(); i++) {
            scrollDown(By.xpath("//*[@id=\"bad-request\"]"));
            linksPage.getListOfLinksThatSendAnAPICall().get(i).click();
            Thread.sleep(500);
            list1.add(driver.findElement(By.cssSelector("p[id=\"linkResponse\"]")).getText());
        }
        for (int i = 0; i < list1.size(); i++) {
            if(!(list1.get(i)).equals(linksPage.getListOfMessageStrings().get(i))){
                Assert.fail();
            }
        }
    }
}