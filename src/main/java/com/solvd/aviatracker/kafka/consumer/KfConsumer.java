package com.solvd.aviatracker.kafka.consumer;

public interface KfConsumer<T> {

    void receive(T message);

}
