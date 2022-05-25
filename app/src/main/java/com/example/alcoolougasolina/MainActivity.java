package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editAlccol, editGasolina;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editAlccol      = findViewById(R.id.editAlcool);
        editGasolina    = findViewById(R.id.editGasolina);
        textoResultado  = findViewById(R.id.textoResultado);

    }



    public void calcular (View view){

        //recuperar valores digitados
        String precoAlcool = editAlccol.getText().toString();
        String precoGasolina = editGasolina.getText().toString();

        // validaçao de campos
        Boolean camposValidados = validarCampos(precoAlcool,precoGasolina);

        if(camposValidados){

            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            Double resultado = valorAlcool/valorGasolina;

            if(resultado >= 0.7){
                textoResultado.setText("USE ALCOOL");
            }else {
                textoResultado.setText("USE GASOLINA");
            }

        }else {
            textoResultado.setText("preencha os preços para realizar o cáculo");

        }

    }


    public Boolean validarCampos(String pAlcool,String pGasolina){

        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;

        }

        return camposValidados;
    }

}



