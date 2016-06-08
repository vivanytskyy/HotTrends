package com.gmail.ivanytskyy.vitaliy.hottrends.fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.gmail.ivanytskyy.vitaliy.hottrends.adapter.TrendListAdapter;
import com.gmail.ivanytskyy.vitaliy.hottrends.service.Link;
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
public class TrendListFragment extends ListFragment {
    private String mUrl;
    private Link mLink;
    private List<Trend> trends;
    private Retrofit mRetrofit;
    TrendListAdapter adapter;
    public static final String EXTRA_BASE_URL = "com.gmail.ivanytskyy.vitaliy.hottrends.fragment.trendslistfragment.url";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUrl = getArguments().getString(EXTRA_BASE_URL);
        mRetrofit = new Retrofit.Builder()
                .baseUrl(mUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mLink = mRetrofit.create(Link.class);
        Call<List<Trend>> call = mLink.getTrends();
        call.enqueue(new Callback<List<Trend>>() {
            @Override
            public void onResponse(Call<List<Trend>> call, Response<List<Trend>> response) {
                trends = response.body();
                adapter = new TrendListAdapter(TrendListFragment.this.getActivity(), trends);
                setListAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<Trend>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    public static TrendListFragment newInstance(String url){
        Bundle args = new Bundle();
        TrendListFragment trendListFragment = new TrendListFragment();
        args.putString(EXTRA_BASE_URL, url);
        trendListFragment.setArguments(args);
        return trendListFragment;
    }
}