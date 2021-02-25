package com.telran;

import com.telran.config.BaseTest;
import com.telran.pageobject.SplashScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchAppTest extends BaseTest {

    @Test
    public void launchTest() {
        String version = new SplashScreen(driver).getCurrentVersion();
        Assert.assertEquals(version, "0.0.3");
    }

    @Test
    public void checkVersion() {
        new SplashScreen(driver).checkVersion("0.0.3");
    }
}
