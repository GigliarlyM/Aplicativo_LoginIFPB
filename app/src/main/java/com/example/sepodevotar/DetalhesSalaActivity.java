package com.example.sepodevotar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sepodevotar.service.StatusService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class DetalhesSalaActivity extends AppCompatActivity {

    private StatusService statusApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_sala);
    }

    public void setupRetrofit() {
        // Faz as requisições com base numa URl, e as requisição serão feitas junto com os End-points
        String baseUrl = "https://api.github.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        statusApi = retrofit.create(StatusService.class);
    }
}