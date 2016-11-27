package com.nicarial.nicarial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {
    DataBaseHandler db = new DataBaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        final EditText txt_nombre = (EditText) findViewById(R.id.txt_nombre);
        final EditText txt_comment = (EditText) findViewById(R.id.txt_comment);

        Button btn_enviar = (Button) findViewById(R.id.btn_submit);



        btn_enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            db.addContract(new Contract(txt_nombre.getText().toString(),txt_comment.getText().toString()));
                Toast.makeText(FeedbackActivity.this, "Comentario Guardado",
                        Toast.LENGTH_LONG).show();
                txt_nombre.setText("");
                txt_comment.setText("");
            }
        });
    }
}
