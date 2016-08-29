#include <stdio.h>
#include <math.h>

int main()
{
    //                               //
    /* Part One: Summation of Red ID */
    //                               //

    int redID = 0; // Initializing our RedID variable

    printf("Input your RedID:\n");
    scanf("%d", &redID); // Getting user input for Red ID

    int tmpRedID = redID; // Initializing the RedID variable for our while loop
    int output; // Initializing our output variable

    while (tmpRedID > 10) {

        output += (tmpRedID % 10); // This bit gets the first number in our RedID (ie given 817917276, gets 6).
        tmpRedID = (tmpRedID / 10); // This bit reduces our RedID by the number we just took (817917276 -> 81791727)
        // This will repeat until we have reduced our tmpRedID to a number less than 10, which means we've executed our loop enough times
    }

    output += tmpRedID; // Because our while loop leaves one number left over, we add that number at the end

    printf("The summation of your RedID is :%d\n", output);

    //                                            //
    /* Part Two: Polynomial Formula with Integers */
    //                                            //

    printf("Polynomial evaluation (with integers)\n");

    int a = 0; // Initializing our variables as ints
    int b = 0;
    int c = 0;
    int x = 0;

    printf("Enter the value for a, b, c, and x seperated by a space\n");

    scanf("%d %d %d %d", &a, &b, &c, &x); // Scan statement to take in a, b, c, x

    int powPart = pow(x,2.0); // Calculating our exponent

    int polySum = ( ( a * powPart ) + (b * x) + c ); // The polynomial sum, evaluated and passed into polySum

    printf("Our value is :%d\n", polySum);

    //                                            //
    /* Part Three: Polynomial Formula with floats */
    //                                            //

    float aF = 0; // Initializing our variables as floats
    float bF = 0;
    float cF = 0;
    float xF = 0;

    printf("Enter the values for a, b, c, and x seperated by a space\n");

    scanf("%f %f %f %f", &aF, &bF, &cF, &xF); // Scan statement to take in a, b, c, x

    float powPartFloat = pow(xF,2.0); // Calculating our exponent

    float polySumFloat = ( ( aF * powPartFloat ) + (bF * xF) + cF ); // The polynomial sum, evaluated and passed into polySum

    printf("Our value is: %f\n", polySumFloat);

    return 0;
}
