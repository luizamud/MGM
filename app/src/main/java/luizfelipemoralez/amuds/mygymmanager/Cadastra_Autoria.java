package luizfelipemoralez.amuds.mygymmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cadastra_Autoria extends AppCompatActivity {

        private EditText god_name;
        private EditText god_job;
        private EditText god_email;
        private EditText god_bio;
        private TextView god_name_label;
        private TextView god_job_label;
        private TextView god_email_label;
        private TextView god_bio_label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_autoria);

    }


    public void sendOwner(View view) {
        callOwner();
    }
}
