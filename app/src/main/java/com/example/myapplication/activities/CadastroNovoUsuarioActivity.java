package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.entities.User;
import com.example.myapplication.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroNovoUsuarioActivity extends AppCompatActivity {
    private static final String TAG = "CadastroNovoUsuarioActi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_novo_usuario);
    }

    public void salvar(View view) {
        String nome = ((TextView)findViewById(R.id.et_nome)).getText().toString();
        String fone = ((TextView)findViewById(R.id.et_fone)).getText().toString();
        String mail = ((TextView)findViewById(R.id.et_mail)).getText().toString();
        String senha = ((TextView)findViewById(R.id.et_senha)).getText().toString();
        User user = new User(mail,nome,senha,fone);
        RetrofitService.getServico().cadastrarNovoUsuario(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "onResponse: "+response.body().getId());
                Toast.makeText(CadastroNovoUsuarioActivity.this, "Usuário criado com sucesso. Você será redirecionado para tela de login", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
