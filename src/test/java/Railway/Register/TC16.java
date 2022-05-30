package Railway.Register;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC16 - Verify that user cannot register account with incorrect email format ")

    public void TC16() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Register\" tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3: Enter incorrect email info");
        System.out.println("Step 4: Enter valid info for the remaining fields");
        System.out.println("Step 5: Click Register button");
        String email = Utilities.getPasswordRandom();
        String password = Utilities.conditionalPasswordRandom(17);
        String confirmPassword = password;
        registerPage.register(email, password, confirmPassword, Utilities.getPidRandom());

        String actualMsg = registerPage.getErrorInvalidEmailLengthMessage();
        String expectedMsg = "Invalid email address";
        Assert.assertEquals(actualMsg, expectedMsg, "User cannot register account");

        String actualMsg1 = registerPage.getErrorRegisterAccountFail();
        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg1, expectedMsg1, "Error register function");
    }
}
