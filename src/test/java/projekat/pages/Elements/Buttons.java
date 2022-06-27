package projekat.pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import projekat.base.BasePage;

public class Buttons extends BasePage {

    WebDriver driver;
    WebDriverWait wdwait;
    public String urlButtons = "https://demoqa.com/buttons";

    By doubleClickButton = By.id("doubleClickBtn");
    By rightClickButton = By.id("rightClickBtn");

    By doubleClickMessage = By.id("doubleClickMessage");
    By rightClickMessage = By.id("rightClickMessage");

    By clickMessage = By.id("dynamicClickMessage");


    public Buttons(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }


    public void goToButtonsPage() {

        driver.navigate().to(urlButtons);
    }

    public WebElement getDoubleClickButton(){

        return driver.findElement(doubleClickButton);
    }


    public WebElement getRightClickButton(){

        return driver.findElement(rightClickButton);
    }



    public WebElement getDoubleClickMessage(){

        return driver.findElement(doubleClickMessage);
    }

    public WebElement getRightClickMessage(){

        return driver.findElement(rightClickMessage);
    }

    public WebElement getClickMessage(){

        return driver.findElement(clickMessage);
    }
}

