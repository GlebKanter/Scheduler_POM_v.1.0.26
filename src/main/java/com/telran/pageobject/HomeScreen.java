package com.telran.pageobject;

import com.telran.model.Event;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class HomeScreen extends BaseScreen {
    @AndroidFindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;
    @AndroidFindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_add_event']")
    MobileElement fabAddEvent;


    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean isFubButtonPresent() {
        should(fabAdd, 15);
        return true;
    }

    public HomeScreen checkFabPresent() {
        should(fabAdd, 15);
        return this;
    }

    public EditCreatEventScreen initCreationNew() {
        fabAdd.click();
        fabAddEvent.click();
        return new EditCreatEventScreen(driver);
    }

}

