package Railway.Contact;

import Common.JsonHelper;
import Common.Utilities;
import PageObjects.ContactPage;
import PageObjects.HomePage;
import Railway.TestBase;
import com.google.gson.JsonObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC40 extends TestBase {
    HomePage homePage = new HomePage();
    ContactPage contactPage = new ContactPage();

    @Test(description = "TC40 - Verify that contact infor displays", dataProvider = "data-provider")

    public void TC40( String seatCode, String phone, String skype, String email) {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Contact page");
        System.out.println("Step 3: Get information below");
        homePage.goToContactTab();

        String actualObject = contactPage.getSeatCode();
        //System.out.println(actualObject.ge);

//        String actualObj = contactPage.getSeatCode();
//

//        String actualMsg1 = contactPage.getSeatCode();
//        String expectedMsg1 = seatCode;
//        Assert.assertEquals(actualMsg1,expectedMsg1,"Seat Code does not exit");

//        String actualMsg2 = contactPage.getPhone();
//        Object expectedMsg2 = dataTC37;
//        Assert.assertEquals(actualMsg2, expectedMsg2,"Phone does not exit");
//
//        String actualMsg3 = contactPage.getSkype();
//        String expectedMsg3 = skype;
//        Assert.assertEquals(actualMsg3, expectedMsg3,"Skype does not exit");
//
//        String actualMsg4 = contactPage.getEmail();
//        String expectedMsg4 = email;
//        Assert.assertEquals(actualMsg4, expectedMsg4,"Email does not exit");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC37 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String seatCode = dataTC37.get("seatCode").getAsString();
        String phone = dataTC37.get("phone").getAsString();
        String skype = dataTC37.get("skype").getAsString();
        String email = dataTC37.get("email").getAsString();

        Object[][] object = new Object[][]{
                {seatCode, phone, skype, email}
        };
        return object;
    }
}
