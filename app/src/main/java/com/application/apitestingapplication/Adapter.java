package com.application.apitestingapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {

    List<ApiModels> listArray;
    Context context;

    public Adapter(List<ApiModels> listArray, Context context) {
        this.listArray = listArray;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v=layoutInflater.inflate(R.layout.design, parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.CustomViewHolder holder, int position) {
        holder.titles.setText(listArray.get(position).getTitle());
        holder.body.setText(listArray.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return listArray.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView titles, body;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            titles=itemView.findViewById(R.id.titles);
            body=itemView.findViewById(R.id.body);
        }
    }
}
