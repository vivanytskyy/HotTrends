package com.gmail.ivanytskyy.vitaliy.hottrends.activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.gmail.ivanytskyy.vitaliy.hottrends.R;
import com.gmail.ivanytskyy.vitaliy.hottrends.fragment.TrendListFragment;
public class TrendsActivity extends AppCompatActivity {
    public static final String BASE_URL = "http://geekinformer.net";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trends);
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if(fragment == null){
            fragment = TrendListFragment.newInstance(BASE_URL);
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }
}