package Railway.Register;

import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase {
    HomePage homePage = new HomePage();

    @Test(description = "TC004 - Verify that user can navigate to Register tab")

    public void TC04() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Register page");
        homePage.goToRegisterPage();

        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Create account";
        Assert.assertEquals(actualMsg, expectedMsg, "Register page is not displayed as expected");
    }
}