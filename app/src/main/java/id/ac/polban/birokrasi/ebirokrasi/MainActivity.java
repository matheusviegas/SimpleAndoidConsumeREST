package id.ac.polban.birokrasi.ebirokrasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    List<Mahasiswa> mahasiswaData;
    ArrayAdapter<Mahasiswa> adapter;

    ListView lvMahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mahasiswaData = new ArrayList<Mahasiswa>();
        adapter = new ArrayAdapter<Mahasiswa>(this, R.layout.single_list, R.id.tvSingleMahasiswa, mahasiswaData);

        lvMahasiswa = (ListView) findViewById(R.id.lvListMhs);

        lvMahasiswa.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getMahasiswa();
    }

    public void BtnAddMahasiswa(View view){
        Intent intentActivityMahasiswa = new Intent(MainActivity.this, AddMahasiswaActivity.class);
        startActivity(intentActivityMahasiswa);
    }

    public void BtnEditMahasiswa(View view){
        Intent intentActivityMahasiswa = new Intent(MainActivity.this, EditMahasiswaActivity.class);
        startActivity(intentActivityMahasiswa);
    }

    public void BtnDelMahasiswa(View view){
        Intent intentActivityMahasiswa = new Intent(MainActivity.this, DelMahasiswaActivity.class);
        startActivity(intentActivityMahasiswa);
    }

    public void getMahasiswa() {

        mahasiswaData.clear();

        MahasiswaClient.get("mahasiswa_api/user", null, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                try {
                    for (int i=0; i < response.length();i++){

                        Mahasiswa m = new Mahasiswa();
                        JSONObject obj = response.getJSONObject(i);

                        m.setNama(obj.getString("nama"));
                        m.setNim(obj.getString("nim"));
                        m.setUmur(obj.getString("umur"));

                        mahasiswaData.add(m);

                    }

                    adapter.notifyDataSetChanged();

                }catch (Exception e){
                    e.printStackTrace();
                }

            }

        });

    }

}
