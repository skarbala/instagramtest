package pages.newpost;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static context.TestBase.getAppiumDriver;
import static org.openqa.selenium.By.id;

public class SharePage extends GeneralPage {

    public SharePage() {
        super();
    }

    public GeneralPage addCaption(String captionText) {
        new WebDriverWait(getAppiumDriver(), 10)
            .until(ExpectedConditions.visibilityOfElementLocated(getCaptionLocator()));
        getAppiumDriver().findElement(getCaptionLocator()).sendKeys(captionText);
        return this;
    }

    private By getCaptionLocator() {
        return id("caption_text_view");
    }
}
