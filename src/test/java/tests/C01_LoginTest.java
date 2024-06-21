package tests;


import org.testng.annotations.Test;
import pages.CLContactPage;
import pages.CLHomePage;
import utilities.ConfigReader;
import utilities.Driver;

import static org.testng.Assert.assertEquals;

public class C01_LoginTest {

    @Test
    public void loginTest01() {

        CLHomePage clHomePage = new CLHomePage();
        CLContactPage clContactPage = new CLContactPage();

        //Go to url
        Driver.getDriver().get(ConfigReader.getProperty("contact_list_url"));

        //Enter email
        clHomePage.email.sendKeys("xyz@gmail.com");

        //Enter password
        clHomePage.password.sendKeys("1234567");

        //Click submit
        clHomePage.submit.click();

        //Assert Contact List Header
        assertEquals(clContactPage.header.getText(), "Contact List");
        assert clContactPage.logout.isDisplayed();

        Driver.closeDriver();
    }


}
