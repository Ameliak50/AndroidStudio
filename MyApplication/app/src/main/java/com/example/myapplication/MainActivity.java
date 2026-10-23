package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

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
        ListView lista = findViewById(R.id.lista);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lista.setItemChecked(0,true);

        String[] opcje = {"czerwony", "zielony", "niebieski", "zolty"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice,opcje);
        lista.setAdapter(adapter);
    }
    public void wypisz(View view) {
        ListView lista = findViewById(R.id.lista);
        int pozycja = lista.getCheckedItemPosition();
        String tekscik = lista.getItemAtPosition(pozycja).toString();
        TextView textView = findViewById(R.id.tekst);
        textView.setText(tekscik);
    }
}