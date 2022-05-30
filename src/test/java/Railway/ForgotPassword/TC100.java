package Railway.ForgotPassword;

import Common.Utilities;
import PageObjects.ForgotPasswordPage;
import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC100 extends TestBase {
    HomePage homePage = new HomePage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Test(description = "TC100 - Verify that user can not reset password with an invalid email")

    public void TC100() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Login page");
        homePage.goToLoginPage();

        System.out.println("Step 3: Go to Forgot password page");
        homePage.goToForgotPasswordPage();

        System.out.println("Step 4:  Fill an invalid email in \"Email Address\" ");
        System.out.println("Step 5: Click Send Instructions button");
        forgotPasswordPage.forgotPassword(Utilities.getPasswordRandom());

        String actualMsg = forgotPasswordPage.getInvalidEmailResetMess();
        String expectedMsg = "Please enter a valid email";
        Assert.assertEquals(actualMsg, expectedMsg, "Forgot password function Error");
    }
}
