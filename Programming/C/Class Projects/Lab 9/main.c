#include <stdio.h>
#include <stdlib.h>
#define MAX_STR_LEN     80

struct link_node
{
char node_str[ MAX_STR_LEN ];
struct link_node *next;
};

int compare_node( struct link_node *n1, struct link_node *n2 );
struct link_node *add_node( struct link_node *list, struct link_node *node );
void removeNextln(char *s1);
void display_list( struct link_node *head );

//struct link_node *head = (struct link_node*)malloc(sizeof(struct link_node));// Creating the main/first link node

int main()
{
    struct link_node *head = (struct link_node*)malloc(sizeof(struct link_node));
    head->next = NULL;

    printf("Input value, enter to continue: \n");
    char input[MAX_STR_LEN];

    fgets(input,MAX_STR_LEN, stdin);
    removeNextln(input);

    strcpy(head->node_str, input); // #1

    while (input[0]!='\0') {

        fgets(input, MAX_STR_LEN, stdin);
        removeNextln(input);
        if (input[0]!='\0') {
            struct link_node *newNode = (struct link_node*)malloc(sizeof(struct link_node));
            strcpy(newNode->node_str,input);

            newNode->next = NULL;

            head = add_node(head,newNode);
        }

    }

    display_list(head);
    free_mem(head);
}

int compare_node(struct link_node *n1, struct link_node *n2) {

    int ret = -99;

    if (strcmp(n1->node_str,n2->node_str)==0) {ret = 0;}
    else if (strcmp(n1->node_str,n2->node_str)>0) {ret = 1;}
    else if (strcmp(n1->node_str,n2->node_str)<0) {ret = -1;}

    //printf("Comparing %s to %s: %d \n", n1->node_str,n2->node_str,ret);

    return ret;
}

struct link_node *add_node(struct link_node *list, struct link_node *node) {

    struct link_node *curNode = list;
    struct link_node *prevNode = list;

    int cont = 1;

    if (compare_node(curNode,node)>0) {

            //printf("Oh no! New input should be above head!");
            char temp[MAX_STR_LEN];
            strcpy(temp,list->node_str);
            strcpy(list->node_str,node->node_str);
            strcpy(node->node_str,temp);
    }

    while (curNode->next != NULL && cont == 1) {
        prevNode = curNode;
        curNode = curNode->next;

        if (compare_node(curNode,node)>0) {
            cont = 0;
        }
    }

    //printf("CurNode: %s, PrevNode: %s\n", curNode->node_str,prevNode->node_str);

    if (cont == 1) {
        //printf("Reached end...");
        curNode->next = node;
    }

    else if (cont == 0) {
        //printf("Found earlier match...");
        //printf("PrevNode: %s", prevNode->node_str);

        node->next = curNode;
        prevNode->next = node;


    }

    return list;
}


void display_list(struct link_node *head) {

    struct link_node *curNode = head;
    while (curNode->next != NULL) {
        printf("%s\n", curNode->node_str);
        curNode = curNode->next;
    }
    printf("%s\n", curNode->node_str);
}

void removeNextln(char *s1) {

    int count;
    for (count = 0; s1[count]!= '\n'; count++);
    s1[count--] ='\0';

}

void free_mem(struct link_node *head) {

    struct link_node *next = head;
    struct link_node *prev = NULL;

    while (next!=NULL) {
        prev = next;
        next = next->next;
        free(prev);
    }

}
