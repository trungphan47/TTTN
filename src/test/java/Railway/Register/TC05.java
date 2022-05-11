package Railway.Register;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC05 - User can create new account")

    public void TC05() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Register\" tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3: Enter valid information into all fields");
        System.out.println("Step 4: Click on \"Register\" button");
        String password = Utilities.getPasswordRandom();
        String confirmPassword = password;
        String pid = Utilities.getPidRandom();
        registerPage.register(Utilities.getEmailRandom(), password, confirmPassword, pid);
        String actualMsg = registerPage.getRegisterSuccessMessage();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg, expectedMsg, "User cannot register account");
    }
}
