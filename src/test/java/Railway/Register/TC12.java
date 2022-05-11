package Railway.Register;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC12 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC12 - Verify that user can register an account with email info has 32 chars")

    public void TC12() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Register\" tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3: Enter email info with 32 characters");
        System.out.println("Step 4: Enter valid info for the remaining fields");
        System.out.println("Step 5: Click Register button");
        String password = Utilities.getPasswordRandom();
        String confirmPassword = password;
        registerPage.register(Utilities.conditionalEmailRandom(37), password, confirmPassword, Utilities.getPidRandom());
        String actualMsg = registerPage.getRegisterSuccessMessage();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg, expectedMsg, "User cannot register account");
    }
}