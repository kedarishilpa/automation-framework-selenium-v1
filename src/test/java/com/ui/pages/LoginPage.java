package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.User;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public final class LoginPage extends BrowserUtility {
	

	Logger logger = LoggerUtility.getLogger(this.getClass());
    
    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("passwd");
    private static final By SUBMIT_BUTTON = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWith(User user) {
        logger.info("Performing login with user: {}", user.getEmailAddress());

        setText(EMAIL_INPUT, user.getEmailAddress());
        setText(PASSWORD_INPUT, user.getPassword());
        clickOn(SUBMIT_BUTTON);

        return new MyAccountPage(getDriver());
    }
}
