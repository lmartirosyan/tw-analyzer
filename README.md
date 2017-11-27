# tw-analyzer

Twitte Analayzer is simple project which takes data from Twitter Streaming api aggrigates by minute and stores in Redis DB or pushes to Kafka.
Project Designed by Clean architeture, which allows us to isolate modules from each other.

# Working Modes

There are 2 working mode store to redis or push to kafka, you can manage mode  by changing processing.mode property in 
* tw-armenia.properties 
* tw-georgia.properties 
* tw-azerbaijan.properties.


# Technologies
* Clean Architecture
* Redis
* Kafka
* Junit

# DB Structure

The most important in this stage is key design, I have designed key as by following pattern: country_minute.
So record on the same minute will be aggrigated under  the same key. Value will be count of twittes for that minutes.

Install Redis: https://www.rosehosting.com/blog/how-to-install-configure-and-use-redis-on-ubuntu-16-04/

Run Redis Server:
redis-server

Run Redis Client to checkout what in redis:
redis-cli

# Redis Wrapper
Please also check out my Dummy  project which wraps Redis, so you can see what is stored in redis.


# Kafka Structure
Kafka is message bus so we can't push data in aggrigated format to kafka. Data of each country is pushed to separate topic, key is country, value is timestamp (sorry havn't time to design more original flow).
So you should install Kafka, create topic with 3 partitions and 1 (or 3) replication factor. 


 Install kafka: https://kafka.apache.org/downloads
 
 Install Zookeeper: https://devops.profitbricks.com/tutorials/install-and-configure-apache-kafka-on-ubuntu-1604-1/
 
 Create topic: 
./kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 3 --topic twitte

Conusumer:
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic twitte


# Clean  Architecture
Read here about clean architecture:
https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html


# Notes
Please add twitter account credentials in 
* tw-armenia.properties
* tw-georgia.properties
* te-azerbaijan.properties
