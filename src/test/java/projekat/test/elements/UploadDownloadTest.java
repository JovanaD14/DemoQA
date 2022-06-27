package projekat.test.elements;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import projekat.base.BasePage;

public class UploadDownloadTest extends BasePage {

    @Test
    public void download() throws InterruptedException {

        uploadDownloadPage.goToUploadDownload();
        Thread.sleep(2000 );
        uploadDownloadPage.getDownload().click();
    }

    @Test
    public void upload() {
        uploadDownloadPage.goToUploadDownload();
        Actions actions = new Actions(driver);
       // actions.moveToElement(uploadDownloadPage.getUpload()).click().sendKeys("C:\\Users\\Korisnik\\Pictures\111.jpg").build().perform();


    }
}
