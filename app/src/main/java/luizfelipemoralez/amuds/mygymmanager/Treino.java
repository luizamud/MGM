package luizfelipemoralez.amuds.mygymmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Treino extends AppCompatActivity {
    private ListView id_lista_treino;
    public String id_aux;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino);
        id_lista_treino = findViewById(R.id.id_list_treino_c);
        geraTreino();


    }
    public String geraTreino(){

        ArrayList <String> treino = new ArrayList<>();
        treino.add("Treino - A");
        treino.add("Treino - B");
        treino.add("Treino - C");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,treino);
        id_lista_treino.setAdapter(adapter);
        id_lista_treino.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              id_aux= id_lista_treino.getItemAtPosition(position).toString();
            }
        });
        return id_aux;
    }
    public void validaTreino(){
        String id_aux = geraTreino();
        if(id_aux.equalsIgnoreCase("Treino - A")){
            Intent intent = new Intent(this,TreinoA.class);
        }else if (id_aux.equalsIgnoreCase("Treino - B")) {

        }else if(id_aux.equalsIgnoreCase("Treino - C")) {

        }
    }




}
