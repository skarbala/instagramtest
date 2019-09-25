package pages.newpost;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class SharePage extends GeneralPage {

    public SharePage() {
        super();
    }

    public GeneralPage addCaption(String captionText) {
        $(id("caption_text_view")).sendKeys(captionText);
        return this;
    }
}
