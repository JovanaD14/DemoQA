package projekat.pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButton {
    WebDriver driver;
    WebDriverWait wdwait;
    public String urlRadioButton = "https://demoqa.com/radio-button";


    By yesButton = By.cssSelector("label[for=\"yesRadio\"]");
    By impressiveButton = By.cssSelector("label[for=\"impressiveRadio\"]");
    By noButton = By.cssSelector("label[for=\"noRadio\"]");

    public RadioButton(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }


    public static void goToRadioButtonPage(RadioButton RadioButtonTest){
        RadioButtonTest.driver.navigate().to(RadioButtonTest.urlRadioButton);
    }

public String getTextOfSelectedOption(){
    wdwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class=\"text-success\"")));
    WebElement selectedOption = driver.findElement(By.cssSelector("span[class=\"text-success\""));
    return selectedOption.getText();
}
    public WebElement getYesButton(){
        return driver.findElement(yesButton);
    }

    public WebElement getImpressiveButton(){
        return driver.findElement(impressiveButton);
    }
    public WebElement getNoButton(){
        return driver.findElement(noButton);
    }
}
