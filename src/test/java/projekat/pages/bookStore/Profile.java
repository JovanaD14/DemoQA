package projekat.pages.bookStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import projekat.base.BasePage;

import java.util.List;

public class Profile extends BasePage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public final String urlProfile = "https://demoqa.com/profile";

    By buttonsList = By.id("submit");
    By goToStoreButton = By.id("gotoStore");


    public Profile(WebDriver driver, WebDriverWait wdwait) {

        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void goToProfilePage(){

        driver.navigate().to(urlProfile);
    }

    public WebElement getLogoutButton(){

        List<WebElement> list = driver.findElements(buttonsList);
        return list.get(0);
    }

    public WebElement getDeleteAccountButton(){

        List<WebElement> list = driver.findElements(buttonsList);
        return list.get(1);
    }

    public WebElement getDeleteAllBooksButton(){

        List<WebElement> list = driver.findElements(buttonsList);
        return list.get(2);
    }

    public WebElement getGoToStoreButton(){
        return driver.findElement(goToStoreButton);
    }


}
