package projekat.test.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projekat.base.BasePage;

import java.util.List;

public class WebTablesTest extends BasePage {

    @BeforeMethod
    public void beforeMethod() {
        webTablePage.goToWebTables();
        wdwait.until(ExpectedConditions.urlMatches(webTablePage.urlWebTables));
    }

    @Test (priority = 0)
    public void goToWebTables() {
        Assert.assertEquals(driver.getCurrentUrl(), webTablePage.urlWebTables);
        Assert.assertTrue(driver.findElement(By.className("web-tables-wrapper")).isDisplayed());
    }

    @Test (priority = 1)
    public void checkAddButton() throws InterruptedException {
        Thread.sleep(2000);
        webTablePage.clickAddButton();
        wdwait.until(ExpectedConditions.presenceOfElementLocated(By.className("modal-content")));
        Assert.assertTrue(driver.findElement(By.className("modal-content")).isDisplayed());
    }

    @Test(priority = 2)
    public void addValidDataToTable() throws InterruptedException {
        wdwait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class=\"rt-tr -even\"]")));
        List<WebElement> list = driver.findElements(By.cssSelector("div[class=\"rt-tr -even\"]"));

        for (int i = 0; i < webTablePage.getValidFirstNames().size(); i++) {
            Thread.sleep(2000);
            webTablePage.clickAddButton();
            webTablePage.getModalFields().get(0).sendKeys(webTablePage.getValidFirstNames().get(i));
            webTablePage.getModalFields().get(1).sendKeys(webTablePage.getValidLastNames().get(i));
            webTablePage.getModalFields().get(2).sendKeys(webTablePage.getValidEmails().get(i));
            webTablePage.getModalFields().get(3).sendKeys(webTablePage.getValidAges().get(i));
            webTablePage.getModalFields().get(4).sendKeys(webTablePage.getValidSalaries().get(i));
            webTablePage.getModalFields().get(5).sendKeys(webTablePage.getValidDepartments().get(i));
            webTablePage.clickSubmitButton();
            webTablePage.getSearchBox().click();
            webTablePage.getSearchBox().sendKeys(webTablePage.getValidEmails().get(i));
            Assert.assertEquals(list.size(), 1);
        }
    }

    @Test(priority = 3)
    public void addInvalidFirstLastNameData() throws InterruptedException {
        for (int i = 0; i < webTablePage.getInvalidFirstLastNames().size(); i++) {
            Thread.sleep(2000);
            webTablePage.clickAddButton();
            webTablePage.getModalFields().get(0).sendKeys(webTablePage.getInvalidFirstLastNames().get(i));
            webTablePage.getModalFields().get(1).sendKeys(webTablePage.getInvalidFirstLastNames().get(i));
            webTablePage.getModalFields().get(2).sendKeys(webTablePage.getValidEmails().get(0));
            webTablePage.getModalFields().get(3).sendKeys(webTablePage.getValidAges().get(0));
            webTablePage.getModalFields().get(4).sendKeys(webTablePage.getValidSalaries().get(0));
            webTablePage.getModalFields().get(5).sendKeys(webTablePage.getValidDepartments().get(0));
            webTablePage.clickSubmitButton();
            List<WebElement> list = driver.findElements(By.cssSelector("form[class=\"was-validated\"]"));
            Assert.assertTrue(list.size() == 1);
        }
    }

    @Test(priority = 4)
    public void addInvalidEmailData() throws InterruptedException {
        for (int i = 0; i < webTablePage.getInvalidEmails().size(); i++) {
            Thread.sleep(2000);
            webTablePage.clickAddButton();
            webTablePage.getModalFields().get(0).sendKeys(webTablePage.getValidFirstNames().get(0));
            webTablePage.getModalFields().get(1).sendKeys(webTablePage.getValidLastNames().get(0));
            webTablePage.getModalFields().get(2).sendKeys(webTablePage.getInvalidEmails().get(i));
            webTablePage.getModalFields().get(3).sendKeys(webTablePage.getValidAges().get(0));
            webTablePage.getModalFields().get(4).sendKeys(webTablePage.getValidSalaries().get(0));
            webTablePage.getModalFields().get(5).sendKeys(webTablePage.getValidDepartments().get(0));
            webTablePage.clickSubmitButton();
            List<WebElement> list = driver.findElements(By.cssSelector("form[class=\"was-validated\"]"));
            Assert.assertTrue(list.size() == 1);
        }
    }

    @Test(priority = 5)
    public void addInvalidAgeData() throws InterruptedException {
        for (int i = 0; i < webTablePage.getInvalidAges().size(); i++) {
            Thread.sleep(2000);
            webTablePage.clickAddButton();
            webTablePage.getModalFields().get(0).sendKeys(webTablePage.getValidFirstNames().get(0));
            webTablePage.getModalFields().get(1).sendKeys(webTablePage.getValidLastNames().get(0));
            webTablePage.getModalFields().get(2).sendKeys(webTablePage.getValidEmails().get(0));
            webTablePage.getModalFields().get(3).sendKeys(webTablePage.getInvalidAges().get(i));
            webTablePage.getModalFields().get(4).sendKeys(webTablePage.getValidSalaries().get(0));
            webTablePage.getModalFields().get(5).sendKeys(webTablePage.getValidDepartments().get(0));
            webTablePage.clickSubmitButton();
            List<WebElement> list = driver.findElements(By.cssSelector("form[class=\"was-validated\"]"));
            Assert.assertTrue(list.size() == 1);
        }
    }

    @Test(priority = 6)
    public void addInvalidSalaryData() throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i < webTablePage.getInvalidSalaries().size(); i++) {
            webTablePage.clickAddButton();
            webTablePage.getModalFields().get(0).sendKeys(webTablePage.getValidFirstNames().get(0));
            webTablePage.getModalFields().get(1).sendKeys(webTablePage.getValidLastNames().get(0));
            webTablePage.getModalFields().get(2).sendKeys(webTablePage.getValidEmails().get(0));
            webTablePage.getModalFields().get(3).sendKeys(webTablePage.getValidAges().get(0));
            webTablePage.getModalFields().get(4).sendKeys(webTablePage.getInvalidSalaries().get(i));
            webTablePage.getModalFields().get(5).sendKeys(webTablePage.getValidDepartments().get(0));
            webTablePage.clickSubmitButton();
            List<WebElement> list = driver.findElements(By.cssSelector("form[class=\"was-validated\"]"));
            Assert.assertTrue(list.size() == 1);
        }
    }

    @Test(priority = 7)
    public void addNoDepartmentData() throws InterruptedException {
        Thread.sleep(2000);
        webTablePage.clickAddButton();
        webTablePage.getModalFields().get(0).sendKeys(webTablePage.getValidFirstNames().get(0));
        webTablePage.getModalFields().get(1).sendKeys(webTablePage.getValidLastNames().get(0));
        webTablePage.getModalFields().get(2).sendKeys(webTablePage.getValidEmails().get(0));
        webTablePage.getModalFields().get(3).sendKeys(webTablePage.getValidAges().get(0));
        webTablePage.getModalFields().get(4).sendKeys(webTablePage.getValidSalaries().get(0));
        webTablePage.getModalFields().get(5).sendKeys(webTablePage.getInvalidDepartments().get(0));
        webTablePage.clickSubmitButton();
        List<WebElement> list = driver.findElements(By.cssSelector("form[class=\"was-validated\"]"));
        Assert.assertTrue(list.size() == 1);
    }


    @Test(priority = 8)
    public void addAllInvalidData() throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i < webTablePage.getInvalidSalaries().size(); i++) {


            webTablePage.clickAddButton();
            webTablePage.getModalFields().get(0).sendKeys(webTablePage.getInvalidFirstLastNames().get(0));
            webTablePage.getModalFields().get(1).sendKeys(webTablePage.getInvalidFirstLastNames().get(0));
            webTablePage.getModalFields().get(2).sendKeys(webTablePage.getInvalidEmails().get(i));
            webTablePage.getModalFields().get(3).sendKeys(webTablePage.getInvalidAges().get(i));
            webTablePage.getModalFields().get(4).sendKeys(webTablePage.getInvalidSalaries().get(i));
            webTablePage.getModalFields().get(5).sendKeys(webTablePage.getInvalidDepartments().get(0));
            webTablePage.clickSubmitButton();
            List<WebElement> list = driver.findElements(By.cssSelector("form[class=\"was-validated\"]"));
            Assert.assertTrue(list.size() == 1);
        }
    }

    @Test(priority = 9)
    public void deleteRow() {
        List<WebElement> list = driver.findElements(By.cssSelector("div[class=\"rt-tr-group\"]"));
        String s = list.get(0).getText();
        driver.findElement(By.id("delete-record-1")).click();
        List<WebElement> list2 = driver.findElements(By.cssSelector("div[class=\"rt-tr-group\"]"));
        for (int i = 0; i < list2.size(); i++) {
            Assert.assertFalse(list2.get(i).getText().equals(s));
        }
    }

    @Test(priority = 10)
    public void editRowData() {
        webTablePage.clickEditButton1stRow();
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class=\"modal-dialog modal-lg\"]")).isDisplayed());
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("firstName"))).click().keyDown(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).keyUp(Keys.CONTROL).sendKeys("Ana").build().perform();
        driver.findElement(By.id("submit")).click();
        List<WebElement> list = driver.findElements(By.cssSelector("div[class=\"rt-tr-group\"]"));
        List<WebElement> list1 = list.get(0).findElements(By.cssSelector("div[class=\"rt-td\"]"));
        String s = list1.get(0).getText();
        Assert.assertEquals(s, "Ana");
    }

    @Test(priority = 11)
    public void sortTextColumnsLexicographically() {

        List<WebElement> list = driver.findElements(By.cssSelector("div[class=\"rt-th rt-resizable-header -cursor-pointer\"]"));
        for (int i = 0; i < list.size()-1 && i!=2 && i!=4; i++) {
            list.get(i).click();
            List<WebElement> list1 = driver.findElements(By.cssSelector("div[class=\"rt-tr-group\"]"));
            List<WebElement> list2 = list1.get(0).findElements(By.cssSelector("div[class=\"rt-td\"]"));
            List<WebElement> list3 = list1.get(1).findElements(By.cssSelector("div[class=\"rt-td\"]"));
            List<WebElement> list4 = list1.get(2).findElements(By.cssSelector("div[class=\"rt-td\"]"));
            System.out.println(list2.size()); //7
            int result1 = list2.get(i).getText().compareTo(list3.get(i).getText());
            int result2 = list3.get(i).getText().compareTo(list4.get(i).getText());
            Assert.assertTrue(result1 < 0 && result2 < 0);
            list.get(i).click();
            int result3 = list2.get(i).getText().compareTo(list3.get(i).getText());
            int result4 = list3.get(i).getText().compareTo(list4.get(i).getText());
            Assert.assertTrue(result3 > 0 && result4 > 0);
        }
    }


    @Test(priority = 12)
    public void sortNumberColumnsByNumberValue() {

        List<WebElement> list = driver.findElements(By.cssSelector("div[class=\"rt-th rt-resizable-header -cursor-pointer\"]"));
        for (int i = 2; i <= 4 && i != 3; i++) {
            list.get(i).click();
            List<WebElement> list1 = driver.findElements(By.cssSelector("div[class=\"rt-tr-group\"]"));
            List<WebElement> list2 = list1.get(0).findElements(By.cssSelector("div[class=\"rt-td\"]"));
            List<WebElement> list3 = list1.get(1).findElements(By.cssSelector("div[class=\"rt-td\"]"));
            List<WebElement> list4 = list1.get(2).findElements(By.cssSelector("div[class=\"rt-td\"]"));
            System.out.println(list2.size()); //7
            if ((!(Integer.parseInt(list2.get(i).getText()) <= Integer.parseInt(list3.get(i).getText()))) &&
                    (!(Integer.parseInt(list3.get(i).getText()) <= Integer.parseInt(list4.get(i).getText())))) {
                Assert.fail();
            }
            list.get(i).click();
            if ((!(Integer.parseInt(list2.get(i).getText()) >= Integer.parseInt(list3.get(i).getText()))) &&
                    (!(Integer.parseInt(list3.get(i).getText()) >= Integer.parseInt(list4.get(i).getText())))) {
                    Assert.fail();
            }
        }
    }

    @Test(priority = 13)
    public void checkSearchBox(){
        List<WebElement> list1 = driver.findElements(By.cssSelector("div[class=\"rt-tr-group\"]"));
        List<WebElement> list2 = list1.get(1).findElements(By.cssSelector("div[class=\"rt-td\"]"));
        String s1 = list2.get(0).getText();
        System.out.println(s1);
        webTablePage.getSearchBox().sendKeys(list2.get(0).getText());
        List<WebElement> list3 = list1.get(0).findElements(By.cssSelector("div[class=\"rt-td\"]"));
        String s2 = list3.get(0).getText();
        System.out.println(list3.get(0).getText());
        Assert.assertEquals(s2, s1);


    }
}













