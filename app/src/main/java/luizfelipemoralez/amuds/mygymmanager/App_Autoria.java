package luizfelipemoralez.amuds.mygymmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class App_Autoria extends AppCompatActivity {
    private View view;
    private TextView id_god;
    private TextView id_formacao;
    private TextView id_email;
    private TextView id_biografia;
    private TextView id_utfpr;
    private ImageView id_image_utfpr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_autoria);
        view = findViewById(R.id.id_app_autoria);
        view.setBackgroundColor(getResources().getColor(android.R.color.black));
        id_god =findViewById(R.id.id_god);
        id_formacao =findViewById(R.id.id_formacao);
        id_email =findViewById(R.id.id_email);
        id_biografia =findViewById(R.id.id_biografia);
        id_utfpr =findViewById(R.id.id_label_utf);
        id_image_utfpr = findViewById(R.id.id_image_utf);
        id_image_utfpr.setImageResource(R.drawable.utfpr);
        id_god.setTextColor(getResources().getColor(R.color.accent_utfpr_color));
        id_formacao.setTextColor(getResources().getColor(R.color.accent_utfpr_color));
        id_email.setTextColor(getResources().getColor(R.color.accent_utfpr_color));
        id_biografia.setTextColor(getResources().getColor(R.color.accent_utfpr_color));
        id_utfpr.setTextColor(getResources().getColor(R.color.accent_utfpr_color));

        Intent intent = getIntent();
        id_god.setText(intent.getStringExtra("nome"));
        id_formacao.setText(intent.getStringExtra("trampo"));
        id_email.setText(intent.getStringExtra("email"));
        id_biografia.setText(intent.getStringExtra("bio"));
    }
}
