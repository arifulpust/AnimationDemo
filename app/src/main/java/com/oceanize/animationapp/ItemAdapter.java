package com.oceanize.animationapp;

import android.app.Activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by WIN-HAIVM on 6/29/17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    private List<Item> mList = null;

    private Activity mActivity = null;
    ClickInterface mClick;


    public ItemAdapter(Activity activity, List<Item> list, ClickInterface click) {
        mList = list;
        mClick = click;
        mActivity = activity;

    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        CorrectSizeUtil.getInstance(mActivity).correctSize(v);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        setDataType(holder, position);
    }

    private void setDataType(MyViewHolder holder, final int position) {
        Item currentItem = mList.get(position);

        holder.txt_title.setText(currentItem.Name + "");


        if (mClick != null) {
            holder.rlt_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClick.onItemClick(position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public View rlt_click = null;
        public TextView txt_title = null;
        public TextView txt_date = null;
        public View v_top_line = null;
        public LinearLayout layout = null;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_title = (TextView) itemView.findViewById(R.id.Name);
            rlt_click = itemView.findViewById(R.id.Name);

        }
    }
}
