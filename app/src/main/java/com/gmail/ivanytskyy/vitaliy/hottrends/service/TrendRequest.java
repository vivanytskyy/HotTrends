package com.gmail.ivanytskyy.vitaliy.hottrends.service;
import com.gmail.ivanytskyy.vitaliy.hottrends.model.Trend;
import java.util.List;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Vitaliy Ivanytskyy on 09.06.2016.
 */
public abstract class TrendRequest implements Request<List<Trend>>{
    private Retrofit mRetrofitBuilder;
    private Link mLink;
    public TrendRequest(){
        mRetrofitBuilder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mLink = mRetrofitBuilder.create(Link.class);
    }
    public Link getLink() {
        return mLink;
    }
}