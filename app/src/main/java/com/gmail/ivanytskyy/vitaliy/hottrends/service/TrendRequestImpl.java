package com.gmail.ivanytskyy.vitaliy.hottrends.service;
import com.gmail.ivanytskyy.vitaliy.hottrends.model.Trend;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Vitaliy Ivanytskyy on 08.06.2016.
 */
public class TrendRequestImpl implements Request<List<Trend>>{
    private Retrofit mRetrofitBuilder;
    private Link mLink;
    public TrendRequestImpl(){
        mRetrofitBuilder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    @Override
    public void obtainDataList(final CustomCallback<List<Trend>> callback) {
        mLink = mRetrofitBuilder.create(Link.class);
        Call<List<Trend>> call = mLink.getTrends();
        call.enqueue(new Callback<List<Trend>>() {
            @Override
            public void onResponse(Call<List<Trend>> call, Response<List<Trend>> response) {
                callback.next(response.body());
            }
            @Override
            public void onFailure(Call<List<Trend>> call, Throwable t) {}
        });
    }
}