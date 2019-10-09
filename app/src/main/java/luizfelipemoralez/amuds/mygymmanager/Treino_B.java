package luizfelipemoralez.amuds.mygymmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import luizfelipemoralez.amuds.mygymmanager.utils.RecyclerItemClickListener;

public class Treino_B extends AppCompatActivity {

    private RecyclerView list_treino;
    private RecyclerView.LayoutManager layoutManager;
    private TreinoAdapter treinoAdapter;
    private ArrayList<Treino> treino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino_b);

        list_treino = findViewById(R.id.id_list_treino_b);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        list_treino.setLayoutManager(layoutManager);
        list_treino.setHasFixedSize(true);
        list_treino.addItemDecoration(new DividerItemDecoration(this,LinearLayout.VERTICAL));
        geraLista();
        reciveLista();
    }
    public void geraLista(){
        String[] temp_treinos = getResources().getStringArray(R.array.treino_b);
        String[] temp_repeticao =getResources().getStringArray(R.array.repeticao_b);
        String[] intervalo =getResources().getStringArray(R.array.intervalo_universal);

        treino = new ArrayList<>();
        for (int count = 0;count < temp_treinos.length;count++){
            treino.add(new Treino(temp_treinos[count],temp_repeticao[count],intervalo[count]));
        }
        treinoAdapter = new TreinoAdapter(treino);
        list_treino.setAdapter(treinoAdapter);
    }
    private void reciveLista(){
        list_treino.addOnItemTouchListener(

                new RecyclerItemClickListener(getApplicationContext(),
                        list_treino,
                        new RecyclerItemClickListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {

                                Treino temp_treino = treino.get(position);
                                Toast.makeText(Treino_B.this, "O treino selecionado foi: "+temp_treino.getNomeTreino(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                Treino temp_treino = treino.get(position);
                                Toast.makeText(Treino_B.this, "Um toque longo foi reconhecido em cima do treino: "+temp_treino.getNomeTreino(), Toast.LENGTH_SHORT).show();
                            }
                        }
                ));
    }
}
