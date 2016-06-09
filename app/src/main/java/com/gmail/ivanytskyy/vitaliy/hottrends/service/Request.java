package com.gmail.ivanytskyy.vitaliy.hottrends.service;
/**
 * Created by Vitaliy Ivanytskyy on 08.06.2016.
 */
public interface Request<T> {
    String BASE_URL = "http://geekinformer.net";
    void obtainDataList(CustomCallback<T> customCallback);
}