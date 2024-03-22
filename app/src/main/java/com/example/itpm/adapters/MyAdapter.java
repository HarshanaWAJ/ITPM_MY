package com.example.itpm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itpm.R;
import com.example.itpm.models.RateModel;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<RateModel> list;

    public MyAdapter(Context context, ArrayList<RateModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rateentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RateModel rate =  list.get(position);
        holder.id.setText(rate.getStaffId());
        holder.onTime.setText(rate.getOnTimeScore());
        holder.service.setText(rate.getServiceScore());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id, onTime, service;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.textStaffId);
            onTime = itemView.findViewById(R.id.textOntime);
            service = itemView.findViewById(R.id.textOntime);
        }
    }
}
