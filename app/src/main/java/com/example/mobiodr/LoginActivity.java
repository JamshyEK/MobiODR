package com.example.mobiodr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button;
    userpass up=new userpass();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);

        editText1=findViewById(R.id.name);
        editText2=findViewById(R.id.product);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String user = editText1.getText().toString();
                String pass = editText2.getText().toString();
                boolean isadmin = up.admin(user, pass);
                if(isadmin==true){
                    Intent intent=new Intent(LoginActivity.this,NavActivity.class);
                    editText1.setText("");
                    editText2.setText("");
                    editText2.clearFocus();
                    startActivity(intent);
                }else {
                    Toast toast=Toast.makeText(getApplicationContext(),"Incorrect Username & Password",Toast.LENGTH_SHORT);
                    toast.show();
                    editText1.setText("");
                    editText2.setText("");
                    editText2.clearFocus();


                }

            }
        });


    }

}
