package com.example.sepodevotar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalculoIdade extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_idade);

        getSupportActionBar().hide();

        this.mViewHolder.textResult = findViewById(R.id.text_resultado);
        EditText textData = findViewById(R.id.text_Data);
        java.util.Date dataNasc = (Date) textData.getText();

        int idade = calculaIdade(dataNasc);

    }

    public static class ViewHolder{
        TextView textResult;
    }

    public static void testVoto(){

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
