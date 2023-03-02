import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class ProductGenerator {
    private static final int LIST_SIZE = 100000;
    private static final int DUPLICATES_COUNT = 1000;
    private static final int INTERNAL_CODE_LENGTH = 32;

    /*
    Метод initData() создает и возвращает список продуктов. В цикле создаются новые продукты и добавляются в список list,
    задается имя продукта и категория, генерируется внутренний код, используя класс SecureRandom.
     */

    public static List<Product> initData() {
        List<Product> list = new ArrayList<>(LIST_SIZE);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < LIST_SIZE; i++) {
            Product product = new Product();
            product.setName("Product" + i);
            product.setCategory("Category" + random.nextInt(10));
            byte[] internalCode = new byte[INTERNAL_CODE_LENGTH];
            random.nextBytes(internalCode);
            product.setInternalCode(internalCode);
            list.add(product);
        }

        return list;
    }

    /*
     Метод initDataWithDuplicates(List<Product> list1) создает и возвращает список продуктов, содержащий дубликаты.
     Входной параметр - список продуктов list1, который будет использоваться для создания нового списка с дубликатами и уникальными продуктами.
     Создается множество дубликатов и заполняется из list1. Затем в цикле добавляются уникальные продукты в новый список list2,
     используя list1 и класс SecureRandom, чтобы выбрать случайный продукт. Если продукт не находится в множестве дубликатов,
     он добавляется в list2. После этого список дубликатов добавляется в list2.
     Оба метода используют класс SecureRandom для генерации случайных чисел.
     Метод initDataWithDuplicates(List<Product> list1) также использует HashSet для хранения дубликатов и
     List для хранения уникальных продуктов. Оба метода используют константы для задания размера списка продуктов,
     количества дубликатов и длины внутреннего кода продукта.
    */
    public static List<Product> initDataWithDuplicates(List<Product> list1) {
        Set<Product> duplicates = new HashSet<>();
        List<Product> list2 = new ArrayList<>(LIST_SIZE);

        // добавить дубликаты из list1
        for (int i = 0; i < DUPLICATES_COUNT; i++) {
            duplicates.add(list1.get(i));
        }

        SecureRandom random = new SecureRandom();

        // добавить уникальные продукты в list2
        while (list2.size() < LIST_SIZE) {
            Product product = list1.get(random.nextInt(list1.size()));
            if (!duplicates.contains(product)) {
                list2.add(product);
            }
        }

        // добавить дубликаты в list2
        list2.addAll(duplicates);

        return list2;
    }
}

