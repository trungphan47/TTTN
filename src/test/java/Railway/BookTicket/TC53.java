package Railway.BookTicket;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC53 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC53 - Verify that user can navigate to Book tab")

    public void TC53() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 2: Go to Book ticket page");
        homePage.goToBookTicketPage();

        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Book ticket";
        Assert.assertEquals(actualMsg, expectedMsg, "Book ticket page is not displayed as expected");
    }
}
