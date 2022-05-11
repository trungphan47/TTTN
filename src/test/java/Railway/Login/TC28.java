package Railway.Login;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC28 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC28 - Verify that user can login with valid account.")

    public void TC28() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Login\" tab");
        homePage.goToLoginPage();

        System.out.println("Step 3 & 4: Enter valid Email, Password and Click on \"Login\" button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
