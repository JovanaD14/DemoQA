package projekat.pages.bookStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import projekat.base.BasePage;

import java.util.List;

public class BookStoreApp extends BasePage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public final String urlBook = "https://demoqa.com/books";

    public BookStoreApp(WebDriver driver, WebDriverWait wdwait) {

        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void goToBookStoreApplication(){

        driver.navigate().to(urlBook);
    }

    public WebElement getLoginPageButton(){

        List<WebElement> list = driver.findElements(By.cssSelector("span[class=\"text\"]"));
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getText().equals("Login")){
                return list.get(i);
            }
        }
        return null;
    }

    public WebElement getBookStoreButton(){

        List<WebElement> list = driver.findElements(By.cssSelector("span[class=\"text\"]"));
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getText().equals("Book Store")){
                return list.get(i);
            }
        }
        return null;
    }


    public WebElement getProfileButton(){

        List<WebElement> list = driver.findElements(By.cssSelector("span[class=\"text\"]"));
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getText().equals("Profile")){
                return list.get(i);
            }
        }
        return null;
    }

    public WebElement getBookStoreAPIButton(){

        List<WebElement> list = driver.findElements(By.cssSelector("span[class=\"text\"]"));
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getText().equals("Book Store API")){
                return list.get(i);
            }
        }
        return null;
    }
}
