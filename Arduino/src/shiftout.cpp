#include <Arduino.h>
#include <ShiftIn.h>
#include <ShiftOut.h>

ShiftOut shifter = ShiftOut(16,14,15);

int buzzState [16];
int i = -1;

void setup() {
  pinMode(13, OUTPUT);
  digitalWrite(13, HIGH);
  Serial.begin(9600);
  while(!Serial);
  Serial.println("READY TO WORK\n\n");
  while(i++<16) {
    buzzState[i] = 1;
  }
  shifter.write(buzzState);

}

void loop() {

}
