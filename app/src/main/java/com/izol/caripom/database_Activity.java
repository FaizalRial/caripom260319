package com.izol.caripom;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.izol.caripom.model.Requests;

public class database_Activity extends AppCompatActivity {
    private static final String TAG = "caripom";
    private DatabaseReference database;

    private EditText etnama, etjenis, etjam, etpertamax, etpertalite, etpremium, etsolar, etdexlite, etpertamaxturbo;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_);

        database = FirebaseDatabase.getInstance().getReference();

        etnama = findViewById(R.id.et_nama);
        etjenis = findViewById(R.id.et_jenis);
        etjam = findViewById(R.id.et_jam);
        etpertamax = findViewById(R.id.et_pertamax);
        etpertalite = findViewById(R.id.et_pertalite);
        etpremium = findViewById(R.id.et_premium);
        etsolar = findViewById(R.id.et_solar);
        etdexlite = findViewById(R.id.et_dexlite);
        etpertamaxturbo = findViewById(R.id.et_pertamaxturbo);

        Button button = findViewById(R.id.btn_simpan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Snama = etnama.getText().toString();
                String Sjenis = etjenis.getText().toString();
                String Sjam = etjam.getText().toString();
                String Spertamax = etpertamax.getText().toString();
                String Spertalite = etpertalite.getText().toString();
                String Spremium = etpremium.getText().toString();
                String Ssolar = etsolar.getText().toString();
                String Sdexlite = etdexlite.getText().toString();
                String Spertamaxturbo = etpertamaxturbo.getText().toString();

                if (Snama.equals("")) {
                    etnama.setError("Silahkan Masukkan Nama");
                    etnama.requestFocus();
                } else if (etjenis.equals("")) {
                    etjenis.setError("Silahkan Masukkan Jenis SPBU/Pom Mini");
                    etjenis.requestFocus();
                } else if (etjam.equals("")) {
                    etjam.setError("Silahkan Masukkan Jam");
                    etjam.requestFocus();
                } else if (etpertamax.equals("")) {
                    etpertamax.setError("Silahkan Masukkan Pertamax");
                    etpertamax.requestFocus();
                } else if (etpertalite.equals("")) {
                    etpertalite.setError("Silahkan Masukkan Pertalite");
                    etpertalite.requestFocus();
                } else if (etpremium.equals("")) {
                    etpremium.setError("Silahkan Masukkan Premium");
                    etpremium.requestFocus();
                } else if (etsolar.equals("")) {
                    etsolar.setError("Silahkan Masukkan Solar");
                    etsolar.requestFocus();
                } else if (etdexlite.equals("")) {
                    etdexlite.setError("Silahkan Masukkan Dexlite");
                    etdexlite.requestFocus();
                } else if (etpertamaxturbo.equals("")) {
                    etpertamaxturbo.setError("Silahkan Masukkan Pertamax Turbo");
                    etpertamaxturbo.requestFocus();
                } else
                    loading = ProgressDialog.show(database_Activity.this,
                            null,
                            "Please wait...",
                            true,
                            false);

                submitUser(new Requests(
                        Snama.toLowerCase(),
                        Sjenis.toLowerCase(),
                        Sjam.toLowerCase(),
                        Spertamax.toLowerCase(),
                        Spertalite.toLowerCase(),
                        Spremium.toLowerCase(),
                        Ssolar.toLowerCase(),
                        Sdexlite.toLowerCase(),
                        Spertamaxturbo.toLowerCase()));
            }
        });
    }

    private void submitUser (Requests requests) {
        database.child("Request")
                //.child("request_satu")
                .push()
                .setValue(requests)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                    }
                });
        loading.dismiss();

        etnama.setText("");
        etjenis.setText("");
        etjam.setText("");
        etpertamax.setText("");
        etpertalite.setText("");
        etpremium.setText("");
        etsolar.setText("");
        etdexlite.setText("");
        etpertamaxturbo.setText("");

        Toast.makeText(database_Activity.this,
                "Data Berhasil Ditambahkan",
                Toast.LENGTH_SHORT).show();
    };
}
