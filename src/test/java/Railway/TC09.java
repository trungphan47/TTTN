package Railway;

import Common.Utilities;
import PageObjects.ChangePasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase {
    HomePage homePage = new HomePage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can't change password when \"New Password\" and \"Confirm Password\" are different.")

    public void TC09() {
        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        homePage.goToRegisterPage();
        String username = Utilities.getEmailRandom();
        String password = Utilities.getPasswordRandom();
        String confirmPassword = password;
        String pid = Utilities.getPidRandom();
        registerPage.register(username, password, confirmPassword, pid);

        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Login with a valid account ");
        homePage.goToLoginPage();
        loginPage.login(username, password);

        System.out.println("Step 3: Click on \"Change Password\" tab");
        homePage.goToChangePasswordPage();

        System.out.println("Step 4: . Enter valid information into \"Current Password\" textbox but enter \"a123:\"/{}!@$\\\" into \"New Password\" textbox and \"b456:\"/{}!@$\\\" into \"Confirm Password\" textbox.");
        homePage.goToChangePasswordPage();
        changePasswordPage.changePassword("123456789", "a123:\"/{}!@$\\", "b456:\"/{}!@$\\");

        String actualMsg1 = homePage.getTileValidationError();
        String expectedMsg1 = "The password confirmation does not match the new password.";
        Assert.assertEquals(actualMsg1, expectedMsg1, "Error message to inform user cannot change password doesn't appear");

        String actualMsg2 = homePage.getTitleErrorMessageCommonInForms();
        String expectedMsg2 = "Password change failed. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg2, expectedMsg2, "User can change password successfully thought confirm password doesn't match");
    }
}
