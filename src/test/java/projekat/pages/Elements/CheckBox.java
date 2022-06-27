package projekat.pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckBox {
    WebDriver driver;
    WebDriverWait wdwait;
    public String urlCheckBox = "https://demoqa.com/checkbox";

    By checkedOptions = By.className("text-success");
    By checkHomeBox = By.className("rct-checkbox");


    public CheckBox(WebDriver driver, WebDriverWait wdwait) {

        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void goToCheckBoxPage() {

        driver.navigate().to(urlCheckBox);
    }

    public WebElement getCheckHomeBox() {

        return driver.findElement(checkHomeBox);
    }

    public List<WebElement> getListOfCheckedOptions() {

        List<WebElement> list = driver.findElements(checkedOptions);
        return list;
    }

    public WebElement getExpandButton() {

        return driver.findElement(By.cssSelector("svg[class=\"rct-icon rct-icon-expand-all\"]"));
    }

    public WebElement getCollapseAllButton() {

        return driver.findElement(By.cssSelector("svg[class=\"rct-icon rct-icon-collapse-all\"]"));
    }

    public WebElement getExpandCloseIconFirstUsage() {

        return driver.findElement(By.cssSelector("svg[class=\"rct-icon rct-icon-expand-close\"]"));
    }

    public WebElement getExpandCloseIconSecondUsage() {

        return driver.findElement(By.cssSelector("svg[class=\"rct-icon rct-icon-expand-open\"]"));
    }

    public WebElement getDesktopCheckBox() {

        List<WebElement> desktopCheckBox = driver.findElements(By.cssSelector("span[class=\"rct-title\"]"));
        for (int i = 0; i < desktopCheckBox.size(); i++) {
            if (desktopCheckBox.get(i).getText().equals("Desktop")) {
                return desktopCheckBox.get(i);
            }
        }
        return null;
    }

    public WebElement getDocumentsCheckBox() {

        List<WebElement> documentsCheckBox = driver.findElements(By.cssSelector("span[class=\"rct-title\"]"));
        for (int i = 0; i < documentsCheckBox.size(); i++) {
            if (documentsCheckBox.get(i).getText().equals("Documents")) {
                return documentsCheckBox.get(i);
            }
        }
        return null;
    }

    public WebElement getDownloadsCheckBox() {

        List<WebElement> downloadsCheckBox = driver.findElements(By.cssSelector("span[class=\"rct-title\"]"));
        for (int i = 0; i < downloadsCheckBox.size(); i++) {
            if (downloadsCheckBox.get(i).getText().equals("Downloads")) {
                return downloadsCheckBox.get(i);
            }
        }
        return null;
    }
}