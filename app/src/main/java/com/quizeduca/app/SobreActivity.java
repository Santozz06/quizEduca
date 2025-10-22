package com.quizeduca.app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);


        ImageButton btnVoltarSobre = findViewById(R.id.btnVoltarSobre);
        btnVoltarSobre.setOnClickListener(v -> {
            finish();
        });
    }
}
