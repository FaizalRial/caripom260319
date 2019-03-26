package com.izol.caripom.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.izol.caripom.List_Activity;
import com.izol.caripom.R;
import com.izol.caripom.model.Requests;

import java.util.List;

public class RequestAdapterRecyclerView extends RecyclerView.Adapter<RequestAdapterRecyclerView.MyViewHolder> {

    private List<Requests> moviesList;
    private Activity mActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout rl_layout;
        public TextView tv_nama, tv_jenis;

        public MyViewHolder(View view) {
            super(view);
            rl_layout = view.findViewById(R.id.rl_layout);
            tv_nama = view.findViewById(R.id.tv_nama);
            tv_jenis = view.findViewById(R.id.tv_jenis);
        }
    }

    public RequestAdapterRecyclerView(List<Requests> moviesList, List_Activity list_activity) {this.moviesList = moviesList;}
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_request, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Requests movie = moviesList.get(position);

        holder.tv_nama.setText(movie.getNama());
        holder.tv_jenis.setText(movie.getJenis());

        holder.rl_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent goDetail = new Intent(mActivity, List_Activity.class);
                goDetail.putExtra("id", movie.getKey());
                goDetail.putExtra("Nama", movie.getNama());
                goDetail.putExtra("Jenis", movie.getJenis());
                goDetail.putExtra("Jam Operasional", movie.getJam());
                goDetail.putExtra("Pertamax", movie.getPertamax());
                goDetail.putExtra("Pertalite", movie.getpertalite());
                goDetail.putExtra("Premium", movie.getpremium());
                goDetail.putExtra("Solar", movie.getSolar());
                goDetail.putExtra("Dexlite", movie.getDexlite());
                goDetail.putExtra("Pertamax Turbo", movie.getPertamaxturbo());

                mActivity.startActivity(goDetail);


            }
        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


}
