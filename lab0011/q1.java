import java.util.Scanner;

public class q1 {

    // Функция сортировки слиянием
    public static void main(int[] arr, int left, int right) {
        // Если массив состоит из одного элемента — он уже отсортирован
        if (left < right) {
            int mid = (left + right) / 2; // Находим середину

            // Рекурсивно делим массив на две части
            main(arr, left, mid);
            main(arr, mid + 1, right);

            // Сливаем две отсортированные части
            merge(arr, left, mid, right);
        }
    }

    // Функция для слияния двух отсортированных подмассивов
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;  // размер левой части
        int n2 = right - mid;     // размер правой части

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Копируем данные во временные массивы
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Сливаем элементы обратно в основной массив
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Добавляем оставшиеся элементы
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество чисел: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Число " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        // Запускаем сортировку
        main(arr, 0, n - 1);

        System.out.print("Отсортированные числа: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
