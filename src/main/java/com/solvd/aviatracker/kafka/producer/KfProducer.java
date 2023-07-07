package com.solvd.aviatracker.kafka.producer;

public interface KfProducer<T> {

    void sendMessage(T t);

}
