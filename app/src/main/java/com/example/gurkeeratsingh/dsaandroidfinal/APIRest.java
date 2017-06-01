package com.example.gurkeeratsingh.dsaandroidfinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;



public interface APIRest {



    @GET("/users/{user}/followers")
    Call<List<Seguidor>> seguidores(
            @Path("user") String user
    );

    @GET("/users/{user}/following") Call<List<Seguidor>> seguidos(@Path("user") String user);


    /*@GET("/users/{user}")
    Call<UsuarioMaster> getUser(
            @Path("user") String user
    );*/

}
