package Railway.Logout;

import Common.Constant;
import PageObjects.ContactPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.LogoutPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC101 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();
    ContactPage contactPage = new ContactPage();

    @Test(description = "TC101 - User can logout")

    public void TC101() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Login with valid Email and Password");
        homePage.goToLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("Step 3: Click on \"Contact\" tab");
        contactPage.gotoContactPage();

        System.out.println("Step 4: Click on \"Log out\" tab");
        logoutPage.goToLogOutPage();
        String actualMsgLogout = homePage.getNamePagesTitle();
        String expectedMsgLogout = "Welcome to Safe Railway";
        Assert.assertEquals(actualMsgLogout, expectedMsgLogout, "Welcome message is not displayed as expected");
    }
}
