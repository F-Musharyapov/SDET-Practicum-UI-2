package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForAlert;

/**
 * Класс с методами для взаимодействия с табом AddCustomer
 */
public class AddCustomerPage extends BasePage {

    /**
     * Конструктор создания AddCustomerPage
     *
     * @param driver драйвер для управления браузером
     */
    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Элемент таба AddCustomer
     */
    @FindBy(css = "button[ng-class='btnClass1']")
    private WebElement tabAddCustomer;

    /**
     * Элемент с полем ввода First Name
     */
    @FindBy(xpath = "//input[@ng-model='fName']")
    private WebElement firstName;

    /**
     * Элемент с полем ввода Last Name
     */
    @FindBy(css = "input[ng-model='lName']")
    private WebElement lastName;

    /**
     * Элемент с полем ввода Post Code
     */
    @FindBy(css = "input[ng-model='postCd']")
    private WebElement postCode;

    /**
     * Элемент кнопка Add Customer отправки данных
     */
    @FindBy(css = "button[type='submit'].btn-default")
    private WebElement buttonAddCustomer;

    /**
     * Метод клика на таб tabAddCustomer
     *
     * @return текущая страница
     */
    @Step("Выбор таба AddCustomer")
    public AddCustomerPage clickToTabAddCustomer() {
        tabAddCustomer.click();
        return this;
    }

    /**
     * Метод ввода в поле Post Code
     *
     * @return текущая страница
     */
    @Step("Ввод в поле Post Code")
    public AddCustomerPage inputPostCode(String postCodeValue) {
        postCode.sendKeys(postCodeValue);
        return this;
    }

    /**
     * Метод ввода в поле First Name
     *
     * @return текущая страница
     */
    @Step("Ввод в поле First Name")
    public AddCustomerPage inputFirstName(String firstNameValue) {
        firstName.sendKeys(firstNameValue);
        return this;
    }

    /**
     * Метод ввода в поле Last Name
     *
     * @return текущая страница
     */
    @Step("Ввод в поле Last Name")
    public AddCustomerPage inputLastName(String input) {
        lastName.sendKeys(input);
        return this;
    }

    /**
     * Метод клика по кнопке отправки
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке отправки")
    public AddCustomerPage clickToButtonAddCustomer() {
        buttonAddCustomer.click();
        return this;
    }

    /**
     * Метод извлечения текста алерта
     *
     * @return извлеченный текст
     */
    public String getAlertText() {
        waitForAlert(driver);
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    /**
     * Метод закрытия алерта
     */
    @Step("Закрытие окна алерта")
    public void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (IllegalStateException e) {
            throw new RuntimeException("Нет активного алерта.", e);
        }
    }
}