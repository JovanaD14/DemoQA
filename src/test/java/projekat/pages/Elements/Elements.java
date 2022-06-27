package projekat.pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import projekat.base.BasePage;

import java.util.List;

public class Elements extends BasePage{

    public WebDriver driver;
    public WebDriverWait wdwait;
    public final String url1 = "https://demoqa.com/elements";

    public TextBox textBoxPage;
    public CheckBox checkBoxPage;
    public RadioButton radioButtonPage;
    public WebTables webTablesPage;
    public Buttons buttonsPage;
    public Links linksPage;
    public DynamicProperties dynamicPropertiesPage;




    By toolsQA = By.cssSelector("img[src=\"/images/Toolsqa.jpg\"]");

    public Elements(WebDriver driver, WebDriverWait wdwait) {

        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void goToElementsPage(){
        driver.navigate().to(url1);
    }

    public WebElement getToolsQAimg (){
        return driver.findElement(toolsQA);
    }

    public List<WebElement> getElementsList(){
        List<WebElement> listOfElements = driver.findElements(By.cssSelector("li[class=\"btn btn-light \"]"));
        return listOfElements;
    }
    public void chooseTextBox() {
        getElementsList().get(0).click();
    }

    public void chooseCheckBox() {
        getElementsList().get(1).click();
    }
    public void chooseRadioButton() {
        getElementsList().get(2).click();
    }

    public void chooseWebTables() {
        getElementsList().get(3).click();
    }

    public void chooseButtons() {
        getElementsList().get(4).click();
    }

    public void chooseLinks() {
        getElementsList().get(5).click();
    }

    public void chooseBrokenLinksImages() {
        getElementsList().get(6).click();
    }

    public void chooseUploadDownload() {
        getElementsList().get(7).click();
    }

    public void chooseDynamicProperties() {
        getElementsList().get(8).click();
    }




}
