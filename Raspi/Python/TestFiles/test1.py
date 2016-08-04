import smbus
import time

#Initialize IIC buzzState
bus = smbus.SMBus(1)
arduino_address = 0x04

while (True):
    time.sleep(.5)
    bus.write_byte(arduino_address,0)
    data = bus.read_i2c_block_data(arduino_address,0)
    print data
