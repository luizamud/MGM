package luizfelipemoralez.amuds.mygymmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Treino extends AppCompatActivity {
    private ListView id_lista_treino;
    private String posicao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino);
        id_lista_treino = findViewById(R.id.id_list_treino);
        Toast.makeText(this, posicao, Toast.LENGTH_LONG).show();
        geraTreino();
    }
    public void geraTreino(){
        ArrayList <String> treino = new ArrayList<>();
        treino.add("Peito");
        treino.add("Costas");
        treino.add("Biceps");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,treino);
        id_lista_treino.setAdapter(adapter);
    }
    public void recuperaTreino(){
        id_lista_treino.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                posicao = (String) parent.getItemAtPosition(position).toString();
            }
        });
    }
}
