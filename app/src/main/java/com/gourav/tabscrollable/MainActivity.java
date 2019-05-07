package com.gourav.tabscrollable;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.ogaclejapan.smarttablayout.SmartTabLayout;


public class MainActivity extends AppCompatActivity {

    SmartTabLayout tabLayout;

    public static String Day="Monday";

    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=(SmartTabLayout) findViewById(R.id.tab);
        viewPager=(ViewPager)findViewById(R.id.view);

        FirebaseMessaging.getInstance().subscribeToTopic("notify");
        final FragmentAdapter fragmentAdapter=new FragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.addFragment(new BlankFragment(),"Monday");
        fragmentAdapter.addFragment(new BlankFragment(),"Tuesday");
        fragmentAdapter.addFragment(new BlankFragment(),"Wednesday");
        fragmentAdapter.addFragment(new BlankFragment(),"Thursday");
        fragmentAdapter.addFragment(new BlankFragment(),"Friday");
        fragmentAdapter.addFragment(new BlankFragment(),"Saturday");

        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setViewPager(viewPager);

        tabLayout.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {
            @Override
            public void onTabClicked(int position) {
                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                Day=fragmentAdapter.title(position);
            }
        });


    }
}

