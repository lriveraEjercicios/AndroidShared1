package com.example.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv_resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_resultado = findViewById(R.id.txtResult);

        //Recogemos los extras que mandamos desde MainActivity
        int resultado = getIntent().getIntExtra("valor_num",0);

        String texto = getIntent().getStringExtra("valor_texto");

        //Modifico el texto del TextView del layout:
        tv_resultado.setText(texto+" "+resultado);
    }

    public void goBackButtonPressed(View view)
    {
        finish();
    }
}
