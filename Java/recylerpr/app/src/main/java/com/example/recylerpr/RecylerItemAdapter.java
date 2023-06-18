package com.example.recylerpr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class RecylerItemAdapter extends RecyclerView.Adapter<RecylerItemAdapter.viewholder> {
    Context context;
    ArrayList<items_container> arrayitems;

    //create constructor recyler adapter
    public RecylerItemAdapter(Context context, ArrayList<items_container> arrayitems) {
        this.context = context;
        this.arrayitems = arrayitems;
    }

    public RecylerItemAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.design_layout, parent, false);
        viewholder view_holder = new viewholder(item);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerItemAdapter.viewholder holder, int position) {
        holder.photo.setImageURI(arrayitems.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return arrayitems.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        RoundedImageView photo;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            //set txtUrl to the textview having id of
            photo = itemView.findViewById(R.id.imageViewDesign);
        }
    }
}
