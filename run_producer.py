import subprocess
import os

# Define the paths to the scripts you want to run

PATH = "./MQTT_producer/"
NUM_THREAD = 5

# Run each script using the subprocess module

subprocess.Popen(['python', PATH + "producer_temp.py", '--thread', str(NUM_THREAD)], bufsize=0)

subprocess.Popen(['python', PATH + "producer_humidity.py", '--thread', str(NUM_THREAD)], bufsize=0)

subprocess.Popen(['python', PATH + "producer_light.py", '--thread', str(NUM_THREAD)], bufsize=0)

# subprocess.Popen(['python', PATH + "producer_pressure.py", '--thread', str(NUM_THREAD)], bufsize=0)

# subprocess.Popen(['python', PATH + "producer_salinity.py", '--thread', str(NUM_THREAD)], bufsize=0)



