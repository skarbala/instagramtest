package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static context.DriverProvider.getAppiumDriver;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PostDetailPage {

    public PostDetailPage postComment(String commentText) {
        getAppiumDriver().findElementByAccessibilityId("Comment").click();
        $(id("layout_comment_thread_edittext")).setValue(commentText);
        $(id("layout_comment_thread_post_button_click_area"))
            .shouldBe(enabled)
            .click();
        return this;
    }

    public PostDetailPage checkComment(String commentText) {
        By commentLocator = xpath(String.format("//*[contains(@text,'%s')]", commentText));
        new WebDriverWait(getAppiumDriver(), 10)
            .until(visibilityOfElementLocated(commentLocator));
        getCommentRow(commentText);
        return this;
    }

    private MobileElement getCommentRow(String commentText) {
        return getAppiumDriver().findElements(By.id("row_comment"))
            .stream()
            .filter(webElement -> webElement.findElement(By.id("row_comment_textview_comment"))
                .getText()
                .contains(commentText))
            .findFirst()
            .orElseThrow(NotFoundException::new);
    }

    public void deleteComment(String commentText) throws InterruptedException {
        getCommentRow(commentText).click();
        Thread.sleep(1500);
        getAppiumDriver().findElementByAccessibilityId("Delete Comment").click();
        new WebDriverWait(getAppiumDriver(), 10)
            .until(visibilityOfElementLocated(By.xpath("//*[contains(@text,'Comment deleted.')]")));
    }

    public void checkDescription(String expectedText) {
        $(id("row_feed_comment_textview_layout")).shouldHave(text(expectedText));
    }
}
