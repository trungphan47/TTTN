package Railway.ChangePassword;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC88 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC88 - Verify that user can navigate to Change password tab")

    public void TC88() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Login with valid account");
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 3: Click on Changepassword tab");
        homePage.goToChangePasswordPage();
        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Change password";
        Assert.assertEquals(actualMsg, expectedMsg, "Changepassword page does not display");
    }
}
