package pages.newpost;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public abstract class GeneralPage {

    GeneralPage() {
        waitForPageToLoad();
    }

    private void waitForPageToLoad() {
        $(id("next_button_textview"))
            .waitUntil(Condition.visible, 15000);
    }

    public GeneralPage next() {
        $(id("next_button_textview")).click();
        return this;
    }
}
