package com.example.quizapp_o2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class Score extends AppCompatActivity {

    Button next,quit;
    int oldscore;
    String niveau;
    com.app.adprogressbarlib.AdCircleProgress circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        next=(Button) findViewById(R.id.retry);
        quit=(Button) findViewById(R.id.exit);

        Intent intent = getIntent();
        oldscore = intent.getIntExtra("score",0);

        if(oldscore == 2 & niveau == "Deb")
        {
            Toast.makeText(Score.this,"votre niveau est maintenant Amateur !",Toast.LENGTH_SHORT).show();
            circle.setAdProgress(100);
            next.setText("Amateur");
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Toast.makeText(Score.this,"Pas encore disponible",Toast.LENGTH_SHORT).show();
                }
            });

        }
        else if (oldscore == 1)
        {
            circle.setAdProgress(50);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Toast.makeText(Score.this,"Pas encore disponible",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Score.this,quiz.class);
                    startActivity(intent);
                }
            });
        }
        else if (oldscore == 0)
        {
            circle.setAdProgress(0);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Toast.makeText(Score.this,"Pas encore disponible",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Score.this,quiz.class);
                    startActivity(intent);
                }
            });
        }

    }
}
