package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.steps.Steps;

@Owner("yuliaorlova")
@Feature("Mobile тесты")
@DisplayName("Mobile тесты для приложения Wikipedia")
@Tags({@Tag("mobile"), @Tag("high"), @Tag("critical")})
@Severity(SeverityLevel.CRITICAL)
public class AndroidWikipediaTests extends TestBase {
    Steps steps = new Steps();

    @Test
    @DisplayName("Проверка работы Onboarding Screen")
    void onboardingScreenTest() {

        steps
             .checkContentScreen("The Free Encyclopedia\n" +
                        "…in over 300 languages")
             .openNextScreen()
             .checkContentScreen("New ways to explore")
             .openNextScreen()
             .checkContentScreen("Reading lists with sync")
             .openNextScreen()
             .checkContentScreen("Send anonymous data")
             .openFinishedScreen()
             .checkFinishedScreen();
    }

    @Test
    @DisplayName("Проверка работы вкладок footter-меню")
    void checkFootterTabbarTest() {

        steps
             .skipLanguage()
             .switchTabFootter("Explore")
             .checkTabExplore("Customize your Explore feed")
             .switchTabFootter("Saved")
             .checkTabSaved("Sync reading lists")
             .switchTabFootter("Search")
             .checkTabSearch("History")
             .switchTabFootter("Edits")
             .checkTabEdits("Did you know that everyone can edit Wikipedia?")
             .switchTabFootter("More")
             .checkTabMore();
    }

    @Test
    @DisplayName("Проверка работы перехода по содержанию статьи")
    void checkChapterOfArticleTest() {
        String searchWord = "appium";

        steps
             .skipLanguage()
             .searchRequest(searchWord)
             .verifyContentFound()
             .openRequestArticle(searchWord)
             .checkArticle()
             .switchTabContents()
             .checkTabContents()
             .switchArticleTitleAndCheck(searchWord)
             .switchTabContents()
             .switchArticleChapterAndCheck("History")
             .switchTabContents()
             .switchArticleChapterAndCheck("References")
             .switchTabContents()
             .switchArticleChapterAndCheck("External links")
             .switchTabContents()
             .switchArticleChapterAndCheck("About this article");
    }

    @Test
    @DisplayName("Проверка работы поиска и открытия статьи по слову")
    void searchWordTest() {
        String searchWord = "Selenide";

        steps
             .skipLanguage()
             .searchRequest(searchWord)
             .verifyContentFound()
             .openFirstArticle()
             .checkArticle();
    }

    @Test
    @DisplayName("Проверка работы поиска и открытия статьи по фразе")
    void searchPhraseTest() {
        String searchPhrase = "Mobile testing";

        steps
             .skipLanguage()
             .searchRequest(searchPhrase)
             .verifyContentFound()
             .openRequestArticle(searchPhrase)
             .checkArticle();
    }
}





