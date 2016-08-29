#include <stdio.h>
#include <stdlib.h>

int main()
{
    // Creating the check mark
    printf("       *\n");
    printf("      *\n");
    printf("     *\n");
    printf("*   *\n");
    printf(" * *\n");
    printf("  *\n");

    // Creating my RedID printed vertically

    printf("8\n1\n7\n9\n1\n7\n2\n7\n6\n");

    // Initializing birth date
    int birthDay = 10;
    int birthMonth = 12;
    int birthYear = 1995;
    // Initializing current date
    int curDay = 26;
    int curMonth = 1;
    int curYear = 2016;

    // Initializing our output

    int output = 0;

    output += ( curDay - birthDay);
    output += ( curMonth - birthMonth) * 30;
    output += ( curYear - birthYear) * 365;

    printf("Days since I was born: %d\n", output);

    return 0;
}
