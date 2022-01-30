package PO;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPageStellarBurgers extends BasePageStellarBurgers {

    public static final String URL = ConstructorPageStellarBurgers.URL + "/account/profile";

    //Локатор кнопки Выход
    @FindBy(how = How.XPATH, using = ".//button[text() = 'Выход']")
    private SelenideElement logOutButton;

    //Локатор плейсхолдера Имя
    @FindBy(how = How.XPATH, using = ".//label[text() = 'Имя']")
    private SelenideElement nameLabel;
    //Локатор плейсхолдера Email
    @FindBy(how = How.XPATH, using = ".//label[text() = 'Email']")
    private SelenideElement emailLabel;

    //метод клика на кнопку Выход
    @Step("Click log out button")
    public void logOutButtonClick() {
        logOutButton.click();
    }

    public String getValueFromNameField() {
        return nameLabel.parent().find("input").attr("value");
    }
}
