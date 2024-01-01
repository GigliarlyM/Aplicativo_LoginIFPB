package com.example.sepodevotar.service;

import com.example.sepodevotar.domain.Repository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StatusService {
    // Definir o end point para a requesição de busca
    @GET("status")
    Call<Repository> statusService();

    @GET("status/{sala}")
    Call<Repository> statusUnicoService(@Path("sala") String sala);
}
