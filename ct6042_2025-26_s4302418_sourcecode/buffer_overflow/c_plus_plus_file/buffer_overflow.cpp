#include <iostream>
#include <cstring>
using namespace std;

int main() {

    // 12-byte long buffer and a 2-byte big-endian integer
    char buffer[12];
    unsigned short data = 2025;

    // attempts to copy the string in the buffer but overflows into "data"
    strcpy(buffer, "trying to cause an overflow");
    cout << "buffer: " << buffer << endl;
    cout << "data: " << data << endl;  // The overflow overwrites "data"
}
