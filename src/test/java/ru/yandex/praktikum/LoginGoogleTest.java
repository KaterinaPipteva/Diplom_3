package ru.yandex.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginGoogleTest {
    String email;
    String password;
    MainPage mainPageAfterLogin;

    @Before
    public void setUp(){
        //Использую дефолтные данные, чтобы не создавать кучу новых клиентов
        // без возможности удаления их через UI тесты
        email = "r2d2robot@mail.ru";
        password = "123456";
    }

    @After
    public void tearDown(){
        //выход из аккаунта
        PersonalAccountPage personalAccountPage = mainPageAfterLogin.clickOnPersonalAccountButtonWhenUserAuthorized();
        LoginPage loginPage = personalAccountPage.clickOnExitButton();
    }

@Test
@DisplayName("Login with user credentials from the main page")
@Description("Test of login with default user credentials from the main page")
    public void loginFromTheMainPageTest(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        LoginPage loginPage = mainPage.clickOnLoginButton();
        mainPageAfterLogin = loginPage.loginWithEmailAndPassword(email, password);
        mainPageAfterLogin.makeOrderButton.shouldBe(visible);
}

    @Test
    @DisplayName("Login with user credentials from personal account page")
    @Description("Test of login with default user credentials from personal account page")
    public void loginFromPersonalAccountPageTest(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        LoginPage loginPage = mainPage.clickOnPersonalAccountButtonWhenUserUnauthorized();
        mainPageAfterLogin = loginPage.loginWithEmailAndPassword(email, password);
        mainPageAfterLogin.makeOrderButton.shouldBe(visible);
    }

    @Test
    @DisplayName("Login with user credentials from registration page")
    @Description("Test of login with default user credentials from registration page")
    public void loginFromRegistrationPageTest(){
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
        LoginPage loginPage = registerPage.clickOnChangeLoginPageButton();
        mainPageAfterLogin = loginPage.loginWithEmailAndPassword(email, password);
        mainPageAfterLogin.makeOrderButton.shouldBe(visible);
    }

    @Test
    @DisplayName("Login with user credentials from restore password page")
    @Description("Test of login with default user credentials from restore password page")
    public void loginFromRestorePasswordPageTest(){
        RestorePasswordPage restorePasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password", RestorePasswordPage.class);
        LoginPage loginPage = restorePasswordPage.clickToTheLoginPageLink();
        mainPageAfterLogin = loginPage.loginWithEmailAndPassword(email, password);
        mainPageAfterLogin.makeOrderButton.shouldBe(visible);
    }


}
