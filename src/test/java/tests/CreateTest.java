package tests;


import data.EditData;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import properties.BaseTest;

import static org.testng.Assert.assertTrue;


public class CreateTest extends BaseTest {

    @Test(dataProvider = "customer")
    public void checkFunctionalBooking(String name, String phone) throws Exception {
        actions.fillTheBookingForm(name, phone);
        editData = EditData.generateTextAlertMessage();
        Assert.assertEquals("Test fail, because function \"Booking\" has'nt realised yet",
                actions.getAllertTextMessage(), editData.getAlertMessage());
    }

    @Test
    public void checkErrorMessages() throws Exception {
        editData = EditData.generateTextErrorMessages();
        actions.fillEmptyTheBookingForm();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actions.findErrorMessageEmptyName(editData), "Text of error message of Empty " +
                "name doesn't display");
        softAssert.assertTrue(actions.findErrorMessageEmptyPhone(editData), "Text of error message of Empty " +
                "phone doesn't display");
        softAssert.assertTrue(actions.findErrorMessageWrongPhone(editData), "Text of error message of Wrong " +
                "phone doesn't display");

        softAssert.assertAll();
    }
}
