import paho.mqtt.client as paho
import time
import random
import datetime
import json
import threading

MQTT_BROKER = 'localhost'
MQTT_PORT = 1883
TOPICS = 'smartfarm/ph'
NUM_THREAD = 5

client = paho.Client()
client.connect(MQTT_BROKER, MQTT_PORT)
client.loop_start()

def generate_ph(num):
    while True:
        try:
            ph = random.uniform(0, 14)
            
            msg = {
                "deviceId": "ph_sensors_" + str(num),
                "timestamps": datetime.datetime.now().strftime("%Y-%m-%dT%H:%M:%S.%f%z"),
                "value": round(ph, 4)
            }
            
            print("Publish message with ph value: ", msg)
            # client.publish(TOPICS, json.dumps(msg), qos=1)
            time.sleep(10)
        except KeyboardInterrupt:
            break
        
if __name__== '__main__':
    thread_lst = []
    for i in range (0,NUM_THREAD):
        t = threading.Thread(target=generate_ph, args=(i,))
        t.start()
        thread_lst.append(t)
    
    for t in thread_lst:
        t.join()
 
    # both threads completely executed
    print("Done!")