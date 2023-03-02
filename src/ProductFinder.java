import java.util.*;

public class ProductFinder {
    /*
     Метод findDuplicates:
    Принимает два списка объектов типа Product.
    Создает новый список duplicates для хранения найденных дубликатов.
    Для каждого элемента p1 из первого списка list1 перебирает каждый элемент p2 из второго списка list2.
    Если p1 и p2 равны по значению (через метод equals), то добавляет p1 в список duplicates и прерывает внутренний цикл.
     Возвращает список duplicates.
     */
    // Метод для поиска дубликатов в коллекциях (первая реализация)
    public static List<Product> findDuplicates(List<Product> list1, List<Product> list2) {
        List<Product> duplicates = new ArrayList<>();
        for (Product p1 : list1) {
            for (Product p2 : list2) {
                if (p1.equals(p2)) {
                    duplicates.add(p1);
                    break;
                }
            }
        }

        return duplicates;
    }

    /*
    Метод findDuplicatesFast:

     Принимает два списка объектов типа Product.
   Создает новое множество set1, заполненное элементами из первого списка list1.
   Создает новое множество duplicates для хранения найденных дубликатов.
   Для каждого элемента p2 из второго списка list2 проверяет, может ли p2 быть добавлен в множество set1.
   Если добавление p2 в set1 не удалось (то есть p2 уже находится в set1), то добавляет p2 в множество duplicates.
   Возвращает новый список, созданный из множества duplicates.
     */
    // Метод для поиска дубликатов в коллекциях (вторая реализация)
    public static List<Product> findDuplicatesFast(List<Product> list1, List<Product> list2) {
        Set<Product> set1 = new HashSet<>(list1);
        Set<Product> duplicates = new HashSet<>();

        for (Product p2 : list2) {
            if (!set1.add(p2)) {
                duplicates.add(p2);
            }
        }

        return new ArrayList<>(duplicates);
    }
}
/*
   Общее:
   В обоих методах возвращается список объектов типа Product, содержащий найденные дубликаты.
   Второй метод (findDuplicatesFast) использует множества для более быстрого поиска дубликатов.
   Оба метода статические, то есть могут быть вызваны без создания объекта класса ProductFinder.
   Оба метода имеют линейную сложность в худшем случае (O(n^2) для первого и O(n) для второго),
   но второй метод быстрее за счет использования множеств.
 */