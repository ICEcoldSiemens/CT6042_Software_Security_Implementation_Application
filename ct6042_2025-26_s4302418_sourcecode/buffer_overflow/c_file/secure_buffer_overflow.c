#include <stdio.h>
#include <string.h>

int main() {

    // 12-byte long buffer and a 2-byte big-endian integer
    char buffer[12];
    unsigned short data = 2025;

    // use of safer function strncpy() method limits byte allocation
    strncpy(buffer, "trying to cause an overflow", 5);
    printf("buffer: %s\n", buffer); // Will output "tryin"
    printf("data: %d\n", data); // Will output the number 2025
    return 0;
}