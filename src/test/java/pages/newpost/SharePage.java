package pages.newpost;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static context.DriverProvider.getAppiumDriver;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SharePage extends GeneralPage {

    public SharePage() {
        super();
    }

    public GeneralPage addCaption(String captionText) {
        new WebDriverWait(getAppiumDriver(), 10)
            .until(visibilityOfElementLocated(getCaptionLocator()));
        getAppiumDriver().findElement(getCaptionLocator()).sendKeys(captionText);
        return this;
    }

    private By getCaptionLocator() {
        return id("caption_text_view");
    }
}
