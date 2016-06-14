package id.ac.polban.birokrasi.ebirokrasi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class DelMahasiswaActivity extends AppCompatActivity {

    EditText etNIM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_mahasiswa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNIM = (EditText) findViewById(R.id.etNIM);
    }

    public void BtnDelMahasiswa(View view){

        String nimMahasiswa = etNIM.getText().toString();

        MahasiswaClient.delete("mahasiswa_api/user/" + nimMahasiswa, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(DelMahasiswaActivity.this,
                        "sukses delete", Toast.LENGTH_LONG).show();
                Intent intentMain = new Intent(DelMahasiswaActivity.this, MainActivity.class);
                startActivity(intentMain);
            }
        });

    }

}
