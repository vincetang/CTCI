//
//  main.cpp
//  cracking_the_coding_interview
//
//  Created by Vincent Tang on 2016-01-24.
//  Copyright © 2016 Vincent Tang. All rights reserved.
//

#include <iostream>

// 1.2
void reverse(char* str) {
    int length = (unsigned)strlen(str);
    int start = 0;
    int end = length - 1;
    
    while (start < end) {
        char temp = *(str+start);
        *(str+start) = *(str+end);
        *(str+end) = temp;
        start++;
        end--;
    }
}

int main(int argc, const char * argv[]) {
    /*
    // 1.2
    char str[10];
    str[0] = 'H';
    str[1] = 'e';
    str[2] = 'l';
    str[3] = 'l';
    str[4] = 'o';
    str[5] = '\0';
    
    std::cout << str << '\n';
    
    reverse(str);
    std::cout << str <<'\n';
    */
    
    return 0;
}
