package id.ac.polban.birokrasi.ebirokrasi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class EditMahasiswaActivity extends AppCompatActivity {

    EditText etNIM, etName, etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mahasiswa_activiy);
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
        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);

    }

    public void BtnEditMahasiswa(View view){
        RequestParams params = new RequestParams();
        String nimMahasiswa = etNIM.getText().toString();
        String nameMahasiswa = etName.getText().toString();
        String ageMahasiswa = etAge.getText().toString();

        params.put("nim", nimMahasiswa);
        params.put("nama", nameMahasiswa);
        params.put("umur", ageMahasiswa);

        MahasiswaClient.put("mahasiswa_api/user", params, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(EditMahasiswaActivity.this,
                        "success Edit data", Toast.LENGTH_LONG).show();
                Intent intentMain = new Intent(EditMahasiswaActivity.this, MainActivity.class);
                startActivity(intentMain);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(EditMahasiswaActivity.this,
                        "fail", Toast.LENGTH_LONG).show();
            }

        });

    }

}
