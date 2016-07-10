#include <ShiftIn.h>
#include <ShiftOut.h>
#include <Wire.h>

#define slaveAddress 0x05

void setup()
{
  Wire.begin(slaveAddress);
  Serial.begin(9600);
  while(!Serial);
  Serial.println("READY");
  Wire.onRequest(sendData);
  Wire.onReceive(receiveData);
}

void loop()
{
}

void sendData() {

}

void receiveData(int byteCount) {

}
