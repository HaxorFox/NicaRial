package com.nicarial.nicarial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        ImageView ivuser = (ImageView) findViewById(R.id.ivuser);
        ivuser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), Usuarios.class);
                startActivityForResult(intent1, 0);
            }
        });

        ImageView ivdonation = (ImageView) findViewById(R.id.ivdonation);
        ivdonation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), DonacionesActivity.class);
                startActivityForResult(intent2, 0);
            }
        });

        ImageView ivcalculator = (ImageView) findViewById(R.id.ivcalculator);
        ivcalculator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent3 = new Intent(v.getContext(), Ingresos.class);
                startActivityForResult(intent3, 0);
            }
        });

        ImageView ivfeedback = (ImageView) findViewById(R.id.ivfeedback);
        ivfeedback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent4 = new Intent(v.getContext(), FeedbackActivity.class);
                startActivityForResult(intent4, 0);
            }
        });

    }
}
