#include <Arduino.h>
#include <Wire.h>
#include <ShiftIn.h>

#define slave 0x04

ShiftIn reader = ShiftIn(4, 2, 3);

void setup() {
  pinMode(13, OUTPUT);
  digitalWrite(13, 1);

  Wire.begin(slave);
  Serial.begin(9600);
  while(!Serial);
  delay(500);
  Serial.println("READY TO WORK\n\n");
}

void printBuzzState() {
  int * h = reader.read();
  Serial.print("[ ");
  for(int i = 0; i<8; i++) {
    Serial.print(h[i]);
    Serial.print(i<7?", ":" ]");
  }
  Serial.println();
}

void loop () {
  printBuzzState();
  delay(500);
}
