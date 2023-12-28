package com.example.sepodevotar.data;

import com.example.sepodevotar.domain.Repository;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DataService {
    @GET("users/{user}/repos")
    public Call<ArrayList<Repository>> getAllRepositoriesByUser(@Path("user") String user);
}
