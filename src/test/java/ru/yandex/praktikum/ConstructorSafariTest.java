package ru.yandex.praktikum;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class ConstructorSafariTest {
    //тесты на Safari браузере (не яндекс потому что куратор писал,
    // что главное реализовать тесты в браузере отличном от GoogleChrome,
    // а с Яндекс у меня никак не получалось на селениде это реализовать)
    @BeforeClass
    public static void setProperties(){
        Configuration.browser = "safari";
    }

    MainPage mainPage;

    @Before
    public void setUp(){
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
    }

    @Test
    @DisplayName("make active souse tab in constructor")
    @Description("Test of make active souse tab in constructor by clicking on it")
    public void goToTheSouseTabTest(){
        mainPage.clickOnSouseTab();
        String actualNameTab = mainPage.getNameOfActiveTab();
        assertEquals("Соусы", actualNameTab);
    }

    @Test
    @DisplayName("make active filling tab in constructor")
    @Description("Test of make active filling tab in constructor by clicking on it")
    public void goToTheFillingTabTest(){
        mainPage.clickOnFillingTab();
        String actualNameTab = mainPage.getNameOfActiveTab();
        assertEquals("Начинки", actualNameTab);
    }

    @Test
    @DisplayName("make active bun tab in constructor")
    @Description("Test of make active bun tab in constructor by clicking on it")
    public void goToTheBunTabTest(){
        //первым дейстием меняю таб, так как по умолчанию и так активен таб "булки"
        mainPage.clickOnSouseTab();
        mainPage.clickOnBunTab();
        String actualNameTab = mainPage.getNameOfActiveTab();
        assertEquals("Булки", actualNameTab);
    }
}
