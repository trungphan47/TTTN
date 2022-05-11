package Railway.Register;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC15 - Verify that user cannot register account with Email field " +
            "includes more than 2 valid emails")

    public void TC15() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Register\" tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3: Enter email info with 38 characters");
        System.out.println("Step 4: Enter valid info for the remaining fields");
        System.out.println("Step 5: Click Register button");
        String email = Utilities.conditionalEmailRandom(13);
        String email2 = email + email;
        String password = Utilities.getPasswordRandom();
        String confirmPassword = password;
        registerPage.register(email2, password, confirmPassword, Utilities.getPidRandom());


        String actualMsg1 = registerPage.getErrorRegisterAccountFail();
        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg1, expectedMsg1, "Error register function");
    }
}
