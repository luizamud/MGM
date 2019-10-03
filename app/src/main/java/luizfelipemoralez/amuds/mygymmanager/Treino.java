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

public class Treino extends AppCompatActivity {
    private ListView id_lista_treino;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino);
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
                switch (nome){
                    case "Treino-A":
                        Intent intent = new Intent(getApplicationContext(),TreinoA.class);
                        startActivity(intent);
                        break;
                    case "Treino-B":
                        Intent intent1 = new Intent(getApplicationContext(),TreinoB.class);
                        startActivity(intent1);
                        break;
                    case "Treino-C":
                        Intent intent2 = new Intent(getApplicationContext(),TreinoC.class);
                        startActivity(intent2);
                        break;
                }
            }
        });
    }
    private void geraLista(){
        ArrayList <String> treino = new ArrayList<>();
        treino.add("Treino-A");
        treino.add("Treino-B");
        treino.add("Treino-C");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,treino);
        id_lista_treino.setAdapter(adapter);
    }

}
