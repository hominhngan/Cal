package com.example.vocab;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

// VocabPagerAdapter.java
public class VocabPagerAdapter extends FragmentStateAdapter {
    private List<Vocab> vocabs;
    private VocabPageChangeInterface pageChangeInterface;

    public VocabPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Vocab> vocabs, VocabPageChangeInterface pageChangeInterface) {
        super(fragmentActivity);
        this.vocabs = vocabs;
        this.pageChangeInterface = pageChangeInterface;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new VocabFragment(vocabs.get(position), pageChangeInterface);
    }

    @Override
    public int getItemCount() {
        return vocabs.size();
    }
}