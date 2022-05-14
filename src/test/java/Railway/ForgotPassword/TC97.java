package Railway.ForgotPassword;

import Common.Constant;
import PageObjects.ForgotPasswordPage;
import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC97 extends TestBase {
    HomePage homePage = new HomePage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Test(description = "TC97 - Verify that user can reset password")

    public void TC97() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Login page");
        homePage.goToLoginPage();

        System.out.println("Step 3: Go to Forgot password page");
        homePage.goToForgotPasswordPage();

        System.out.println("Step 4: Fill an registered email in \"Email Address\" ");
        System.out.println("Step 5: Click Send Instructions button");
        forgotPasswordPage.forgotPassword(Constant.USERNAME);

        String actualMsg = forgotPasswordPage.getForgotPasswordTitle();
        String expectedMsg = "A password recovery email has been sent to your email";
        Assert.assertEquals(actualMsg, expectedMsg, "Forgot password page is not displayed as expected");
    }
}
