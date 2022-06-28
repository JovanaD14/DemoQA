package projekat.test.elements;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import projekat.base.BasePage;

public class UploadDownloadTest extends BasePage {

    @Test
    public void download() {

        uploadDownloadPage.goToUploadDownload();
        uploadDownloadPage.getDownload().click();
    }

    @Test
    public void upload() {

        uploadDownloadPage.goToUploadDownload();
        uploadDownloadPage.getUpload().sendKeys("C:\\Users\\Korisnik\\Desktop\\Picture.jpeg");
    }
}
