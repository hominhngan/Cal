package com.example.vocab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

// VocabFragment.java
public class VocabFragment extends DialogFragment {
    private Vocab vocab;
    private VocabPageChangeInterface pageChangeInterface;

    VocabFragment(Vocab vocab, VocabPageChangeInterface pageChangeInterface){
        this.vocab = vocab;
        this.pageChangeInterface = pageChangeInterface;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vocab_layout, container, false);
        TextView defTextView = rootView.findViewById(R.id.defTextView);
        defTextView.setText(vocab.def);
        TextView ipaTextView = rootView.findViewById(R.id.ipaTextView);
        ipaTextView.setText(vocab.ipa);
//        Button nextButton = rootView.findViewById(R.id.nextButton);
//
//        Button previousButton = rootView.findViewById(R.id.previousButton);
//        Button backButton = rootView.findViewById(R.id.backButton);
//        nextButton.setOnClickListener(v -> {
//            pageChangeInterface.goToNextPage();
//        });
//
//        previousButton.setOnClickListener(v -> {
//            pageChangeInterface.gotoPreviousPage();
//        });
//
//        backButton.setOnClickListener(v -> {
//            pageChangeInterface.goBack();
//        });
//


        return rootView;
    }
}


