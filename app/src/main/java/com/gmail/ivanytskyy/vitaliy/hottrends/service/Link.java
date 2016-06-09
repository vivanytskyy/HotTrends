package com.gmail.ivanytskyy.vitaliy.hottrends.service;
import com.gmail.ivanytskyy.vitaliy.hottrends.model.Trend;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;
/**
 * Created by Vitaliy Ivanytskyy on 08.06.2016.
 */
public interface Link {
    @GET("api/db/items/trends")
    Call<List<Trend>> getTrends();

    @GET("api/db/items/trends")
    Observable<List<Trend>> getTrendsByRxJava();
}