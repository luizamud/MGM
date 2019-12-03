package luizfelipemoralez.amuds.mygymmanager.Controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import luizfelipemoralez.amuds.mygymmanager.R;

public class StartApp extends AppCompatActivity {

    private static final String USER_INFO ="luizfelipemoralez.amuds.mygymmanager.sharedpreferences.USER_INFO";
    private static final String FIRST_USER = "FIRST_USER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reader();
    }
    private void reader(){
        SharedPreferences shared = getSharedPreferences(USER_INFO,
                Context.MODE_PRIVATE);
        if (shared.contains(FIRST_USER)){
            Intent intent = new Intent(getApplicationContext(),Home.class);
            startActivity(intent);
        }else{
            Intent intentf= new Intent(this,Ficha_Usuario.class);
            startActivity(intentf);
        }

    }
}

