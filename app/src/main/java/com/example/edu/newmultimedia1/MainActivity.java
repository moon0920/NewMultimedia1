package com.example.edu.newmultimedia1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnFileRead = findViewById(R.id.btnFileRead);
        btnFileRead.setOnClickListener(this);
        Button btnFileWrite = findViewById(R.id.btnFileWrite);
        btnFileWrite.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editTextinput = findViewById(R.id.editTextinput);
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        switch (v.getId()){
            case R.id.btnFileRead:

                try {
                    inputStream = openFileInput("inner,txt");
                    byte[] buffer = new byte[0];
                    buffer = new byte[inputStream.available()];
                    inputStream.read(buffer);
                    editTextinput.setText(new String(buffer));
                    inputStream.close();
                }

                catch (FileNotFoundException e) {
                    e.printStackTrace(); }

                catch (IOException e) {
                    e.printStackTrace(); }

                break;

            case R.id.btnFileWrite:
                try {
                    outputStream = openFileOutput("inner,txt",Context.MODE_PRIVATE);
                    outputStream.write(editTextinput.getText().toString().getBytes());
                    outputStream.close();}

                catch (FileNotFoundException e) {
                    e.printStackTrace(); }

                catch (IOException e) {
                    e.printStackTrace(); }

                editTextinput.setText("");


                break;
        }

    }
}
