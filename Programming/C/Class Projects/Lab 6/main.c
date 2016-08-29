#include <stdio.h>

/* Lab 6 part 1 - Your name, Red ID, section number  */

#define SIZE 9 // array size
int main(void) // multiply two arrays
{
   int array1[SIZE] = {8, 1, 7, 9, 1, 7, 2, 7, 6}; // first array has your Red ID digits
   int array2[SIZE] = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // second array has numbers 1-9
   int array3[SIZE]; // declare 3rd array with SIZE elements to store result

   int i; // Initializing our iterator
   for (i = 0; i < SIZE; i++) { // For loop to multiply and assign to array 3
       array3[i] = array1[i] * array2[i];
   }

   printf("Array One:   ");
   for (i = 0; i < SIZE; i++) {
       printf("%d ", array1[i]);
   }

   printf("\nArray Two:   ");
   for (i = 0; i < SIZE; i++) {
       printf("%d ", array2[i]);
   }

   printf("\nArray Three: ");
   for (i = 0; i < SIZE; i++) {
       printf("%d ", array3[i]);
   }
   printf("\n");
   return 0;
}
