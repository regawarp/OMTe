package com.safetyfirst.omte;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements OrderFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener, MoreFragment.OnFragmentInteractionListener {
    private TextView mTextMessage;
    private EditText etSearch;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment homeFragment = new HomeFragment();
                    openFragment(homeFragment);
                    return true;
                case R.id.navigation_order:
                    OrderFragment orderFragment = new OrderFragment();
                    openFragment(orderFragment);
                    return true;
                case R.id.navigation_more:
                    MoreFragment moreFragment = new MoreFragment();
                    openFragment(moreFragment);
                    return true;
            }
            return false;
        }
    };

    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void setCustomActionBar() {
        //Custom Action Bar
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.search_action_bar);

        View view = actionBar.getCustomView();
        etSearch = view.findViewById(R.id.et_search);
        etSearch.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_launcher_round, 0);
        etSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    etSearch.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }else{
                    etSearch.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_launcher_round, 0);
                }
            }
        });
    }
}
