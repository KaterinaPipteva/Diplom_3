package ru.yandex.praktikum;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class ConstructorGoogleTest {

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
