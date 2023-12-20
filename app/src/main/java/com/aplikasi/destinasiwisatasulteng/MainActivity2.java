package com.aplikasi.destinasiwisatasulteng;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.aplikasi.destinasiwisatasulteng.databinding.ActivityMain2Binding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding binding;



        private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                int itemId = item.getItemId();

                if (itemId == R.id.fragment_home) {
                    fragment = new HomeFragment();
                } else if (itemId == R.id.fragment_category) {
                    fragment = new CategoryFragment();
                } else if (itemId == R.id.fragment_account) {
                    fragment = new AccountFragment();
                }

                if (fragment != null) {
                    replaceFragment(fragment);
                    return true;
                }

                return false;
            }
        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        if (savedInstanceState == null){
            binding.bottomNavigationView.setSelectedItemId(R.id.fragment_home);
    }
}
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}

