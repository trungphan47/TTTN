package Railway.Login;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC29 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC29 - System shows message when user enters wrong password several times")

    public void TC29() throws InterruptedException {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Login\" tab");
        homePage.goToLoginPage();

        System.out.println("Step 3:  Enter valid information into \"Username\" textbox except \"Password\" textbox.");
        System.out.println("Step 4: Repeat step 4 three more times.");
        loginPage.multipleLoginWithInvalidPassword(4);
        String actualMsg = loginPage.getErrorLoginInvalidUsernameOrPassword();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg,
                "There is no message is display to notify the maximum times which user can login with incorrect password");
    }
}
