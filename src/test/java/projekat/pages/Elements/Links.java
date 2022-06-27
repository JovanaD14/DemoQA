package projekat.pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import projekat.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class Links extends BasePage {
    WebDriver driver;
    WebDriverWait wdwait;
    public String urlLinks = "https://demoqa.com/links";
    By simpleLinkHome = By.id("simpleLink");
    By dynamicLinkHome = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p[2]/a");
    By listOfAPILinks = By.cssSelector("a[href=\"javascript:void(0)\"]");

    public Links(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void goToLinksPage(){
        driver.navigate().to(urlLinks);
    }

    public WebElement getSimpleHomeLink(){

        return driver.findElement(simpleLinkHome);
    }

    public WebElement getDynamicHomeLink(){

        return driver.findElement(dynamicLinkHome);
    }

    public List<WebElement> getListOfLinksThatSendAnAPICall(){
        List<WebElement> list = driver.findElements(listOfAPILinks);
        return list;
    }
    public String getMessage201(){
        return "Link has responded with staus 201 and status text Created";
    }

    public String getMessage204(){
        return "Link has responded with staus 204 and status text No Content";
    }

    public String getMessage301(){
        return "Link has responded with staus 301 and status text Moved Permanently";
    }

    public String getMessage400(){
        return "Link has responded with staus 400 and status text Bad Request";
    }

    public String getMessage401(){
        return "Link has responded with staus 401 and status text Unauthorized";
    }

    public String getMessage403(){
        return "Link has responded with staus 403 and status text Forbidden";
    }
    public String getMessage404(){
        return "Link has responded with staus 404 and status text Not Found";
    }

    public List<String> getListOfMessageStrings(){
        List<String> list = new ArrayList<>();
        list.add(getMessage201());
        list.add(getMessage204());
        list.add(getMessage301());
        list.add(getMessage400());
        list.add(getMessage401());
        list.add(getMessage403());
        list.add(getMessage404());
        return list;
    }


}
