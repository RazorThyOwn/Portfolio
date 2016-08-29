#include <stdio.h>
#include <stdlib.h>

int strlen (char *str) {

    int i;
    for (i = 0; str[i] != '\0'; i++);
    return i;
}

char* strcpy(char* s1, char* s2) {

    char* output = s1;

    int i = 0;
    char letter;
    while (letter!='\0') {
        letter = s2[i];
        output[i] = letter;
        i++;
    }
    return output;
}

char* strcat(char* s1, char* s2) {

    int len = strlen(s1);
    int i;
    for (i = 0; i < len; i++) {
        s1[len+i] = s2[i];
    }

    return s1;

}

int main() {

    // Demonstrating string length three times
    printf("### Demonstrating string length 3 times ###\n\n");
    char str[50];
    int i = 0;
    while (i < 3) {
    i++;
    printf("Input your name:\n");
    gets(str);

    printf("%s", str);
    printf(" length of %d\n",strlen(str));
    }

    // Demonstrating strcpy
    printf("\n\n### Demonstrating string copy ###\n\n");
    char str2[50];
    printf("Input your name:\n");
    gets(str);
    strcpy(str2,str);
    printf("String one: ");
    puts(str);
    printf("String two: ");
    puts(str2);

    // Demonstrating strcat
    printf("\n\n### Demonstrating string cat ###\n\n");
    char strName[50];
    char strLast[50];
    char strRedID[50];

    printf("Input your name:\n");
    gets(strName);
    printf("Input your last name:\n");
    gets(strLast);
    printf("Input your red ID:\n");
    gets(strRedID);

    strcat(strName,strLast);
    strcat(strName,strRedID);
    printf("\n%s",strName);

}
