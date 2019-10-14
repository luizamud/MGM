package luizfelipemoralez.amuds.mygymmanager.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import luizfelipemoralez.amuds.mygymmanager.R;

public class App_Autoria extends AppCompatActivity {
    private View view;
    private TextView id_god;
    private TextView id_formacao;
    private TextView id_email;
    private TextView id_biografia;
    private TextView label_nome;
    private TextView label_formacao;
    private TextView label_email;
    private TextView label_biografia;
    private TextView id_utfpr;
    private ImageView id_image_utfpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_autoria);
        view = findViewById(R.id.id_app_autoria);
        view.setBackgroundColor(getResources().getColor(android.R.color.black));
        id_god = findViewById(R.id.id_god);
        id_formacao = findViewById(R.id.id_formacao);
        id_email = findViewById(R.id.id_email);
        id_biografia = findViewById(R.id.id_biografia);
        label_nome = findViewById(R.id.label_nome);
        label_formacao = findViewById(R.id.label_formacao);
        label_email = findViewById(R.id.label_email);
        label_biografia = findViewById(R.id.label_bio);

        label_nome.setText(getString(R.string.nome));
        label_formacao.setText(getString(R.string.curso));
        label_email.setText(getString(R.string.email));
        label_biografia.setText(getString(R.string.label_bio));
        id_god.setText(getString(R.string.owner_name));
        id_formacao.setText(getString(R.string.owner_job));
        id_email.setText(getString(R.string.owner_email));
        id_biografia.setText(getString(R.string.owner_bio));

        id_utfpr = findViewById(R.id.id_label_utf);
        id_image_utfpr = findViewById(R.id.id_image_utf);
        id_image_utfpr.setImageResource(R.drawable.utfpr_cp);
        id_god.setTextColor(getResources().getColor(R.color.accent_utfpr_color));
        id_formacao.setTextColor(getResources().getColor(R.color.accent_utfpr_color));
        id_email.setTextColor(getResources().getColor(R.color.accent_utfpr_color));
        id_biografia.setTextColor(getResources().getColor(R.color.accent_utfpr_color));
        id_utfpr.setTextColor(getResources().getColor(R.color.accent_utfpr_color));
        label_nome.setTextColor(getResources().getColor(R.color.accent_utfpr_color));
        label_formacao.setTextColor(getResources().getColor(R.color.accent_utfpr_color));
        label_email.setTextColor(getResources().getColor(R.color.accent_utfpr_color));
        label_biografia.setTextColor(getResources().getColor(R.color.accent_utfpr_color));
    }

    public void sair_autoria() {
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_autoria, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_voltar:
                sair_autoria();
                return true;
            default:
                return onOptionsItemSelected(item);
        }
    }
}
