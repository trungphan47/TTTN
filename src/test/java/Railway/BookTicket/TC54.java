package Railway.BookTicket;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC54 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC54 - Verify that user can not book ticket if not logged in yet")

    public void TC54() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Book ticket page");
        homePage.goToBookTicketPage();

        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Login Page";
        Assert.assertEquals(actualMsg, expectedMsg, "TC54 error");
    }
}
