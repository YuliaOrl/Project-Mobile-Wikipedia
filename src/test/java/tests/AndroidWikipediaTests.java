package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("yuliaorlova")
@Feature("Mobile тесты")
@DisplayName("Mobile тесты для приложения Wikipedia")
public class AndroidWikipediaTests extends TestBase {
    Steps steps = new Steps();

    @Test
    void OnboardingScreenTest() {

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
    void CheckFootterTabbarTest() {

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
    void CheckChapterOfArticleTest() {
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
    void SearchWordTest() {
        String searchWord = "Selenide";

        steps
             .skipLanguage()
             .searchRequest(searchWord)
             .verifyContentFound()
             .openFirstArticle()
             .checkArticle();
    }

    @Test
    void SearchPhraseTest() {
        String searchPhrase = "Mobile testing";

        steps
             .skipLanguage()
             .searchRequest(searchPhrase)
             .verifyContentFound()
             .openRequestArticle(searchPhrase)
             .checkArticle();
    }
}





