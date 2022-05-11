package Railway;

import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can't create account while password and PID fields are empty")

    public void TC11() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Register\" tab");
        homePage.goToRegisterPage();

        System.out.println("Step 3:  Enter valid email address and leave other fields empty");
        System.out.println("Step 4: Click on \"Register\" button");
        registerPage.register(Utilities.getEmailRandom(), "", "", "");

        String actualMsg1 = registerPage.getErrorInvalidPasswordLengthMessage();
        String expectedResult1 = "Invalid password length";
        Assert.assertEquals(actualMsg1, expectedResult1, "Error message is not displayed");

        String actualMsg2 = registerPage.getErrorInvalidPidLengthMessage();
        String expectedResult2 = "Invalid ID length";
        Assert.assertEquals(actualMsg2, expectedResult2, "Error message is not displayed");

        String actualMsg3 = registerPage.getErrorRegisterAccountFail();
        String expectedResult3 = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg3, expectedResult3, "User can register account without password and PID");
    }
}
