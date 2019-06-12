package com.example.intents;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv_resultado;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        prefs = getSharedPreferences(getString(R.string.prefs_name), Context.MODE_PRIVATE);

        tv_resultado = findViewById(R.id.txtResult);

        //Recogemos los extras que mandamos desde MainActivity
        int resultado = getIntent().getIntExtra("valor_num", 0);

        String texto = getIntent().getStringExtra("valor_texto");

        //Modifico el texto del TextView del layout:
        tv_resultado.setText(texto + " " + resultado);

        //Recoger el valor antiguo de counter (inicialmente 0)
        int counter = prefs.getInt("counter", 0);
        //Le sumo 1
        counter = counter + 1;  //counter++;
        //Lo guardo en SharedPreferences:
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("counter", counter);
        editor.commit();
    }

    public void goBackButtonPressed(View view) {
        finish();
    }
}
