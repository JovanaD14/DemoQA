package projekat.pages.bookStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import projekat.base.BasePage;

import java.util.List;

public class BookStore extends BasePage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public final String urlStore = "https://demoqa.com/books";

    By searchBox = By.id("searchBox");
    By logout = By.id("submit");
    By verification = By.id("userName-value");
    By rowsPerPage = By.cssSelector("select[aria-label=\"rows per page\"]");
    By listOfRows = By.cssSelector("div[class=\"rt-tr-group\"]");
    By fieldsInsideRow = By.cssSelector("div[class=\"rt-td\"]");
    By linksList = By.cssSelector("span[class=\"mr-2\"]");



    public BookStore(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void goToBookStore(){
        driver.navigate().to(urlStore);
    }

    public WebElement getSearchBox(){
        return driver.findElement(searchBox);
    }

    public WebElement getLogoutButton(){
        return driver.findElement(logout);
    }
    public List<WebElement> getVerificationList(){
        List<WebElement> list = driver.findElements(verification);
        return list;
    }

    public String getUsernameVerification(){
        return getVerificationList().get(0).getText();
    }

    public List<WebElement> listOfRowsPerPage(){
        List<WebElement> list = driver.findElements(listOfRows);
        return list;
    }

    public List<WebElement> listOfFieldsInsideRow(int i){
        List<WebElement> list = listOfRowsPerPage().get(i).findElements(fieldsInsideRow);
        return list;
    }
    public String getLinkTextForSearch(){
        String s = listOfFieldsInsideRow(0).get(1).getText();
        return s;
    }

    public WebElement getRowsPerPageField(){

        return driver.findElement(rowsPerPage);
    }

    public List<WebElement> getLinksList(){
        List<WebElement> list = driver.findElements(linksList);
        return list;
    }

    public WebElement getBackToStoreButton(){

        List<WebElement> list = driver.findElements(By.id("addNewRecordButton"));
        return list.get(0);
    }

    public WebElement getAddToCollectionButton(){
        List<WebElement> list = driver.findElements(By.id("addNewRecordButton"));
        System.out.println(list.size());
        return list.get(1);
    }





}
