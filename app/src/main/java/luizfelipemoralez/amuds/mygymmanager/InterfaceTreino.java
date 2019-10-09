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

public class InterfaceTreino extends AppCompatActivity {
    private ListView id_lista_treino;
    private String treino_a = "Treino-A";
    private String treino_b = "Treino-B";
    private String treino_c = "Treino-C";

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
                switch (nome){
                    case "Treino A":
                            Intent intent1 = new Intent(getApplicationContext(),Treino_A.class);
                            startActivity(intent1);
                        break;
                    case "Treino B":
                        Intent intent2 = new Intent(getApplicationContext(),Treino_B.class);
                        startActivity(intent2);
                        break;
                    case "Treino C":
                        Intent intent3 = new Intent(getApplicationContext(),Treino_C.class);
                        startActivity(intent3);
                        break;

                    default:
                        Toast.makeText(InterfaceTreino.this, "Por favor escolha um tipo de treino", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }
    private void geraLista(){
        ArrayList <String> treino = new ArrayList<>();
        treino.add(treino_a);
        treino.add(treino_b);
        treino.add(treino_c);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,treino);
        id_lista_treino.setAdapter(adapter);
    }
}
