#include <stdio.h>
#include <string.h>

#define TABLE_SIZE 10

int hashTable[TABLE_SIZE];

// Initialize the hash table
void initialize() {
    for (int i = 0; i < TABLE_SIZE; i++) {
        hashTable[i] = -1;  // -1 indicates an empty slot
    }
}

// Hash function
int hashFunction(int key) {
    return key % TABLE_SIZE;
}

// Insert using Linear Probing
void insert(int key) {
    int index = hashFunction(key);

    // Linear probing in case of collision
    while (hashTable[index] != -1) {
        index = (index + 1) % TABLE_SIZE;
    }
    hashTable[index] = key;
}

// Search for a key
int search(int key) {
    int index = hashFunction(key);
    int originalIndex = index;

    // Linear probing to search for the key
    while (hashTable[index] != key) {
        index = (index + 1) % TABLE_SIZE;

        if (index == originalIndex) {
            return -1;  // The key is not found
        }
    }
    return index;
}

// Display the hash table
void display() {
    printf("Hash Table:\n");
    for (int i = 0; i < TABLE_SIZE; i++) {
        if (hashTable[i] != -1) {
            printf("Index %d: %d\n", i, hashTable[i]);
        } else {
            printf("Index %d: Empty\n", i);
        }
    }
}

int main() {
    initialize();

    // Insert keys into the hash table
    insert(23);
    insert(43);
    insert(13);
    insert(27);

    display();

    // Search for a key
    int key = 43;
    int index = search(key);
    if (index != -1) {
        printf("Key %d found at index %d\n", key, index);
    } else {
        printf("Key %d not found\n", key);
    }

    return 0;
}