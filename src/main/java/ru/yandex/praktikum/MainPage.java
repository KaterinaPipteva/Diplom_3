package ru.yandex.praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    //Заголовок "Соберите бургер"
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement headerBuildBurger;

    //Кнопка "Оформить заказ" (если пользователь авторизован)
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    public SelenideElement makeOrderButton;

    //Кнопка Личного кабинета
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;

    //Кнопка "Войти в аккаунт" (если пользователь не авторизован)
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    //Активный таб ингредиентов
    //И далее локаторы конкретных активных и неактивных табов
    @FindBy(how = How.XPATH, using = ".//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span")
    private SelenideElement activeTab;

    @FindBy(how = How.XPATH, using = ".//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']")
    private SelenideElement activeBunTab;

    @FindBy(how = How.XPATH, using = ".//*[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']")
    private SelenideElement nonActiveBunTab;

    @FindBy(how = How.XPATH, using = ".//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']")
    private SelenideElement activeSouseTab;

    @FindBy(how = How.XPATH, using = ".//*[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']")
    private SelenideElement nonActiveSouseTab;

    @FindBy(how = How.XPATH, using = ".//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']")
    private SelenideElement activeFillingTab;

    @FindBy(how = How.XPATH, using = ".//*[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']")
    private SelenideElement nonActiveFillingTab;




    public void waitForLoadMainPage(){
        headerBuildBurger.shouldBe(visible);
    }

    //метод для входа в личный кабинет авторизованного пользователя
    public PersonalAccountPage clickOnPersonalAccountButtonWhenUserAuthorized(){
        personalAccountButton.click();
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.waitForLoadPersonalAccountPage();
        return personalAccountPage;
    }

    //Метод для входа на экран логина через клик на личный кабинет
    public LoginPage clickOnPersonalAccountButtonWhenUserUnauthorized(){
        personalAccountButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    //метод для перехода на экран логина через кнопку "Войти в аккаунт"
    public LoginPage clickOnLoginButton(){
        loginButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    //Метод для получения имени активного таба
    public String getNameOfActiveTab(){
        String tabName = activeTab.getOwnText();
        return tabName;
    }

    //методы для нажатия на каждый из табов
    public void clickOnBunTab(){
        nonActiveBunTab.click();
        activeBunTab.shouldBe(visible, Duration.ofSeconds(8));
        nonActiveSouseTab.shouldBe(visible, Duration.ofSeconds(8));
        nonActiveFillingTab.shouldBe(visible, Duration.ofSeconds(8));
    }

    public void clickOnSouseTab(){
        nonActiveSouseTab.click();
        activeSouseTab.shouldBe(visible, Duration.ofSeconds(8));
        nonActiveBunTab.shouldBe(visible, Duration.ofSeconds(8));
        nonActiveFillingTab.shouldBe(visible, Duration.ofSeconds(8));
    }

    public void clickOnFillingTab(){
        nonActiveFillingTab.click();
        activeFillingTab.shouldBe(visible, Duration.ofSeconds(8));
        nonActiveBunTab.shouldBe(visible, Duration.ofSeconds(8));
        nonActiveSouseTab.shouldBe(visible, Duration.ofSeconds(8));
    }


}
