package Railway.Register;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC17 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC17 - Verify that user can register an account with password info has 8 chars")

    public void TC17() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Register\" tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3: Enter password info with 8 characters");
        System.out.println("Step 4: Enter valid info for the remaining fields");
        System.out.println("Step 5: Click Register button");
        String password = Utilities.conditionalPasswordRandom(17);
        String confirmPassword = password;
        registerPage.register(Utilities.getEmailRandom(), password, confirmPassword, Utilities.getPidRandom());

        String actualMsg = registerPage.getRegisterSuccessMessage();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg, expectedMsg, "User cannot register account");
    }
}
