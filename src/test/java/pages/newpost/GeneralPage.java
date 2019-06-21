package pages.newpost;

import org.openqa.selenium.support.ui.WebDriverWait;

import static context.TestBase.getAppiumDriver;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class GeneralPage {

    GeneralPage() {
        waitForPageToLoad();
    }

    private void waitForPageToLoad() {
        new WebDriverWait(getAppiumDriver(), 20)
            .until(visibilityOfElementLocated(id("next_button_textview")));
    }

    public GeneralPage next() {
        getAppiumDriver().findElement(id("next_button_textview")).click();
        return this;
    }
}
