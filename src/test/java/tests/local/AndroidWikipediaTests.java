package tests.local;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidWikipediaTests extends TestBase {

    @Test
    @Tag("android_local")
    @DisplayName("Successful onboarding")
    void onboardingTest() {
        step("Verify that first screen opened", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("The Free Encyclopedia …in over 300 languages")));
        step("Click continue button", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                        .click());
        step("Verify that second screen opened", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("New ways to explore")));
        step("Click continue button", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                        .click());
        step("Verify that third screen opened", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Reading lists with sync")));
        step("Click continue button", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                        .click());
        step("Verify that forth screen opened", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Send anonymous data")));
    }

    @Test
    @Tag("android_local")
    @DisplayName("Successful search")
    void successfulSearchTest() {
        step("skip screen", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}
