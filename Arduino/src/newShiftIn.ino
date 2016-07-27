#include <ShiftIn.h>

ShiftIn reader = ShiftIn(A0,A2j,A1);

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  while(!Serial);
  Serial.println("READY!\n\n");
  delay(2000);
}

void loop() {
  // put your main code here, to run repeatedly:
  delay(100);
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

