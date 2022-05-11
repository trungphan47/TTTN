package Railway.Register;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC24 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC24 - Verify that user cannot register account with PID info has 8 chars")

    public void TC24() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Register\" tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3: Enter PID info has 8 chars");
        System.out.println("Step 4: Enter valid info for the remaining fields");
        System.out.println("Step 5: Click Register button");
        String password = Utilities.getPasswordRandom();
        String confirmPassword = password;
        registerPage.register(Utilities.getEmailRandom(), password, confirmPassword, Utilities.conditionalPIDRandom(17));

        String actualMsg = registerPage.getRegisterSuccessMessage();
        String expectedMsg = "You're here";

        Assert.assertEquals(actualMsg, expectedMsg, "Error register function");
    }
}
