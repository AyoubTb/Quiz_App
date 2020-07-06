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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText etLogine, etPassword, etMail, etName;
    Button register;
    TextView tvRegister;
    FirebaseAuth mFirebaseAuth;
    String niveau = "";
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

            setContentView(R.layout.activity_register);
            etLogine=(EditText)findViewById(R.id.Logine);
            etName=(EditText)findViewById(R.id.name);
            etPassword=(EditText)findViewById(R.id.mdpp);
            etMail=(EditText)findViewById(R.id.mail);
            tvRegister=(TextView) findViewById(R.id.newaccountt);
            register=(Button) findViewById(R.id.register);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null )
                {
                    startActivity(new Intent( Register.this,quiz.class));
                }
            }
        };

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etMail.getText().toString();
                String pwd = etPassword.getText().toString();
                if(email.isEmpty()){
                    etMail.setError("Entrez votre mail");
                    etMail.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    etPassword.setError("Entrez votre mot de passe");
                    etPassword.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(Register.this,"Champ vide !",Toast.LENGTH_SHORT).show();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Register.this,"Veuillez entrez vos données de nouveau !",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(Register.this,quiz.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Register.this,"Error !",Toast.LENGTH_SHORT).show();

                }

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");


                String name = etName.getEditableText().toString();
                String Mail = etMail.getEditableText().toString();
                String login = etLogine.getEditableText().toString();
                String password = etPassword.getEditableText().toString();

                User usr = new User(name,Mail,login,password);
                reference.setValue(usr);
            }
        });

    }


}
