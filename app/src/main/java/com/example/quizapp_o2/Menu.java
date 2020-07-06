package com.example.quizapp_o2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    RadioButton r1,r2,r3;
    Button debut;
    String niveau;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        debut=(Button) findViewById(R.id.start);
        r1=(RadioButton) findViewById(R.id.radioButton);
        r2=(RadioButton) findViewById(R.id.radioButton2);
        r3=(RadioButton) findViewById(R.id.radioButton3);
        debut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r1.isChecked()){
                    Intent intToHome = new Intent(Menu.this,quiz.class);
                    niveau = "Deb";
                    intToHome.putExtra("niveau", niveau);
                    startActivity(intToHome);
                }
                else if (r2.isChecked()){
                    Toast.makeText(Menu.this,"Pas encore disponible !",Toast.LENGTH_SHORT).show();
                }
                else if (r3.isChecked()){
                    Toast.makeText(Menu.this,"Pas encore disponible !",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Menu.this,"Veuillez choisir votre niveau !",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}