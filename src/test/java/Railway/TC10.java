package Railway;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can't create account with an already in-use email")

    public void TC10() {
        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        homePage.goToRegisterPage();
        String username = Utilities.getEmailRandom();
        String password = Utilities.getPasswordRandom();
        String confirmPassword = password;
        String pid = Utilities.getPidRandom();
        registerPage.register(username, password, confirmPassword, pid);

        System.out.println("Step 1: Navigate to QA Railway Website ");
        homePage.open();

        System.out.println("Step 2: Click on \"Register\" tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3: Enter information of the created account in Pre-condition");
        registerPage.register(username, password, confirmPassword, pid);

        System.out.println("Step 4: Click on \"Register\" button");
        String actualMsg = registerPage.getErrorEmailMessage();
        String expectedMsg = "This email address is already in use.";
        Assert.assertEquals(actualMsg, expectedMsg, "User can register account with an exiting email");
    }
}
