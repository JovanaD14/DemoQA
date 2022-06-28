package projekat.pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import projekat.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class WebTables extends BasePage {
    WebDriver driver;
    WebDriverWait wdwait;
    public String urlWebTables = "https://demoqa.com/webtables";

    By addButton = By.id("addNewRecordButton");
    By searchBox = By.id("searchBox");
    By modalFields = By.cssSelector("input[required]");
    By submitButton = By.id("submit");
    By editButton = By.id("edit-record-1");

    public WebTables(WebDriver driver, WebDriverWait wdwait) {

        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void goToWebTables(){

        driver.navigate().to(urlWebTables);
    }

    public void clickAddButton(){

         goToWebTables();
         driver.findElement(addButton).click();
    }
    public WebElement getSearchBox(){

        return driver.findElement(searchBox);
    }

    public List<WebElement> getModalFields(){

        List<WebElement> list = driver.findElements(modalFields);
        return list;
    }
    public List<String> getValidFirstNames(){

        List<String> list = new ArrayList<>();
        list.add("Petar");
        list.add("Uros");
        list.add("Jelena");
        list.add("MARIJA");
        return list;
    }
    public List<String> getValidLastNames(){

        List<String> list = new ArrayList<>();
        list.add("Petrovic");
        list.add("Urosevic");
        list.add("Pavlovic");
        list.add("Pavic");
        return list;
    }
    public List<String> getValidAges(){

        List<String> list = new ArrayList<>();
        list.add("00");
        list.add("0");
        list.add("99");
        list.add("02");
        return list;
    }

    public List<String> getValidEmails(){

        List<String> list = new ArrayList<>();
        list.add("petar@gmail.com");
        list.add("petar@gmail.co");
        list.add("jelena@yahoo.com");
        list.add("jelena@yahoo.co");
        return list;
    }
    public List<String> getValidSalaries(){

        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("1234567890");
        list.add("00");
        return list;
    }
    public List<String> getValidDepartments(){

        List<String> list = new ArrayList<>();
        list.add("Marketing");
        list.add("HR");
        list.add("Finance");
        list.add(" HR");
        return list;
    }
    public List<String> getInvalidFirstLastNames(){

        List<String> list = new ArrayList<>();
        list.add("");
        return list;
    }
    public List<String> getInvalidAges() {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add(" ");
        list.add(" 5");
        list.add("abc");
        return list;
    }
    public List<String> getInvalidEmails(){

        List<String> list = new ArrayList<>();
        list.add("petar@gmail.c");
        list.add("123");
        list.add("jelena@yahoo.");
        list.add("jelenayahoo");
        return list;
    }

    public List<String> getInvalidDepartments(){

        List<String> list = new ArrayList<>();
        list.add("");
        return list;
    }

    public List<String> getInvalidSalaries() {

        List<String> list = new ArrayList<>();
        list.add(" ");
        list.add(" 45");
        list.add("abc");
        list.add(" abc");
        return list;
    }

    public void clickSubmitButton(){

        driver.findElement(submitButton).click();
    }

    public void clickEditButton1stRow(){

        driver.findElement(editButton).click();
    }
}
