package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SortingCustomersPage;

import java.util.List;

/**
 * Класс тестирования сортировки по полю First Name
 */
@Epic(value = "Тестирование ресурса globalsqa")
@Feature(value = "Тестирование страницы BankingProject")
public class SortingCustomersTest extends BaseTest {

    @Story(value = "Тестирование вкладки Customers")
    @Test(description = "ID 2 Проверка сортировки по полю First Name на вкладке Customers")
    public void sortingTest() {

        SortingCustomersPage customerPage = new SortingCustomersPage(driver);

        customerPage.clickToTabCustomer();
        List<String> namesListFirst = customerPage.getFirstNamesFromRows();

        customerPage.clickToFirstNameHeader();
        List<String> namesListSecond = customerPage.getFirstNamesFromRows();
        List<String> sortedDecreasingNamesList = customerPage.sortNames(namesListFirst, false);
        Assert.assertEquals(sortedDecreasingNamesList, namesListSecond, "Сортировка имен по убыванию выполнена некорректно.");

        customerPage.clickToFirstNameHeader();
        List<String> namesListThird = customerPage.getFirstNamesFromRows();
        List<String> sortedIncreasingNamesList = customerPage.sortNames(namesListFirst, true);
        Assert.assertEquals(sortedIncreasingNamesList, namesListThird, "Сортировка имен по возрастанию выполнена некорректно.");
    }
}