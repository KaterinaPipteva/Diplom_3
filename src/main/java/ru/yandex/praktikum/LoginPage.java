package ru.yandex.praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    //Заголовок "Выход"
    @FindBy(how = How.XPATH, using = ".//div/h2[text()='Вход']")
    public SelenideElement entryHeader;

    //Поле для ввода почты
    @FindBy(how = How.XPATH, using = ".//*[@class='input pr-6 pl-6 input_type_text input_size_default']/input")
    private SelenideElement emailField;

    //Поле для ввода пароля
    @FindBy(how = How.XPATH, using = ".//*[@class='input pr-6 pl-6 input_type_password input_size_default']/input")
    private SelenideElement passField;

    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement entryButton;




    public void waitForLoadLoginPage(){
        entryButton.shouldBe(visible);
    }

    public void enterEmailField(String email){
        emailField.setValue(email);
    }

    public void enterPasswordField(String password){
        passField.setValue(password);
    }

    public void clickOnEntryButton(){
        entryButton.click();
    }

    //Общий метод авторизации
    public MainPage loginWithEmailAndPassword(String email, String password){
        enterEmailField(email);
        enterPasswordField(password);
        clickOnEntryButton();
        MainPage mainPage = page(MainPage.class);
        mainPage.waitForLoadMainPage();
        return mainPage;
    }
}
