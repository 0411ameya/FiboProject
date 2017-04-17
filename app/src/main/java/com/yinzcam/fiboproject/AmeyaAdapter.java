package com.yinzcam.fiboproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by 0411a on 4/14/2017.
 */

public class AmeyaAdapter extends RecyclerView.Adapter<AmeyaAdapter.MyViewHolder> {

    private  LayoutInflater inflater;
    List<FiboNumber> data = Collections.emptyList();

    public AmeyaAdapter (Context context, List<FiboNumber> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.custom_fibo_row, parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FiboNumber fbNum = data.get(position);
        holder.id.setText(Integer.toString(fbNum.id));
        holder.number.setText(fbNum.number);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView number;

        public MyViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.listID);
            number = (TextView) itemView.findViewById(R.id.listNumber);
        }
    }

}
