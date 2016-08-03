import smbus
import time

#Initialize IIC buzzState
bus = smbus.SMBus(1)
arduino_address = 0x04

while (True):
    time.sleep(.5)
    nothing = [1]
    print bus.read_i2c_block_data(arduino_address,0,nothing)
