package com.mrkumar.sqlitedbstoreapp.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mrkumar.sqlitedbstoreapp.R;
import com.mrkumar.sqlitedbstoreapp.model.ResponseApiItem;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    List<ResponseApiItem>heroesDataList;
    Context context;

    public HeroesAdapter(List<ResponseApiItem> heroesDataList, Context context) {
        this.heroesDataList = heroesDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public HeroesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.ViewHolder holder, int position) {
        ResponseApiItem data=heroesDataList.get(position);

        Glide.with(context)
                .load(data.getImageurl())
                .into(holder.img);

        holder.txtBio.setText(data.getBio());
        holder.txtName.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return heroesDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtBio;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.heroesName);
            txtBio=itemView.findViewById(R.id.txtBio);
            img=itemView.findViewById(R.id.imgView);
        }
    }
}
