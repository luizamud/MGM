package luizfelipemoralez.amuds.mygymmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Tipo_A extends AppCompatActivity {

    private RecyclerView id_recycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_a);
        id_recycle = findViewById(R.id.id_recycle_A);
        id_recycle.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        id_recycle.setLayoutManager(linearLayoutManager);
        Treino treino = new Treino("Flexão","12x","1 min");
        List<Treino> dados = (List<Treino>) treino;
        TreinoAdapter treinoAdapter = new TreinoAdapter(dados);
        id_recycle.setAdapter(treinoAdapter);


    }
}
