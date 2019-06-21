package tests;

import context.TestBase;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.newpost.FilterPage;
import pages.newpost.FirstPage;
import pages.newpost.SharePage;

public class InstagramTest extends TestBase {

    @Test
    public void testComment() throws InterruptedException {
        String commentText = "vykoti ta do jarku ked sa budes hrat s instagramom za volantom";

        new LoginPage()
            .loginAsUser(getUser("furbo.slav"))
            .openProfile()
            .openPhoto()
            .postComment(commentText)
            .checkComment(commentText)
            .deleteComment(commentText);
    }

    @Test
    public void itShouldAddPhoto() {
        new LoginPage()
            .loginAsUser(getUser("furbo.slav"))
            .startNewPost();

        new FirstPage().next();
        new FilterPage()
            .selectFilter("Ludwig")
            .next();
        new SharePage()
            .addCaption("toto je velmi dolezity post #veryinteresting")
            .next();
    }


}
