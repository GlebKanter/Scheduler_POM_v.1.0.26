package com.telran;

import com.telran.config.BaseTest;
import com.telran.model.Credentials;
import com.telran.pageobject.SplashScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void loginTest() {
        boolean isFabPresent =
                new SplashScreen(driver)
                        .checkVersion("0.0.3")
                        .fillEmail("user2@mail.com")
                        .fillPassword("Bb123456")
                        .tapLoginButton()
                        .skipWizard()
                        .isFubButtonPresent();
        Assert.assertTrue(isFabPresent);
    }

    @Test
    public void loginComplexTest() {
        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .complexLogin(Credentials.builder()
                        .username("user3@mail.com")
                        .password("123456Aa")
                        .build())
                .skipWizard()
                .checkFabPresent();

    }
}
