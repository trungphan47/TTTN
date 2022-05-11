package Railway.Register;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC07 - Verify that user cannot register an account if Password field is blank")

    public void TC07() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Register\" tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3: Blank Password field and enter other valid info fields");
        System.out.println("Step 4: Click on \"Register\" button");

        String email = Utilities.getEmailRandom();
        String confirmPassword = Utilities.getPasswordRandom();
        String pid = Utilities.getPidRandom();
        registerPage.register(email, "", confirmPassword, pid);

        String actualMsg = registerPage.getErrorInvalidPasswordLengthMessage();
        String expectedMsg = "Invalid password length";
        Assert.assertEquals(actualMsg, expectedMsg, "Error register function");

        String actualMsg1 = registerPage.getErrorRegisterAccountFail();
        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg1, expectedMsg1, "Error register function");
    }
}
