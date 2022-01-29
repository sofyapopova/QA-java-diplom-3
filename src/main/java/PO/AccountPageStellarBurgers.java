package PO;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPageStellarBurgers extends BasePageStellarBurgers {

    //Локатор кнопки Выход
    @FindBy(how = How.XPATH, using = ".//button[text() = 'Выход']")
    private SelenideElement logOutButton;

    //метод клика на кнопку Выход
    @Step("Click log out button")
    public void logOutButtonClick() {
        logOutButton.click();
    }
}
