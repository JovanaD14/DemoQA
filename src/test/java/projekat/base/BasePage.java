package projekat.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import projekat.pages.Elements.*;
import projekat.pages.bookStore.BookStore;
import projekat.pages.bookStore.BookStoreApp;
import projekat.pages.bookStore.Login;
import projekat.pages.bookStore.Profile;
import projekat.pages.forms.Forms;

import java.time.Duration;

public class BasePage {
    public static WebDriverManager wdm;
    public static WebDriver driver;
    public static WebDriverWait wdwait;
    public final String url = "https://demoqa.com/";
    public Home homePage;
    public Elements elementsPage;
    public TextBox textBoxPage;

    public CheckBox checkBoxPage;
    public RadioButton radioButtonPage;
    public WebTables webTablePage;
    public Buttons buttonsPage;
    public Links linksPage;
    public DynamicProperties dynamicPropertiesPage;
    public Forms formsPage;
    public BookStoreApp bookStoreAppPage;
    public Login loginPage;
    public BookStore bookStorePage;
    public Profile profilePage;
    public UploadDownload uploadDownloadPage;



    public By toolsQA = By.cssSelector("img[src=\"/images/Toolsqa.jpg\"");


    @BeforeClass
    public void beforeClass(){
    wdm = new ChromeDriverManager();
    wdm.setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    homePage = new Home(driver);
    elementsPage = new Elements(driver, wdwait);
    textBoxPage = new TextBox(driver, wdwait);
    checkBoxPage = new CheckBox(driver,wdwait);
    radioButtonPage = new RadioButton(driver,wdwait);
    webTablePage = new WebTables(driver,wdwait);
    buttonsPage = new Buttons(driver, wdwait);
    linksPage = new Links(driver,wdwait);
    dynamicPropertiesPage = new DynamicProperties(driver,wdwait);
    formsPage = new Forms(driver, wdwait);
    bookStoreAppPage = new BookStoreApp(driver,wdwait);
    loginPage = new Login(driver,wdwait);
    bookStorePage = new BookStore(driver,wdwait);
    profilePage = new Profile(driver,wdwait);
    uploadDownloadPage = new UploadDownload(driver,wdwait);

}

    public WebElement getToolsQA(){
        return driver.findElement(toolsQA);
    }

    public static void scrollDown(By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        String ycoord = String.valueOf(element.getLocation().y-300);
        js.executeScript("window.scrollTo(0,"+ycoord+");");
    }

    @AfterClass
    public void afterClass(){
    driver.quit();
}
}

