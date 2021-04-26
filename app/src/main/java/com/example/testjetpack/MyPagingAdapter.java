package com.example.testjetpack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class MyPagingAdapter extends PagedListAdapter<Road,MyPagingAdapter.VH> {
    protected MyPagingAdapter() {
        super(diffCallBack);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,null,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Road road=getItem(position);
        holder.roadCode.setText(road.getRoadCode());
        holder.roadName.setText(road.getRoadName());
    }

    static class VH extends RecyclerView.ViewHolder{
        TextView roadName;
        TextView roadCode;
        public VH(@NonNull View itemView) {
            super(itemView);
            roadName=itemView.findViewById(R.id.roadName);
            roadCode=itemView.findViewById(R.id.roadCode);
        }
    }
    private static DiffUtil.ItemCallback<Road> diffCallBack=new DiffUtil.ItemCallback<Road>() {
        @Override
        public boolean areItemsTheSame(@NonNull Road oldItem, @NonNull Road newItem) {
            return oldItem.getRoadCode().equals(newItem.getRoadCode());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Road oldItem, @NonNull Road newItem) {
            return oldItem.equals(newItem);
        }
    };
}
