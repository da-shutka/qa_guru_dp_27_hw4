import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearchTest {
    @BeforeAll
    static void settingsBeforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    void searchExampleJUni5(){
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $$("#wiki-body ul li").shouldHave(itemWithText("Soft assertions"));
        $$("#wiki-body ul li a").findBy(text("Soft Assertions")).click();
        $$(".markdown-heading .heading-element").filterBy(text("JUnit5")).shouldHave(size(1));
    }
}
