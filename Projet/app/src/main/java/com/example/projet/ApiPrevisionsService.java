package com.example.projet;


import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiPrevisionsService {

    @GET("api/v2/catalog/datasets/arome-0025-enriched/records?rows=55")

    Call<AromeResponse> getAllData();

}
