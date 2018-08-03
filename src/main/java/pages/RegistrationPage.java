package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    @FindBy(id = "id_gender1")
    private WebElement genderRadioOption;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailIdField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "days")
    private WebElement daySelector;

    @FindBy(id = "months")
    private WebElement monthSelector;

    @FindBy(id = "years")
    private WebElement yearSelector;

    @FindBy(id = "firstname")
    private WebElement address_FirstName;

    @FindBy(id = "lastname")
    private WebElement address_LastName;

    @FindBy(id = "company")
    private WebElement address_Company;

    @FindBy(id = "address1")
    private WebElement full_Address;

    @FindBy(id = "city")
    private WebElement cityName;

    @FindBy(id = "id_state")
    private WebElement stateName;

    @FindBy(id = "postcode")
    private WebElement postalCode;

    @FindBy(id = "phone_mobile")
    private WebElement mobileNumber;

    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    public void select_Gender() {
        genderRadioOption.click();
    }

    public void input_Firstname(String fn, ExtentTest logger) {
        firstNameField.sendKeys(fn);
        logger.info("Firstname entered");
    }

    public void input_Lastname(String ln, ExtentTest logger) {
        lastNameField.sendKeys(ln);
        logger.info("Lastname entered");
    }

    public void input_Emailid(String email, ExtentTest logger) {
        emailIdField.sendKeys(email);
        logger.info("Emailid Entered");
    }

    public void input_Password(String pass, ExtentTest logger) {
        passwordField.sendKeys(pass);
        logger.info("Password Entered");
    }

    public void input_DOB(ExtentTest logger) {
        Select se1 = new Select(daySelector);
        se1.selectByValue("1");
        logger.info("Day selected");

        Select se2 = new Select(monthSelector);
        se2.selectByValue("1");
        logger.info("Month selected");

        Select se3 = new Select(yearSelector);
        se3.selectByValue("2018");
        logger.info("Year selected");
    }

    public void input_Address(String fn, String ln, String add, ExtentTest logger) {
        address_FirstName.sendKeys(fn);
        address_LastName.sendKeys(ln);
        full_Address.sendKeys(add);

    }

    public void input_City(String city) {
        cityName.sendKeys(city);
    }

    public void input_StateName(ExtentTest logger) {
        Select se1 = new Select(stateName);
        se1.selectByValue("1");
        logger.info("State selected");
    }

    public void input_Zipcode(String pin, ExtentTest logger) {
        postalCode.sendKeys(pin);
        logger.info("Zipcode entered");
    }

    public void input_MobileNumber(String num, ExtentTest logger) {
        mobileNumber.sendKeys(num);
        logger.info("Mobile Number entered");
    }

    public void click_SubmitButton(ExtentTest logger) {
        submitButton.click();
        logger.info("Submit button Clicked");
    }

    public String getUserFullName() {
        return firstNameField.getAttribute("value") + " " + lastNameField.getAttribute("value");
    }
}
