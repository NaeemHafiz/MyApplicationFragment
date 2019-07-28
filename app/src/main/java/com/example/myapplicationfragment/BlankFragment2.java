package com.example.myapplicationfragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {
    View view;
    String message;
    TextView textView;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle(R.string.subtitle2);
        return view;
    }

    private void initViews() {
        textView = view.findViewById(R.id.text2);
        if (getArguments() != null)
            message = getArguments().getString("message", null);
        if (message != null)
            textView.setText(message);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }
}
