package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mukesh.countrypicker.Country;
import com.mukesh.countrypicker.CountryPicker;
import com.mukesh.countrypicker.OnCountryPickerListener;

public class MainActivity extends AppCompatActivity implements OnCountryPickerListener {

    private TextView countryName;
    private Button pickCountryBtn;
    private CountryPicker countryPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListener();
    }


    private void setListener() {
        pickCountryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countryPicker.showDialog(getSupportFragmentManager());
            }
        });
    }

    private void init() {
        countryName = findViewById(R.id.select_country);
        pickCountryBtn = findViewById(R.id.btnSelect);
        countryPicker = new CountryPicker.Builder().with(this)
                .listener(this)
                .build();
    }

    @Override
    public void onSelectCountry(Country country) {
        countryName.setText(country.getName());
    }


}