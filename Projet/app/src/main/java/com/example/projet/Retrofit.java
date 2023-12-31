package com.example.projet;
import retrofit2.converter.gson.GsonConverterFactory;

// Classe pour configurer et initialiser Retrofit, un client HTTP pour Android

public class Retrofit {
    // Méthode pour créer une instance de Retrofit avec la configuration de base URL et convertisseurs

    private static retrofit2.Retrofit retrofit;
    private static String BASE_URL="https://public.opendatasoft.com/";
    public static retrofit2.Retrofit getRetrofitInstance(){
        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
