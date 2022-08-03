package com.example.parcial_n2_recycleview_cardview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Warframe> data;

    public RecyclerViewAdapter(Context context, List<Warframe> data){
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.activity_warframe_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.warframeList.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade));
        holder.tvWarframeName.setText(data.get(position).getName());
        holder.tvWarframeVersion.setText(data.get(position).getVersion());
        holder.warframePicture.setImageResource(data.get(position).getImage());
        holder.warframeList.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Activity_Warframe.class);
                intent.putExtra("Name", data.get(position).getName());
                intent.putExtra("Image", data.get(position).getImage());
                intent.putExtra("Version", data.get(position).getVersion());
                intent.putExtra("Description", data.get(position).getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvWarframeName, tvWarframeVersion;
        ImageView warframePicture;
        CardView warframeList;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWarframeName = (TextView) itemView.findViewById(R.id.tvWarframeName);
            tvWarframeVersion = (TextView) itemView.findViewById(R.id.tvWarframeVersion);
            warframePicture = (ImageView) itemView.findViewById(R.id.warframePicture);
            warframeList = (CardView) itemView.findViewById(R.id.warframeList);
        }
    }
}
