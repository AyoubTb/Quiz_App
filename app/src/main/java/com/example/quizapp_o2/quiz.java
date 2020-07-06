package com.example.quizapp_o2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class quiz extends AppCompatActivity {
    RadioButton r1,r2;
    Button s;
    int score;


    Intent intent = getIntent();
    String niveau = intent.getStringExtra("niveau");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        s=(Button) findViewById(R.id.next);
        r1=(RadioButton) findViewById(R.id.Q1);
        r2=(RadioButton) findViewById(R.id.Q2);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r1.isChecked()){
                    Toast.makeText(quiz.this,"Juste !",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(quiz.this,quiz2.class);
                    score=1;
                    intent.putExtra("score", score);
                    intent.putExtra("niveau", niveau);
                    startActivity(intent);
                }
                else if (r2.isChecked()){
                    Toast.makeText(quiz.this,"Faux !",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(quiz.this,quiz2.class);
                    score=0;
                    intent.putExtra("score", score);
                    intent.putExtra("niveau", niveau);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(quiz.this,"Veuillez choisir une réponse!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
