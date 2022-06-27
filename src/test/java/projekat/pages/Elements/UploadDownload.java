package projekat.pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import projekat.base.BasePage;

public class UploadDownload extends BasePage {
    WebDriver driver;
    WebDriverWait wdwait;
    public String urlUploadDownload = "https://demoqa.com/upload-download";

    By download = By.id("downloadButton");
    By upload = By.id("uploadFile");



    public UploadDownload(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void goToUploadDownload(){
        driver.navigate().to(urlUploadDownload);
    }
    public WebElement getDownload() {
        return driver.findElement(download);
    }
    public WebElement getUpload() {
        return driver.findElement(upload);
    }

}
