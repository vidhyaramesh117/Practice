package com.example.toolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Viewholder>
{
    private final Context context;
    private ArrayList<recycler_model>recyclerModelArrayList = null;

    public RecyclerAdapter(Context context, ArrayList<recycler_model> recyclerModelArrayList)
    {
        this.context = context;
        this.recyclerModelArrayList = recyclerModelArrayList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.Viewholder holder, int position)
    {
        recycler_model model = recyclerModelArrayList.get(position);
        holder.image.setImageResource(model.getGrp_image());
        holder.name.setText(model.getGrp_name());
        holder.content.setText(model.getGrp_cont());

    }

    @Override
    public int getItemCount()
    {
        return recyclerModelArrayList.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView name;
        private final TextView content;

        public Viewholder(@NonNull View itemView)
        {
            super(itemView);
            image = itemView.findViewById(R.id.recycler_img);
            name = itemView.findViewById(R.id.recycler_name);
            content = itemView.findViewById(R.id.recycler_cont);
        }
    }
}




