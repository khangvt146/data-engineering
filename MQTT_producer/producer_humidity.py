import paho.mqtt.client as paho
import time
import random
import datetime
import json
import threading
import argparse

MQTT_BROKER = 'localhost'
MQTT_PORT = 1883
TOPICS = 'smartfarm/humidity'

parser = argparse.ArgumentParser()
parser.add_argument("--thread", type=int, default=5, help='setting thread')
parser.add_argument("--delay", type=int, default=10, help='setting delay time')

args = parser.parse_args()
_thread, _delay = args.thread, args.delay

client = paho.Client()
client.connect(MQTT_BROKER, MQTT_PORT)
client.loop_start()

def generate_humidity(num):
    while True:
        try:
            humidity = random.randint(0,100)
            
            msg = {
                "deviceId": "humidity_sensors_" + str(num),
                "timestamps": datetime.datetime.now().strftime("%Y-%m-%dT%H:%M:%S.%f%z"),
                "value": humidity,
                "unit": "%"
            }
            
            print("Publish message with humidity: ", msg)
            client.publish(TOPICS, json.dumps(msg), qos=1)
            time.sleep(_delay)
        except KeyboardInterrupt:
            break
        
if __name__== '__main__':
    thread_lst = []
    for i in range (0,_thread):
        t = threading.Thread(target=generate_humidity, args=(i,))
        t.start()
        thread_lst.append(t)
    
    for t in thread_lst:
        t.join()
    # both threads completely executed
    print("Done!")