import java.util.Scanner;

public class q2 {

    // Функция бинарного поиска
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // Пока диапазон не пустой
        while (left <= right) {
            int mid = (left + right) / 2; // Находим середину массива

            if (arr[mid] == target) {
                return mid; // Элемент найден, возвращаем индекс
            } else if (arr[mid] < target) {
                left = mid + 1; // Ищем в правой половине
            } else {
                right = mid - 1; // Ищем в левой половине
            }
        }
        return -1; // Элемент не найден
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество чисел: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Введите отсортированные числа (по возрастанию):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Введите число для поиска: ");
        int target = sc.nextInt();

        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Число найдено на индексе: " + index);
        } else {
            System.out.println("Число не найдено.");
        }
    }
}

