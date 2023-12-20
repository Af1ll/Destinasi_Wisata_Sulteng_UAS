package com.aplikasi.destinasiwisatasulteng;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText mMainText, mMainText1;
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainText = findViewById(R.id.mainText);
        mMainText1 = findViewById(R.id.mainText2);
        Button mSaveBtn = findViewById(R.id.saveBtn);
        ProgressBar progressBar = findViewById(R.id.progress_bar);

        FirebaseApp.initializeApp(this);
        mFirestore = FirebaseFirestore.getInstance();


        mSaveBtn.setOnClickListener(v -> {
            String username = mMainText.getText().toString();
            String password = mMainText1.getText().toString();

            Map<String, String> userMap = new HashMap<>();

            userMap.put( "username", username);
            userMap.put("password", password);

            progressBar.setVisibility(View.VISIBLE);
            if (!username.equals("") && !password.equals("")) {
                mFirestore.collection("pengguna").add(userMap).addOnSuccessListener(documentReference -> {
                    Toast.makeText(MainActivity.this, "Pengguna Ditambahkan di Firestore", Toast.LENGTH_SHORT).show();
                    mMainText.setText("");
                    mMainText1.setText("");
                    progressBar.setVisibility(View.GONE);

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                }).addOnFailureListener(e -> {
                    String error = e.getMessage();
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                });
            } else {
                Toast.makeText(MainActivity.this, "Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}