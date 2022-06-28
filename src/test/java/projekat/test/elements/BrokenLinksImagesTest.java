package projekat.test.elements;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekat.base.BasePage;

public class BrokenLinksImagesTest extends BasePage {

    @BeforeMethod
    public void beforeMethod(){

       driver.navigate().to(homePage.url);
    }

    @Test
    public void validLink() {

       homePage.getElements().click();
       scrollDown(By.xpath("//*[@id=\"item-6\"]/span"));
       elementsPage.chooseBrokenLinksImages();
       brokenLinksImagesPage.getValidLink().click();
       String expectedUrl = "https://demoqa.com/";
       Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }

    @Test public void brokenLink() {

        homePage.getElements().click();
        scrollDown(By.xpath("//*[@id=\"item-6\"]/span"));
        elementsPage.chooseBrokenLinksImages();
        brokenLinksImagesPage.getBrokenLink().click();
        String brokenURl = "http://the-internet.herokuapp.com/status_codes/500";
        Assert.assertEquals(driver.getCurrentUrl(),brokenURl);
    }
}
