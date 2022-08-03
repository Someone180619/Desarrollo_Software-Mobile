package com.example.semestral;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semestral.Fotos;
import com.example.semestral.FotoActivity;
import com.example.semestral.R;

import java.util.ArrayList;

/*
 * Obtiene los datos de la BD para mostrar todas las instancias almacenadas
 *  en la lista de activity_galeria.xml
 * */
public class ListaFotosAdapter extends RecyclerView.Adapter<ListaFotosAdapter.FotoViewHolder> {

    ArrayList<Fotos> listaFotos;
    Context context;

    // Constructor que btiene un arreglo de tipo objeto Fotos, y el contexto desde GaleriaActivity.class
    public ListaFotosAdapter (Context ct, ArrayList<Fotos> listaFotos) {
        this.listaFotos = listaFotos;
        context = ct;
    }

    @NonNull
    @Override
    public ListaFotosAdapter.FotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_foto, null, false);
        return new FotoViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listaFotos.size();
    }

    //Reconoce todos los elementos de lista_item_foto.xml
    public class FotoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewFoto;
        TextView idFoto, tituloFoto, fechaFoto;
        ConstraintLayout itemFoto;

        public FotoViewHolder(@NonNull View itemView) {
            super(itemView);

            idFoto = itemView.findViewById(R.id.idFoto);
            imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
            tituloFoto = itemView.findViewById(R.id.tituloFoto);
            fechaFoto = itemView.findViewById(R.id.fechaFoto);
            itemFoto = itemView.findViewById(R.id.itemFoto);
        }
    }

    //Obtiene todas las instancias de la BD y coloca los datos en los elementos correspondientes del item de la lista
    @Override
    //El error no da problemas
    public void onBindViewHolder(@NonNull ListaFotosAdapter.FotoViewHolder holder, int position) {
        Bitmap fotoBitmap = BitmapFactory.decodeFile(listaFotos. get(position).getRutaImagen());
        String id = String.valueOf(listaFotos.get(position).getID());

        holder.idFoto.setText(id);
        holder.imageViewFoto.setImageBitmap(fotoBitmap);
        holder.tituloFoto.setText(listaFotos. get(position).getTituloImagen());
        holder.fechaFoto.setText(listaFotos. get(position).getFechaCreacion());

        //Cuando se toca alguno de los elementos de la lista, se obtienen los datos especificos de ese item y se le envia a FotoActivity.class
        holder.itemFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FotoActivity.class);

                intent.putExtra("ID", id);
                intent.putExtra("Foto", listaFotos. get(position).getRutaImagen());
                intent.putExtra("Titulo", listaFotos.get(position).getTituloImagen());
                intent.putExtra("Fecha", listaFotos.get(position).getFechaCreacion());

                context.startActivity(intent);
            }
        });

    }
}

