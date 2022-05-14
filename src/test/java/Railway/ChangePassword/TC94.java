package Railway.ChangePassword;

import Common.Utilities;
import PageObjects.ChangePasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC94 extends TestBase {
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

    @Test(description = "TC94 - Verify that user cannot change password if Confirm Password field is blanked")

    public void TC94() {
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

        System.out.println("Step 4: Blank Confirm Password field and enter valid other fields");
        System.out.println("Step 5: Click \"Change password\" button");
        homePage.goToChangePasswordPage();
        changePasswordPage.changePassword(password, newPassword,"");

        String actualMsg1 = changePasswordPage.getInvalidConfirmPass();
        String expectedMsg1 = "The password confirmation does not match the new password.";
        Assert.assertEquals(actualMsg1, expectedMsg1, "Error message to inform user cannot change password doesn't appear");

        String actualMsg2 = homePage.getTitleErrorMessageCommonInForms();
        String expectedMsg2 = "Password change failed. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg2, expectedMsg2, "User can change password successfully thought confirm password doesn't match");
    }
}
