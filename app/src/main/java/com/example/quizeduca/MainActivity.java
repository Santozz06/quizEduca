package com.example.quizeduca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TemaAdapter temaAdapter;
    private TextView txtTema;
    private LinearLayout indicatorLayout;
    private List<TemaItem> temaItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        txtTema = findViewById(R.id.txtTema);
        indicatorLayout = findViewById(R.id.indicator_layout);
        Button btnJogar = findViewById(R.id.btnJogar);

        // itens do carrossel
        temaItems = new ArrayList<>();
        temaItems.add(new TemaItem(R.drawable.icon_geral, "GERAL"));
        temaItems.add(new TemaItem(R.drawable.icon_historia, "HISTÓRIA"));
        temaItems.add(new TemaItem(R.drawable.icon_geografia, "GEOGRAFIA"));
        temaItems.add(new TemaItem(R.drawable.icon_biologia, "BIOLOGIA"));
        temaItems.add(new TemaItem(R.drawable.icon_matematica, "MATEMÁTICA"));
        temaItems.add(new TemaItem(R.drawable.icon_portugues, "PORTUGUÊS"));
        temaItems.add(new TemaItem(R.drawable.icon_ingles, "INGLÊS"));
        temaItems.add(new TemaItem(R.drawable.icon_fisica, "FÍSICA"));
        temaItems.add(new TemaItem(R.drawable.icon_quimica, "QUÍMICA"));
        temaItems.add(new TemaItem(R.drawable.icon_arte, "ARTE"));
        temaItems.add(new TemaItem(R.drawable.icon_ed_fisica, "EDUCAÇÃO FÍSICA"));
        temaItems.add(new TemaItem(R.drawable.icon_filosofia, "FILOSOFIA"));
        temaItems.add(new TemaItem(R.drawable.icon_sociologia, "SOCIOLOGIA"));


        temaAdapter = new TemaAdapter(temaItems);
        viewPager.setAdapter(temaAdapter);
        setupIndicators();

        // Listener para mudança de página
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
                txtTema.setText(temaItems.get(position).getNome());
            }
        });

        btnJogar.setOnClickListener(v -> {
            int currentPosition = viewPager.getCurrentItem();
            String temaSelecionado = temaItems.get(currentPosition).getNome();

        });
    }

    private void setupIndicators() {
        indicatorLayout.removeAllViews();

        View[] indicators = new View[temaItems.size()];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                16,
                16
        );
        params.setMargins(8, 0, 8, 0);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new View(this);
            indicators[i].setLayoutParams(params);
            indicators[i].setBackgroundResource(i == 0 ?
                    R.drawable.dot_active : R.drawable.dot_inactive);
            indicatorLayout.addView(indicators[i]);
        }
    }

    private void setCurrentIndicator(int position) {
        int childCount = indicatorLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = indicatorLayout.getChildAt(i);
            view.setBackgroundResource(i == position ?
                    R.drawable.dot_active : R.drawable.dot_inactive);
        }
    }
}