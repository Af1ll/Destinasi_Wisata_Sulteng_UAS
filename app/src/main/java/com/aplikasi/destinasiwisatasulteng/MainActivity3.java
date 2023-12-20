package com.aplikasi.destinasiwisatasulteng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Intent intent = getIntent();
        String name = intent.getStringExtra("data_name");
        String description = intent.getStringExtra("data_description");
        int photo = intent.getIntExtra("data_photo", 0);

        Button contact_btn = findViewById(R.id.contact_btn);
        TextView nameTextView = findViewById(R.id.tv_item_name);
        TextView deskripsiTextView = findViewById(R.id.tv_item_description);
        ImageView photoTextView = findViewById(R.id.img_item_photo);


        nameTextView.setText(name);
        deskripsiTextView.setText(description);
        photoTextView.setImageResource(photo);

        contact_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "6282271194230"; // Ganti dengan nomor WhatsApp yang dituju tanpa awalan "0" dan kode negara di depannya

                // Format URL untuk membuka aplikasi WhatsApp
                String url = "https://api.whatsapp.com/send?phone=" + phoneNumber;

                try {
                    // Periksa apakah aplikasi WhatsApp terpasang di perangkat
                    PackageManager pm = getApplicationContext().getPackageManager();
                    pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);

                    // Jika terpasang, buka melalui aplikasi WhatsApp
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                } catch (PackageManager.NameNotFoundException e) {
                    // Jika tidak terpasang, buka melalui browser
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                }
            }
        });

    }
}