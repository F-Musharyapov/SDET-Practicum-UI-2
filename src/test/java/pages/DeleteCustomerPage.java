package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static utils.DataHelper.*;

/**
 * Класс с методами для удаления пользователя
 */
public class DeleteCustomerPage extends BasePage {

    /**
     * Конструктор создания страницы DeleteCustomerPage
     *
     * @param driver драйвер для управления браузером
     */
    public DeleteCustomerPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Элемент таба Customer
     */
    @FindBy(css = "button[ng-class='btnClass3']")
    private WebElement tabCustomer;

    /**
     * Элемент таблица
     */
    @FindBy(css = ".table.table-bordered.table-striped tbody tr")
    private List<WebElement> tableElements;

    /**
     * Элемент первой ячейки FirstName c менем
     */
    @FindBy(css = ".table.table-bordered.table-striped tbody td:nth-child(1)")
    private List<WebElement> firstNameCells;

    /**
     * Метод клика на таб Customer
     *
     * @return текущая страница
     */
    @Step("Выбор таба Customer")
    public DeleteCustomerPage clickToTabCustomer() {
        tabCustomer.click();
        return this;
    }

    /**
     * Метод получения списка имен
     *
     * @return список имен
     */
    @Step("Получение первоначального списка имен из таблицы")
    public List<String> getFirstNamesFromRows() {
        List<String> names = new ArrayList<>();
        for (WebElement row : firstNameCells) {
            names.add(row.getText());
        }
        return names;
    }

    /**
     * Метод удаления строк с именами со средней длиной
     *
     * @param initialNamesList лист со всеми именами на странице
     * @return лист с удаленными именами
     */
    @Step("Удаление строк с именами со средней длиной")
    public List<String> deleteCustomerWithNameClosestToAverageLength(List<String> initialNamesList) {
        List<String> closestNamesList = getFirstNamesAverage(initialNamesList);
        if (!closestNamesList.isEmpty()) {
            for (WebElement row : tableElements) {
                String customerName = row.findElement(By.cssSelector(FIRST_NAME_SELECTOR)).getText();
                if (closestNamesList.contains(customerName)) {
                    WebElement deleteButton2 = row.findElement(By.cssSelector(DELETE_BUTTON_SELECTOR));
                    deleteButton2.click();
                }
            }
        }
        return closestNamesList;
    }
}