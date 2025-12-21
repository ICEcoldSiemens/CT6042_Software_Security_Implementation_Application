#include <stdio.h>
#include <string.h>

int main() {

        // 12-byte long buffer and a 2-byte big-endian integer
        char buffer[12];
        unsigned short data = 2025;

        // attempts to copy the string in the buffer but overflows into "data"
        strcpy(buffer, "trying to cause an overflow");
        printf("buffer: %s\n", buffer); // Will output the entire string
        printf("data: %d\n", data); // Due to overflow, byte value changes
        return 0;
}

