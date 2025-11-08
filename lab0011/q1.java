import java.util.Scanner;

public class q1 {

    // Merge sort function
    public static void main(int[] arr, int left, int right) {
        // If the array consists of one element, it is already sorted.
        if (left < right) {
            int mid = (left + right) / 2; // Finding the middle

            // Recursively divide the array into two parts
            main(arr, left, mid);
            main(arr, mid + 1, right);

            // We merge the two sorted parts
            merge(arr, left, mid, right);
        }
    }

    // Function to merge two sorted subarrays
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;  // the size of the left part
        int n2 = right - mid;     // the size of the right part

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copying data into temporary arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Merge the elements back into the main array
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

        // Adding the remaining elements
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

        System.out.print("Enter the number of digits: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Digit " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        // Start the sorting
        main(arr, 0, n - 1);

        System.out.print("Sorted digits: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
