package luizfelipemoralez.amuds.mygymmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelecionaTreino extends AppCompatActivity {
    private ListView id_lista_treino;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_treino);
        id_lista_treino = findViewById(R.id.id_list_treino);
        reciveLista();
        geraLista();
    }
    private void reciveLista(){
        id_lista_treino.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = (String) id_lista_treino.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), nome, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),Tipo_A.class);
                startActivity(intent);
            }
        });
    }
    private void geraLista(){
        ArrayList <String> treino = new ArrayList<>();
        treino.add("SelecionaTreino-A");
        treino.add("SelecionaTreino-B");
        treino.add("SelecionaTreino-C");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,treino);
        id_lista_treino.setAdapter(adapter);
    }
}
