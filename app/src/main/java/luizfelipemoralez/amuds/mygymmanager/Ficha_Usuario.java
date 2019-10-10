package luizfelipemoralez.amuds.mygymmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ficha_Usuario extends AppCompatActivity{
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
    }

    private void startSpinner() {
        ArrayList<String> genero = new ArrayList<>();
        genero.add("Masculino");
        genero.add("Feminino");
        genero.add("Não Binario");
        genero.add("Indefinido");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,genero);
        id_spinner_genero.setAdapter(adapter);
    }

    private String reciveGenero(){
        genero = (String) id_spinner_genero.getSelectedItem().toString().trim();
        Toast.makeText(this, genero, Toast.LENGTH_LONG).show();
        return genero;
    }

    private boolean verificaTexto(){
        boolean boll = false;
        String aviso = "Este campo não pode ficar em branco";
        if(!id_torax.getText().toString().equalsIgnoreCase("0.0")) {
            if (!id_cintura.getText().toString().equalsIgnoreCase("0.0")) {
                if (!id_coxa.getText().toString().equalsIgnoreCase("0.0")) {
                    if (!id_quadril.getText().toString().equalsIgnoreCase("0.0")) {
                        if (!id_braco.getText().toString().equalsIgnoreCase("0.0")) {
                            if (!id_altura.getText().toString().equalsIgnoreCase("0.0")) {
                                if (!id_peso.getText().toString().equalsIgnoreCase("0.0")) {
                                    boll = true;
                                }else{
                                    id_peso.requestFocus();
                                    Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                id_altura.requestFocus();
                                Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            id_braco.requestFocus();
                            Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        id_quadril.requestFocus();
                        Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    id_coxa.requestFocus();
                    Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
                }
            }else {
                id_cintura.requestFocus();
                Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
            }
        }else {
            id_torax.requestFocus();
            Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();

        }
    return boll;
    }

    private void verficaTudo(){
        if(!reciveGenero().equalsIgnoreCase("")){
            if (verificaTexto()){
                Toast.makeText(this, "Ok Tudo Certo", Toast.LENGTH_LONG).show();
                iniciaTela();
            }else{
                limpaTudo();
            }
        }else{
            startSpinner();
        }
    }

    private void limpaTudo() {
        id_torax.setText("0.10");
        id_cintura.setText("01.0");
        id_coxa.setText("0.10");
        id_quadril.setText("10.0");
        id_braco.setText("0.01");
        id_altura.setText("0.01");
        id_peso.setText("0.10");
        genero = "Masculino";
    }

    public void sendUpdate(View view) {
        verficaTudo();
    }

    public void sendClear(View view) {
        limpaTudo();
    }
    private void iniciaTela(){
        Intent intent = new Intent(getApplicationContext(),InterfaceTreino.class);
        startActivity(intent);
    }
}
