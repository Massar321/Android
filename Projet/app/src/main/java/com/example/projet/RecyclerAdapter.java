package com.example.projet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<Informations> arrayList;

    public RecyclerAdapter(ArrayList<Informations> arrayList){
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.data_list,null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Informations info = arrayList.get(position);

        holder.tempMax.setText(info.getTempMax());
        holder.tempMin.setText(info.getTempMin());
        holder.precip.setText(info.getPrecip());
        holder.lat.setText(String.valueOf(info.getLat()));
        holder.lon.setText(String.valueOf(info.getLon()));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tempMax;
        TextView tempMin;
        TextView precip;
        TextView lat;
        TextView lon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            tempMax = itemView.findViewById(R.id.textViewSurfSolRadDown);
            tempMin = itemView.findViewById(R.id.textViewSurfSensHeatFlux);
            precip = itemView.findViewById(R.id.textViewSurfLatHeatFlux);
            lat = itemView.findViewById(R.id.textViewSurfNetSolRad);
            lon = itemView.findViewById(R.id.textViewSurfNetThermRad);
        }
    }
}
