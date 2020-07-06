package com.example.quizapp_o2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class  MainActivity extends AppCompatActivity {
    EditText etLogin, etPassword;
    Button bLogin;
    TextView tvRegister;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//method qui permet d'associer un layout a un controleur
        //Recuperation des ids
        etLogin=(EditText)findViewById(R.id.Login);
        etPassword=(EditText)findViewById(R.id.MDP);
        bLogin=(Button) findViewById(R.id.connexion);
        tvRegister=(TextView) findViewById(R.id.newaccount);
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if( mFirebaseUser != null ){
                    Toast.makeText(MainActivity.this,"Connecté !",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, Menu.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this,"Veuillez entrez vos données de nouveau !",Toast.LENGTH_SHORT).show();
                }
            }
        };
        //Association de listeners
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Traitement
                String email = etLogin.getText().toString();
                String pwd = etPassword.getText().toString();
                if(email.isEmpty()){
                    etLogin.setError("Entrez votre mail");
                    etLogin.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    etPassword.setError("Entrez votre mot de passe");
                    etPassword.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"Champ vide !",Toast.LENGTH_SHORT).show();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    //Pour la connexion OFFLINE Sans connexion à la base de données
                    if(etLogin.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin") )
                    {
                        Intent intToHome = new Intent(MainActivity.this,Menu.class);
                        startActivity(intToHome);
                    }
                    else
                        {
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(MainActivity.this,"Veuillez entrez vos données de nouveau !",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Intent intToHome = new Intent(MainActivity.this,quiz.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                }
                }
                else{
                    Toast.makeText(MainActivity.this,"Error !",Toast.LENGTH_SHORT).show();

                }
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent myIntent = new Intent(v.getContext(), Register.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
    /*@Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }*/
}
