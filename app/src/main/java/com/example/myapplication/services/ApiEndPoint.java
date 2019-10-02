package com.example.myapplication.services;

import com.example.myapplication.entities.Product;
import com.example.myapplication.entities.User;
import com.example.myapplication.entities.UserLog;
import com.example.myapplication.entities.UserLogReturn;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndPoint {

    @POST("auth/login")
    Call<UserLogReturn> autenticar(@Body UserLog userLog);

    @POST("users")
    Call<User> cadastrarNovoUsuario(@Body User user);

    @GET("products")
    Call<Product> todosProdutos();
}
