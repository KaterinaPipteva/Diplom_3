package ru.yandex.praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class PersonalAccountPage {

    //Таб профиля (по умолчанию активен)
    @FindBy(how = How.XPATH, using = ".//a[text()='Профиль']")
    private SelenideElement profileTab;

    //Таб истории заказов клиента
    @FindBy(how = How.XPATH, using = ".//a[text()='История заказов']")
    public SelenideElement orderHistoryTab;

    //Кнопка конструктора на верхней части экрана
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    //Логотип Stellar Burgers
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoStellarBurgers;

    //Кнопка выхода из аккаунта
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement exitButton;

    public void waitForLoadPersonalAccountPage(){
        profileTab.shouldBe(visible);
    }

    public MainPage clickOnConstructorButton(){
        constructorButton.click();
        MainPage mainPage = page(MainPage.class);
        mainPage.waitForLoadMainPage();
        return mainPage;
    }

    public MainPage clickOnLogoStellarBurgers(){
        logoStellarBurgers.click();
        MainPage mainPage = page(MainPage.class);
        mainPage.waitForLoadMainPage();
        return mainPage;
    }

    public LoginPage clickOnExitButton(){
        exitButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }


}
