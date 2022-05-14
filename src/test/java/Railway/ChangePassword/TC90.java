package Railway.ChangePassword;

import Common.Utilities;
import PageObjects.ChangePasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC90 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    LoginPage loginPage = new LoginPage();
    String email = Utilities.getEmailRandom();
    String password = Utilities.getPasswordRandom();
    String pid = Utilities.getPidRandom();
    String newPassword = Utilities.getPasswordRandom();
    String confirmNewPassword = newPassword;

    @Test(description = "TC90 - Verify that user cannot change password with \n" +
            "incorrect current password info")

    public void TC90() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Login with valid account");
        homePage.goToRegisterPage();
        registerPage.register(email, password, password, pid);
        homePage.goToLoginPage();
        loginPage.login(email, password);

        System.out.println("Step 3: Go to Change password tab");
        homePage.goToChangePasswordPage();

        System.out.println("Step 4: Enter incorrect current password info");
        System.out.println("Step 5: Click \"Change password\" button");
        changePasswordPage.changePassword("123456789", newPassword, confirmNewPassword);
        String actualMsg = changePasswordPage.changePasswordMess();
        String expectedMsg = "An error occurred when attempting to change the password. Maybe your current password is incorrect.";
        Assert.assertEquals(actualMsg, expectedMsg, "Changepassword is failed");
    }
}
