package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeleteCustomerPage;

import java.util.List;

/**
 * Класс тестирования удаления пользователя
 */
@Epic(value = "Тестирование ресурса globalsqa")
@Feature(value = "Тестирование страницы BankingProject")
public class DeleteCustomerTest extends BaseTest {

    @Story(value = "Тестирование вкладки Customers")
    @Test(description = "ID 3 Проверка удаления по среднеарифметическому количеству букв по полю First Name на вкладке Customers")
    public void deleteTest() {
        DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage(driver);
        deleteCustomerPage.clickToTabCustomer();
        List<String> initialNamesList = deleteCustomerPage.getFirstNamesFromRows();
        List<String> closestNamesList = deleteCustomerPage.deleteCustomerWithNameClosestToAverageLength(initialNamesList);
        List<String> deleteNamesList = deleteCustomerPage.getFirstNamesFromRows();
        Assert.assertFalse(deleteNamesList.contains(closestNamesList), "Поле с именем " + closestNamesList + " не был удален.");
    }
}