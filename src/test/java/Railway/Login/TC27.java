package Railway.Login;

import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC27 extends TestBase {
    HomePage homePage = new HomePage();

    @Test(description = "TC027 - Verify that user can navigate to Register tab")

    public void TC25() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Login page");
        homePage.goToLoginPage();

        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Login Page";
        Assert.assertEquals(actualMsg, expectedMsg, "Login page is not displayed as expected");
    }
}
