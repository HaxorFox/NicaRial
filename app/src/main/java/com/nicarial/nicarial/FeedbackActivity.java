package com.nicarial.nicarial;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class FeedbackActivity extends AppCompatActivity {
    DataBaseHandler db = new DataBaseHandler(this);
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        final EditText txt_nombre = (EditText) findViewById(R.id.txt_nombre);
        final EditText txt_comment = (EditText) findViewById(R.id.txt_comment);

        Button btn_enviar = (Button) findViewById(R.id.btn_submit);


        btn_enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                db.addContract(new Contract(txt_nombre.getText().toString(), txt_comment.getText().toString()));

                if (txt_nombre.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Porfavor, ingrese su nombre.",
                            Toast.LENGTH_LONG).show();
                } else if (txt_comment.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Porfavor, ingrese su comentario.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(FeedbackActivity.this, "Comentario Guardado a la Base de Datos.",
                            Toast.LENGTH_LONG).show();
                    txt_nombre.setText("");
                    txt_comment.setText("");
                }


            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Feedback Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
