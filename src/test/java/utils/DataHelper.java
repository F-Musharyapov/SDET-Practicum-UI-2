package utils;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Класс с методами генераторами данных
 */
public class DataHelper {

    /**
     * Экземпляр для Faker
     */
    private static final Faker faker = new Faker();

    /**
     * Константа для локатора первого столбца FirstName
     */
    public static final String FIRST_NAME_SELECTOR = "td:nth-child(1)";

    /**
     * Константа для локатора первой кнопки удаления в таблице напротив первого имени
     */
    public static final String DELETE_BUTTON_SELECTOR = "td button[ng-click=\"deleteCust(cust)\"]";

    /**
     * Константа текста алерта для AddCustomerTest
     */
    public static final String ALERT_MESSAGE = "Customer added successfully with customer id";

    /**
     * Метод генерации валидных данных для поля Last Name для класса AddCustomerTest
     *
     * @return сгенерированный lastName
     */
    public static String generateLastName() {
        return faker.name().lastName();
    }

    /**
     * Метод генерации числа из 10 рандомных цифр для поля Post Code для класса AddCustomerTest
     *
     * @return сгенерированный postCode
     */
    public static String generatePostCode() {
        Random random = new Random();
        String postCode = "";

        for (int i = 0; i < 10; i++) {
            postCode += random.nextInt(10);
        }
        return postCode;
    }

    /**
     * Генерирует имя для поля FirstName на основе цифр из поля Post Cod для класса AddCustomerTest
     *
     * @param postCode элемент содержащий рандомные цифры для преобразования
     * @return сгенерированный firstName
     */
    public static String generateFirstName(String postCode) {
        StringBuilder firstName = new StringBuilder();
        for (int i = 0; i < 10; i += 2) {
            firstName.append((char) ('a' + Integer.parseInt(postCode.substring(i, i + 2)) % 26));
        }
        return firstName.toString();
    }

    /**
     * Метод для поиска имен со средним значением
     *
     * @param namesCustomers лист с именами
     * @return лист с именем/именами со средними значениями
     */
    public static List<String> getFirstNamesAverage(List<String> namesCustomers) {
        double averageLength = namesCustomers.stream()
                .mapToDouble(String::length)
                .average()
                .orElse(0.0);

        double minDistanceToAverageLength = namesCustomers.stream()
                .mapToDouble(name -> Math.abs(name.length() - averageLength))
                .min()
                .orElse(0.0);

        List<String> collect = namesCustomers.stream()
                .filter(name -> Math.abs(name.length() - averageLength) == minDistanceToAverageLength)
                .collect(Collectors.toList());
        return collect;
    }
}