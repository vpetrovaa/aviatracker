kafka-topics \
  --bootstrap-server localhost:9092 \
  --topic messages \
  --replication-factor 1 \
  --partitions 3 \
  --create

kafka-topics \
  --bootstrap-server localhost:9092 \
  --topic accidents \
  --replication-factor 1 \
  --partitions 3 \
  --create
