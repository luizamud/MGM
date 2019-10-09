package luizfelipemoralez.amuds.mygymmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Treino_A extends AppCompatActivity {

    private RecyclerView list_treino;
    private RecyclerView.LayoutManager layoutManager;
    private TreinoAdapter treinoAdapter;
    private ArrayList<Treino> treino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino_a);

        list_treino = findViewById(R.id.id_list_treino_a);
        layoutManager = new LinearLayoutManager(this);
        list_treino.setHasFixedSize(true);
        list_treino.addItemDecoration(new DividerItemDecoration(this,LinearLayout.VERTICAL));
        geraLista();


    }
    public void geraLista(){
        String[] treinos = getResources().getStringArray(R.array.treino_a);
        String[] repeticao =getResources().getStringArray(R.array.repeticao_a);
        String[] intervalo =getResources().getStringArray(R.array.intervalo_universal);

        treino = new ArrayList<>();
        for (int count = 0;count < treinos.length;count++){
            treino.add(new Treino(treinos[count],repeticao[count],intervalo[count]));
        }
        treinoAdapter = new TreinoAdapter(treino);
        list_treino.setAdapter(treinoAdapter);
    }
}
