package com.feicuiedu.recyclerviewdemo_0310;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gqq on 2017/3/13.
 */

public class StaggerAdapter extends RecyclerView.Adapter<StaggerAdapter.ViewHolder>{

    // 数据
    private List<String> mData = new ArrayList<>();

    // 高的随机数据
    private List<Integer> mHeights = new ArrayList<>();

    // 设置数据
    public void setData(List<String> data,List<Integer> heights){
        mHeights.clear();
        mHeights.addAll(heights);
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // item的宽高需要随机
        ViewGroup.LayoutParams layoutParams = holder.mTvItem.getLayoutParams();
        layoutParams.height = mHeights.get(position);
        holder.mTvItem.setLayoutParams(layoutParams);

        holder.mTvItem.setText(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_text)
        TextView mTvItem;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
