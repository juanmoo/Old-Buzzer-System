#include <ShiftIn.h>
#include <ShiftOut.h>
#include <Wire.h>

#define SLAVE 0x04

ShiftIn reader = ShiftIn(2,0,1);

void setup() {
  Wire.begin(SLAVE);
  Serial.begin(9600);
  while(!Serial);
  Serial.println("READY TO BEGIN!");

  printBuzzState(); 
}

void loop() {
  delay(300);
  //printBuzzState();
}

void printBuzzState(){
  reader.read();
  for (int i = 0; i<8; i++) {
    Serial.print(reader.pins()[i]);
    Serial.print(" ");
  }

  Serial.println(reader.pinsNum());
}
