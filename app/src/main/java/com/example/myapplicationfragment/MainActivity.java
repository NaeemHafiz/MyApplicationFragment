package com.example.myapplicationfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        setFragment(new BlankFragment());
    }

    // This could be moved into an abstract BaseActivity
    // class for being re-used by several instances
    protected void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment).addToBackStack(null).commit();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(MainActivity.this, "helo", Toast.LENGTH_SHORT).show();
//        if (getFragmentManager().getBackStackEntryCount() != 0) {
//            getFragmentManager().popBackStack();
//        } else {
//            super.onBackPressed();
//        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();

    }
}
