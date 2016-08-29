#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// This method will return the specific value of the rectangle over a given cartesian x co-ordinate and a length n
double returnArea(double cartX, double interval) {

    double pointOne = cos(cartX);

    double output = pointOne * interval;
    return output;

}

int main() {

    // Variable Initializing block //

    double a; // Initializing var for left side of the area to measure
    double b; // Initializing var for right side of the area to measure
    double nn; // Initializing var for interval amount
    double n; // Initializing, as a float, our interval variable
    int riemannType; // Initializing riemann sum type where 0 = left, 1 = right, 2 = middle
    int debug; // Initializing our debug variable



    // Main Scan Statements //

    printf("===== Riemann Sum Calculator using cos(x) ====\n"); // Header
    printf("Input lower limit a: \n"); // Asking and scanning in left side of area to measure
    scanf("%lf", &a);
    printf("\nInput upper limit b: \n"); // Asking and scanning in right side of area to measure
    scanf("%lf", &b);
    printf("\nInput the interval amount n: \n"); // Asking and scanning in interval
    scanf("%lf", &nn);
    while (nn == 0) {
        printf("\nERROR: CANNOT ACCEPT 0. Input the interval amount n: \n"); // Making sure we don't get a runtime error by div 0
        scanf("%lf", &nn);
    }
    printf("\nInput riemann sum type (0: left, 1:right, 2:middle, anything else is left)\n"); // Asking and scanning sum type
    scanf("%d", &riemannType);
    printf("Enable debug? 0 = no, 1 = yes\n");
    scanf("%d", &debug);

    if (a>b) { // This is to make sure that our a value is larger than our b value, to prevent the while loop from breaking
        int temp = a;
        a = b;
        b = temp;
    }


    // Riemann Sum Set-up

    n = (b-a)/(nn);
    if (debug) {printf("%lf\n",n);}

    double startCord; // Initializing our co-ordinate that we will increment on
    double bonusDistance;

    if (riemannType == 1) { // If our riemann type is right, setting up startCord
        startCord = a + n; // Makes our start cord one interval length to the right, which is how right-endpoint works
        bonusDistance = n; // Increases how far we will go in our while loop
    }
    else if (riemannType == 2) {
        startCord = a + (n/2.0);
        bonusDistance = (n/2.0);
    }
    else {
        bonusDistance = 0;
        startCord = a;
    }

    double area = 0; // Initializing our area at 0


    // Calculating Riemann Sum

    while (startCord<b+bonusDistance) {
    if (debug) {printf("Current cartX using: %lf\n",startCord);}
        double nextArea = returnArea(startCord,n);
    if (debug) {printf("Next area: %lf\n", nextArea);}
        area += nextArea;
    if (debug) {printf("Current area: %lf\n",area);}
        startCord+=n;
    }


    printf("Final area on given interval: %lf\n", area);
    return 0;
}

