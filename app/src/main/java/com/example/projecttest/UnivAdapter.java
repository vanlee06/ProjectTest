package com.example.projecttest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UnivAdapter extends RecyclerView.Adapter<UnivAdapter.ViewHolder>{
    public static final String TAG_ID="id" ;
    private Database db;
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

        final Integer[] kampus = {R.drawable.itb, R.drawable.ugm, R.drawable.ipb, R.drawable.its, R.drawable.ui, R.drawable.undip, R.drawable.unair, R.drawable.unhas, R.drawable.ub, R.drawable.unpad,};
        final UnivModel UnivModel = univer.get(i);

        String a = "Akrei ";
        String b = "Status ";
        viewHolder.tvNama.setText(UnivModel.getNama());
        viewHolder.tvAkre.setText(a+UnivModel.getAkre());
        viewHolder.tvStatus.setText(b+UnivModel.getStatus());

        final int idd = i;
        final int idx = UnivModel.getId();
        viewHolder.ivlogo.setImageResource(kampus[idx-1]);

        viewHolder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final UnivModel UnivModel = univer.get(idd);

                Intent intent = new Intent(context, detailkampus.class);
                intent.putExtra("id",UnivModel.getId());
                intent.putExtra("nama", UnivModel.getNama() );
                intent.putExtra("akreditas", UnivModel.getAkre() );
                intent.putExtra("status", UnivModel.getStatus() );
                intent.putExtra("jenis", UnivModel.getJenis() );
                intent.putExtra("alamat", UnivModel.getAlamat() );
                intent.putExtra("kota", UnivModel.getKota() );
                intent.putExtra("provinsi", UnivModel.getProvinsi() );
                intent.putExtra("website", UnivModel.getWebsite() );
                intent.putExtra("singkat", UnivModel.getSingkat() );
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return univer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvItem;
        private TextView tvNama, tvAkre, tvStatus;
        ImageView ivlogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvItem = itemView.findViewById(R.id.cv_item);
            tvNama = itemView.findViewById(R.id.tv_title);
            tvAkre = itemView.findViewById(R.id.tv_akreditas);
            tvStatus = itemView.findViewById(R.id.tv_status);
            ivlogo = itemView.findViewById(R.id.logo);


        }
    }
}
