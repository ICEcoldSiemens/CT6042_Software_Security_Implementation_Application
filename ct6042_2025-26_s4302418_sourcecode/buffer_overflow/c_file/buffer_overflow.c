#include <stdio.h>
#include <string.h>

int main() {

        char buffer[12];
        unsigned short data = 2025;

        strcpy(buffer, "trying to cause an overflow");
        printf("buffer: %s\n", buffer);
        printf("data: %d\n", data);
        return 0;
}

