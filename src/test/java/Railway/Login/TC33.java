package Railway.Login;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC33 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC33 - User can't login with blank \"Username\" textbox")

    public void TC33() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Login\" tab");
        homePage.goToLoginPage();

        System.out.println("Step 3: Blank Email and enter Password fields ");
        System.out.println("Step 4: Click on \"Login\" button");
        loginPage.login("", Constant.PASSWORD);

        String actualMsg = loginPage.getErrorUseNameBlanksMessage();
        String expectedMsg = "You must specify a username.";
        Assert.assertEquals(actualMsg, expectedMsg, "There was a problem with your login and/or errors exist in your form.");
    }
}
