package ru.yandex.praktikum;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class RegisterSafariTest {
    private String name;
    private String email;
    private String password;
    Faker faker;
    RegisterPage registerPage;

    //тесты на Safari браузере (не яндекс потому что куратор писал,
    // что главное реализовать тесты в браузере отличном от GoogleChrome,
    // а с Яндекс у меня никак не получалось на селениде это реализовать)
    @BeforeClass
    public static void setProperties(){
        Configuration.browser = "safari";
    }

    @Before
    public void setUp(){
        faker = new Faker();
        name = faker.name().firstName();
        email = name + "@bk.ru";
        registerPage = open("https://stellarburgers.nomoreparties.site/register", RegisterPage.class);
    }

    @Test
    @DisplayName("Registration with name, email and password")
    @Description("Test for success registration client with proper name, email, password")
    public void successRegisterClientTest(){
        password = "123456";
        LoginPage loginPage = registerPage.registrationWithNameEmailPassword(name, email, password);
        loginPage.entryHeader.shouldBe(visible);
    }

    @Test
    @DisplayName("Failure registration with short password")
    @Description("Test for failure registration client with proper name, email but with short password")
    public void failureRegistrationWithShortPasswordTest(){
        password = "12345";
        String actualError = registerPage.registrationWithShortPass(name, email, password);
        assertEquals("Некорректный пароль", actualError);
    }
}
