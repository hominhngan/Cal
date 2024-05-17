package com.example.vocab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

// VocabDetailActivity.java
public class VocabDetailActivity extends AppCompatActivity implements VocabPageChangeInterface {
    private ViewPager2 viewPager;
    Button nextButton;

    Button previousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_detail);
        Intent intent = getIntent();
        ArrayList<Vocab> vocabList = (ArrayList<Vocab>) intent.getSerializableExtra("vocabList");
        int position = intent.getIntExtra("position", 0);
        viewPager = findViewById(R.id.viewPager);
        VocabPagerAdapter adapter = new VocabPagerAdapter(this, vocabList, this);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
        nextButton = findViewById(R.id.nextButton);
        previousButton = findViewById(R.id.previousButton);
        nextButton.setOnClickListener(v -> {
            goToNextPage();
        });
        previousButton.setOnClickListener(v -> {
            gotoPreviousPage();
        });

    }

    @Override
    public void goToNextPage() {
        int nextItem = viewPager.getCurrentItem() + 1;
        if (nextItem < viewPager.getAdapter().getItemCount()) {
            viewPager.setCurrentItem(nextItem);
        }
    }

    @Override
    public void gotoPreviousPage() {
        int previousItem = viewPager.getCurrentItem() - 1;
        if (previousItem >= 0) {
            viewPager.setCurrentItem(previousItem);
        }
    }

    @Override
    public void goBack() {
        finish();
    }
}