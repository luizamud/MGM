package luizfelipemoralez.amuds.mygymmanager.Controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import luizfelipemoralez.amuds.mygymmanager.R;

public class Ficha_Usuario extends AppCompatActivity {
    private static final String USER_INFO = "luizfelipemoralez.amuds.mygymmanager.sharedpreferences.USER_INFO";
    private static final String FIRST_USER = "FIRST_USER";

    private TextView id_label_torax;
    private TextView id_label_genero;
    private TextView id_label_cintura;
    private TextView id_label_quadril;
    private TextView id_label_braco;
    private TextView id_label_coxa;
    private TextView id_label_altura;
    private TextView id_label_peso;
    private TextView id_label_nome;
    private TextView id_label_termo;
    private TextView id_label_lingua_materna;

    private Spinner id_spinner_genero;
    private EditText id_nome;
    private EditText id_torax;
    private EditText id_cintura;
    private EditText id_quadril;
    private EditText id_braco;
    private EditText id_coxa;
    private EditText id_altura;
    private EditText id_peso;
    private String genero;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_usuario);

        SharedPreferences shared = getApplicationContext().getSharedPreferences(USER_INFO,
                Context.MODE_PRIVATE);

        ActionBar actionBar = getSupportActionBar();

            actionBar.setDisplayHomeAsUpEnabled(true);


        id_label_nome = findViewById(R.id.label_nome);
        id_label_genero = findViewById(R.id.label_genero);
        id_label_torax = findViewById(R.id.label_torax);
        id_label_cintura = findViewById(R.id.label_cintura);
        id_label_coxa = findViewById(R.id.label_coxa);
        id_label_quadril = findViewById(R.id.label_quadril);
        id_label_braco = findViewById(R.id.label_braco);
        id_label_altura = findViewById(R.id.label_altura);
        id_label_peso = findViewById(R.id.label_peso);



        id_spinner_genero = findViewById(R.id.id_genero);
        id_nome = findViewById(R.id.id_nome);
        id_torax = findViewById(R.id.id_torax);
        id_cintura = findViewById(R.id.id_cintura);
        id_coxa = findViewById(R.id.id_coxa);
        id_quadril = findViewById(R.id.id_quadril);
        id_braco = findViewById(R.id.id_braco);
        id_altura = findViewById(R.id.id_altura);
        id_peso = findViewById(R.id.id_peso);

        startSpinner();
        if(shared != null){
         Preferences(shared);
        }


    }

    private void startSpinner() {
        ArrayList<String> genero = new ArrayList<>();
        genero.add(getString(R.string.masculino));
        genero.add(getString(R.string.feminino));
        genero.add(getString(R.string.nao_binario));
        genero.add(getString(R.string.indefinido));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, genero);
        id_spinner_genero.setAdapter(adapter);
    }

    private String reciveGenero() {
        genero = id_spinner_genero.getSelectedItem().toString().trim();
        Toast.makeText(this, genero, Toast.LENGTH_LONG).show();
        return genero;
    }

    private void verficaTudo() {
        writer();
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
        startSpinner();
    }

    private void limpaTudo() {
        id_nome.setText("");
        id_torax.setText("0.0");
        id_cintura.setText("0.0");
        id_coxa.setText("0.0");
        id_quadril.setText("0.0");
        id_braco.setText("0.0");
        id_altura.setText("0.0");
        id_peso.setText("0.0");

    }

    private void writer() {
        genero = reciveGenero();
        String nome = id_nome.getText().toString();
        String peso = id_peso.getText().toString();
        String altura = id_altura.getText().toString();
        String torax = id_torax.getText().toString();
        String cintura = id_cintura.getText().toString();
        String coxa = id_coxa.getText().toString();
        String quadril = id_quadril.getText().toString();
        String braco = id_braco.getText().toString();


        SharedPreferences shared = getSharedPreferences(USER_INFO,
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = shared.edit();

        editor.putBoolean(FIRST_USER, true);
        editor.putString("id_nome", nome);
        editor.putString("id_genero", genero);
        editor.putString("id_torax", torax);
        editor.putString("id_cintura", cintura);
        editor.putString("id_coxa", coxa);
        editor.putString("id_quadril", quadril);
        editor.putString("id_braco", braco);
        editor.putString("id_altura", altura);
        editor.putString("id_peso", peso);
        editor.apply();
        Toast.makeText(this, "Preferencia Salva", Toast.LENGTH_LONG).show();

    }
    private void Preferences(SharedPreferences shared){
        String nome = shared.getString("id_nome", "");
        String torax = shared.getString("id_torax", "");
        String cintura = shared.getString("id_cintura", "");
        String coxa = shared.getString("id_coxa", "");
        String quadril = shared.getString("id_quadril", "");
        String braco = shared.getString("id_braco", "");
        String altura = shared.getString("id_altura", "");
        String peso = shared.getString("id_peso", "");




        id_nome.setText(nome);
        id_torax.setText(torax);
        id_cintura.setText(cintura);
        id_coxa.setText(coxa);
        id_quadril.setText(quadril);
        id_braco.setText(braco);
        id_altura.setText(altura);
        id_peso.setText(peso);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_salvar,menu);
       return  true;
    }

    public void sendRegister(MenuItem item) {
        writer();
        verficaTudo();
    }

    public void sendClear(MenuItem item) {
        limpaTudo();
        Toast.makeText(this, "LIMPOU", Toast.LENGTH_SHORT).show();

    }

}
