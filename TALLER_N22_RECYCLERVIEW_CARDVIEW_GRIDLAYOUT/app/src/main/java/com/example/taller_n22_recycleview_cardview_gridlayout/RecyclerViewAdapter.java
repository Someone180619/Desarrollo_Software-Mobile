package com.example.taller_n22_recycleview_cardview_gridlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHoler> {

    private Context context;
    private List<Libro> data;

    public RecyclerViewAdapter(Context context, List<Libro> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.activity_cardview_item, parent, false);
        return new MyViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, @SuppressLint("RecyclerView") int position) {
        holder.tvtitulo.setText(data.get(position).getTitulo());
        holder.imagenlibro.setImageResource(data.get(position).getMiniatura());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, activity_libro.class);
                intent.putExtra("Titulo", data.get(position).getTitulo());
                intent.putExtra("Descripcion", data.get(position).getDescripcion());
                intent.putExtra("Categoria", data.get(position).getCategoria());
                intent.putExtra("Miniatura", data.get(position).getMiniatura());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHoler extends RecyclerView.ViewHolder{

        TextView tvtitulo;
        ImageView imagenlibro;
        CardView cardView;

        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
            tvtitulo = (TextView) itemView.findViewById(R.id.tvtitulo);
            imagenlibro = (ImageView) itemView.findViewById(R.id.imagenlibro);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }


}
