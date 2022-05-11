package Railway;

import Common.Constant;
import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC003 - User cannot log into Railway with invalid password")

    public void TC03() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Login\" tab");
        homePage.goToLoginPage();

        System.out.println("Step 3: Enter valid Email and invalid Password");
        loginPage.login(Constant.USERNAME, Utilities.getPasswordRandom());

        System.out.println("Step 4: Click on \"Login\" button");
        String actualMsg = loginPage.getErrorPasswordMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form";
        Assert.assertEquals(actualMsg, expectedMsg, "An error message doesn't display");
    }
}
