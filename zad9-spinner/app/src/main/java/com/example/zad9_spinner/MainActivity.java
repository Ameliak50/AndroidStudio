package com.example.zad9_spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    }
    public void SprawdzOdpowiedz (View view) {
        String tekst = "";
        int dlugosc = Toast.LENGTH_LONG;
        Spinner lista = findViewById(R.id.spinner);
        String wybor = String.valueOf(lista.getSelectedItem());
        if (wybor.equals("zielony"))
            tekst = "prawidlowa odpowiedz";
        else
            tekst = "bledna odpowiedz";
        Toast toast = Toast.makeText(this, tekst, dlugosc);
        toast.show();
        TextView textview = findViewById(R.id.kolor);
        textview.setText(wybor);
    }
}