package com.example.taller21_recycleview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {
    String data1[], data2[];
    int images[];
    Context context;
    public myAdapter(Context ct, String s1[], String s2[], int img[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_recycler_fila, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tv3.setText(data1[position]);
        holder.tv4.setText(data1[position]);
        holder.imageView.setImageResource(images[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("images", images[position]);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return images.length;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv3, tv4;
        ImageView imageView;
        ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv3 = itemView.findViewById(R.id.tv3);
            tv4 = itemView.findViewById(R.id.tv4);
            imageView = itemView.findViewById(R.id.imageView2);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

