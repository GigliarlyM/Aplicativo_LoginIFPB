package com.example.sepodevotar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DetalhesVoto {
}

class CalculaIdade {
    //Calcula a Idade baseado em java.util.Date
    public static int CalculaIdade(java.util.Date dataNasc){

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
