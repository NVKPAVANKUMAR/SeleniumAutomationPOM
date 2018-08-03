package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {

    @FindBy(id = "email_create")
    private WebElement emailField;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    public void input_Email(String mailId, ExtentTest logger) {
        emailField.sendKeys(mailId);
        logger.info("Email id entered for signup");
    }


    public boolean isCreateButtonExist() {
        return createAccountButton.isDisplayed();
    }

    public void click_createAccountButton(ExtentTest logger) {
        createAccountButton.click();
        logger.info("Create Button Clicked");
    }
}
