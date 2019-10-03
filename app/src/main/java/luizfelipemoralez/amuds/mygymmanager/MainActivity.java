package luizfelipemoralez.amuds.mygymmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView id_label_nome;
    private TextView id_label_sobrenome;
    private TextView id_label_senha;
    private TextView id_label_termos;
    private TextView id_label_lingua;
    private EditText id_nome;
    private EditText id_sobrenome;
    private EditText id_senha;
    private CheckBox id_termos;
    private RadioGroup id_manager_lingua;
    private RadioButton id_portugues;
    private RadioButton id_ingles;
    private RadioButton id_espanhol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id_nome = findViewById(R.id.id_nome);
        id_sobrenome = findViewById(R.id.id_sobrenome);
        id_senha= findViewById(R.id. id_senha);
        id_termos= findViewById(R.id. id_termos);
        id_manager_lingua= findViewById(R.id. id_manager_lingua);
        id_portugues= findViewById(R.id. id_portugues);
        id_ingles= findViewById(R.id. id_ingles);
        id_espanhol= findViewById(R.id. id_espanhol);
        id_label_nome= findViewById(R.id. id_label_nome);
        id_label_sobrenome =findViewById(R.id. id_label_sobrenome);
        id_label_senha= findViewById(R.id. id_label_senha);
        id_label_termos= findViewById(R.id. id_label_termos);
        id_label_lingua= findViewById(R.id. id_label_lingua);

    }

    public void sendClear(View view) {
              limpaTela();
    }

    public void limpaTela()    {
        id_nome.setText("");
        id_sobrenome.setText("");
        id_senha.setText("");
        id_termos.setChecked(false);
        id_manager_lingua.clearCheck();
        id_nome.requestFocus();
        Toast.makeText(this, "Tela limpa", Toast.LENGTH_SHORT).show();
    }

    public boolean verificaTexto(){
        String nome  = id_nome.getText().toString().trim();
        String sobrenome  = id_sobrenome.getText().toString().trim();
        String senha = id_senha.getText().toString().trim();
        boolean bool = false;

        if(!nome.equalsIgnoreCase("")){
            if(!sobrenome.equalsIgnoreCase("")){
                if(!senha.equalsIgnoreCase("")){
                    bool = true;
                }else {
                    Toast.makeText(this, "Senha não pode ser deixado em branco", Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(this, "Sobrenome não pode ser deixado em branco", Toast.LENGTH_SHORT).show();
            }


        }else {
            Toast.makeText(this, "Nome não pode ser deixado em branco", Toast.LENGTH_SHORT).show();
        }

        return bool;
    }

    public boolean verificaTermo(){
        boolean bool = false;

        if(id_termos.isChecked()){
            bool = true;
        }
        return bool;
    }

    public boolean verificaLingua(){
        boolean bool = false;
        String msg="";
        String aviso=" foi selecionado!";
      switch (id_manager_lingua.getCheckedRadioButtonId()){
          case R.id.id_portugues:
              msg="Portugues";
              Toast.makeText(this, msg+aviso, Toast.LENGTH_SHORT).show();
              bool = true;
                break;
          case R.id.id_ingles:
              msg="Inglês";
              Toast.makeText(this, msg+aviso, Toast.LENGTH_SHORT).show();
              bool = true;
                break;
          case R.id.id_espanhol:
              msg="Espanhol";
              Toast.makeText(this, msg+aviso, Toast.LENGTH_SHORT).show();
              bool = true;
              break;
          default:
              Toast.makeText(this, "Selecione uma lingua materna", Toast.LENGTH_SHORT).show();
      }
        return bool;
    }

    public void verificaTudo(){
/**
        if(verificaTexto()){
            if (verificaTermo()){
                if(verificaLingua()){
                    Intent intent = new Intent(this,Ficha_Usuario.class);
                    intent.putExtra("id_nome",id_nome.getText().toString());
                    intent.putExtra("id_sobrenome",id_sobrenome.getText().toString());
                    intent.putExtra("id_senha",id_senha.getText().toString());
                    intent.putExtra("id_termo",true);
                    startActivity(intent);
                }else{
                    verificaLingua();
                }
            }else {
                verificaTermo();
            }
        }else{
            verificaTexto();
        }
 **/
        Intent intent = new Intent(this, SelecionaTreino.class);
        startActivity(intent);
    }

    public void sendUser(View view) {
       verificaTudo();
    }
}

