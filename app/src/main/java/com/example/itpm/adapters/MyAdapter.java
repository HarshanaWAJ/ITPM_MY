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
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        RateModel rate = list.get(position);
        holder.staffId.setText(rate.getStaffId());
        holder.serviceScore.setText(rate.getServiceScore());
        holder.onTimeScore.setText(rate.getOnTimeScore());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView staffId, onTimeScore, serviceScore;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            staffId = itemView.findViewById(R.id.staffIdEt);
            onTimeScore = itemView.findViewById(R.id.onTimeScoreEt);
            serviceScore = itemView.findViewById(R.id.serviceScoreEt);
        }
    }
}
