#include <stdio.h>
#include <wiringPi.h>
#include <wiringPiI2C.h>

#define SLAVE_ADDRESS 0x04

int main() {
  wiringPiSetup();
  int df = wiringPiI2CSetup(SLAVE_ADDRESS);
  
  if (df == -1 ) {
    printf("There was an error\n");
    return 1;
  }

  char i = wiringPiI2CRead(SLAVE_ADDRESS);

  printf("The number received was %d\n", i);

  wiringPiI2CWrite(SLAVE_ADDRESS, 1);

  char l = wiringPiI2CRead(SLAVE_ADDRESS);
  printf("The number received was %d\n", l);
  
  //wiringPiI2CWrite(SLAVE_ADDRESS,1);
  //char l = wiringPiI2CRead(SLAVE_ADDRESS);
  //printf(l);

  return 0;
}
