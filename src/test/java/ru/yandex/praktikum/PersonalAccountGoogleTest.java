package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class PersonalAccountGoogleTest {
    String email;
    String password;
    MainPage mainPageAfterLogin;

    @Before
    public void setUp(){
        email = "r2d2robot@mail.ru";
        password = "123456";
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        mainPageAfterLogin = loginPage.loginWithEmailAndPassword(email, password);
    }

    @Test
    @DisplayName("Passage to the Personal account of user")
    @Description("Test of passage to the personal account of authorized user")
    public void passageToThePersonalAccountOfUser(){
        PersonalAccountPage personalAccountPage = mainPageAfterLogin.clickOnPersonalAccountButtonWhenUserAuthorized();
        personalAccountPage.orderHistoryTab.shouldBe(visible);

        //выход из аккаунта
        personalAccountPage.clickOnExitButton();
    }

    //Тест на Переход из личного кабинета в конструктор
    @Test
    @DisplayName("Passage to constructor from Personal account")
    @Description("Test of passage to constructor from personal account of authorized user")
    public void passageToConstructorFromPersonalAccountOfUser(){
        PersonalAccountPage personalAccountPage = mainPageAfterLogin.clickOnPersonalAccountButtonWhenUserAuthorized();
        MainPage mainPage = personalAccountPage.clickOnConstructorButton();
        mainPage.makeOrderButton.shouldBe(visible);

        //выход из аккаунта
        PersonalAccountPage personalAccountPage1 = mainPageAfterLogin.clickOnPersonalAccountButtonWhenUserAuthorized();
        personalAccountPage1.clickOnExitButton();
    }

    //Тест на Переход из личного кабинета в конструктор
    @Test
    @DisplayName("Passage to constructor by clicking on Stellar Burgers logo from Personal account")
    @Description("Test of passage to constructor by clicking on Stellar Burgers logo from personal account of authorized user")
    public void passageToConstructorByClickOnLogoFromPersonalAccountOfUser(){
        PersonalAccountPage personalAccountPage = mainPageAfterLogin.clickOnPersonalAccountButtonWhenUserAuthorized();
        MainPage mainPage = personalAccountPage.clickOnLogoStellarBurgers();
        mainPage.makeOrderButton.shouldBe(visible);

        //выход из аккаунта
        PersonalAccountPage personalAccountPage1 = mainPageAfterLogin.clickOnPersonalAccountButtonWhenUserAuthorized();
        personalAccountPage1.clickOnExitButton();
    }

    //Тест на Выход из аккаунта
    @Test
    @DisplayName("Exit from personal account")
    @Description("Test of exit from personal account of authorized user")
    public void exitFromPersonalAccountOfUser(){
        PersonalAccountPage personalAccountPage = mainPageAfterLogin.clickOnPersonalAccountButtonWhenUserAuthorized();
        LoginPage loginPage = personalAccountPage.clickOnExitButton();
        loginPage.entryHeader.shouldBe(visible);
    }
}
