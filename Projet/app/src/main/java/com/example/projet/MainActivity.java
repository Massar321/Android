package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Informations> arrayList;
    private Button btnTemperature;
    private RecyclerAdapter recyclerAdapter;
    private Button btnMap;
    private Button btnQuitter;

    ApiPrevisionsService apiPrevisionsService;
    Call<AromeResponse> call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isConnectedToNetwork(this)) {
            btnTemperature = (Button) findViewById(R.id.btnTemperature);
            recyclerView = findViewById(R.id.recyclerView);
            arrayList = new ArrayList<>();
            btnMap = (Button) findViewById(R.id.btnMap);
            btnQuitter = (Button) findViewById(R.id.btnQuitter);


            btnTemperature.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    apiPrevisionsService = Retrofit.getRetrofitInstance().create(ApiPrevisionsService.class);
                    call = apiPrevisionsService.getAllData();

                    call.enqueue(new Callback<AromeResponse>() {
                        @Override

                        public void onResponse(Call<AromeResponse> call, Response<AromeResponse> response) {
                            Log.d("onResponse", "Le code : " + response.code());

                            ArrayList<AromeResponse.Records> records = response.body().getRecords();

                            for (AromeResponse.Records info : records) {

                                Log.d("onResponse", "Id  : " + info.record.getRecord_id());
                                if (info.record.fields.getGeo().getLon() != null) {
                                    Log.d("onResponse", "La Longitude  : " + info.record.fields.getGeo().getLon());
                                }
                                if (info.record.fields.getGeo().getLat() != null) {
                                    Log.d("onResponse", "La Latitude  : " + info.record.fields.getGeo().getLat());
                                }
                                if (info.record.fields.getMinimum_temperature_at_2_metres() != null) {
                                    Log.d("onResponse", "La température MIN :" + info.record.fields.getMinimum_temperature_at_2_metres().toString());
                                }
                                if (info.record.fields.getMximum_temperature_at_2_metres() != null) {
                                    Log.d("onResponse", "La température MAX :" + info.record.fields.getMximum_temperature_at_2_metres().toString());
                                }
                                if (info.record.fields.getTotal_precipitation() != null) {
                                    Log.d("onResponse", "La Précipitation :" + info.record.fields.getTotal_precipitation().toString());
                                }
                                if (info.record.fields.getMximum_temperature_at_2_metres() != null) {
                                    arrayList.add(new Informations("La température MAX : " + info.record.fields.getMximum_temperature_at_2_metres().toString(), "La température MIN : " + info.record.fields.getMinimum_temperature_at_2_metres().toString(), "La précipitation totale : " + info.record.fields.getTotal_precipitation().toString(), info.record.fields.getGeo().getLon(), info.record.fields.getGeo().getLat()));

                                }
                            }
                            RecyclerAdapter recyclerAdapter = new RecyclerAdapter(arrayList);
                            recyclerView.setAdapter(recyclerAdapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        }


                        @Override
                        public void onFailure(Call<AromeResponse> call, Throwable t) {

                            Log.e("onFailure", "onFailure : " + t.getMessage());
                        }
                    });
                }
            });

            btnMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    apiPrevisionsService = Retrofit.getRetrofitInstance().create(ApiPrevisionsService.class);
                    call = apiPrevisionsService.getAllData();

                    call.enqueue(new Callback<AromeResponse>() {
                        @Override
                        public void onResponse(Call<AromeResponse> call, Response<AromeResponse> response) {
                            ArrayList<AromeResponse.Records> records = response.body().getRecords();

                            for (AromeResponse.Records info : records) {


                                if (info.record.fields.getMximum_temperature_at_2_metres() != null) {
                                    arrayList.add(new Informations(info.record.fields.getGeo().getLon(), info.record.fields.getGeo().getLat()));

                                }
                            }
                            Intent intent = new Intent(MainActivity.this, MapsActivity2.class);
                            intent.putExtra("infos", arrayList);
                            startActivity(intent);

                        }

                        @Override
                        public void onFailure(Call<AromeResponse> call, Throwable t) {
                            Log.e("onFailure", "onFailure : " + t.getMessage());
                        }
                    });
                }
            });

            btnQuitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    System.exit(0);
                }
            });

        }else {
            new AlertDialog.Builder(this)
                    .setTitle("Erreur de connexion")
                    .setMessage("Vérifiez votre connexion internet")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Code à exécuter lorsque l'utilisateur clique sur le bouton "OK"
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        }


    }

    public boolean isConnectedToNetwork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                // Network is available
                return true;
            }
        }
        // Network is not available
        return false;
    }
}