package com.example.sepodevotar.config;

import com.example.sepodevotar.service.StatusService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig(String baseUrl) {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public StatusService getStatusService() {
        return this.retrofit.create(StatusService.class);
    }

}
