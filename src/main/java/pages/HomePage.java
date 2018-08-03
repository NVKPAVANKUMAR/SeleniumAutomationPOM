package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "//*[@class=\"logo img-responsive\"]")
    private WebElement homePageLogo;

    @FindBy(xpath = "//*[@class=\"login\"]")
    private WebElement signInButton;

    public boolean isLogoPresent() {
        return homePageLogo.isDisplayed();
    }

    public void clickOnSignIn(ExtentTest logger) {
        signInButton.click();
        logger.info("Clicked on Signin Button");
    }
}
