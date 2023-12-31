package com.example.projet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Adapter pour gérer la liste des informations dans RecyclerView
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<Informations> arrayList;

    // Constructeur de l'adapter
    public RecyclerAdapter(ArrayList<Informations> arrayList){
        this.arrayList = arrayList;

    }

    // Crée les nouvelles vues (appelé par le gestionnaire de mise en page)
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.data_list,null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    // Remplace le contenu d'une vue (appelé par le gestionnaire de mise en page)
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Informations info = arrayList.get(position);

        // Liaison des données avec les vues
        holder.tempMax.setText(info.getTempMax());
        holder.tempMin.setText(info.getTempMin());
        holder.precip.setText(info.getPrecip());
        holder.lat.setText(String.valueOf(info.getLat()));
        holder.lon.setText(String.valueOf(info.getLon()));

    }

    // Retourne la taille de la liste des données
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    // Fournit une référence aux vues pour chaque élément de données
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tempMax;
        TextView tempMin;
        TextView precip;
        TextView lat;
        TextView lon;

        // Constructeur du ViewHolder
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Trouver les vues par leur ID
            tempMax = itemView.findViewById(R.id.textViewSurfSolRadDown);
            tempMin = itemView.findViewById(R.id.textViewSurfSensHeatFlux);
            precip = itemView.findViewById(R.id.textViewSurfLatHeatFlux);
            lat = itemView.findViewById(R.id.textViewSurfNetSolRad);
            lon = itemView.findViewById(R.id.textViewSurfNetThermRad);
        }
    }
}
