package com.hashan.springb.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hashan.springb.model.Coffee;
import com.hashan.springb.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Coffee> mDaList;
    RequestOptions options;


    public RecyclerViewAdapter(Context mContext, List<Coffee> mDaList) {
        this.mContext = mContext;
        this.mDaList = mDaList;

        options =new RequestOptions().centerCrop().placeholder(R.drawable.ic_dload).error(R.drawable.ic_dload);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.coffee_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = mDaList.get(viewHolder.getAdapterPosition()).getId();
                int o = mDaList.get(viewHolder.getAdapterPosition()).getOrder();
                String name = mDaList.get(viewHolder.getAdapterPosition()).getName();
                int pr = mDaList.get(viewHolder.getAdapterPosition()).getPrice();

                Toast.makeText(mContext, i+"\n"+o+"\n"+name+"\n"+pr , Toast.LENGTH_SHORT).show();


                UpdateOrder(i,o);

            }
        });

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.c_name.setText(mDaList.get(position).getName());
        holder.c_desc.setText(mDaList.get(position).getDesc());
        int price = mDaList.get(position).getPrice();
        holder.c_prize.setText("Rs. "+String.valueOf(price));

        Glide.with(mContext).load(mDaList.get(position).getImg()).apply(options).into(holder.img_thumbnail);



    }

    @Override
    public int getItemCount() {
        return mDaList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView c_name ;
        TextView c_desc;
        TextView c_prize;
        ImageView img_thumbnail;
        LinearLayout view_container;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);

            c_name = itemView.findViewById(R.id.name);
            c_desc= itemView.findViewById(R.id.desc);
            c_prize = itemView.findViewById(R.id.price);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);


        }
    }


    private void UpdateOrder(int i, int o) {
        String JSON_URL = "http://192.168.8.100:8088/api/"+i;
        int updated = ++o;
        Toast.makeText(mContext, ""+JSON_URL+"\n"+updated, Toast.LENGTH_SHORT).show();
        Toast.makeText(mContext, "Updated", Toast.LENGTH_SHORT).show();

        
    }






}
