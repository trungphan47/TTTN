package Railway;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC08 - User can't login with an account hasn't been activated")

    public void TC08() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Login\" tab");
        homePage.goToLoginPage();

        System.out.println("Step 3: Enter username and password of account hasn't been activated.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 4: Click on \"Login\" button");
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "User can login with account is not active");
    }
}
