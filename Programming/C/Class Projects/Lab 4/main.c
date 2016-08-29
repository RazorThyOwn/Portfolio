#include <stdio.h>
#include <stdlib.h>
int main()
{
    // Part 1 //
    printf("*\n");
    printf("**\n");
    printf("***\n");
    printf("****\n");
    printf("*****\n");
    printf("******\n");
    printf("*******\n");
    printf("********\n");
    printf("*********\n");
    printf("**********\n");

    // Part 2 //
    char stars[10] = "*";
    int i = 1;
    while (i <= 10) {
        printf("%s\n", stars);
        stars[i] = '*';
        stars[i+1] = '\0';
        i++;
    }

    // Part 3 //
    int cents = 0;
    int num20s = 0;
    int num10s = 0;
    int num5s = 0;
    int num1s = 0;

    printf("Input number of dollars:\n");
    scanf("%d",&cents);

    num20s = cents/20;
    cents = cents%20;

    num10s = cents/10;
    cents = cents%10;

    num5s = cents/5;
    cents = cents%5;

    num1s = cents;

    printf("$20 bills: %d\n$10 bills:%d\n$5 bills: %d\n$1 bills: %d\n",num20s, num10s, num5s, num1s);
    return 0;
}
