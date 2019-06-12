package com.example.intents;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etText, etNumber;

    //Declaro una variable para SharedPreferences:
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences(getString(R.string.prefs_name), Context.MODE_PRIVATE);

        etText = findViewById(R.id.etText);
        etNumber = findViewById(R.id.etNumber);

        //Recupero el text de les preferencies,
        //Si no existeixen, text=""
        String text = prefs.getString("text",""); //getString(R.string.no_value)
        etText.setText(text);

        prefs.getInt("counter",0);
    }

    public void buttonGoPressed(View view) {
        //Recoger el valor del EditText de texto:
        String valor1 = etText.getText().toString();
        //Recoger el valor del EditText de number (parseInt para hacer el cast):
        int valor2 = Integer.parseInt(etNumber.getText().toString());

        //código para abrir SecondActivity y mandar los dos extras:
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("valor_num", valor2);
        intent.putExtra("valor_texto", valor1);
        startActivity(intent);
    }

    public void buttonPrefsPressed(View view) {
        SharedPreferences.Editor editor = prefs.edit();
        //Guardo l'string al editor de les preferencies:
        editor.putString("text", etText.getText().toString());
        //Faig commit (sino no guarda!)
        editor.commit();
    }

    public void buttonCounterPressed (View view){
        int counter = prefs.getInt("counter", 0);
        Toast.makeText(this, String.valueOf(counter), Toast.LENGTH_LONG).show();
    }
}
