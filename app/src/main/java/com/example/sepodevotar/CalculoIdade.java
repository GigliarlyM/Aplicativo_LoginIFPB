package com.example.sepodevotar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CalculoIdade extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_idade);

        getSupportActionBar().hide();

        this.mViewHolder.textResult = findViewById(R.id.text_resultado);
        this.mViewHolder.textData = findViewById(R.id.text_Data);
        this.mViewHolder.buttonStart = findViewById(R.id.button_calcular);
        this.mViewHolder.textLink = findViewById(R.id.text_link_inicial);

        clearText();
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.mViewHolder.buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testVoto();
            }
        });

        this.mViewHolder.textLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculoIdade.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void clearText(){
        this.mViewHolder.textResult.setText("");
    }

    public static class ViewHolder{
        TextView textResult;
        EditText textData;
        Button buttonStart;
        TextView textLink;
    }

    public void testVoto() {
        // para receber a data não formatada
        String dataNasci = this.mViewHolder.textData.getText().toString();
        // processo de formatação
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNasc = null;
        try {
            dataNasc = format.parse(dataNasci);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int idade = calculaIdade(dataNasc);

        if (idade < 16){
            // não vota
            this.mViewHolder.textResult.setText("Não vota, pois idade é: " + idade);

        }else if (idade >= 18 && idade < 70){
            // obrigatório
            this.mViewHolder.textResult.setText("Voto obrigatório, pois idade é: " + idade);

        }else{
            // facultativo
            this.mViewHolder.textResult.setText("Voto facultativo, pois idade é: " + idade);

        }
    }

    public static int calculaIdade(java.util.Date dataNasc) {
        //Calcula a Idade baseado em java.util.Date

        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(dataNasc);

        // Cria um objeto calendar com a data atual

        Calendar today = Calendar.getInstance();

        // Obtém a idade baseado no ano

        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

        dateOfBirth.add(Calendar.YEAR, age);

        //se a data de hoje é antes da data de Nascimento, então diminui 1(um)

        if (today.before(dateOfBirth)) {
            age--;
        }
        return age;
    }

}
