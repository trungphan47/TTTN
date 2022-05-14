package Railway.ChangePassword;

import Common.Utilities;
import PageObjects.ChangePasswordPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC89 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    LoginPage loginPage = new LoginPage();
    String email = Utilities.getEmailRandom();
    String password = Utilities.getPasswordRandom();
    String pid = Utilities.getPidRandom();
    String newPassword = Utilities.getPasswordRandom();
    String confirmNewPassword = newPassword;

    @Test(description = "TC89 - Verify that user can change password with valid info")

    public void TC89() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Login with valid account");
        homePage.goToRegisterPage();
        registerPage.register(email, password, password, pid);
        homePage.goToLoginPage();
        loginPage.login(email, password);

        System.out.println("Step 3: Go to Changepassword tab");
        homePage.goToChangePasswordPage();
        changePasswordPage.changePassword(password, newPassword, confirmNewPassword);
        String actualMsg = changePasswordPage.changePasswordMess();
        String expectedMsg = "Your password has been updated!";
        Assert.assertEquals(actualMsg, expectedMsg, "Changepassword is failed");
    }
}
