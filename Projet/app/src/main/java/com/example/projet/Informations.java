package com.example.projet;


import android.os.Parcel;
import android.os.Parcelable;

// Classe modèle pour les informations météorologiques
    public class Informations implements Parcelable {

    // Variables pour les différentes informations météorologiques

    // Constructeur pour initialiser les informations
    // Getters et setters pour chaque variable


        private String tempMax;
        private String tempMin;
        private String precip;
        private Double lat;
        private Double lon;


        private String surfaceNetThermalRadiation;

        public Informations(String tempMax, String tempMin, String precip,Double lat, Double lon) {

            this.tempMax = tempMax;
            this.tempMin = tempMin;
            this.precip = precip;
            this.lat = lat;
            this.lon = lon;

        }
        public Informations(Double lat, Double lon){
            this.lat = lat;
            this.lon = lon;
        }

        public Informations(Parcel prcl) {

            tempMax = prcl.readString();
            tempMin = prcl.readString();
            precip = prcl.readString();
            lat = prcl.readDouble();
            lon = prcl.readDouble();
        }

        public static final Creator<Informations> CREATOR = new Creator<Informations>() {
            @Override
            public Informations createFromParcel(Parcel in) {
                return new Informations(in);
            }

            @Override
            public Informations[] newArray(int size) {
                return new Informations[size];
            }
        };


        public String getTempMax() {
            return tempMax;
        }

        public void setTempMax(String tempMax) {
            this.tempMax = tempMax;
        }

        public String getTempMin() {
            return tempMin;
        }

        public void setTempMin(String tempMin) {
            this.tempMin = tempMin;
        }

        public String getPrecip() {
            return precip;
        }

        public void setPrecip(String precip) {
            this.precip = precip;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }

        public String getSurfaceNetThermalRadiation() {
            return surfaceNetThermalRadiation;
        }

        public void setSurfaceNetThermalRadiation(String surfaceNetThermalRadiation) {
            this.surfaceNetThermalRadiation = surfaceNetThermalRadiation;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel prcl, int i) {

            prcl.writeString(tempMax);
            prcl.writeString(tempMin);
            prcl.writeString(precip);
            prcl.writeDouble(lat);
            prcl.writeDouble(lon);
        }
    }

