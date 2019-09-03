package com.example.hygormmnunes.todo_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TarefaActivity extends AppCompatActivity {

   private TextView textViewTituloTarefa;
    private  TextView txtDescricao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);

        textViewTituloTarefa = findViewById(R.id.textViewTituloTarefa);
        txtDescricao = findViewById(R.id.txtDescricao);

        Intent intent = getIntent();
        String titulo = intent.getStringExtra("TITULO");
        String descricao = intent.getStringExtra("DESCRICAO");


        textViewTituloTarefa.setText(titulo);
        txtDescricao.setText(descricao);
    }
}
