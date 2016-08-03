import smbus
import time

#Initialize IIC buzzState
bus = smbus.SMBus(1)
arduino_address = 0x04

while (True):
    time.sleep(.5)
    bus.write(0)
    print bus.read_i2c_block_data(arduino_address,0)
