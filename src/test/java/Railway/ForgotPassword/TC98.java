package Railway.ForgotPassword;

import Common.Utilities;
import PageObjects.ForgotPasswordPage;
import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC98 extends TestBase {
    HomePage homePage = new HomePage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Test(description = "TC98 - Verify that user can not reset password with an unregistered email")

    public void TC98() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Login page");
        homePage.goToLoginPage();

        System.out.println("Step 3: Go to Forgot password page");
        homePage.goToForgotPasswordPage();

        System.out.println("Step 4:  Fill an invalid email in \"Email Address\" ");
        System.out.println("Step 5: Click Send Instructions button");
        forgotPasswordPage.forgotPassword(Utilities.getEmailRandom());

        String actualMsg = forgotPasswordPage.getEmailDoesnotExit();
        String expectedMsg = "This email address doesn't exist.";
        Assert.assertEquals(actualMsg, expectedMsg, "Forgot password function Error");
    }
}
