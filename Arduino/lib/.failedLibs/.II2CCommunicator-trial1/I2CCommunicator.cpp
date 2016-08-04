#include "I2CCommunicator.h"

// Initialize Class Variables //////////////

uint8_t (*I2CCommunicator::user_getBuzzState)(void);



///////////////////////////////////////////



// Base Functions (Constructor & Destructor) /////////

I2CCommunicator :: I2CCommunicator()
{
  Wire.begin(arduino_address);
  Wire.onRequest(I2CCommunicator::sendData);
  Wire.onReceive(I2CCommunicator::receiveData);
}

I2CCommunicator::~I2CCommunicator()
{
  Wire.end();
}

//On-type Functions
void I2CCommunicator::onBuzzRequest(uint8_t * (*function)())
{
  getBuzzState = function;
}


//Data control functions
void I2CCommunicator::sendData()
{

}

void I2CCommunicator::receiveData(int byteCount)
{
  int cmd = Wire.read();

  uint8_t data [8];

  if(byteCount>1) {
    int index = 0;
    while(Wire.available()){
      data[index] = Wire.read();
      index++;
    }
  }
  else {
    for (int i = 0; i<8; i++) {
      data[i] = -1;
    }
  }

  if (cmd <= 10) {//Request to read from the arduino
    receiveAction(cmd, &data[0]);
  }

  else { //Request for arduino to send data
    sendAction(cmd);
  }
}





void I2CCommunicator::receiveAction(int cmd, uint8_t * data) {
  if (cmd == 0) { //Read Buzzer State
    uint8_t * buzzState = getBuzzState();
  }
}

void I2CCommunicator::sendAction(int cmd) {

}




//Public Functions
void sendNewBuzzState(void (*function)(uint8_t * newBuzzState)) {

}
