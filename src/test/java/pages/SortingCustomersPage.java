package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.Waiters.waitUntilVisible;

/**
 * Класс с методами для взаимодействия с табом Customers
 */
public class SortingCustomersPage extends BasePage {

    /**
     * Конструктор создания CustomerPage
     *
     * @param driver драйвер для управления браузером
     */
    public SortingCustomersPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Элемент таба Customer
     */
    @FindBy(css = "button[ng-class='btnClass3']")
    private WebElement tabCustomer;

    /**
     * Элемент столбца FirstName
     */
    @FindBy(css = "a[ng-click=\"sortType = 'fName'; sortReverse = !sortReverse\"]")
    private WebElement firstNameHeader;

    /**
     * Элемент первой ячейки FirstName
     */
    @FindBy(css = ".table.table-bordered.table-striped tbody td:nth-child(1)")
    private List<WebElement> firstNameCells;

    /**
     * Метод клика на таб Customers
     *
     * @return текущая страница
     */
    @Step("Клик по табу Customers")
    public SortingCustomersPage clickToTabCustomer() {
        tabCustomer.click();
        return this;
    }

    /**
     * Метод клика по столбцу First Name
     *
     * @return текущая страница
     */
    @Step("Клик по столбцу First Name")
    public SortingCustomersPage clickToFirstNameHeader() {
        waitUntilVisible(driver, firstNameHeader);
        firstNameHeader.click();
        return this;
    }

    /**
     * Метод для извлечения имен из строк таблицы
     *
     * @return возвращает инициализированные строки
     */
    @Step("Извлечение имен из строк таблицы")
    public List<String> getFirstNamesFromRows() {
        List<String> names = new ArrayList<>();
        for (WebElement row : firstNameCells) {
            names.add(row.getText());
        }
        return names;
    }

    /**
     * Метод сортировки имен
     *
     * @param list      список имен для сортировки
     * @param ascending значение для варианта выбора сортировки (true - по возрастанию, false - по убыванию)
     * @return возвращает отсортированный список
     */
    @Step("Метод сортировки имен из строк таблицы для сравнения")
    public List<String> sortNames(List<String> list, boolean ascending) {
        List<String> sortedList = new ArrayList<>(list);
        if (ascending) {
            Collections.sort(sortedList);
        } else {
            Collections.sort(sortedList, Collections.reverseOrder());
        }
        return sortedList;
    }
}