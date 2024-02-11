package tests;
import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthentificationScreen;
public class LoginSecondTest extends AppiumConfig {
    @Test
    public void loginSuccess() {
        new AuthentificationScreen(driver)
                .fillEmail("test.anna.book@gmail.com")
                .fillPassword("SAMASAMa2023@")
                .submitLogin()
                .isAccountOpened()
                .logout();
    }
    @Test
    public void loginSuccessModel() {
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("test.anna.book@gmail.com")
                        .password("SAMASAMa2023@").build())
                .submitLogin()
                .isAccountOpened()
                .logout();
    }
    @Test
    public void loginWrongEmail(){
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("test.anna.bookgmail.com")
                        .password("SAMASAMa2023@").build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");
    }

    @Test
    public void loginWrongPassword(){
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("test.anna.book@gmail.com")
                        .password("SAMASAMa2023").build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");
    }
}