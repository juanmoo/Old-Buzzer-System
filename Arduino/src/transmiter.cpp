#include <Arduino.h>
#include <ShiftIn.h>
#include <ShiftOut.h>
#include <Wire.h>
#include <inttypes.h>

#define slave_address 0x04

//Instatiate Input and Output shift Registers
  ShiftIn reader = ShiftIn(4, 2, 3);
  ShiftOut shifter = ShiftOut(16, 14, 15);

//Define Functions to be implemented later.
  void sendData();
  void receiveData( int byteCount );
  void writeState(int cmd);
  void readState(int cmd);
  void sendBuzzState();
  void updateBuzzState();
  void sendButtonState();

//Global Variables
  int data [8];
  int rs = 0;

//Main Program Order
void setup () {
  //Setup Buttons
    for (int i = 5; i<=12; i++) {
      pinMode(i, INPUT);
    }

  //Initialize IIC
    Wire.begin(slave_address);
    Wire.onReceive(receiveData);
    Wire.onRequest(sendData);

  //Initialize Serial
    Serial.begin(9600);
    while(!Serial);
    Serial.println("Serial has been activated!\n");

}

void loop () {
 delay(100);
}

//Communication Functions
void receiveData( int byteCount ) {
  int cmd = Wire.read();
  if (byteCount>1) {
    int i = 0;
    while (Wire.available()>0) {
      data[i++] = Wire.read();
    }
  }

  Serial.print("Command Received: ");
  Serial.print(cmd);
  Serial.println();

  for (int i = 0; i<8; i++) {
    Serial.print(data[i]);
    Serial.print(", ");
  }
  Serial.println("\n");

  if (cmd<=10) { //Read Data Commands
    Serial.println("A read command was entered.");
    readState(cmd);
  }

  else {  //Write Data Commands
    Serial.println("A write command was entered.");
    writeState(cmd);
  }

}

void sendData() {
  if (rs == 11) { //Send Buzzer State
    sendBuzzState();
  }

  else if (rs == 12) { //Send Button State
    sendButtonState();
  }

  rs = -1;
}


void writeState(int cmd) {
  rs = cmd;
}

void readState(int cmd) {
  if (cmd == 0) {
    sendBuzzState();
  }
}

void sendBuzzState() {
  int * h = reader.read();
  uint8_t toSend [8];
  for (int i = 0; i<8; i++) {
    toSend[i] = h[i];
  }

  Wire.write(toSend,8);
}

void updateBuzzState() {
  shifter.write(data);
}

void sendButtonState() {
  uint8_t buttons [8];
  for(int i = 0; i<8; i++) {
    buttons[i] = digitalRead(i+5);
  }

  Wire.write(buttons,8);
}
