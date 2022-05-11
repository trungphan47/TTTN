package Railway.Register;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC06 - Verify that user cannot register an account if Email field is blank")

    public void TC06() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Register\" tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3:  Blank Email field and enter valid information other fields");
        System.out.println("Step 4: Click on \"Register\" button");
        String password = Utilities.getPasswordRandom();
        String pid = Utilities.getPidRandom();
        registerPage.register("", password, password, pid);

        String actualMsg = registerPage.getErrorInvalidEmailLengthMessage();
        String expectedMsg = "Invalid email length";

        String actualMsg1 =  registerPage.getErrorRegisterAccountFail();
        String expectedMsg1 = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error register function");
        Assert.assertEquals(actualMsg1, expectedMsg1, "Error register function");
    }
}

