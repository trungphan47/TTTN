package Railway.Contact;


import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC39 extends TestBase {
    HomePage homePage = new HomePage();

    @Test(description = "TC39 - Verify that user can navigate to Contact tab")

    public void TC39() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Contact page");
        homePage.goToContactTab();

        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Contact Information";
        Assert.assertEquals(actualMsg, expectedMsg, "Contact page is not displayed as expected");
    }
}
