package Railway.MyTicket;

import Common.Utilities;
import PageObjects.*;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC79 extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can filter tickets by choosing Depart Station and Arrive Station incorrect DepartDate")
    public void TC01() {

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        homePage.goToRegisterPage();
        String username = Utilities.getEmailRandom();
        String password = Utilities.getPasswordRandom();
        String confirmPassword = password;
        String pid = Utilities.getPidRandom();
        String departDate = Utilities.getDepartDate(4);
        registerPage.register(username, password, confirmPassword, pid);

        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Login with a valid account");
        homePage.goToLoginPage();
        loginPage.login(username, password);

        System.out.println("Step 3: Book a ticket");
        homePage.goToBookTicketPage();
        bookTicketPage.clickBtnBookTicketMutilpleTime(6);

        System.out.println("Step 4: Click on \"My ticket\" tab");
        homePage.goToMyTicketPage();

        System.out.println("Step 5: Choosing Arriver Station");
        myTicketPage.selectDropDownArriveStation("Phan Thiết");

        System.out.println("Step 6: Choosing Depart Station");
        myTicketPage.selectDropDownDepartStation("Sài Gòn");

        System.out.println("Step 7: Enter incorrect DepartDate");
        myTicketPage.enterDepartDate(departDate + "1");

        System.out.println("Step 8: Click ApplyFilter button ");
        myTicketPage.clickApplyFilterButton();

        System.out.println("Step 9: Verify No Result Found Error Message Display");
        Assert.assertTrue(myTicketPage.isLblNoResultFoundErrorMessage(), "Tickets are display");

        System.out.println("Step 10: Verify Malformed Date Error Message Display");
        Assert.assertTrue(myTicketPage.isLblMalformedDateErrorMessage(), "Malformed Date Error Message not Display");
    }

    @Test(description = "User can filter tickets by choosing Depart Station and Arrive Station and incorrect DepartDate")
    public void TC02() {

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        homePage.goToRegisterPage();
        String username = Utilities.getEmailRandom();
        String password = Utilities.getPasswordRandom();
        String confirmPassword = password;
        String pid = Utilities.getPidRandom();
        String departDate = Utilities.getDepartDate(4);
        registerPage.register(username, password, confirmPassword, pid);

        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Login with a valid account");
        homePage.goToLoginPage();
        loginPage.login(username, password);

        System.out.println("Step 3: Book a ticket");
        homePage.goToBookTicketPage();
        bookTicketPage.clickBtnBookTicketMutilpleTime(6);

        System.out.println("Step 4: Click on \"My ticket\" tab");
        homePage.goToMyTicketPage();

        System.out.println("Step 5: Choosing Depart Station");
        myTicketPage.selectDropDownDepartStation("Đà Nẵng");

        System.out.println("Step 6: Choosing Arrive Station");
        myTicketPage.selectDropDownArriveStation("Huế");

        System.out.println("Step 7: Enter incorrect DepartDate");
        myTicketPage.enterDepartDate(departDate + "1");

        System.out.println("Step 8: Click ApplyFilter button ");
        myTicketPage.clickApplyFilterButton();

        System.out.println("Step 9: Verify No Result Found Error Message Display");
        Assert.assertTrue(myTicketPage.isLblNoResultFoundErrorMessage(), "Tickets are display");

        System.out.println("Step 10: Verify Malformed Date Error Message Display");
        Assert.assertTrue(myTicketPage.isLblMalformedDateErrorMessage(), "Malformed Date Error Message not Display");
    }
}
