package com.example.gurkeeratsingh.dsaandroidfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {//seguidores

    private TextView mensajeloading;
    private TextView buscado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        try{
            Intent intent = getIntent();
            String user = intent.getStringExtra("usuario");
            buscado = (TextView) findViewById(R.id.titulo);
            buscado.setText(user);


            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create());


            Retrofit retrofit =
                    builder.client(httpClient.build()).build();

            APIRest interfazAPI = retrofit.create(APIRest.class);

            Call<List<Seguidor>> call = interfazAPI.seguidores(user);

            call.enqueue(new Callback<List<Seguidor>>() {

                @Override

                public void onResponse(Call<List<Seguidor>> call, Response<List<Seguidor>> response) {
                    mensajeloading = (TextView) findViewById(R.id.loading);
                    if(response.code()==200){
                        List<Seguidor> followers = (List<Seguidor>)response.body();

                        List<String>nombres=new ArrayList<String>();
                        List<String>list_URLs=new ArrayList<String>();
                        List<String>list_type=new ArrayList<String>();

                        ListView listView = (ListView) findViewById(R.id.listView);
                        ImageView imageView = (ImageView) findViewById(R.id.imageView);

                        for (int i = 0; i < followers.size(); i++) {
                            nombres.add(followers.get(i).getLogin());
                            list_URLs.add(followers.get(i).getAvatar_url());
                            list_type.add(followers.get(i).getType());
                        }


                        miAdapter adapter=new miAdapter(Main2Activity.this, nombres, list_URLs,list_type);
                        listView.setAdapter(adapter);

                        Picasso.with(getApplicationContext()).load("https://github.com/identicons/jasonlong.png").resize(270, 200).into(imageView);

                    }
                    else {
                        Toast.makeText(Main2Activity.this, "Error del server: "+response.code(), Toast.LENGTH_SHORT).show();
                        Main2Activity.this.finish();
                    }
                    mensajeloading.setVisibility(View.INVISIBLE);

                }

                @Override

                public void onFailure(Call<List<Seguidor>> call, Throwable t) {

                    Log.e("RequestCall", "El servidor te ha rechazado");
                    Main2Activity.this.finish();
                }

            });





        }catch (Exception e){
            Toast.makeText(Main2Activity.this, "Error de conexió, probable mala url", Toast.LENGTH_SHORT).show();
        }
    }
}

