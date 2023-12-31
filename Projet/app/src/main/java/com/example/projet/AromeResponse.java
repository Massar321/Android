package com.example.projet;

import androidx.annotation.Nullable;

import java.util.ArrayList;

// Classe représentant la réponse de l'API pour les données météorologiques
public class AromeResponse {

    // Définition des variables pour stocker les données de réponse

    // Constructeurs, getters et setters pour manipuler les données de réponse

    int total_count;

    ArrayList<Records> records;

    public ArrayList<AromeResponse.Records> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<AromeResponse.Records> records) {
        this.records = records;
    }
    public class Links{
        String rel ;
        String href;
    }

    public class Record {
        String id;
        Fields fields;
        String timestamp;
        int size;

        public String getRecord_id() {
            return id;
        }

        public Fields getFields() {
            return fields;
        }

        public String getRecord_timestamp() {
            return timestamp;
        }

        public int getSize() {
            return size;
        }
    }

    public class Fields {
        @Nullable
        Float minimum_temperature_at_2_metres;
        @Nullable
        Float maximum_temperature_at_2_metres;
        @Nullable
        Float total_precipitation;
        @Nullable
        Float surface_net_solar_radiationsurface_net_solar_radiation;
        @Nullable
        Float surface_net_thermal_radiation;
        @Nullable
        Float surface_solar_radiation_downwards;
        @Nullable
        Float surface_latent_heat_flux;
        @Nullable
        Float surface_sensible_heat_flux;
        @Nullable
        GeoPoint position;

        public Float getSurface_solar_radiation_downwards() {
            return surface_solar_radiation_downwards;
        }

        public Float getMinimum_temperature_at_2_metres() {
            return minimum_temperature_at_2_metres;
        }

        public Float getMximum_temperature_at_2_metres() {
            return maximum_temperature_at_2_metres;
        }

        public Float getSurface_sensible_heat_flux() {
            return surface_sensible_heat_flux;
        }
        public Float getTotal_precipitation() {
            return total_precipitation;
        }

        public Float getSurface_latent_heat_flux() {
            return surface_latent_heat_flux;
        }
        public Float getSurface_net_solar_radiationsurface_net_solar_radiation() {
            return surface_net_solar_radiationsurface_net_solar_radiation;
        }
        public Float getSurface_net_thermal_radiation() {
            return surface_net_thermal_radiation;
        }


        public GeoPoint getGeo() {
            return position;
        }
    }

    public class GeoPoint {
        Double lat;
        Double lon;

        public Double getLat() {
            return lat;
        }

        public Double getLon() {
            return lon;
        }
    }
    public class Records{
        Record record;
        //Links links;
    }
}