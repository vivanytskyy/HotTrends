package com.gmail.ivanytskyy.vitaliy.hottrends.service;
import com.gmail.ivanytskyy.vitaliy.hottrends.model.Trend;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
/**
 * Created by Vitaliy Ivanytskyy on 09.06.2016.
 */
public class TrendRequestWithRxJavaAndRetrofitImpl extends TrendRequest{
    @Override
    public void obtainDataList(final CustomCallback<List<Trend>> customCallback) {
        Observable<List<Trend>> observable = super.getLink().getTrendsByRxJava();
        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<List<Trend>>() {
            @Override
            public void onCompleted() {}
            @Override
            public void onError(Throwable e) {}
            @Override
            public void onNext(List<Trend> trends) {
                customCallback.next(trends);
            }
        });
    }
}