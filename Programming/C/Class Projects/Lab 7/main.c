#include <stdio.h>
#include <stdlib.h>

int sum(int array[], int asize) {

    int i; // Initializing our counter and iterator
    int count = 0;

    for (i = 0; i < asize; i++) { // For loop to iterate up to asize
        count += array[i]; //Incrementing count by the required value
    }

    return count;
}

int swap(int *pA, int *pB) {

    if (*pA > *pB) {
        int temp = *pB;
        *pB = *pA;
        *pA = temp;
        return 1;
    }
    return 0;

}

int sort_1pass(int *array[], int asize) {
    int i;
    int flag;
    int returnNum = 0;
    for (i = 0; i < asize-1; i++) {
        flag = swap(&array[i], &array[i+1]);
        if (flag==1) {returnNum = 1;}
    }
    return returnNum;
}

int sort(int *array[], int asize) {
    int i;
    for (i = 0; i < asize-1; i++) {
        sort_1pass(array,asize);
        printarray(array,asize);
    }
}

void printarray(int array[], int asize) {
    int i;
    for (i = 0; i < asize; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");
}

int main()
{

    int array[] = {8,1,7,9,1,7,2,7,6};
    printf("Pre-sorted: ");
    printarray(array,9);
    sort(&array,9);
    printf("Sum: %d\n", sum(array,9));
    printf("Middle (index 4): %d\n", array[4]);
    printf("Average: %lf\n", (sum(array,9)/9.0));
    printf("Post sorted: ");
    printarray(array,9);
}
