package projekat.pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import projekat.base.BasePage;

import java.util.List;

public class DynamicProperties extends BasePage {
    WebDriver driver;
    WebDriverWait wdwait;
    public String urlDynamicProperties = "https://demoqa.com/dynamic-properties";

    By enableAfter = By.id("enableAfter");
    By visibleAfter = By.id("visibleAfter");
    By colorChange = By.id("colorChange");


    public DynamicProperties(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void goToDynamicPropertiesPage(){
        driver.navigate().to(urlDynamicProperties);
    }


    public WebElement getEnableAfterButton(){
        return driver.findElement(enableAfter);
    }

    public WebElement getVisibleAfterButton(){
        return driver.findElement(visibleAfter);
    }

    public WebElement getColorChangeButton(){
        return driver.findElement(colorChange);
    }
    public WebElement getTextWithRandomID(){
        List<WebElement> list = driver.findElements(By.tagName("p"));
        for (int i = 0; i < list.size() ; i++) {
            if (list.get(i).getText().equals("This text has random Id")){
                return list.get(i);
            }
        }
        return null;
    }
}
