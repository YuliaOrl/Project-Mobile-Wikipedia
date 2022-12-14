package tests.steps;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class Steps {

    public Steps skipLanguage() {
        step("Пропуск выбора языка", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        return this;
    }

    public Steps checkArticle() {
        step("Проверка отображения статьи", () ->
                $(AppiumBy.className("android.webkit.WebView")).shouldBe(visible));
        return this;
    }

    public Steps checkContentScreen(String content) {
        step("Проверка контента страницы onboarding screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text(content));
            $(AppiumBy.id("org.wikipedia.alpha:id/imageViewCentered")).shouldBe(visible);
        });
        return this;
    }

    public Steps openNextScreen() {
        step("Переход на следующую страницу", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        return this;
    }

    public Steps openFinishedScreen() {
        step("Открытие последней страницы onboarding screen", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click());
        return this;
    }

    public Steps checkFinishedScreen() {
        step("Проверка успешного завершения процесса onboarding", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_text")).shouldBe(visible);
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).shouldBe(visible);
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_header_image")).shouldBe(visible);
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_text"))
                    .shouldHave(Condition.text("Customize your Explore feed"));
        });
        return this;
    }

    public Steps switchTabFootter(String content) {
        step("Переход в следующий раздел footter menu", () ->
                $(AppiumBy.accessibilityId(content)).click());
        return this;
    }

    public Steps checkTabExplore(String content) {
        step("Проверка контента раздела \"Explore\"", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_text")).shouldHave(Condition.text(content)));
        return this;
    }

    public Steps checkTabSaved(String content) {
        step("Проверка контента раздела \"Saved\"", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/messageTitleView")).shouldHave(text(content)));
        return this;
    }

    public Steps checkTabSearch(String content) {
        step("Проверка контента раздела \"Search\"", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/history_title")).shouldHave(text(content)));
        return this;
    }

    public Steps checkTabEdits(String content) {
        step("Проверка контента раздела \"Edits\"", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/messageTitleView")).shouldHave(text(content)));
        return this;
    }

    public Steps checkTabMore() {
        step("Проверка раздела \"More\"", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/touch_outside")).shouldBe(visible));
        return this;
    }

    public Steps switchTabContents() {
        step("Переход в раздел \"Contents\"", () ->
                $(AppiumBy.accessibilityId("Contents")).click());
        return this;
    }

    public Steps checkTabContents() {
        step("Проверка раздела \"Contents\"", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/toc_list")).shouldBe(visible));
        return this;
    }

    public Steps switchArticleTitleAndCheck(String content) {
        step("Переход в загаловок статьи и его проверка", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_toc_item_text")).findBy(text(content)).click();
            $(AppiumBy.className("android.webkit.WebView")).shouldHave(text(content));
        });
        return this;
    }

    public Steps switchArticleChapterAndCheck(String content) {
        step("Переход в раздел статьи и его проверка", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_toc_item_text")).findBy(text(content)).click();
            $(AppiumBy.className("android.widget.TextView")).shouldBe(visible);
        });
        return this;
    }

    public Steps searchRequest(String searchRequest) {
        step("Ввод поискового запроса", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchRequest);
        });
        return this;
    }

    public Steps verifyContentFound() {
        step("Проверка, что результаты найдены", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
        return this;
    }

    public Steps openFirstArticle() {
        step("Открытие первой найденной статьи", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).first().click());
        return this;
    }

    public Steps openRequestArticle(String searchRequest) {
        step("Открытие стать по поисковому запросу", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).findBy(text(searchRequest)).click());
        return this;
    }
}
