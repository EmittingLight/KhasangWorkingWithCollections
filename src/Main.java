import java.time.Duration;
import java.time.Instant;
import java.util.List;

/*
Создаем два списка продуктов: один содержит уникальные продукты, другой содержит продукты, включая дубликаты.
Затем вызываем два метода для поиска дубликатов, используя каждый список продуктов в качестве параметров.
Мы замеряем время выполнения каждого метода и выводим количество найденных дубликатов и время выполнения каждого метода на экран.
 */
public class Main {
    public static void main(String[] args) {
        List<Product> list1 = ProductGenerator.initData();
        List<Product> list2 = ProductGenerator.initDataWithDuplicates(list1);
        //System.out.println(list1.size());
        //System.out.println(list2.size());

        // время измерения для обычного поиска дубликатов
        Instant start1 = Instant.now();
        List<Product> duplicates1 = ProductFinder.findDuplicates(list1, list2);
        //System.out.println(duplicates1.size());
        Instant end1 = Instant.now();
        long timeElapsed1 = Duration.between(start1, end1).toMillis();
        System.out.println("Время, затраченное на метод для обычного поиска дубликатов: " + timeElapsed1 + " ms");

        // измерить время для быстрого поиска дубликатов
        Instant start2 = Instant.now();
        List<Product> duplicates2 = ProductFinder.findDuplicatesFast(list1, list2);
        //System.out.println(duplicates2.size());
        Instant end2 = Instant.now();
        long timeElapsed2 = Duration.between(start2, end2).toMillis();
        System.out.println("Время, затраченное для быстрого поиска дубликатов: " + timeElapsed2 + " ms");

        // выводим количество найденных дубликатов и время выполнения методов
        System.out.println("Метод поиска дубликатов():");
        System.out.println("  затраченное время: " + timeElapsed1 + " ms");
        System.out.println("  количество дубликатов: " + duplicates1.size());
        System.out.println("Метод быстрого поиска дубликатов");
        System.out.println("  затраченное время: " + timeElapsed2 + " ms");
        System.out.println("  количество дубликатов: " + duplicates2.size());
    }
}

