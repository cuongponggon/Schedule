package com.example.petcare;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {



    TextView overdue, upcoming;
    ViewPager viewPager;
    PagerViewAdapter pagerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        overdue = (TextView) findViewById(R.id.tab_overdue);
        upcoming = (TextView) findViewById(R.id.tab_upcoming);
        viewPager = (ViewPager) findViewById(R.id.fragment_container);

        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerViewAdapter);

        overdue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        upcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onPageSelected(int position) {
                onChangeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void onChangeTab(int position) {
        if(position == 0){
            overdue.setTextSize(20);
            overdue.setTextColor(getColor(R.color.colorBlack));

            upcoming.setTextSize(15);
            upcoming.setTextColor(getColor(R.color.colorPrimaryDark));

        }
        if(position == 1){
            overdue.setTextSize(15);
            overdue.setTextColor(getColor(R.color.colorPrimaryDark));

            upcoming.setTextSize(20);
            upcoming.setTextColor(getColor(R.color.colorBlack));
        }
    }
}
