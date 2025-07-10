package com.example.beeradviser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button findBeerButton = findViewById(R.id.find_beer);
        TextView brands = findViewById(R.id.brands);

        BeerExpert expert = new BeerExpert();

        findBeerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner color = findViewById(R.id.color);
                String beerType = String.valueOf(color.getSelectedItem());

                List<String> brandsList = expert.getBrands(beerType);
                StringBuilder brandsFormatted = new StringBuilder();
                for (String brand : brandsList) {
                    brandsFormatted.append(brand).append('\n');
                }

                // output
                brands.setText(brandsFormatted);
            }
        });

    }
}