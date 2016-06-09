package com.gmail.ivanytskyy.vitaliy.hottrends.service;
import com.gmail.ivanytskyy.vitaliy.hottrends.model.Trend;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Created by Vitaliy Ivanytskyy on 08.06.2016.
 */
public class TrendRequestWithPlainRetrofitImpl extends TrendRequest{
    @Override
    public void obtainDataList(final CustomCallback<List<Trend>> callback) {
        Call<List<Trend>> call = super.getLink().getTrends();
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