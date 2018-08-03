package tests;

import com.github.javafaker.Faker;
import driver.BrowserInstance;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegistrationPage;
import pages.SignUpPage;
import utilities.ConfigParser;
import utilities.RandomEmailGenerator;
import utilities.RandomPasswordGenerator;

import java.io.IOException;

import static utilities.ReportGenerator.*;

public class TestRunner extends BrowserInstance {
    private Faker faker;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private RegistrationPage registrationPage;
    private MyAccountPage myAccountPage;


    @BeforeSuite
    public void setUp() throws IOException {
        startReport();
        initiateDriver(ConfigParser.fetchProperity("browser").toString());
        openUrl(ConfigParser.fetchProperity("testurl").toString());
        faker = new Faker();
        homePage = PageFactory.initElements(driver, HomePage.class);
        signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
    }

    @Test
    public void test_SignUp() {
        startTest(new Object() {
        }.getClass().getEnclosingMethod().getName());
        assert homePage.isLogoPresent() == true;
        homePage.clickOnSignIn(logger);
        assert signUpPage.isCreateButtonExist() == true;
        signUpPage.input_Email(RandomEmailGenerator.generate(), logger);
        signUpPage.click_createAccountButton(logger);
        registrationPage.select_Gender();
        registrationPage.input_Firstname(faker.name().firstName(), logger);
        registrationPage.input_Lastname(faker.name().lastName(), logger);
        String initialName = registrationPage.getUserFullName();
        registrationPage.input_Password(RandomPasswordGenerator.generate(), logger);
        registrationPage.input_DOB(logger);
        registrationPage.input_Address(faker.name().firstName(), faker.name().lastName(), faker.address().fullAddress(), logger);
        registrationPage.input_City(faker.address().city());
        registrationPage.input_StateName(logger);
        registrationPage.input_Zipcode("56001", logger);
        registrationPage.input_MobileNumber(faker.phoneNumber().cellPhone(), logger);
        registrationPage.click_SubmitButton(logger);
        assert myAccountPage.getUserName().equalsIgnoreCase(initialName);
        logger.pass("SignUp Flow PASSED");
    }


    @AfterClass
    public void tearDown() {
        endReport();
        driver.quit();
    }


}
