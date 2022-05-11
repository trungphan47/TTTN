package Railway.MyTicket;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyTicketPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC60 extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage=new MyTicketPage();

    @Test(description = "TC060 - Verify that user can navigate My Ticket tab")

    public void TC60() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Login\" tab");
        homePage.goToLoginPage();

        System.out.println("Step 3: User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox ");
        System.out.println("Step 4: Click on \"Login\" button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 5: Click on \"My Ticket\" tab ");
        homePage.goToMyTicketPage();

        String actualMsg = myTicketPage.getLabelTitle();
        String expectedMsg = "Manage Tickets";
        Assert.assertEquals(actualMsg, expectedMsg, "Expected and actual results are different.");
    }
}
