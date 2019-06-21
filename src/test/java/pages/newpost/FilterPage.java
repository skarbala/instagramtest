package pages.newpost;

import org.openqa.selenium.By;

import static context.TestBase.getAppiumDriver;
import static org.openqa.selenium.By.xpath;
import static utils.GesturesUtils.swipeLeft;

public class FilterPage extends GeneralPage {

    public FilterPage() {
        super();
    }

    public FilterPage selectFilter(String filterName) {
        int widthOfScreen = getAppiumDriver().manage().window().getSize().width;
        int yOffsetOfFilterElement = getAppiumDriver()
            .findElement(getFilterLocator("Normal"))
            .getLocation().y;
        swipeUntilFilterIsDisplayed(filterName, widthOfScreen, yOffsetOfFilterElement);
        getAppiumDriver().findElement(getFilterLocator(filterName)).click();
        return this;
    }

    private void swipeUntilFilterIsDisplayed(String filterName, int width, int yOffset) {
        int swipes = 0;
        final int MAX_SWIPES = 5;
        while (!isFilterDisplayed(filterName) && MAX_SWIPES >= swipes) {
            swipeLeft((int) (width * 0.6), (int) (width * 0.2), yOffset);
            swipes++;
        }
    }

    private boolean isFilterDisplayed(String filterName) {
        return getAppiumDriver().findElements(getFilterLocator(filterName)).size() == 1;
    }

    private By getFilterLocator(String filterName) {
        return xpath("//android.widget.RadioButton[@content-desc='" + filterName + "']");
    }
}

