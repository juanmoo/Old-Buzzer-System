#include <Wire.h>
#include <ShiftIn.h>
#include <ShiftOut.h>
#include <inttypes.h>


#define slave_address 0x04 //I2C Address of the Arduino Board

//Instantiate 8-bit parallel to serial shift register
ShiftIn buzzReader = ShiftIn(2,0,1); // ShiftIn(Data Pin, Clock Pin, Latch Pin);

//Instantiate  8-bin serial to parallel shift register
ShiftOut shifter = ShiftOut(A2,A0,A1); // ShiftOut(Data Pin, Clock Pin, Latch Pin);

int ws = 0;
byte data [8];


void setup() {
  Wire.begin(slave_address);  //Setup I2C and set slave_address as the board's address.
  
  //Sets default actions to send and receive data over I2C.
  Wire.onRequest(sendData); 
  Wire.onReceive(receiveData);
  
  //Temporal Feedback code
  
  Serial.begin(9600);
  while(!Serial);
  Serial.println("READY TO BEGIN!\n\n");
  

}


void loop() {
  delay (100);
}

void sendData() {
  writeState();
}

void receiveData(int byteCount) {
  ws = -1;
  clearData();
  byte id = Wire.read();
  if (byteCount>1) {
    int index = 0;
    while (Wire.available()>0) {
      data[index] = Wire.read();
      index++;
    }
  }

  readState(id);
    
}

void clearData() {
  for (int i = 0; i<8; i++) {
    data[i] = -1;
  }
}


void writeState() {
  switch (ws) {
    case 0: //Send Buzzer State
      sendBuzzState();
      break;
    case 1: //Send Button State
      sendButtonState();
      break;
    default:
      Wire.write(byte(-1));
      break;
  }
}

void readState(int id) {
  switch (id) {
    case 0: // Setting Write State Mode
      ws = data[0];
      break;
    case 1: // Receiving Buzzer State
      writeReceivedBuzzState();
      break;
    default:
      break;
  }
}

void sendBuzzState() {
  int * h = buzzReader.read();
  uint8_t buzzState [8];
  for (int i = 0; i<8; i++) {
    buzzState[i] = h[i];
  }
  
  Wire.write(buzzState,8);
}

void sendButtonState() {
  uint8_t buttonState[8];
  for (int i = 0; i<8; i++) {
    buttonState[i] = digitalRead(i+4);
  }
  Wire.write(buttonState, 8);
}

void writeReceivedBuzzState() {
  int dataB [8];
  for (int i = 0; i<8; i++) {
    dataB[i] = data[i];
  }
  shifter.write(dataB);
}




