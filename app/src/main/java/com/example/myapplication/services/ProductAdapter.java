package com.example.myapplication.services;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.entities.Content;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;

    //dados
    List<Content> lista;

    //inflador de layout - cria uma view para uma linha da lista recycler
    private LayoutInflater mInflater;

    private static final String TAG = "ProductAdapter";

    public ProductAdapter(Context context, List<Content> lista) {
        this.context = context;
        this.lista = lista;
        this.mInflater = LayoutInflater.from(context);
    }

    public List<Content> getLista() {
        return lista;
    }

    public void setLista(List<Content> lista) {
        this.lista = lista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View linha = mInflater.inflate(R.layout.item_lista_produto_recycler, parent, false);
        return new ProductViewHolder(linha, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+position);
        Content produto = lista.get(position);
        Glide.with(context)
                .load(produto.getImgUrl())
                .into(holder.imagemView);
        holder.precoView.setText(String.valueOf(produto.getPrice()));
        holder.descricaoView.setText(produto.getDescription());
        holder.nomeView.setText(produto.getName());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public final TextView nomeView, descricaoView, precoView;
        public final ImageView imagemView;
        public final ProductAdapter mAdapter;

        public ProductViewHolder(@NonNull View itemView, ProductAdapter adapter) {
            super(itemView);
            nomeView = itemView.findViewById(R.id.tv_nome);
            descricaoView = itemView.findViewById(R.id.tv_nome);
            precoView = itemView.findViewById(R.id.tv_nome);
            imagemView = itemView.findViewById(R.id.iv_url);
            this.mAdapter = adapter;
        }
    }
}
