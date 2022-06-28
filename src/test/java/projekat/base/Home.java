package projekat.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projekat.base.BasePage;

import java.util.List;

public class Home {

    public WebDriver driver;
    public final String url = "https://demoqa.com/";
    By certificationTrainingBanner = By.cssSelector("img[class=\"banner-image\"]");

    public Home(WebDriver driver) {

        this.driver = driver;
    }

    public void scrollToCategoryCards(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.className("category-cards"));
        String ycoord = String.valueOf(element.getLocation().y-300);
        js.executeScript("window.scrollTo(0,"+ycoord+");");
    }


    public List<WebElement> getCategoryList(){

        List<WebElement> categoryList = driver.findElements(By.cssSelector("div[class=\"card mt-4 top-card\"]"));
        return categoryList;
    }

    public WebElement getElements(){

        scrollToCategoryCards();
        return getCategoryList().get(0);
    }

    public WebElement getForms(){

        scrollToCategoryCards();
        return getCategoryList().get(1);
    }

    public WebElement getAlertsFrameWindows(){

        scrollToCategoryCards();
        return getCategoryList().get(2);
    }

    public WebElement getWidgets(){

        scrollToCategoryCards();
        return getCategoryList().get(3);
    }

    public WebElement interactions(){

        scrollToCategoryCards();
        return getCategoryList().get(4);
    }

    public WebElement getBookStoreApplication(){

        scrollToCategoryCards();
        return getCategoryList().get(5);
    }

    public WebElement getCertificationTrainingBanner(){

        return driver.findElement(certificationTrainingBanner);
    }

}
