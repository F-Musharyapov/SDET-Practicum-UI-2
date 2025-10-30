package tests;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddCustomerPage;

import static org.testng.AssertJUnit.assertTrue;
import static utils.DataHelper.*;

/**
 * Класс тестирования отправки данных на вкладке AddCustomer
 */
@Epic(value = "Тестирование ресурса globalsqa")
@Feature(value = "Тестирование страницы BankingProject")
public class AddCustomerTest extends BaseTest {

    /**
     * Экземпляр AddCustomerPage
     */
    private static AddCustomerPage addCustomerPage;

    /**
     * Метод предусловие для инициализации
     */
    @BeforeMethod
    public void initialsBefore() {
        addCustomerPage = new AddCustomerPage(driver);
    }

    @Story(value = "Тестирование вкладки AddCustomer")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(description = "ID 2 Проверка отправки данных с заполненными полями формы на вкладке AddCustomer")
    public void testForm() {
        String postCodeValue = generatePostCode();

        addCustomerPage
                .clickToTabAddCustomer()
                //.inputFirstName(firstNameValue)
                .inputFirstName(generateFirstName(postCodeValue))
                .inputLastName(generateLastName())
                .inputPostCode(postCodeValue)
                .clickToButtonAddCustomer();

        assertTrue(addCustomerPage.getAlertText().contains(ALERT_MESSAGE));
    }

    /**
     * Метод для закрытия алерта
     */
    @AfterMethod
    public void exitAlert() {
        addCustomerPage.acceptAlert();
    }
}