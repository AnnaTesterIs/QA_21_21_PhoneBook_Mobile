package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthentificationScreen;
import screens.SplashScreen;
import lombok.Builder;
@Test
public class LoginTests extends AppiumConfig {
    public void loginSuccess(){
       // boolean result = new SplashScreen(driver)
                //.checkCurrentVersion("Version 1.0.0")
        boolean result = new AuthentificationScreen(driver)
                .fillEmail("test.anna.book@gmail.com")
                .fillPassword("SAMASAMa2023@")
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }
@Test
    public void loginSuccessModel(){
       //boolean result =  new SplashScreen(driver)
                //.checkCurrentVersion("Version 1.0.0")
    boolean result = new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("test.anna.book@gmail.com")
                        .password("SAMASAMa2023@").build())
                .submitLogin()
               .isActivityTitleDisplayed("Contact list");
    Assert.assertTrue(result);
}

    @Test
    public void loginSuccessModel2() {
        Assert.assertTrue(new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("test.anna.book@gmail.com")
                        .password("SAMASAMa2023@").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list"));


    }

@AfterMethod
    public  void postCondition(){

}

}
