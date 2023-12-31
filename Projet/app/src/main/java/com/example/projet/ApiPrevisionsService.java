package com.example.projet;


import retrofit2.Call;
import retrofit2.http.GET;

// Interface définissant les appels de service pour les prévisions météorologiques
public interface ApiPrevisionsService {

    // Obtient toutes les données de prévisions en utilisant une requête GET
    @GET("api/v2/catalog/datasets/arome-0025-enriched/records?rows=55")

    Call<AromeResponse> getAllData();

}
