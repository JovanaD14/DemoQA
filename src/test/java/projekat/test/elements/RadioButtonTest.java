package projekat.test.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekat.base.BasePage;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class RadioButtonTest extends BasePage {

    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to(radioButtonPage.urlRadioButton);
    }


    @Test
    public void checkYesRadioButton() {

       radioButtonPage.getYesButton().click();
       assertEquals(radioButtonPage.getTextOfSelectedOption(),"Yes");
        }


    @Test
    public void checkImpressiveRadioButton()  {

        radioButtonPage.getImpressiveButton().click();
        assertEquals(radioButtonPage.getTextOfSelectedOption(),"Impressive");
    }

    @Test
    public void checkNoRadioButton(){

        radioButtonPage.getNoButton().click();
        List<WebElement> list = driver.findElements(By.cssSelector("p[class=\"mt-3\""));
        assertEquals(list.size(), 0);
    }
}
