#! /usr/bin/python

import time
import smbubs

bus = smbus.SMBus(1)
slave_address = 0x10

t = 60*10;

while time >= 0:
    data = []
    data.append(t%60)
    data.append(t/60)
    t -= 1;
    bus.write_i2c_block_data(slave_address,12,data)
    time.sleep(1)
