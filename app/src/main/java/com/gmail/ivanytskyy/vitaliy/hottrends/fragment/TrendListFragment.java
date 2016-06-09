package com.gmail.ivanytskyy.vitaliy.hottrends.fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gmail.ivanytskyy.vitaliy.hottrends.adapter.TrendListAdapter;
import com.gmail.ivanytskyy.vitaliy.hottrends.service.CustomCallback;
import com.gmail.ivanytskyy.vitaliy.hottrends.model.Trend;
import com.gmail.ivanytskyy.vitaliy.hottrends.service.Request;
import com.gmail.ivanytskyy.vitaliy.hottrends.service.TrendRequestImpl;
import java.util.List;
/**
 * Created by Vitaliy Ivanytskyy on 08.06.2016.
 */
public class TrendListFragment extends ListFragment {
    TrendListAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Request request = new TrendRequestImpl();
        request.obtainDataList(new CustomCallback<List<Trend>>() {
            @Override
            public void next(List<Trend> results) {
                adapter = new TrendListAdapter(getActivity(), results);
                setListAdapter(adapter);
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    public static TrendListFragment newInstance(){
        Bundle args = new Bundle();
        TrendListFragment trendListFragment = new TrendListFragment();
        trendListFragment.setArguments(args);
        return trendListFragment;
    }
}