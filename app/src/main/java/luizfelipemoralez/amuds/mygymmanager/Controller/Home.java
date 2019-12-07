package luizfelipemoralez.amuds.mygymmanager.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import luizfelipemoralez.amuds.mygymmanager.Model.Treino;
import luizfelipemoralez.amuds.mygymmanager.R;
import luizfelipemoralez.amuds.mygymmanager.Utils.RecyclerTouchListener;
import luizfelipemoralez.amuds.mygymmanager.View.HomeAdapter;

public class Home extends AppCompatActivity {
    private RecyclerView id_list;
    private RecyclerView.LayoutManager layoutManager;
    private HomeAdapter homeAdapter;
    private ArrayList<Treino> treino;
    private ActionMode actionMode;
    private static  int POSITION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        id_list = findViewById(R.id.id_home_list);
        id_list.addOnItemTouchListener(new RecyclerTouchListener(this,
                id_list, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public boolean onLongClick(View view, int position) {
                POSITION = position;
                if(actionMode != null){
                    return false;
                }
                actionMode= startSupportActionMode(callback);
            return true;
            }
        }));
        layoutManager = new LinearLayoutManager(getApplicationContext());
        id_list.setLayoutManager(layoutManager);
        id_list.setHasFixedSize(true);
        id_list.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        treino = new ArrayList<Treino>();
        homeAdapter = new HomeAdapter(treino);
        id_list.setAdapter(homeAdapter);

    }
    private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = mode.getMenuInflater();
            menuInflater.inflate(R.menu.menu_edit,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.id_delete:
                    deleteTreino();
                    return true;
                case R.id.id_alterar:
                    alterarTreino();
                    return true;

            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (data != null) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                String tipo = bundle.getString("treino_tipo");
                String nome = bundle.getString("treino_nome");
                String qtd = bundle.getString("treino_qtd");
                String intervalo = bundle.getString("treino_intervalo");

                if(RESULT_OK == resultCode && requestCode == RESULT_FIRST_USER){
                    treino.add(new Treino(nome, qtd, intervalo, tipo));
                    homeAdapter.notifyDataSetChanged();
                }


                if (requestCode == 3){
                    Bundle bundle1 = data.getExtras();
                    String tipo1 = bundle.getString("treino_tipo");
                    String nome1 = bundle1.getString("treino_nome");
                    String qtd1 = bundle1.getString("treino_qtd");
                    String intervalo1 = bundle1.getString("treino_intervalo");
                    treino.remove(POSITION);
                    treino.add(new Treino(nome1, qtd1, intervalo1, tipo1));
                    homeAdapter.notifyDataSetChanged();

                }
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, R.string.erro_cadastrar_treino, Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_adicionar:
                sendRegister(item);
                return true;
            case R.id.id_sobre:
                sendAbout(item);
                return true;
            default:
                return onOptionsItemSelected(item);
        }
    }

    public void sendAbout(MenuItem item) {
        //Intent intent = new Intent(this, App_Autoria.class);
        //startActivity(intent);
        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
    }

    public void sendRegister(MenuItem item) {
        Intent intent = new Intent(this, Cadastro_Treino.class);
        startActivityForResult(intent, RESULT_FIRST_USER);
    }
    private void deleteTreino(){
        if(!treino.isEmpty()){
            treino.remove(POSITION);
        }

        homeAdapter.notifyDataSetChanged();
    }
    private void alterarTreino(){

        if(!treino.isEmpty()){
            Intent intent = new Intent(getApplicationContext(),Cadastro_Treino.class);

            startActivityForResult(intent,3);
        }

    }


    public void sendPreferences(MenuItem item) {
        Intent intent = new Intent(this,Ficha_Usuario.class);
        startActivity(intent);
    }
}
