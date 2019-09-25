package pages;

import context.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.openqa.selenium.By.id;

public class LoginPage {

    public HomePage loginAsUser(User user) {
        $(id("log_in_button")).click();
        $(id("login_username")).setValue(user.getUserName());
        $(id("password")).setValue(user.getPassword());
        $(id("button_text")).click();
        return page(HomePage.class);
    }
}
