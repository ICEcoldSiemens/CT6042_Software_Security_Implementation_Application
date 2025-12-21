#include <iostream>
#include <cstring>
using namespace std;

int main() {

    // 12-byte long buffer and a 2-byte big-endian integer
    char buffer[12];
    unsigned short data = 2025;

    // // use of safer function strncpy() method limits byte allocation
    strncpy(buffer, "trying to cause an overflow", 5);
    cout << "buffer: " << buffer << endl; // Will output "tryin"
    cout << "data: " << data << endl;  // Will output the number 2025
}
