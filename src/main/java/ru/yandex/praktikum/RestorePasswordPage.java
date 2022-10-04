package ru.yandex.praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class RestorePasswordPage {

    //Кнопка для перехода авторизацию
    @FindBy(how = How.XPATH, using = ".//a[@href='/login']")
    private SelenideElement loginPageLink;



    public LoginPage clickToTheLoginPageLink(){
        loginPageLink.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }
}
