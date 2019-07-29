package com.example.myapplicationfragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    View view;
    @BindView(R.id.text)
    TextView textView;
    @BindString(R.string.hello_blank_fragment)
    String textviewstring;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank, container, false);
        ButterKnife.bind(this, view);
        textView.setText(textviewstring);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle(R.string.subtitle);
        return view;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        submit();
//
//    }


    @OnClick(R.id.text)
    public void submit() {
        setFragment(new BlankFragment2());
    }


    // This could be moved into an abstract BaseActivity
    // class for being re-used by several instances
    protected void setFragment(Fragment fragment) {
        Bundle bundle = new Bundle();
        String myMessage = "Stackoverflow is cool!";
        bundle.putString("message", myMessage);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment).addToBackStack(null).commit();
    }
}
