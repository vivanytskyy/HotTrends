package com.gmail.ivanytskyy.vitaliy.hottrends.activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.gmail.ivanytskyy.vitaliy.hottrends.R;
import com.gmail.ivanytskyy.vitaliy.hottrends.fragment.TrendListFragment;
/**
 * Created by Vitaliy Ivanytskyy on 09.06.2016.
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainerSecond);
        if(fragment == null){
            fragment = TrendListFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.fragmentContainerSecond, fragment).commit();
        }
        //For testing
        Button button = (Button) findViewById(R.id.backToFirstActivityButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
