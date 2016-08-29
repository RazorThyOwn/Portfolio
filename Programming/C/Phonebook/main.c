#include <windows.h>
#include <gdiplus.h>
#include <stdio.h>
#include <stdlib.h>
#include <tchar.h>
#include <C:\Users\Alex Weber\Desktop\Desktop\CompSciLabs\PhoneBook\res.h>

const char wzClass[] = "myWindowClass"; // Creating the window pointer
char szFileName[MAX_PATH] = ""; // Creating the current open file path pointer

FILE *curFile = NULL; // Global FILE pointer

const PAINTSTRUCT brush; // Global brush pointer

const int thickness = 20; // Global variables for size
const int height = 690;
const int width = 450;

RECT headRect; // Global variables for the main painting rectangle
// Saving the file...
BOOL SaveFile(char *outputPath) {

    FILE *newFile; // Initializing output file
    newFile = fopen(outputPath,"w"); // Opening the newfile to write
    curFile = fopen(szFileName,"r"); // Opening current file to read

    char outputChar; // Initializing our iterator character

    do {
        outputChar = fgetc(curFile); // This do loop reads every word from the current file and writes to output file
        fputc(outputChar, newFile);
    } while (outputChar != EOF);

    fclose(newFile); // Closing the files
    fclose(curFile);
}
// Getting the path of the open file...
void GetFilePathOpen(HWND hwnd) {
    // Defining our open file dialog box

    OPENFILENAME filePath; // Initializing our filepath

    // Memory stuff
    ZeroMemory(&filePath, sizeof(filePath)); // Creating memory for the window
    filePath.lStructSize = sizeof(filePath); // Setting struct size
    filePath.hwndOwner = hwnd; // Assigning window owner
    filePath.lpstrFile = szFileName;
    filePath.nMaxFile =  MAX_PATH;

    // Assigning filters, flags, exts
    filePath.lpstrFilter = "Phonebooks (*.pb)\0*.pb\0All Files (*.*)\0*.*\0";
    filePath.Flags = OFN_EXPLORER | OFN_FILEMUSTEXIST | OFN_HIDEREADONLY;
    filePath.lpstrDefExt = "pb";

    if (GetOpenFileName(&filePath)) { // Getting the path of the item, assigning it to filepath
        HWND h = GetDlgItem(hwnd, editBox);
    }
}
// Getting the path of saving the file...
void GetFilePathSave(HWND hwnd, char *newFilePath) {
    // Defining our open file dialog box, basically the same thing as what we did in GetFilePathOpen but instead we
    // will be calling GetSaveFileName inside our if statement at the bottom

    OPENFILENAME filePath;

    // Memory stuff
    ZeroMemory(&filePath, sizeof(filePath));
    filePath.lStructSize = sizeof(filePath);
    filePath.hwndOwner = hwnd;
    filePath.lpstrFile = newFilePath;
    filePath.nMaxFile = MAX_PATH;

    // Assigning filters, flags, exts
    filePath.lpstrFilter = "Phonebooks (*.pb)\0*.pb\0All Files (*.*)\0*.*\0";
    filePath.Flags = OFN_EXPLORER | OFN_FILEMUSTEXIST | OFN_HIDEREADONLY;
    filePath.lpstrDefExt = "pb";

    if (GetSaveFileName(&filePath)) {
        HWND h = GetDlgItem(hwnd, editBox);
    }
    return newFilePath;
}
// The paint method
void phonebookPaint(HDC hdc) {
    curFile = fopen(szFileName, "r"); // Reading in the file to open

    // Filling the area with our color
    FillRect(hdc, &brush.rcPaint, (HBRUSH)(COLOR_WINDOW+1));

    // Creating our brushes
    HBRUSH headBlue = CreateSolidBrush(RGB(110,180,255));
    HBRUSH blueLight = CreateSolidBrush(RGB(244, 239, 255));
    HBRUSH blueDark = CreateSolidBrush(RGB(221,221,255));

    // Creating the main rectangle we are going to use
    headRect.top = 0;
    headRect.left = 0;
    headRect.right = width;
    headRect.bottom = 50;

    // Filling header rect
    FillRect(hdc, &headRect, headBlue);
    DrawText(hdc,"Term | Last Name, First Name                       | Number                              ",80, &headRect, DT_LEFT);

    int i = 0;
    int starting = 50;
    //printf("Painting... 3\n");

    // Drawing the color backgrounds and fill text
    for (i = 0; i < (height/thickness); i++) {

        headRect.top = starting + i*thickness; // Defining the rectangle for our background...
        headRect.left = 0;
        headRect.right = width;
        headRect.bottom = headRect.top + thickness;


        // Alternating colors
        if (i%2 == 0) {
            FillRect(hdc, &headRect, blueLight);
        }
        else {
            FillRect(hdc, &headRect, blueDark);
        }

        headRect.top = headRect.top + 3;

        // Printing term numbers
        // Converting the number to a LPRST object so we can use DrawText with it
        char curIndex[100];
        _stprintf(curIndex,"%d", i);
        int curIndexSize = 0;
        curIndexSize = i/10 + 1;

        DrawText(hdc,curIndex,curIndexSize,&headRect, DT_LEFT);
        headRect.left = 50;

        // Printing name as well as the number...

        char firstName[255] = ""; // Lots of initializers for what we are going to print
        char lastName[255] = "";
        char extNum[255] = "";
        char dirNum[255] = "";
        char nameOutput[255] = "";
        char numOutput[255] = "";

        if (curFile != NULL && !feof(curFile)) {
        fscanf(curFile,"%s %s %s %s", firstName, lastName, extNum, dirNum);

        strcpy(nameOutput, lastName); // Catatenating strings into printable object
        strcat(nameOutput, ", ");
        strcat(nameOutput,firstName);

        int nameOutputLen = strlen(nameOutput);

        DrawText(hdc,nameOutput, nameOutputLen, &headRect, DT_LEFT);

        strcpy(numOutput, extNum);
        strcat(numOutput, " ");
        strcat(numOutput,dirNum);

        int numOutputLen = strlen(numOutput);

        headRect.left = headRect.left + 250;
        DrawText(hdc,numOutput, numOutputLen, &headRect, DT_LEFT);
        }
        if (curFile == NULL) {
        }
    }

    // Drawing the indication lines
    HPEN hPen = CreatePen(PS_SOLID, 1, RGB(0,0,0));
    SelectObject(hdc, hPen);

    for (i = 0; i < (height/thickness); i++) {

        MoveToEx(hdc, 0, 50 + i*thickness, NULL);
        LineTo(hdc, width, 50 + i*thickness);
    }

    // Closing the file

    fclose(curFile);

}
// Returns the number of lines in the file
int GetMaxLines(FILE *fileIn) {

    char outputChar; // Initializing iterator char
    int lines = 1; // Initializing line counter

    do {
        outputChar = fgetc(fileIn); // Counting number of newLines which is how many lines there are
        if (outputChar == '\n') {
            lines++;
        }
    } while (outputChar != EOF); // Making sure we don't leave the file

    return lines;
}
// Sorting everything
void SortFile(int type) {

    char tempDestination[255] = ""; // Creating the file destination
    strcpy(tempDestination,szFileName);
    strcat(tempDestination,".tmp");

    FILE *tmpFile = fopen(tempDestination,"w+"); // Creating the temporary file to read out to
    curFile = fopen(szFileName,"r"); // Opening the current file

    char firstName[255] = ""; // Initializing our names and stuff
    char lastName[255] = "";
    char extNum[255] = "";
    char dirNum[255] = "";

    char winnerFirstName[255] = ""; // Initializing our winners, or the names that we are going to print out
    char winnerLastName[255] = "";
    char winnerExtNum[255] = "";
    char winnerDirNum[255] = "";


    int cyclesToRun = 0; // Counting how many times to increment, or number of lines
    cyclesToRun = GetMaxLines(curFile);

    int i;
    int toSkip[cyclesToRun]; // Initializing our int array to NOT compare since we have already printed them

    for (i = 0; i < cyclesToRun; i++) {
        toSkip[i] = -1; // Making sure we don't have null variables inside the sorter
    }

    // Sorting first names Z to A
if (type == 1) {

    for (i = 0; i <= cyclesToRun; i++) {

        // Scanning our current line

        int currentStep = 0;
        while (!feof(curFile)) {
            // Grabbing what we want to compare, very important...
            // If our current step has already been done, must NOT try to compare this it will win
            // Checking if our step is currently been compared already
            BOOL toComp = TRUE;

            // Ensuring we do not print the same one twice... that would be awkward
            int x;
            for (x = 0; x < cyclesToRun; x++) {
                if (currentStep == toSkip[x]) {
                    toComp = FALSE;
                }
            }


            // Comparing the string we are on
            if (toComp) {
            fscanf(curFile,"%s %s %s %s",firstName,lastName,extNum,dirNum);

                if (strcmp(winnerFirstName,firstName)<0 || i == cyclesToRun-1) {
                    toSkip[i] = currentStep;
                    strcpy(winnerFirstName,firstName);
                    strcpy(winnerLastName,lastName);
                    strcpy(winnerExtNum,extNum);
                    strcpy(winnerDirNum,dirNum);
                }
            }

            else {
                char buffer[255] = "";
                fscanf(curFile,"%s %s %s %s",buffer,buffer,buffer,buffer);
            }

            currentStep++;
        }
        // Rewinding to make sure we start new
        rewind(curFile);

        // Outputting our winner
        if (i!=0) {
        char winnerOutput[255] = "";
        strcpy(winnerOutput,winnerFirstName);
        strcat(winnerOutput," ");
        strcat(winnerOutput,winnerLastName);
        strcat(winnerOutput," ");
        strcat(winnerOutput,winnerExtNum);
        strcat(winnerOutput," ");
        strcat(winnerOutput,winnerDirNum);

        fprintf(tmpFile,winnerOutput);
        if (i != cyclesToRun) {
            fprintf(tmpFile,"\n");
            }
        }




        strcpy(winnerFirstName,"");
    }
}


else if (type == 0) {
    strcpy(winnerFirstName,"~");
    for (i = 0; i <= cyclesToRun; i++) {
        // Scanning our current line

        int currentStep = 0;
        while (!feof(curFile)) {
            // Grabbing what we want to compare, very important...
            // If our current step has already been done, must NOT try to compare this it will win
            // Checking if our step is currently been compared already
            BOOL toComp = TRUE;

            // Ensuring we do not print the same one twice... that would be awkward
            int x;
            for (x = 0; x < cyclesToRun; x++) {
                if (currentStep == toSkip[x]) {
                    toComp = FALSE;
                }
            }


            // Comparing the string we are on
            if (toComp) {
            fscanf(curFile,"%s %s %s %s",firstName,lastName,extNum,dirNum);

            if (i == cyclesToRun) {
                strcpy(winnerFirstName,"~");
            }
                if (strcmp(winnerFirstName,firstName)>0 || i == cyclesToRun) {
                    toSkip[i] = currentStep;
                    strcpy(winnerFirstName,firstName);
                    strcpy(winnerLastName,lastName);
                    strcpy(winnerExtNum,extNum);
                    strcpy(winnerDirNum,dirNum);
                }
            }

            else {
                char buffer[255] = "";
                fscanf(curFile,"%s %s %s %s",buffer,buffer,buffer,buffer);
            }

            currentStep++;
        }
        // Rewinding to make sure we start new
        rewind(curFile);

        // Outputting our winner
        if (i!=0) {
        char winnerOutput[255] = "";
        strcpy(winnerOutput,winnerFirstName);
        strcat(winnerOutput," ");
        strcat(winnerOutput,winnerLastName);
        strcat(winnerOutput," ");
        strcat(winnerOutput,winnerExtNum);
        strcat(winnerOutput," ");
        strcat(winnerOutput,winnerDirNum);

        fprintf(tmpFile,winnerOutput);
        if (i!=cyclesToRun) {
            fprintf(tmpFile,"\n");
            }

        strcpy(winnerFirstName,"~");
        }
    }
}

if (type == 3) {

    for (i = 0; i <= cyclesToRun; i++) {

        // Scanning our current line

        int currentStep = 0;
        while (!feof(curFile)) {
            // Grabbing what we want to compare, very important...
            // If our current step has already been done, must NOT try to compare this it will win
            // Checking if our step is currently been compared already
            BOOL toComp = TRUE;

            // Ensuring we do not print the same one twice... that would be awkward
            int x;
            for (x = 0; x < cyclesToRun; x++) {
                if (currentStep == toSkip[x]) {
                    toComp = FALSE;
                }
            }


            // Comparing the string we are on
            if (toComp) {
            fscanf(curFile,"%s %s %s %s",firstName,lastName,extNum,dirNum);

                if (strcmp(winnerLastName,lastName)<0 || i == cyclesToRun) {
                    toSkip[i] = currentStep;
                    strcpy(winnerFirstName,firstName);
                    strcpy(winnerLastName,lastName);
                    strcpy(winnerExtNum,extNum);
                    strcpy(winnerDirNum,dirNum);
                }
            }

            else {
                char buffer[255] = "";
                fscanf(curFile,"%s %s %s %s",buffer,buffer,buffer,buffer);
            }

            currentStep++;
        }
        // Rewinding to make sure we start new
        rewind(curFile);

        // Outputting our winner
        if (i!=0) {
        char winnerOutput[255] = "";
        strcpy(winnerOutput,winnerFirstName);
        strcat(winnerOutput," ");
        strcat(winnerOutput,winnerLastName);
        strcat(winnerOutput," ");
        strcat(winnerOutput,winnerExtNum);
        strcat(winnerOutput," ");
        strcat(winnerOutput,winnerDirNum);

        fprintf(tmpFile,winnerOutput);
        if (i!=cyclesToRun) {
            fprintf(tmpFile,"\n");
            }
        }

        strcpy(winnerLastName,"");
    }
}


else if (type == 2) {
    strcpy(winnerLastName,"~");
    for (i = 0; i <= cyclesToRun; i++) {
        // Scanning our current line

        int currentStep = 0;
        while (!feof(curFile)) {
            // Grabbing what we want to compare, very important...
            // If our current step has already been done, must NOT try to compare this it will win
            // Checking if our step is currently been compared already
            BOOL toComp = TRUE;

            // Ensuring we do not print the same one twice... that would be awkward
            int x;
            for (x = 0; x < cyclesToRun; x++) {
                if (currentStep == toSkip[x]) {
                    toComp = FALSE;
                }
            }


            // Comparing the string we are on
            if (toComp) {
            fscanf(curFile,"%s %s %s %s",firstName,lastName,extNum,dirNum);


                if (strcmp(winnerLastName,firstName)>0 || i == cyclesToRun) {
                    toSkip[i] = currentStep;
                    strcpy(winnerFirstName,firstName);
                    strcpy(winnerLastName,lastName);
                    strcpy(winnerExtNum,extNum);
                    strcpy(winnerDirNum,dirNum);
                }
            }

            else {
                char buffer[255] = "";
                fscanf(curFile,"%s %s %s %s",buffer,buffer,buffer,buffer);
            }

            currentStep++;
        }
        // Rewinding to make sure we start new
        rewind(curFile);

        // Outputting our winner
        if (i!=0) {
        char winnerOutput[255] = "";
        strcpy(winnerOutput,winnerFirstName);
        strcat(winnerOutput," ");
        strcat(winnerOutput,winnerLastName);
        strcat(winnerOutput," ");
        strcat(winnerOutput,winnerExtNum);
        strcat(winnerOutput," ");
        strcat(winnerOutput,winnerDirNum);

        fprintf(tmpFile,winnerOutput);
        if (i!=cyclesToRun) {
            fprintf(tmpFile,"\n");
            }
        strcpy(winnerLastName,"~");
        }
    }
}


    fclose(curFile); // Closing everything
    fclose(tmpFile);

    remove(szFileName); // Renaming and replacing the last file
    rename(tempDestination,szFileName);

}
// Removing term
BOOL RemoveTerm(int term) {

    char tempDestination[255] = "";
    strcpy(tempDestination,szFileName);
    strcat(tempDestination,".tmp"); // Creating temporary output

    FILE *tmpFile = fopen(tempDestination,"w+"); // Opening files
    curFile = fopen(szFileName,"r");

    char outputChar;
    int lineCount = 0;

    do { // What we are doing here is copying everything that is NOT on the line we want to remove
        outputChar = fgetc(curFile);

        if (outputChar == '\n') {
            lineCount++;
        }

        if (lineCount!=term) {
            fputc(outputChar, tmpFile);
        }
    } while (outputChar != EOF);

    fclose(curFile);
    fclose(tmpFile);

    remove(szFileName);
    rename(tempDestination,szFileName);


}
// Sorting and all that fun stuff...
BOOL CALLBACK SortCallback(HWND hwnd, UINT Messg, WPARAM wParam, LPARAM lParam) {
 switch(Messg) { // Checking to see which button is pressed and running its respective Sort method, given various ints 0 - 3
        case WM_COMMAND:
			switch(LOWORD(wParam))
			{
			    case SORT_FIRST_AZ:
			        SortFile(0);
			    break;
			    case SORT_FIRST_ZA:
			        SortFile(1);
			    break;
			    case SORT_LAST_AZ:
			        SortFile(2);
			    break;
			    case SORT_LAST_ZA:
			        SortFile(3);
			    break;
            }
    break;
    case WM_CLOSE:
        EndDialog(hwnd, 0);
    break;
    default:
        return FALSE;
    }

}
// Processing for obtaining the term to remove
BOOL CALLBACK RemoveCallback(HWND hwnd, UINT Messg, WPARAM wParam, LPARAM lParam) {
    switch(Messg) { // Checking if we press the remove button
        case WM_COMMAND:
			switch(LOWORD(wParam))
			{
				case termToRemoveOKButton:
                    {
                        // Removing the specific number
                        RemoveTerm(GetDlgItemInt(hwnd, termRemoveInput,NULL,0));
                    }
                break;
            }
        break;
        case WM_CLOSE:
			EndDialog(hwnd, 0);
        break;
		default:
			return FALSE;
        }
}
// Processing for the add button...
BOOL CALLBACK EditAddCallback(HWND hwnd, UINT Messg, WPARAM wParam, LPARAM lParam) {
    switch(Messg) { // Initializing our textbox...
        case WM_INITDIALOG:
            SetDlgItemText(hwnd, editFNameBox, "");
        break;

        case WM_COMMAND:
			switch(LOWORD(wParam))
			{   case editClearButton:
                    SetDlgItemText(hwnd, editFNameBox, "");
                    SetDlgItemText(hwnd, editLNameBox, "");
                    SetDlgItemText(hwnd, editExtBox, "");
                    SetDlgItemText(hwnd, numFirstBox, "");
                    SetDlgItemText(hwnd, numSecBox, "");
			    break;
				case editAddButton:
                    {
                        // Initializing stuff
                        char firstName[255] = "";
                        char lastName[255] = "";
                        char numExt[255] = "";
                        char numDir1[255] = "";
                        char numDir2[255] = "";

                        GetDlgItemText(hwnd, editFNameBox, firstName, 255);
                        GetDlgItemText(hwnd, editLNameBox, lastName, 255);
                        GetDlgItemText(hwnd, editExtBox, numExt, 255);
                        GetDlgItemText(hwnd, numFirstBox, numDir1, 255);
                        GetDlgItemText(hwnd, numSecBox, numDir2, 255);

                        char output[255] = "";

                        strcpy(output,firstName); // Catatenating everything into the string
                        strcat(output," ");
                        strcat(output,lastName);
                        strcat(output," (");
                        strcat(output,numExt);
                        strcat(output,") ");
                        strcat(output,numDir1);
                        strcat(output,"-");
                        strcat(output,numDir2);

                        if (szFileName[0] == '\0' ) { // If we haven't initialzed a file yet, create a new one in the current dir
                            strcpy(szFileName,"newPhonebook.pb");
                            curFile = fopen("newPhonebook.pb","w");
                            fprintf(curFile,output);
                            fclose(curFile);
                        }

                        else {
                            curFile = fopen(szFileName,"a");
                        }

                        // Printing to the file and then closing it
                        fprintf(curFile,"\n");
                        fprintf(curFile,output);
                        fclose(curFile);
                    }
                break;
            }
        break;
        case WM_CLOSE:
			EndDialog(hwnd, 0);
        break;
		default:
			return FALSE;
        }
	return TRUE;
}
// Processing for about window, which is its own callback
BOOL CALLBACK AboutCallback(HWND hwnd, UINT Messg, WPARAM wParam, LPARAM lParam) {
        switch(Messg) { // Checking to see if we press the okay button or closed the about window
        case WM_COMMAND:
            switch(LOWORD(wParam)) {
            case IDOK:
                EndDialog(hwnd, IDOK);
                break;
            }
            break;
            default:
                return 0;

        }
        return 1;
}
// The Callback processor, containing all our message processing
LRESULT CALLBACK WndProc(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam) {
    switch(msg) // Main callback for our big window...
    {
        HDC hdc;
        UpdateWindow(hwnd);
        case WM_COMMAND: // Checking to see which button in the toolbar we pressed
            switch(LOWORD(wParam)) {
            case fileExit:
                DestroyWindow(hwnd);
            break;

            case fileLoadBook:
                GetFilePathOpen(hwnd);
            break;

            case fileSaveBook:
            case fileNewBook:
                {
                    char newFilePath[255] = "";
                    GetFilePathSave(hwnd, newFilePath);
            if (newFilePath != NULL) {
                        SaveFile(newFilePath);
                    }
                }
            break;

            case editFileAdd:
                DialogBox(GetModuleHandle(NULL), MAKEINTRESOURCE(addWindow), hwnd, EditAddCallback);
            break;

            case editFileEdit:

            break;

            case editFileRemove:
                DialogBox(GetModuleHandle(NULL), MAKEINTRESOURCE(termToRemove), hwnd, RemoveCallback);
            break;
            case manSortAlpha:
                DialogBox(GetModuleHandle(NULL), MAKEINTRESOURCE(sortWindow), hwnd, SortCallback);
            break;
            case infoTab:
                DialogBox(GetModuleHandle(NULL), MAKEINTRESOURCE(aboutWindow), hwnd, AboutCallback);
            break;
            }
        break;
        case WM_CLOSE:
            DestroyWindow(hwnd);
        break;
        case WM_DESTROY:
            PostQuitMessage(0);
        break;
        case WM_PAINT: // Painting everything
            hdc = BeginPaint(hwnd, &brush);
            phonebookPaint(hdc);
            hdc = EndPaint(hwnd, &brush);
            return 0;
        break;
        default:
            return DefWindowProc(hwnd, msg, wParam, lParam);
    }
    return 0;
}
// The Windows API version of main
int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow) {

    WNDCLASSEX winClass; // Initializing our window class
    HWND hwnd;
    MSG Msg;

    // Registering our windows class
    winClass.cbSize        = sizeof(WNDCLASSEX);
    winClass.style         = 0;
    winClass.lpfnWndProc   = WndProc;
    winClass.cbClsExtra    = 0;
    winClass.cbWndExtra    = 0;
    winClass.hInstance     = hInstance;
    winClass.hIcon         = LoadIcon(NULL, IDI_APPLICATION);
    winClass.hCursor       = LoadCursor(NULL, IDC_ARROW);
    winClass.hbrBackground = (HBRUSH)(COLOR_WINDOW+5);
    winClass.lpszMenuName  = MAKEINTRESOURCE(myMenu);
    winClass.lpszClassName = wzClass;
    winClass.hIconSm       = LoadIcon(NULL, IDI_APPLICATION);

    // Making sure our window is registered
    if(!RegisterClassEx(&winClass))
    {
        MessageBox(NULL, "Window failed...", "Error", MB_ICONEXCLAMATION | MB_OK);
        return 0;
    }

    // Actually creating our window!
    hwnd = CreateWindowEx(
        WS_EX_CLIENTEDGE,
        wzClass,
        "PhoneBook",
        WS_OVERLAPPEDWINDOW | WS_VSCROLL,
        CW_USEDEFAULT, CW_USEDEFAULT, width, height,
        NULL, NULL, hInstance, NULL);

    if(hwnd == NULL) // Making sure we don't break anything
    {
        MessageBox(NULL, "Windows failed...", "Error", MB_ICONEXCLAMATION | MB_OK);
        return 0;
    }

    ShowWindow(hwnd, nCmdShow); // Displaying the window
    UpdateWindow(hwnd);

    // Message processing loop
    while(GetMessage(&Msg, NULL, 0, 0) > 0)
    {
        TranslateMessage(&Msg);
        DispatchMessage(&Msg);
    }

    return Msg.wParam;
}
