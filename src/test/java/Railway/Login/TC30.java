package Railway.Login;

import Common.Constant;
import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC30 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC30 - Verify that user cannot login with an existing email is not registered ")

    public void TC30() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Login\" tab");
        homePage.goToLoginPage();

        System.out.println("Step 3: Enter email which is not registered and password");
        System.out.println("Step 4: Click on Login button");
        loginPage.login(Utilities.getEmailRandom(), Constant.PASSWORD);

        String actualMsg = loginPage.getErrorLoginInvalidUsernameOrPassword();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error login function");
    }
}