package Railway.Register;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC19 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC19 - Verify that user cannot register an account with\n" +
            "password info has less than 8 chars")

    public void TC19() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Register\" tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3: Enter password has 7 chars");
        System.out.println("Step 4: Enter valid info for the remaining fields");
        System.out.println("Step 5: Click Register button");
        String password = Utilities.conditionalPasswordRandom(16);
        String confirmPassword = password;
        registerPage.register(Utilities.getEmailRandom(), password, confirmPassword, Utilities.getPidRandom());

        String actualMsg = registerPage.getErrorInvalidPasswordLengthMessage();
        String expectedMsg = "Invalid password length";

        String actualMsg1 = registerPage.getErrorRegisterAccountFail();
        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error register function");
        Assert.assertEquals(actualMsg1, expectedMsg1, "Error register function");
    }
}