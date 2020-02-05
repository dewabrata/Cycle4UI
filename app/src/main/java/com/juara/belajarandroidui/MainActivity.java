package com.juara.belajarandroidui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtUsername, txtPassword;
    Button btnSignIn, btnSignUp;
    LinearLayout layoutDinamis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutDinamis = findViewById(R.id.layoutdinamis);
        layoutDinamis.setOrientation(LinearLayout.VERTICAL);

        txtUsername = findViewById(R.id.txtName);
        txtPassword = findViewById(R.id.txtPassword);

        btnSignIn = findViewById(R.id.button);
        btnSignUp = findViewById(R.id.button2);
      /*  btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"Ini dari button langsung signin", Toast.LENGTH_SHORT).show();
            }
        });*/

        btnSignIn.setOnClickListener(this);
       txtUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
           @Override
           public void onFocusChange(View v, boolean hasFocus) {
               if(!hasFocus){
                   if (!txtUsername.getText().toString().equalsIgnoreCase("dewabrata")){
                       Toast.makeText(MainActivity.this,"Maaf namanya harus dewabrata!", Toast.LENGTH_SHORT).show();
                       txtUsername.setError("Maaf namanya harus dewabrata!");
                   }
               }else{
                   Toast.makeText(MainActivity.this,"Masukan nama anda!", Toast.LENGTH_SHORT).show();
               }
           }
       });

       txtUsername.setOnKeyListener(new View.OnKeyListener() {
           @Override
           public boolean onKey(View v, int keyCode, KeyEvent event) {

               Log.d("Event Key",keyCode+"");
               if(keyCode == 32){
                  //txtUsername.setText(txtUsername.getText().toString().substring(0,txtUsername.getText().toString().length()-1));

               }
               return false;
           }
       });

    }

    public void tekanSignUp(View v){
        Toast.makeText(MainActivity.this,"Ini dari method sighup", Toast.LENGTH_SHORT).show();
    }

    int x =0 ;
    @Override
    public void onClick(View v) {
        if(v == btnSignIn){
            Toast.makeText(MainActivity.this,"Ini dari button dari activity", Toast.LENGTH_SHORT).show();
            x++;
           Button btnDinamis =  new Button(MainActivity.this);
           btnDinamis.setText("Ini Button ke "+x);
            layoutDinamis.addView(btnDinamis);
        }
    }
}
