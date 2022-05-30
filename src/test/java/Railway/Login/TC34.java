package Railway.Login;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC34 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC34 - User can't login with blank Password textbox")

    public void TC34() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Login\" tab");
        homePage.goToLoginPage();

        System.out.println("Step 3: Blank Password and enter Email fields ");
        System.out.println("Step 4: Click on \"Login\" button");
        loginPage.login(Constant.USERNAME, "");

        String actualMsg = loginPage.getErrorPasswordBlanksMessage();
        String expectedMsg = "You must specify a password.";
        Assert.assertEquals(actualMsg, expectedMsg, "There was a problem with your login and/or errors exist in your form.");
    }
}
