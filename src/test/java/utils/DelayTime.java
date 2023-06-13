package utils;

import io.qameta.allure.Step;

public class DelayTime {

    @Step("Wait some time")
    public static void delay(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
