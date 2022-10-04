package ru.yandex.praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {

//поля для ввода имени, почты и пароля при регестрации
@FindBy(how = How.XPATH, using = ".//fieldset[1]/*/*[@class='input pr-6 pl-6 input_type_text input_size_default']/input")
    private SelenideElement nameField;

@FindBy(how = How.XPATH, using = ".//fieldset[2]/*/div[@class='input pr-6 pl-6 input_type_text input_size_default']/input")
    private SelenideElement emailField;

@FindBy(how = How.XPATH, using = ".//*[@class='input pr-6 pl-6 input_type_password input_size_default']/input")
    private SelenideElement passwordField;

//кнопка для регистрации
@FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

//ошибка при вводе короткого пароля
@FindBy(how = How.CSS, using = ".input__error.text_type_main-default")
    private SelenideElement passwordError;

//кнопка для перехода на форму авторизации
@FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement changeLoginPageButton;


    public void enterNameValue(String name){
    nameField.setValue(name);
}

    public void enterEmailValue(String email){
    emailField.setValue(email);
}

    public void enterPasswordValue(String password){
    passwordField.setValue(password);
}

    public void clickOnRegisterButton(){
        registerButton.click();
    }

    public String getErrorPasswordText(){
        String text = passwordError.shouldBe(visible).getText();
        return text;
    }

    //общий метод для регистрации пользователя
    public LoginPage registrationWithNameEmailPassword(String name, String email, String password){
        enterNameValue(name);
        enterEmailValue(email);
        enterPasswordValue(password);
        clickOnRegisterButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

    //метод для регистрации пользователя с получением ошибки
    public String registrationWithShortPass(String name, String email, String password){
        enterNameValue(name);
        enterEmailValue(email);
        enterPasswordValue(password);
        clickOnRegisterButton();
        String errorText = getErrorPasswordText();
        return errorText;
    }

    //метод для перехода на экран логина через кнопку "Войти"
    public LoginPage clickOnChangeLoginPageButton(){
        changeLoginPageButton.click();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitForLoadLoginPage();
        return loginPage;
    }

}
