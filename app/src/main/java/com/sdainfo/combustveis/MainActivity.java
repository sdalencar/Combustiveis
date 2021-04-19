package com.sdainfo.combustveis;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etalcool, etgasolina;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etalcool = findViewById(R.id.et_alcool);
        etgasolina = findViewById(R.id.et_gasolina);
        tvResultado = findViewById(R.id.tvResultado);

    }

    public void calcular(View view) {
            String dalcool = etalcool.getText().toString();
            String dgasolina = etgasolina.getText().toString();

             boolean calcular = verificarCampos(dalcool, dgasolina);
             if(calcular){
                 this.melhorPreco(dalcool, dgasolina);
             }else {
                 tvResultado.setText(getString(R.string.aviso));
                 tvResultado.setTextColor(getColor(R.color.vermelho));
                 tvResultado.setTextSize(25);
             }

    }

    private void  melhorPreco(String a, String g){

        Double alcool = Double.parseDouble(a);
        Double gasolina = Double.parseDouble(g);

        Double resultado = alcool/ gasolina;
        String notificacao , tipo, u;
        if(resultado >= 0.7){
            notificacao = getString(R.string.resposta);
            tipo = getString(R.string.gasolina);
            u = notificacao + " " + tipo;
            tvResultado.setText(u);
            tvResultado.setTextColor(getColor(R.color.purple_500));
        }else {
            notificacao = getString(R.string.resposta);
            tipo = getString(R.string.alcool);
            u = notificacao + " " + tipo;
            tvResultado.setText(u);
            tvResultado.setTextColor(getColor(R.color.purple_500));
        }
        etalcool.setText("");
        etgasolina.setText("");

    }


    public boolean verificarCampos(String a, String g){
        boolean ok = true;
        if(a == null || a.equals("")){
            ok = false;
        }else if(g == null || g.equals("")){
            ok = false;
        }
        return ok;
    }
}