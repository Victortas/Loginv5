package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
{
    private List<ListElement> mData;
    private LayoutInflater mInflanter;
    private Context context;

    final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ListElement element);
    }

    public ListAdapter(List<ListElement> itemList, Context context, OnItemClickListener listener)
    {
        this.mInflanter = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener = listener;
    }

    public int getItemCount()
    {
        return mData.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewTipe)
    {
        View view = mInflanter.inflate(R.layout.list_element,null);
        return new ViewHolder(view);
    }

    public void onBindViewHolder (final ViewHolder holder, final int posicion)
    {
        holder.binData(mData.get(posicion));
    }

    public void setItems(List<ListElement> items)
    {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView nombre, animal,estado, fecha, codigoPostal;

        ViewHolder(View itemView)
        {
            super(itemView);
            nombre = itemView.findViewById(R.id.name);
            animal = itemView.findViewById(R.id.animal);
            estado = itemView.findViewById(R.id.estado);
            fecha = itemView.findViewById(R.id.fecha);
            codigoPostal = itemView.findViewById(R.id.cp);
        }
        void binData(final ListElement item)
        {
            nombre.setText(item.getNombre());
            animal.setText(item.getAnimal());
            estado.setText(item.getEstado());
            fecha.setText(item.getFecha());
            codigoPostal.setText(item.getCodigoPostal());
            itemView.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            }));
        }
    }

}
