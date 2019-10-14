package luizfelipemoralez.amuds.mygymmanager.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import luizfelipemoralez.amuds.mygymmanager.R;

public class Cadastro_Treino extends AppCompatActivity {
    private TextView label_nome;
    private TextView label_qtd;
    private TextView label_intervalo;
    private EditText id_nome;
    private EditText id_qtd;
    private EditText id_intervalo;
    private Button id_criar_treino;
    private RadioGroup id_list_traning;
    private RadioButton id_A;
    private RadioButton id_B;
    private RadioButton id_C;
    private String responsive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_treino);
        label_nome = findViewById(R.id.label_nome);
        label_qtd = findViewById(R.id.label_qtd);
        label_intervalo = findViewById(R.id.label_intervalo);
        id_nome = findViewById(R.id.id_nome);
        id_qtd = findViewById(R.id.id_qtd);
        id_intervalo = findViewById(R.id.id_intervalo);
        id_criar_treino = findViewById(R.id.id_adicionar);
        id_list_traning = findViewById(R.id.id_list_traning);
        id_A = findViewById(R.id.id_A);
        id_B = findViewById(R.id.id_B);
        id_C = findViewById(R.id.id_C);

    }

    public boolean verificaTipoTreino() {
        boolean bool;
        switch (id_list_traning.getCheckedRadioButtonId()) {
            case R.id.id_A:
                responsive = "A";
                bool = true;
                break;
            case R.id.id_B:
                responsive = "B";
                bool = true;
                break;
            case R.id.id_C:
                responsive = "C";
                bool = true;
                break;
            default:
                bool = false;
                break;
        }
        return bool;
    }

    public void createObejct() {
        boolean bool = verificaTipoTreino();
        if (bool) {
            Intent intent = getIntent();
            intent.putExtra("treino_nome", id_nome.getText().toString());
            intent.putExtra("treino_qtd", id_qtd.getText().toString());
            intent.putExtra("treino_intervalo", id_intervalo.getText().toString());
            intent.putExtra("treino_tipo", responsive);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            verificaTipoTreino();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = getIntent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
        return true;
    }

    public void limpaTela() {
        id_nome.setText("");
        id_qtd.setText("");
        id_intervalo.setText("");
        id_list_traning.clearCheck();
        Toast.makeText(this, R.string.limpar_tela, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_adicionar:
                sendTraining(item);
                return true;
            case R.id.id_clean:
                sendClear(item);
                return true;
            default:
                return onOptionsItemSelected(item);
        }
    }

    public void sendTraining(MenuItem item) {
        createObejct();
    }

    public void sendClear(MenuItem item) {
        limpaTela();
    }
}
