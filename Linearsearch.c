#include <stdio.h>

int main() {
    int a[] = {15, 5, 20, 35, 2, 42, 67, 17}; // Array
    int n = 8; // Size of the array
    int data = 42; // Element to be searched
    int i, found = 0;

    for (i = 0; i < n; i++) {
        if (a[i] == data) {
            printf("Element found at index: %d\n", i);
            found = 1;
            break;
        }
    }

    if (i == n && found == 0) {
        printf("Element not found\n");
    }

    return 0;
}