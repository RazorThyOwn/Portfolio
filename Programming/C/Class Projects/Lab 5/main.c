#include <stdio.h>
#include <math.h>

int main()
{
    printf("PART ONE: COMPOUND INTEREST\n\n");
    double theMoney; // Intializing our variables
    double theRedID = 9172.76; // End of my RedID (817917276)
    double thePercent;
    double reusedMoney;

    int theYears;

    printf("Input starting amount: \n"); // Scanning in our variables
    scanf("%lf", &theMoney);

    printf("Input the percent rate in percent: \n");
    scanf("%lf", &thePercent);
    thePercent = thePercent / 100; // Converting from percent to decimal for later

    printf("Input number of years: \n");
    scanf("%d", &theYears);

    int i; // Printing headers, initializing our i
    printf("Compound interest calculation: Input amount (%lf)\n", theMoney);
    printf("Year Daily   Weekly  Monthly Quarterly Annually\n");
    printf("---- ------- ------- ------- --------- --------\n\n");

    for (i = 0; i <= theYears; i++) { // Doing the interest calculation with given amount
        printf("%d ", i);
        printf("%lf |", (theMoney)* pow(1 + ( (thePercent/365)),(i*365))); // Printing interest rate calculations
        printf("%lf |", (theMoney)* pow(1 + ( (thePercent/52)),(i*52)));
        printf("%lf |", (theMoney)* pow(1 + ( (thePercent/12)),(i*12)));
        printf("%lf |", (theMoney)* pow(1 + ( (thePercent/4)),(i*4)));
        printf("%lf |", (theMoney)* pow(1 + ( (thePercent/1)),(i*1)));

        printf("\n");
    }
    theMoney = theRedID; // Reassigning theMoney to be used for calculating interest

    printf("\nCompound interest calculation: RedID Amount (%lf)\n", theMoney);
    printf("Year Daily   Weekly  Monthly Quarterly Annually\n");
    printf("---- ------- ------- ------- --------- --------\n\n");

    for (i = 0; i <= theYears; i++) { // Doing the interest calculation with my redID
        printf("%d ", i);
        printf("%lf |", (theMoney)* pow(1 + ( (thePercent/365)),(i*365))); // Printing compound interest
        printf("%lf |", (theMoney)* pow(1 + ( (thePercent/52)),(i*52)));
        printf("%lf |", (theMoney)* pow(1 + ( (thePercent/12)),(i*12)));
        printf("%lf |", (theMoney)* pow(1 + ( (thePercent/4)),(i*4)));
        printf("%lf |", (theMoney)* pow(1 + ( (thePercent/1)),(i*1)));

        printf("\n");
    }

    printf("PART TWO: ODD/EVEN CHECKER\n\n");

    int num; // Initializing our input
    printf("Input number to check: \n"); // Scanning our input
    scanf("%d", &num);

    int count;
    int checkNum = num;

    while (num>10) { // Keeping the loop going while we aren't in the single digits
        count = 0;
        while (checkNum > 10) { //Keep dividing the current number while we arent in single digits
            checkNum = checkNum / 10; // Divide our number
            count++; // Keeping track of how many times we divide for later

        }
        if (checkNum%2 == 0 ) { // Checking for even or odd
            printf("%d is even. \n", checkNum);
        }
        else if (checkNum%2 == 1 ) {
            printf("%d is odd. \n", checkNum);
        }
        double subNum = (checkNum * pow(10,count)); // Removing the number we just checked
        num = num - subNum;
        checkNum = num;
    }

    if (checkNum%2 == 0 ) { // Checking final number if its odd or even
            printf("%d is even. \n", checkNum);
    }
    else if (checkNum%2 == 1 ) {
            printf("%d is odd. \n", checkNum);
    }

    printf("PART THREE: PRIME CHECKER\n\n");
    int boolean = 0; // Intializing our input and boolean
    int input;

    printf("Input possible prime: \n");
    scanf("%d",&input);

    int square = sqrt(input) + 1; // The highest number we will check, sqrt(input) + 1

    for (i = 2; i < square; i++ ) {
        if (input%i==0) { // Checking if there is a remainder
            boolean = 1;
        }

    }
    if (boolean==1) {
        printf("%d is not prime\n",input);
    }
    else if (boolean == 0) {
        printf("%d is prime\n",input);
    }


    return 0;
}

