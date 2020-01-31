package com.example.projecttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UnivAdapter extends RecyclerView.Adapter<UnivAdapter.ViewHolder>{
    private Context context;
    private List<UnivModel> univer;

    public UnivAdapter(Context context) {
        this.context = context;
        this.univer = new ArrayList<>();
    }

    public void setUniver(List<UnivModel> univer) {
        this.univer = univer;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.listuniv, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final UnivModel UnivModel = univer.get(i);

        viewHolder.tvNama.setText(UnivModel.getNamaUniv());
        viewHolder.tvAkreditas.setText(UnivModel.getAkre());
        viewHolder.tvStatus.setText(UnivModel.getStatus());
        viewHolder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return univer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvItem;
        private TextView tvNama, tvAkreditas, tvStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.cv_item);
            tvNama = itemView.findViewById(R.id.tv_title);
            tvAkreditas = itemView.findViewById(R.id.tv_akreditas);
            tvStatus = itemView.findViewById(R.id.tv_status);
        }
    }
}
