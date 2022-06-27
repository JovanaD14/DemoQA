package projekat.pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import projekat.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class Forms extends BasePage {
    WebDriver driver;
    WebDriverWait wdwait;
    public String urlForms = "https://demoqa.com/forms";

    By practiceForm = By.cssSelector("div[class=\"element-list collapse show\"]");
    By nameAndLastName = By.cssSelector("div[class=\"col-md-4 col-sm-6\"]");
    By listOfOtherFields = By.cssSelector("div[class=\"col-md-9 col-sm-12\"]");
    By genderOptions = By.cssSelector("div[class=\"custom-control custom-radio custom-control-inline\"]");
    By calendar = By.cssSelector("div[class=\"react-datepicker__month-container\"]");
    By hobbiesOptions = By.cssSelector("div[class=\"custom-control custom-checkbox custom-control-inline\"]");
    By subjectField = By.id("subjectsInput");
    By submit = By.id("submit");
    By modal = By.cssSelector("table[class=\"table table-dark table-striped table-bordered table-hover\"]");


    public Forms(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }


    public void goToForms(){
        driver.navigate().to(urlForms);
    }

    public void clickPracticeForm(){
        driver.findElement(practiceForm).click();
    }

    public List<WebElement> getNameAndLastNameFields(){
        List<WebElement> list = driver.findElements(nameAndLastName);
        System.out.println(list.size());
        return list;
    }
    public List<String> getValidNames(){
        List<String> validFirstNames = new ArrayList<>();
        validFirstNames.add("Ana");
        validFirstNames.add("123");
        validFirstNames.add(" ");
        return validFirstNames;
    }

    public List<String> getValidLastNames(){
        List<String> validLastNames = new ArrayList<>();
        validLastNames.add("Petrovic");
        validLastNames.add("123");
        validLastNames.add(" ");
        return validLastNames;
    }

    public List<String> getListOfValidMobileNumbers(){
        List<String> validMobileNumbers = new ArrayList<>();
        validMobileNumbers.add("1234567890");
        validMobileNumbers.add("0648573845");
        validMobileNumbers.add("0654332222");
        return validMobileNumbers;
    }

    public List<String> getListOfInvalidMobileNumbers(){
        List<String> invalidMobileNumbers = new ArrayList<>();
        invalidMobileNumbers.add(" ");
        invalidMobileNumbers.add("abc");
        invalidMobileNumbers.add("087");
        return invalidMobileNumbers;
    }

    public List<WebElement> getListOfOtherFields(){
        List<WebElement> list = driver.findElements(listOfOtherFields);
        return list;
    }

    public WebElement getEmailField(){
        return getListOfOtherFields().get(0);
    }

    public void chooseMaleOption(){
        List<WebElement> list = getListOfOtherFields().get(1).findElements(genderOptions);
        list.get(0).click();
    }
    public void chooseFemaleOption(){
        List<WebElement> list = getListOfOtherFields().get(1).findElements(genderOptions);
        list.get(1).click();
    }
    public void chooseOtherGenderOption(){
        List<WebElement> list = getListOfOtherFields().get(1).findElements(genderOptions);
        list.get(2).click();
    }

    public WebElement getMobilePhoneField(){
        return getListOfOtherFields().get(2);
    }

    public void clickDateOfBirthField(){
        WebElement dateOfBirth = getListOfOtherFields().get(3).findElement(By.cssSelector("div[class=\"react-datepicker__input-container\"]"));
        dateOfBirth.click();
    }

    public WebElement getCalendar(){
        return driver.findElement(calendar);
    }

    public void chooseValidDateOfBirth(){
        clickDateOfBirthField();
        wdwait.until(ExpectedConditions.presenceOfElementLocated(calendar));
        Select month = new Select(driver.findElement(By.cssSelector("select[class=\"react-datepicker__month-select\"]")));
        month.selectByIndex(1);
        Select year = new Select(driver.findElement(By.cssSelector("select[class=\"react-datepicker__year-select\"]")));
        year.selectByValue("1990");
        List<WebElement> list = driver.findElements(By.className("react-datepicker__week"));
        System.out.println(list.size());
        WebElement day = list.get(2).findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]"));
        day.click();
    }



    public void chooseInvalidDateOfBirth(){
        clickDateOfBirthField();
        wdwait.until(ExpectedConditions.presenceOfElementLocated(calendar));
        Select month = new Select(driver.findElement(By.cssSelector("select[class=\"react-datepicker__month-select\"]")));
        month.selectByIndex(1);
        Select year = new Select(driver.findElement(By.cssSelector("select[class=\"react-datepicker__year-select\"]")));
        year.selectByValue("2030");
        List<WebElement> list = driver.findElements(By.className("react-datepicker__week"));
        System.out.println(list.size());
        WebElement day = list.get(2).findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]"));
        day.click();
    }
    public WebElement getSubjectField(){
        return driver.findElement(subjectField);
    }

    public void chooseHobbiesSports(){
        List<WebElement> list = getListOfOtherFields().get(5).findElements(hobbiesOptions);
        list.get(0).click();
    }
    public WebElement getHobbiesSports(){
        List<WebElement> list = getListOfOtherFields().get(5).findElements(hobbiesOptions);
        return list.get(0);
    }

    public void chooseHobbiesReading(){
        List<WebElement> list = getListOfOtherFields().get(5).findElements(hobbiesOptions);
        list.get(1).click();
    }

    public void chooseHobbiesMusic(){
        List<WebElement> list = getListOfOtherFields().get(5).findElements(hobbiesOptions);
        list.get(2).click();
    }


    public WebElement getCurrentAddressField(){
        return driver.findElement(By.id("currentAddress"));
        //return getListOfOtherFields().get(7);
    }

    public WebElement getSubmit(){
        return driver.findElement(submit);
    }

    public WebElement getModal(){
        return driver.findElement(modal);
    }

    public String getExpectedString (){
        return "Label Values\n" +
                "Student Name Ana Petrovic\n" +
                "Student Email petar@gmail.com\n" +
                "Gender Female\n" +
                "Mobile 1234567890\n" +
                "Date of Birth 14 February,1990\n" +
                "Subjects Maths\n" +
                "Hobbies Music\n" +
                "Picture\n" +
                "Address Kralja Petra 5, Beograd";
    }

    public void zoomOut() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '50%';");
    }

    /*public void validForm(String fName,String lName,String email,String phone, String subject,String currentA) {
        getFirstName().sendKeys(fName);
        getLastName().sendKeys(lName);
        getEmail().sendKeys(email);
        getFemaleButton().click();
        getPhone().sendKeys(phone);
        getSubjects().sendKeys(subject);
        dateSendKeys(date, "24 february 1996");
        getSports().click();
        getCurrentAddress().sendKeys(currentA);
        zoomOut();
        getSubmit().submit();
        By.id("currentAddress");*/



}
