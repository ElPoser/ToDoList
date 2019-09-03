package com.example.hygormmnunes.todo_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hygormmnunes.todo_list.adapter.TarefaAdapter;
import com.example.hygormmnunes.todo_list.modelos.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Tarefa> tarefas = new ArrayList<>();
    private ArrayAdapter<Tarefa> arrayAdapterTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.ListViewTarefas);

        criarTarefas();
        arrayAdapterTarefa = new TarefaAdapter(MainActivity.this,(ArrayList<Tarefa>) tarefas);
        listView.setAdapter(arrayAdapterTarefa);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,TarefaActivity.class);
                intent.putExtra("TITULO",tarefas.get(position).getNome());
                intent.putExtra("DESCRICAO",tarefas.get(position).getDescricao());
                startActivity(intent);


                /*   Toast toast =  Toast.makeText(getApplicationContext(),
                        tarefas.get(position).getNome(),
                        Toast.LENGTH_LONG);
                toast.show();*/

            }
        });

    }

    public void criarTarefas(){
        tarefas.add(new Tarefa("1","Estudar Android",false,"Estudar"));
        tarefas.add(new Tarefa("2", "Estudar Teste",false,"Estudar"));
        tarefas.add(new Tarefa("3","Jogar Coup",true,"Jogar"));
        tarefas.add(new Tarefa("1","Batata",false,"Comer"));
        tarefas.add(new Tarefa("2", "Teste shazam",false,"Shazionar"));
        tarefas.add(new Tarefa("3","Jogar GTA",true,"Jogar"));

    }

}
