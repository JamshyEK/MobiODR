package com.example.mobiodr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);

        editText1=findViewById(R.id.username);
        editText2=findViewById(R.id.password);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String user = editText1.getText().toString();
                String pass = editText2.getText().toString();
                if(user.equals("aaa") && pass.equals("aaa")){

                    Toast toast=Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });


    }

}
