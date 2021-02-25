package com.telran.pageobject;

import com.telran.model.Event;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EditCreatEventScreen extends BaseScreen {
    public EditCreatEventScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_title_input']")
    MobileElement title;
    @AndroidFindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_type_input']")
    MobileElement type;
    @AndroidFindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_break_plus_btn']")
    MobileElement breakPlusBtn;
    @AndroidFindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_edit']")
    MobileElement wageEdit;
    @AndroidFindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_input']")
    MobileElement wageInput;
    @AndroidFindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_save']")
    MobileElement wageSave;
    @AndroidFindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/info_save_btn']")
    MobileElement confirmCreation;

    public EditCreatEventScreen fillCreationForm(Event event) {
        type(title, event.title());
        type(type, event.type());
        hideKeyboard();
        int breaks = event.breaks();
        if (breaks > 0) {
            for (int i = 0; i <= breaks - 1; i++) {
                breakPlusBtn.click();
            }
        }
        wageEdit.click();
        type(wageInput, String.valueOf(event.ammount()));
        wageSave.click();
        return this;

    }

    public HomeScreen confirmCreation() {
        confirmCreation.click();
        return new HomeScreen(driver);
    }


}
