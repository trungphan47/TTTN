package Railway;


import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC002 - User can't login with blank \"Username\" textbox")

    public void TC02() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Login\" tab");
        homePage.goToLoginPage();

        System.out.println("Step 3: User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox ");
        System.out.println("Step 4: Click on \"Login\" button");
        loginPage.login("", Constant.PASSWORD);

        String actualMsg = loginPage.getErrorUseNameBlanksMessage();
        String expectedMsg = "You must specify a username.";
        Assert.assertEquals(actualMsg, expectedMsg, "There was a problem with your login and/or errors exist in your form.");
    }
}
