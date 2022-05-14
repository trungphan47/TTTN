package Railway.ForgotPassword;

import Common.Utilities;
import PageObjects.ForgotPasswordPage;
import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC99 extends TestBase {
    HomePage homePage = new HomePage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Test(description = "TC99 - Verify that user can not reset password with a blank email field")

    public void TC99() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Login page");
        homePage.goToLoginPage();

        System.out.println("Step 3: Go to Forgot password page");
        homePage.goToForgotPasswordPage();

        System.out.println("Step 4:  Blank \"Email Address\" field ");
        System.out.println("Step 5: Click Send Instructions button");
        forgotPasswordPage.forgotPassword("");

        String actualMsg = forgotPasswordPage.getInvalidEmailResetMess();
        String expectedMsg = "Please enter a valid email";
        Assert.assertEquals(actualMsg, expectedMsg, "Forgot password function Error");
    }
}
