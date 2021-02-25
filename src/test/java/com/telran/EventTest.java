package com.telran;

import com.telran.config.BaseTest;
import com.telran.model.Credentials;
import com.telran.model.Event;
import com.telran.pageobject.HomeScreen;
import com.telran.pageobject.SplashScreen;
import org.testng.annotations.Test;

public class EventTest extends BaseTest {

    @Test
    public void eventCreationTest() {
        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .complexLogin(Credentials.builder()
                        .username("user3@mail.com")
                        .password("123456Aa")
                        .build())
                .skipWizard()
                .checkFabPresent()
                .initCreationNew()
                .fillCreationForm(Event.builder()
                        .title("new Event")
                        .type("event")
                        .breaks(2)
                        .ammount(50)
                        .build())
                .confirmCreation()
                .checkFabPresent();


    }
}
