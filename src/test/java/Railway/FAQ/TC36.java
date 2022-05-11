package Railway.FAQ;

import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC36 extends TestBase {
    HomePage homePage = new HomePage();

    @Test(description = "TC36 - Verify that user can navigate to FAQ tab")

    public void TC36() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to FAQ page");
        homePage.goToFAQPage();

        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Frequently Asked Questions";
        Assert.assertEquals(actualMsg, expectedMsg, "FAQ page is not displayed as expected");
    }
}