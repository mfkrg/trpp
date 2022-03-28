package com.mfkrg.trpp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mfkrg.trpp.Models.User;
import com.rengwuxian.materialedittext.MaterialEditText;


public class Auth extends AppCompatActivity{

    Button buttonSignIn;
    Button buttonSignUp;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    RelativeLayout root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        root = findViewById(R.id.root);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showRegistrationWindow();

            }
        });
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showSignInWindow();

            }
        });
    }

    private void showSignInWindow(){

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Sign In");

        LayoutInflater inflater = LayoutInflater.from(this);
        View sign_in_window = inflater.inflate(R.layout.sign_in_window, null);
        dialog.setView(sign_in_window);

        final MaterialEditText email = sign_in_window.findViewById(R.id.emailField);
        final MaterialEditText password = sign_in_window.findViewById(R.id.passwordField);

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Sign me in!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(root, "The email field is empty!", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(password.getText().toString().length() < 5){
                    Snackbar.make(root, "Password must be at least 5 characters long!", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                startActivity(new Intent(Auth.this, MainActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Snackbar.make(root, "Error! " + e.getMessage(), Snackbar.LENGTH_SHORT).show();

                    }
                });
            }
        });

        dialog.show();

    }

    private void showRegistrationWindow() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Registration");

        LayoutInflater inflater = LayoutInflater.from(this);
        View register_window = inflater.inflate(R.layout.register_window, null);
        dialog.setView(register_window);

        final MaterialEditText email = register_window.findViewById(R.id.emailField);
        final MaterialEditText password = register_window.findViewById(R.id.passwordField);
        final MaterialEditText name = register_window.findViewById(R.id.nameField);
        final MaterialEditText phone = register_window.findViewById(R.id.phoneField);

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Register!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(root, "The email field is empty!", Snackbar.LENGTH_SHORT).show();
                    //Snackbar.make(findViewById(android.R.id.content), "The email field is empty!", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(password.getText().toString().length() < 5){
                    Snackbar.make(root, "Password must be at least 5 characters long!", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(phone.getText().toString())){
                    Snackbar.make(root, "The phone field is empty!", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(name.getText().toString())){
                    Snackbar.make(root, "The name field is empty!", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        User user = new User();
                        user.setPhone(phone.getText().toString());
                        user.setName(name.getText().toString());
                        user.setPassword(password.getText().toString());
                        user.setEmail(email.getText().toString());

                        users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Snackbar.make(root, "registrated!", Snackbar.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

            }
        });

        dialog.show();

    }
}