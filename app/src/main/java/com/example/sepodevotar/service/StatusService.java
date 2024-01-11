package com.example.sepodevotar.service;

import com.example.sepodevotar.domain.Sala;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StatusService {
    // Definir o end point para a requesição de busca
    @GET("status")
    Call<List<Sala>> statusService();

    @GET("status/{sala}")
    Call<List<Sala>> statusUnicoService(@Path("sala") String sala);
}
