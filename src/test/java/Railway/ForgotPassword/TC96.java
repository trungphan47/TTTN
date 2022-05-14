package Railway.ForgotPassword;

import PageObjects.ForgotPasswordPage;
import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC96 extends TestBase {
    HomePage homePage = new HomePage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Test(description = "TC96 - Verify that user can navigate to Forgot password tab")

    public void TC96() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Login page");
        homePage.goToLoginPage();

        System.out.println("Step 2: Go to Forgot password page");
        homePage.goToForgotPasswordPage();

        String actualMsg = forgotPasswordPage.getForgotPasswordTitle();
        String expectedMsg = "Password Reset Instructions Form";
        Assert.assertEquals(actualMsg, expectedMsg, "Forgot password page is not displayed as expected");
    }
}
