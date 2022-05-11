package Railway.Register;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC21 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC21 - Verify that user cannot register an account with\n" +
            "password info has more than 64 chars")

    public void TC21() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Register\" tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3:  Enter confirm password doesn't fix with");
        System.out.println("Step 4: Enter valid info for the remaining fields");
        System.out.println("Step 5: Click Register button");
        String password = Utilities.getPasswordRandom();
        String confirmPassword = Utilities.getPasswordRandom();
        registerPage.register(Utilities.getEmailRandom(), password, confirmPassword, Utilities.getPidRandom());

        String actualMsg = registerPage.getErrorDoNotMatchPass();
        String expectedMsg = "The two passwords do not match";

        String actualMsg1 = registerPage.getErrorRegisterAccountFail();
        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error register function");
        Assert.assertEquals(actualMsg1, expectedMsg1, "Error register function");
    }
}
