package ru.lyrian.collections_operations_time;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<FragmentHolder> fragmentHolders;

    @SuppressWarnings("deprecation")
    public ViewPagerAdapter(@NonNull FragmentManager fm, List<FragmentHolder> fragmentHolders) {
        super(fm);
        this.fragmentHolders = fragmentHolders;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return this.fragmentHolders.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return this.fragmentHolders.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return this.fragmentHolders.get(position).getFragmentTitle();
    }
}
