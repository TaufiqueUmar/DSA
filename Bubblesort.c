#include <stdio.h>

int main() {
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    int n = sizeof(arr) / sizeof(arr[0]);
    int i, j, temp;
    int flag;

    // Bubble Sort Algorithm
    for (i = 0; i < n - 1; i++) {
        flag = 0;  // Initially, set swapped to false (0)

        // Traverse through the array
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j+1]
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                flag = 1;  // Set swapped to true (1)
            }
        }

        // If no elements were swapped, the array is already sorted
        if (flag == 0) {
            break;
        }
    }

    // Print the sorted array
    printf("Sorted array: \n");
    for (i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
