#ifndef I2CCommunicator_h
#define I2CCommunicator_h

#include <Arduino.h>
#include <Wire.h>
#include <stdint.h>

#define arduino_address 0x04

class I2CCommunicator {
  private:
    //Parameters
    static int sendState;

    //Function Pointers
    static uint8_t * (*user_getBuzzState)(void);

    //Void Functions
    static void sendData();
    static void receiveData(int byteCount);

    static void receiveAction(int cmd, uint8_t * data);
    static void sendAction(int cmd);

    //Non Void Functions



  public:
    I2CCommunicator();
    ~I2CCommunicator();
    void sendNewBuzzState(void (*function)(uint8_t * newBuzzState));
    void onBuzzRequest(uint8_t * (*function)());





};

#endif
