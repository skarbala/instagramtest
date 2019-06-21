package pages;

import context.User;

import static context.DriverProvider.getAppiumDriver;
import static org.openqa.selenium.By.id;

public class LoginPage {

    public LoginPage() {

    }

    public MainPage loginAsUser(User user) {
        getAppiumDriver().findElement(id("log_in_button")).click();
        getAppiumDriver().findElement(id("login_username")).setValue(user.getUserName());
        getAppiumDriver().findElement(id("password")).setValue(user.getPassword());
        getAppiumDriver().findElement(id("button_text")).click();
        return new MainPage();
    }
}
