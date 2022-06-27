package projekat.test.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekat.base.BasePage;

import static org.testng.Assert.assertEquals;

public class TextBoxTest extends BasePage {


    @Test
    public void goToTextBox() {
        driver.navigate().to(url);
        wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]")));
        homePage.getElements().click();
        elementsPage.chooseTextBox();
        assertEquals(driver.getCurrentUrl(), "https://demoqa.com/text-box");
    }

    @Test
    public void checkTextBoxValidInput() {
        goToTextBox();
        for (int j = 0; j < textBoxPage.getListOfValidFullnames().size() && j < textBoxPage.getListOfValidEmails().size()
                && j < textBoxPage.getListOfValidAddresses().size(); j++) {
            textBoxPage.textBoxValidInput(j);
            textBoxPage.getListOfInputData();
            String actualFullName = textBoxPage.getListOfInputData().get(0).getText().substring(5);
            String actualEmail = textBoxPage.getListOfInputData().get(1).getText().substring(6);
            String actualCurrentAddress = textBoxPage.getListOfInputData().get(2).getText().substring(17);
            String actualPermanentAddress = textBoxPage.getListOfInputData().get(3).getText().substring(20);
            assertEquals(actualFullName, textBoxPage.getListOfValidFullnames().get(j));
            assertEquals(actualEmail, textBoxPage.getListOfValidEmails().get(j));
            assertEquals(actualCurrentAddress, textBoxPage.getListOfValidAddresses().get(j));
            assertEquals(actualPermanentAddress, textBoxPage.getListOfValidAddresses().get(j));
            driver.navigate().to(url);
            //goToTextBox();
        }
    }

    @Test
    public void checkTextBoxAllFieldsEmpty() throws InterruptedException {
        goToTextBox();
        scrollDown(By.id("submit"));
        textBoxPage.clickSubmitButton();
        Thread.sleep(3000);
        assertEquals(textBoxPage.getVerificationBoxList().size(), 0);
    }

    @Test
    public void checkTextBoxOneFieldFilled() throws InterruptedException {
        goToTextBox();
        for (int j = 0; j < textBoxPage.getListOfValidFullnames().size() && j < textBoxPage.getListOfValidEmails().size()
                && j < textBoxPage.getListOfValidAddresses().size(); j++) {
            textBoxPage.getEmailBox().sendKeys(textBoxPage.getListOfValidEmails().get(j));
            scrollDown(By.id("submit"));
            textBoxPage.clickSubmitButton();
            Thread.sleep(1000);
            assertEquals(textBoxPage.getListOfInputData().size(), 1);
            goToTextBox();
            textBoxPage.getFullNameBox().sendKeys(textBoxPage.getListOfValidFullnames().get(j));
            scrollDown(By.id("submit"));
            textBoxPage.clickSubmitButton();
            Thread.sleep(1000);
            assertEquals(textBoxPage.getListOfInputData().size(), 1);
            goToTextBox();
            textBoxPage.getCurrentAddressBox().sendKeys(textBoxPage.getListOfValidAddresses().get(j));
            scrollDown(By.id("submit"));
            textBoxPage.clickSubmitButton();
            Thread.sleep(1000);
            assertEquals(textBoxPage.getListOfInputData().size(), 1);
            goToTextBox();
        }
    }

    @Test
    public void checkTextBoxInvalidEmail() {
        goToTextBox();
        for (int i = 0; i < textBoxPage.getListOfInvalidEmails().size(); i++) {
            textBoxPage.getEmailBox().sendKeys(textBoxPage.getListOfInvalidEmails().get(i));
            scrollDown(By.id("submit"));
            textBoxPage.clickSubmitButton();
            assertEquals(textBoxPage.getEmailBox().getAttribute("class"), "mr-sm-2 field-error form-control");
        }
    }

    @Test
    public void checkTextBoxNumbersAsFullName() {
        goToTextBox();
        textBoxPage.getFullNameBox().sendKeys("123");
        scrollDown(By.id("submit"));
        textBoxPage.clickSubmitButton();
        assertEquals(textBoxPage.getVerificationBoxList().size(), 1);
        assertEquals(textBoxPage.getListOfInputData().get(0).getText().substring(5), "123");
    }



}
