package com.example.myapplication.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.entities.Content;
import com.example.myapplication.entities.Product;
import com.example.myapplication.services.ProductAdapter;
import com.example.myapplication.services.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaDeProdutosActivity extends AppCompatActivity {
    private static final String TAG = "ListaDeProdutosActivity";
    private RecyclerView mRecyclerView;
    private ProductAdapter mAdapter;
    private List<Content> listaDeProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_produtos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaDeProdutos = new ArrayList<Content>();
        mRecyclerView = findViewById(R.id.rv_produtos);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ProductAdapter(ListaDeProdutosActivity.this, listaDeProdutos);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ListaDeProdutosActivity.this));
        buscaProdutos();
    }

    void atualizaAdapter(final Product product) {
        mAdapter.setLista(product.getContent());
        mAdapter.notifyDataSetChanged();
    }

    private void buscaProdutos() {
        RetrofitService.getServico().todosProdutos().enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                atualizaAdapter(response.body());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }

}
