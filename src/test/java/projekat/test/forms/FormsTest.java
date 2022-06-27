package projekat.test.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import projekat.base.BasePage;

import java.security.Key;

public class FormsTest extends BasePage {

    @BeforeMethod
    public void beforeMethod(){
        //komentar
        formsPage.goToForms  (   );
        formsPage.clickPracticeForm();
    }

    @Test
    public void AllValidData() throws InterruptedException {


        Actions actions = new Actions(driver);
        actions.moveToElement(formsPage.getNameAndLastNameFields().get(0)).click().sendKeys(formsPage.getValidNames().get(0)).build().perform();
        actions.moveToElement(formsPage.getNameAndLastNameFields().get(1)).click().sendKeys(formsPage.getValidLastNames().get(0)).build().perform();
        actions.moveToElement(formsPage.getEmailField()).click().sendKeys(textBoxPage.getListOfValidEmails().get(0)).build().perform();
        formsPage.chooseFemaleOption();
        scrollDown(By.id("userNumber"));
        actions.moveToElement(formsPage.getMobilePhoneField()).click().sendKeys(formsPage.getListOfValidMobileNumbers().get(0)).build().perform();
        formsPage.chooseValidDateOfBirth();
        scrollDown(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div[2]/div/div/div[1]"));
        actions.moveToElement(formsPage.getSubjectField()).click().sendKeys("m").build().perform();
        actions.moveToElement(formsPage.getSubjectField()).click().sendKeys(Keys.ENTER).build().perform();
        formsPage.chooseHobbiesMusic();
        formsPage.getCurrentAddressField().sendKeys(textBoxPage.getListOfValidAddresses().get(0));
        formsPage.zoomOut();
        Thread.sleep(1000);
        formsPage.getSubmit().submit();
        Thread.sleep(2000);
        wdwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table[class=\"table table-dark table-striped table-bordered table-hover\"]")));
        String s1 = formsPage.getModal().getText();
        Assert.assertEquals(s1,formsPage.getExpectedString());

    }

    @Test
    public void chooseValidDateOfBirthTest() throws InterruptedException {

        formsPage.chooseValidDateOfBirth();
        Thread.sleep(2000);
        String expected = "14 Feb 1990";
        String actual = driver.findElement(By.id("dateOfBirthInput")).getAttribute("value");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void inputInvalidEmailAddress () throws InterruptedException {
        Actions actions = new Actions(driver);
        String s1 = formsPage.getEmailField().getCssValue("border-color");

        actions.moveToElement(formsPage.getEmailField()).click().sendKeys(textBoxPage.getListOfInvalidEmails().get(0)).build().perform();
        formsPage.getSubmit().submit();
        Thread.sleep(2000);
        String s2 = driver.findElement(By.id("userEmail")).getCssValue("border-color");
        Assert.assertFalse(s1.equals(s2));
        Assert.assertTrue(s2.equals("rgb(220, 53, 69)"));
        }

     @Test
    public void inputInvalidMobileNumber() throws InterruptedException {

         Actions actions = new Actions(driver);
         String s1 = formsPage.getMobilePhoneField().getCssValue("border-color");

         actions.moveToElement(formsPage.getMobilePhoneField()).click().sendKeys(formsPage.getListOfInvalidMobileNumbers().get(0)).build().perform();
         formsPage.getSubmit().submit();
         Thread.sleep(2000);
         String s2 = driver.findElement(By.id("userNumber")).getCssValue("border-color");
         Assert.assertFalse(s1.equals(s2));
         Assert.assertTrue(s2.equals("rgb(220, 53, 69)"));
     }

     @Test
    public void checkAllHobbies() throws InterruptedException {
        scrollDown(By.cssSelector("div[class=\"custom-control custom-checkbox custom-control-inline\"]"));
        formsPage.chooseHobbiesSports();
        formsPage.chooseHobbiesReading();
        formsPage.chooseHobbiesMusic();
        formsPage.getSubmit().submit();
     }

     @Test
    public void EmptyFields() throws InterruptedException {
         String s1 = formsPage.getNameAndLastNameFields().get(0).getCssValue("border-color");
         String s2 = formsPage.getNameAndLastNameFields().get(1).getCssValue("border-color");
         formsPage.getSubmit().submit();
         Thread.sleep(2000);
         String s1afterSubmit = driver.findElement(By.id("firstName")).getCssValue("border-color");
         String s2afterSubmit = driver.findElement(By.id("lastName")).getCssValue("border-color");
         Assert.assertFalse((s1.equals(s1afterSubmit)&& (s2.equals(s2afterSubmit))));
         Assert.assertTrue(s1afterSubmit.equals("rgb(220, 53, 69)"));
         Assert.assertTrue((s2afterSubmit.equals("rgb(220, 53, 69)")));
     }
     }






