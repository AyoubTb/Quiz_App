package com.example.quizapp_o2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class quiz2 extends AppCompatActivity {
    RadioButton r1,r2;
    Button suivant;
    int oldscore;
    Intent intent = getIntent();
    String niveau = intent.getStringExtra("niveau");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        suivant=(Button) findViewById(R.id.next1);
        r1=(RadioButton) findViewById(R.id.Q3);
        r2=(RadioButton) findViewById(R.id.Q4);
        Intent intent = getIntent();
        oldscore = intent.getIntExtra("score",0);
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r1.isChecked()){
                    Toast.makeText(quiz2.this,"Juste !",Toast.LENGTH_SHORT).show();
                    Intent intToHome = new Intent(quiz2.this,Score.class);
                    oldscore +=1;
                    intToHome.putExtra("score", oldscore);
                    intToHome.putExtra("niveau", niveau);
                    startActivity(intToHome);
                }
                else if (r2.isChecked()){
                    Toast.makeText(quiz2.this,"Faux !",Toast.LENGTH_SHORT).show();
                    Intent intToHome = new Intent(quiz2.this,Score.class);
                    intToHome.putExtra("score", oldscore);
                    intToHome.putExtra("niveau", niveau);
                    startActivity(intToHome);
                }
                else {
                    Toast.makeText(quiz2.this,"Veuillez choisir une réponse!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}