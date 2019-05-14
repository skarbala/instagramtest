package tests;

import context.TestBase;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InstagramTest extends TestBase {

    @Test
    public void testComment() throws InterruptedException {
        String commentText = "meetup furbo + slido jesen 2019";

        new LoginPage()
            .loginAsUser(getUser("furbo.slav"))
            .openProfile()
            .openPhoto()
            .postComment(commentText)
            .checkComment(commentText)
            .deleteComment(commentText);
    }
}

