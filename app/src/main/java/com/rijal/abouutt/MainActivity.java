package com.rijal.abouutt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAbout = (Button) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeDialog();
            }
        });
    }
    void makeDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.about_dialog);
        Button btnKeluar = (Button) dialog.findViewById(R.id.btnKeluarDialog);
        TextView txtNamaApp = (TextView) dialog.findViewById(R.id.txtNamaAplikasi);
        TextView txtVersiApp = (TextView) dialog.findViewById(R.id.txtVersiAplikasi);
        txtNamaApp.setText(this.getApplicationInfo().loadLabel(getPackageManager()).toString());
        try {
            txtVersiApp.setText(this.getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}