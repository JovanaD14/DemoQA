package projekat.test.basepage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekat.base.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class HomeTest extends BasePage {


    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to(url);
        wdwait.until(ExpectedConditions.urlMatches(url));
    }


    @Test(priority = 0)
    public void goToSeleniumTrainingPage() {
        homePage.getCertificationTrainingBanner().click();
        Set<String> setOfTabs = driver.getWindowHandles();
        ArrayList<String> listOfTabs = new ArrayList<>(setOfTabs);
        driver.switchTo().window(listOfTabs.get(1));
        assertEquals(driver.getCurrentUrl(), "https://www.toolsqa.com/selenium-training/");
        driver.switchTo().window(listOfTabs.get(0));
    }

    @Test(priority = 1)
    public void checkToolsQaImg() throws InterruptedException {
        Thread.sleep(2000);
        getToolsQA().click();
        assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
    }

    @Test(priority = 2)
    public void checkCategoryCardsLinks() {
        List<String> urlList = new ArrayList<>();
        for (int i = 0; i < homePage.getCategoryList().size(); i++) {
            homePage.scrollToCategoryCards();
            homePage.getCategoryList().get(i).click();
            urlList.add(i, driver.getCurrentUrl());
        }
        List<String> expectedUrlList = new ArrayList<>();
        expectedUrlList.add("https://demoqa.com/elements");
        expectedUrlList.add("https://demoqa.com/forms");
        expectedUrlList.add("https://demoqa.com/alertsWindows");
        expectedUrlList.add("https://demoqa.com/widgets");
        expectedUrlList.add("https://demoqa.com/interaction");
        expectedUrlList.add("https://demoqa.com/books");

        for (int i = 0; i < urlList.size(); i++) {
            if (!(urlList.get(i).equals(expectedUrlList.get(i)))) {
                Assert.fail();
            }
        }
    }

}
