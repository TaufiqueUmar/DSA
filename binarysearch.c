#include <stdio.h>

int binarySearch(int a[], int n, int data) {
    int l = 0, r = n - 1; // Initialize left and right pointers

    while (l <= r) {
        int mid = (l + r) / 2; // Find the middle element

        // Case 1: data is equal to a[mid]
        if (a[mid] == data) {
            return mid; // Return the index if data is found
        }

        // Case 2: data is less than a[mid]
        else if (data < a[mid]) {
            r = mid - 1; // Discard the right half
        }

        // Case 3: data is greater than a[mid]
        else {
            l = mid + 1; // Discard the left half
        }
    }

    return -1; // Return -1 if data is not found
}

int main() {
    int a[] = {5, 9, 17, 23, 25, 45, 59, 63, 71, 89}; // Sorted array
    int n = 10; // Size of the array
    int data = 59; // Element to search for

    int result = binarySearch(a, n, data);

    if (result != -1) {
        printf("Element found at index: %d\n", result);
    } else {
        printf("Element not found\n");
    }

    return 0;
}