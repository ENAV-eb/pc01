package com.na.s03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.na.s03.entidades.Marcador;

import java.util.ArrayList;

public class MarcadorListaAdapter extends RecyclerView.Adapter<MarcadorListaAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Marcador> lista = new ArrayList<>();

    public MarcadorListaAdapter(Context context, ArrayList<Marcador> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public MarcadorListaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fila,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarcadorListaAdapter.MyViewHolder holder, int position) {

        holder.nombre_txt.setText(String.valueOf(lista.get(position).getNombre()));
        holder.marca_txt.setText(String.valueOf(lista.get(position).getMarca()));
        holder.modelo_txt.setText(String.valueOf(lista.get(position).getModelo()));
        holder.color_txt.setText(String.valueOf(lista.get(position).getColor()));
        holder.longitud_txt.setText(String.valueOf(lista.get(position).getLongitud()));

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView nombre_txt,marca_txt,modelo_txt,color_txt,longitud_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre_txt = itemView.findViewById(R.id.nombre);
            marca_txt = itemView.findViewById(R.id.marca);
            modelo_txt = itemView.findViewById(R.id.modelo);
            color_txt = itemView.findViewById(R.id.color);
            longitud_txt = itemView.findViewById(R.id.longitud);
        }
    }
}
