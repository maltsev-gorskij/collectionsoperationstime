package ru.lyrian.collections_operations_time;

import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import dagger.android.support.DaggerAppCompatActivity;
import ru.lyrian.collections_operations_time.presentation.collections.FragmentCollections;
import ru.lyrian.collections_operations_time.presentation.maps.FragmentMaps;

public class MainActivity extends DaggerAppCompatActivity {
    private final List<FragmentHolder> viewPagerFragmentHolders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        this.viewPagerFragmentHolders.add(new FragmentHolder(getString(R.string.fragment_title_collections), new FragmentCollections()));
        this.viewPagerFragmentHolders.add(new FragmentHolder(getString(R.string.fragment_title_maps), new FragmentMaps()));
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this.viewPagerFragmentHolders);
        ViewPager mainActivityViewPager = findViewById(R.id.vpMainActivity);
        mainActivityViewPager.setAdapter(viewPagerAdapter);
    }
}