package com.peachymedia.emmaboard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity {

    ViewPager viewPager;
    SoundPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerAdapter = new SoundPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Emma Soundboard");

    }

    public class SoundPagerAdapter extends FragmentPagerAdapter {

        public SoundPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new SoundFragment();
            Bundle args = new Bundle();
            args.putInt("soundset", position);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return "Basic";
                case 1: return "People";
                case 2: return "Love & Laugh";
                case 3: return "Singing";
                case 4: return "Random";
            }
            return "invalid";
        }
    }

}
