package Railway;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User is redirected to Book ticket page after logging in")

    public void TC04() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Book ticket\" tab");
        homePage.goToBookTicketPage();
        String actualMsgLoginPg = homePage.getNamePagesTitle();
        String expectedMsgLoginPg = "Login Page";
        Assert.assertEquals(actualMsgLoginPg, expectedMsgLoginPg, "Cannot go to Book ticket page");

        System.out.println("Step 3: Login with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsgBookTicketPg = homePage.getNamePagesTitle();
        String expectedMsgBookTicketPg = "Book ticket";
        Assert.assertEquals(actualMsgBookTicketPg, expectedMsgBookTicketPg, "Cannot go to Book ticket page");
    }
}
