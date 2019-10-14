package luizfelipemoralez.amuds.mygymmanager.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import luizfelipemoralez.amuds.mygymmanager.Model.Treino;
import luizfelipemoralez.amuds.mygymmanager.R;
import luizfelipemoralez.amuds.mygymmanager.View.HomeAdapter;

public class Home extends AppCompatActivity {
    private RecyclerView id_list;
    private RecyclerView.LayoutManager layoutManager;
    private HomeAdapter homeAdapter;
    private ArrayList<Treino> treino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        id_list = findViewById(R.id.id_home_list);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        id_list.setLayoutManager(layoutManager);
        id_list.setHasFixedSize(true);
        id_list.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        treino = new ArrayList<Treino>();
        homeAdapter = new HomeAdapter(treino);
        id_list.setAdapter(homeAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                String tipo = bundle.getString("treino_tipo");
                String nome = bundle.getString("treino_nome");
                String qtd = bundle.getString("treino_qtd");
                String intervalo = bundle.getString("treino_intervalo");
                Toast.makeText(this, "Cheguei Aqui", Toast.LENGTH_SHORT).show();
                treino.add(new Treino(nome, qtd, intervalo, tipo));
                homeAdapter.notifyDataSetChanged();
                homeAdapter = new HomeAdapter(treino);
                id_list.setAdapter(homeAdapter);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, R.string.erro_cadastrar_treino, Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void sendRegister(View view) {
        Intent intent = new Intent(this, Cadastro_Treino.class);
        startActivityForResult(intent, RESULT_FIRST_USER);

    }

    public void sendAbout(View view) {
        Intent intent = new Intent(getApplicationContext(), App_Autoria.class);
        startActivity(intent);
    }

}
