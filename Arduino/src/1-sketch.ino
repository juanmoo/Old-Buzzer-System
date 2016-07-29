#include <ShiftIn.h>
#include <ShiftOut.h>
#include <Wire.h>

#define slave 0x04

ShiftOut shifter = ShiftOut(A2,A0,A1);
ShiftIn reader = ShiftIn(7,5,6);

void setup() {
  Wire.begin(slave);
  Serial.begin(9600);
  while(!Serial);
  Serial.println("READY TO WORK!\n");
  
}

void loop() {
  // put your main code here, to run repeatedly:
  delay(100);
  
  if (Serial.available()>0) {

    char l = Serial.read();

    if(l=='l') {
      shifter.latch();
    }

    else if(l == 'c') {
      shifter.clock();
    }

    else if(l == 'd') {
      shifter.data(); 
    }
  }

  readPinState();
}

void readPinState() {
  int * h = reader.read();
  Serial.print("[ ");
  for (int i = 0; i<8; i++) {
    Serial.print(h[i]);
    if (i<7) {
      Serial.print(", ");
    }
    else {
      Serial.print(" ]");
    }
  }
  Serial.println();
}

