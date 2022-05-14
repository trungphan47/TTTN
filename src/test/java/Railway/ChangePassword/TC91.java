package Railway.ChangePassword;

import Common.Utilities;
import PageObjects.ChangePasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC91 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    LoginPage loginPage = new LoginPage();
    String email = Utilities.getEmailRandom();
    String password = Utilities.getPasswordRandom();
    String confirmPassword = password;
    String pid = Utilities.getPidRandom();
    String newPassword = Utilities.getPasswordRandom();
    String confirmNewPassword = Utilities.getPasswordRandom();

    @Test(description = "TC91 - Verify that user cannot change password with \n" +
            "confirm password info doesn't matches new password")

    public void TC91() {
        homePage.open();
        homePage.goToRegisterPage();
        registerPage.register(email, password, confirmPassword, pid);

        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Login with a valid account ");
        homePage.goToLoginPage();
        loginPage.login(email, password);

        System.out.println("Step 3: Click on \"Change Password\" tab");
        homePage.goToChangePasswordPage();

        System.out.println("Step 4: Enter confirm password info doesn't match new password");
        System.out.println("Step 5: Enter valid info for the remaning fields");
        System.out.println("Step 6: Click \"Change password\" button");
        homePage.goToChangePasswordPage();
        changePasswordPage.changePassword(password, newPassword, confirmNewPassword);

        String actualMsg1 = homePage.getTileValidationError();
        String expectedMsg1 = "The password confirmation does not match the new password.";
        Assert.assertEquals(actualMsg1, expectedMsg1, "Error message to inform user cannot change password doesn't appear");

        String actualMsg2 = homePage.getTitleErrorMessageCommonInForms();
        String expectedMsg2 = "Password change failed. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg2, expectedMsg2, "User can change password successfully thought confirm password doesn't match");
    }
}
