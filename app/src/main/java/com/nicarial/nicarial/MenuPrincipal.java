package com.nicarial.nicarial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);


        Button btn_deduc = (Button) findViewById(R.id.btn_deduc);
        btn_deduc.getBackground().setAlpha(20);



        Button btn_salir = (Button) findViewById(R.id.btn_salir);
        btn_salir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();

            }
        });

        Button btn_feed = (Button) findViewById(R.id.btn_feed);
        btn_feed.getBackground().setAlpha(51);

        ImageView ivcalculator = (ImageView) findViewById(R.id.ivcalculator);
        btn_deduc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent3 = new Intent(v.getContext(), Ingresos.class);
                startActivityForResult(intent3, 0);
            }
        });

        ImageView ivfeedback = (ImageView) findViewById(R.id.ivfeedback);
        btn_feed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent4 = new Intent(v.getContext(), FeedbackActivity.class);
                startActivityForResult(intent4, 0);
            }
        });



    }
}
