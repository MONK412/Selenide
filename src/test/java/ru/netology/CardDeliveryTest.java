package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    @Test
    void test1() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Калининград");
//        $("[class='menu-item__control']").click();
        $("[data-test-id='date'] input").sendKeys(Keys.CONTROL + "A");
        $("[data-test-id='date'] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue("05.09.2022");
        $("[data-test-id='name'] input").setValue("Мунир-Ислям Рустам");
        $("[data-test-id='phone'] input").setValue("+75864127846");
        $("[data-test-id='agreement']").click();
        $x("//span[@class='button__text']").click();
        $("[class='spin spin_size_m spin_visible spin_theme_alfa-on-color']").
                shouldBe(visible);
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
    }
}
