package com.example.recycleviewtest;

import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 2016-04-21.
 */
class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewholder> {

    private ArrayList<Dog> dogs = null;

    public MyRecycleViewAdapter(ArrayList<Dog> dogs) {
        this.dogs = dogs;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.recycleview_activity, null);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
        holder.imageView.setImageResource(dogs.get(position).getImageId());
        holder.textView.setText(dogs.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }

    class MyViewholder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public MyViewholder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview_item);
            imageView = (ImageView) itemView.findViewById(R.id.imageview_item);
        }
    }
}

