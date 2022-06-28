package projekat.pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import projekat.base.BasePage;

public class BrokenLinksImages extends BasePage {

    WebDriver driver;
    WebDriverWait wdwait;
    public String urlBroken = "https://demoqa.com/broken";

    By validLink = By.linkText("Click Here for Valid Link");
    By brokenLink = By.linkText("Click Here for Broken Link");


    public BrokenLinksImages(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getValidLink() {
        scrollDown(validLink);
        return driver.findElement(validLink);
    }

    public WebElement getBrokenLink() {
        scrollDown(brokenLink);
        return driver.findElement(brokenLink);
    }
}