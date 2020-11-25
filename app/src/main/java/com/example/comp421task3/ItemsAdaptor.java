package com.example.comp421task3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemsAdaptor extends RecyclerView.Adapter<ItemsAdaptor.ViewHolder> {
    private Context c;
    private List<Item> a;

    private onItemClickListener mLis;
    private onItemLongClickListener mlislong;

    public interface onItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(onItemClickListener listener){
        mLis = listener;
    }

    public interface onItemLongClickListener{
        void onItemLongClick(int position);
    }

    public void setOnItemLongClickListener(onItemLongClickListener listener){
        mlislong = listener;
    }

    public ItemsAdaptor(Context c, List<Item> Itemslist){
        this.a=Itemslist;
        this.c = c;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.todoitemcard,parent,false);
        return new ViewHolder(v,mLis,mlislong);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item i = a.get(position);
        holder.todo.setText(i.getTodo());
        holder.dis.setText(i.getDis());
        holder.isCheck.setChecked(i.isCheck);

    }

    @Override
    public int getItemCount() {
        return a.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        TextView todo,dis;
        CheckBox isCheck;
        public ViewHolder(View itemView,onItemClickListener listener,onItemLongClickListener longClickListener){
            super(itemView);
            todo = (TextView) itemView.findViewById(R.id.todo);
            dis = (TextView) itemView.findViewById(R.id.dis);
            isCheck = (CheckBox) itemView.findViewById(R.id.ischeck);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null ){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

           itemView.setOnLongClickListener(new View.OnLongClickListener(){
               @Override
               public boolean onLongClick(View view) {
                   if(longClickListener != null ){
                       int position = getAdapterPosition();
                       if(position != RecyclerView.NO_POSITION){
                           longClickListener.onItemLongClick(position);
                       }
                   }
                   return false;
               }
           });
        }


    }


}
