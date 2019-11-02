package luizfelipemoralez.amuds.mygymmanager.Controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import luizfelipemoralez.amuds.mygymmanager.R;

public class Ficha_Usuario extends AppCompatActivity {
    private static final String USER_INFO ="br.edu.utfpr.alexandrefeitosa.sharedpreferences.USER_INFO";
    private static final String FIRST_USER = "FIRST_USER";
    private Intent intent;
    private Bundle bundle;
    private TextView id_label_torax;
    private TextView id_label_genero;
    private TextView id_label_cintura;
    private TextView id_label_quadril;
    private TextView id_label_braco;
    private TextView id_label_coxa;
    private TextView id_label_altura;
    private TextView id_label_peso;
    private Spinner id_spinner_genero;
    private EditText id_torax;
    private EditText id_cintura;
    private EditText id_quadril;
    private EditText id_braco;
    private EditText id_coxa;
    private EditText id_altura;
    private EditText id_peso;
    private Button id_atualizar;
    private Button id_limpar;
    private String id_nome;
    private String id_sobrenome;
    private String id_senha;
    private boolean id_termo;
    private String id_spinner_result;
    private String genero;
    private Intent intentx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_usuario);

        id_label_genero = findViewById(R.id.id_label_genero);
        id_label_torax = findViewById(R.id.id_label_torax);
        id_label_cintura = findViewById(R.id.id_label_cintura);
        id_label_coxa = findViewById(R.id.id_label_coxa);
        id_label_quadril = findViewById(R.id.id_label_quadril);
        id_label_braco = findViewById(R.id.id_label_braco);
        id_label_altura = findViewById(R.id.id_label_altura);
        id_label_peso = findViewById(R.id.id_label_peso);
        id_atualizar = findViewById(R.id.id_atualizar);
        id_limpar = findViewById(R.id.id_limpar);
        id_spinner_genero = findViewById(R.id.id_spinner_genero);
        id_torax = findViewById(R.id.id_torax);
        id_cintura = findViewById(R.id.id_cintura);
        id_coxa = findViewById(R.id.id_coxa);
        id_quadril = findViewById(R.id.id_quadril);
        id_braco = findViewById(R.id.id_braco);
        id_altura = findViewById(R.id.id_altura);
        id_peso = findViewById(R.id.id_peso);
        startSpinner();
        intentx = getIntent();
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

    private boolean verificaTexto() {
        boolean boll = false;
        String aviso = "Este campo não pode ficar em branco";
        if (!id_torax.getText().toString().equalsIgnoreCase("0.0")) {
            if (!id_cintura.getText().toString().equalsIgnoreCase("0.0")) {
                if (!id_coxa.getText().toString().equalsIgnoreCase("0.0")) {
                    if (!id_quadril.getText().toString().equalsIgnoreCase("0.0")) {
                        if (!id_braco.getText().toString().equalsIgnoreCase("0.0")) {
                            if (!id_altura.getText().toString().equalsIgnoreCase("0.0")) {
                                if (!id_peso.getText().toString().equalsIgnoreCase("0.0")) {
                                    boll = true;
                                } else {
                                    id_peso.requestFocus();
                                    Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                id_altura.requestFocus();
                                Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            id_braco.requestFocus();
                            Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        id_quadril.requestFocus();
                        Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    id_coxa.requestFocus();
                    Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
                }
            } else {
                id_cintura.requestFocus();
                Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
            }
        } else {
            id_torax.requestFocus();
            Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();

        }
        return boll;
    }

    private void verficaTudo() {
        if (!reciveGenero().equalsIgnoreCase("")) {
            if (verificaTexto()) {
               writer();
                Intent intent = new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
            } else {
                limpaTudo();
            }
        } else {
            startSpinner();
        }
    }

    private void limpaTudo() {
        id_torax.setText("0.0");
        id_cintura.setText("0.0");
        id_coxa.setText("0.0");
        id_quadril.setText("0.0");
        id_braco.setText("0.0");
        id_altura.setText("0.0");
        id_peso.setText("0.0");
        genero = "";
    }
    private void writer(){
                Bundle bundle = intentx.getExtras();
            SharedPreferences shared = getSharedPreferences(USER_INFO,
                    Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = shared.edit();
            if (bundle != null){
                editor.putBoolean(FIRST_USER, true);
                editor.putString("id_nome",bundle.getString("id_nome"));
                editor.putString("id_sobrenome",bundle.getString("id_sobrenome"));
                editor.putString("id_senha",bundle.getString("id_senha"));
                editor.putString("id_lingua",bundle.getString("id_lingua"));
                editor.putString("id_termo",bundle.getString("id_termo"));
                editor.putString("id_torax",id_torax.getText().toString());
                editor.putString("id_cintura",id_cintura.getText().toString());
                editor.putString("id_coxa",id_coxa.getText().toString());
                editor.putString("id_quadril",id_quadril.getText().toString());
                editor.putString("id_braco",id_braco.getText().toString());
                editor.putString("id_altura",id_altura.getText().toString());
                editor.putString("id_peso",id_peso.getText().toString());
                editor.apply();
                Toast.makeText(this, "Preferencia Salva", Toast.LENGTH_LONG).show();

            }


    }
    public void sendClear(View view) {
        limpaTudo();
    }

    public void sendUpdate(View view) {
        verficaTudo();
    }
}
