# Initialize network
docker network create smart_farm_network

# Running all service
docker-compose up -d --build

# Using Kafka UI at localhost:19000

# Create kafka topic (smart_farm_temperature, smart_farm_pressure, smart_farm_humidity, smart_farm_light, smart_farm_salinity) with 2 partions and 1 replica using Kafdrop UI

# Open connector to Kafka
docker cp ./kafka-configuration.xml hivemq:/opt/hivemq-4.13.0/extensions/hivemq-kafka-extension
docker exec -ti hivemq bash

# Inside hivemq container
cd /extensions/hivemq-kafka-extension/
rm -rf DISABLED

# Running generate data scripts
python run_producer.py