package com.example.sepodevotar;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Retrofit;

public class DetalhesVoto extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setupRetrofit() {
        // Faz as requisições com base numa URl, e as requisição serão feitas junto com os End-points
        String baseUrl = "https://api.github.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
//                .addConverterFactory()
                .build();

//        DataService githubApi = retrofit.create(DataService.class);
    }
}
