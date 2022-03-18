package ru.lyrian.collections_operations_time;

import androidx.fragment.app.Fragment;

public class FragmentHolder {
    private final String fragmentTitle;
    private final Fragment fragment;

    public FragmentHolder(String fragmentTitle, Fragment fragment) {
        this.fragmentTitle = fragmentTitle;
        this.fragment = fragment;
    }

    public String getFragmentTitle() {
        return this.fragmentTitle;
    }

    public Fragment getFragment() {
        return this.fragment;
    }
}
