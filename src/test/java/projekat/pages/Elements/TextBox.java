package projekat.pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import projekat.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class TextBox {

    WebDriver driver;
    WebDriverWait wdwait;
    public String urlTextBox = "https://demoqa.com/text-box";


    By fullName = By.id("userName");
    By email = By.id("userEmail");
    By currentAddress = By.id("currentAddress");
    By permanentAddress = By.id("permanentAddress");
    By submit = By.id("submit");
    By verificationBOX = By.cssSelector("div[class=\"border col-md-12 col-sm-12\"]");

    public TextBox(WebDriver driver, WebDriverWait wdwait) {

        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getFullNameBox() {
        return driver.findElement(fullName);
    }

    public WebElement getEmailBox() {
        return driver.findElement(email);
    }

    public WebElement getCurrentAddressBox() {
        return driver.findElement(currentAddress);
    }

    public WebElement getPermanentAddressBox() {
        return driver.findElement(permanentAddress);
    }
    public void goToTextBoxPage() {
        driver.navigate().to(urlTextBox);
    }


    public void clickSubmitButton() {
        driver.findElement(submit).click();
    }

    public List<String> getListOfValidFullnames() {
        List<String> listOfValidFullnames = new ArrayList<>();
        listOfValidFullnames.add("Petar Petrovic");
        listOfValidFullnames.add("Marija Jovanovic");
        listOfValidFullnames.add("Milena Mitrovic");
        return listOfValidFullnames;
    }


    public List<String> getListOfValidEmails() {
        List<String> listOfValidEmails = new ArrayList<>();
        listOfValidEmails.add("petar@gmail.com");
        listOfValidEmails.add("marija@gmail.com");
        listOfValidEmails.add("milena@gmail.com");
        return listOfValidEmails;
    }

    public List<String> getListOfValidAddresses() {
        List<String> listOfValidAddresses = new ArrayList<>();
        listOfValidAddresses.add("Kralja Petra 5, Beograd");
        listOfValidAddresses.add("Dobracina 8/13, Beograd");
        listOfValidAddresses.add("Vukova 3, Beograd");
        return listOfValidAddresses;
    }
    public List<String> getListOfInvalidEmails(){
        List<String > listOfInvalidEmails = new ArrayList<>();
        listOfInvalidEmails.add("petar");
        listOfInvalidEmails.add("abc@");
        listOfInvalidEmails.add("petar@gmail.co");
        return listOfInvalidEmails;
    }

    public WebElement getVerificationBox() {
        List<WebElement> verificationBox = driver.findElements(verificationBOX);
        return verificationBox.get(0);
    }

    public List<WebElement> getVerificationBoxList(){
        List<WebElement> verificationBox = driver.findElements(verificationBOX);
        return verificationBox;
    }

    public List<WebElement> getListOfInputData() {
        List<WebElement> listOfInputData = getVerificationBox().findElements(By.className("mb-1"));
        return listOfInputData;
    }


    public void textBoxValidInput(int i) {
        String inputFullName = getListOfValidFullnames().get(i);
        String inputEmail = getListOfValidEmails().get(i);
        String inputCurrentAddress = getListOfValidAddresses().get(i);
        String inputPermanentAddress = getListOfValidAddresses().get(i);

        getFullNameBox().sendKeys(inputFullName);
        getEmailBox().sendKeys(inputEmail);
        getCurrentAddressBox().sendKeys(inputCurrentAddress);
        getPermanentAddressBox().sendKeys(inputPermanentAddress);
        BasePage.scrollDown(By.id("submit"));
        clickSubmitButton();
    }

}