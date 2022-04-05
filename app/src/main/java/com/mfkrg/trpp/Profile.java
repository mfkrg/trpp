package com.mfkrg.trpp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mfkrg.trpp.Models.User;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity implements View.OnClickListener{

    ImageButton toProfileFromProfileButton;
    ImageButton toCatalogButtonFromProfile;
    ImageButton toOrdersFromProfileButton;
    ImageButton exitFromProfile;


    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.toCatalogButtonFromProfile:
                Intent intentToCatalogFromProfile = new Intent(this, MainActivity.class);
                startActivity(intentToCatalogFromProfile);
                break;
            case R.id.toOrdersFromProfileButton:
                Intent intentToOrdersFromProfile = new Intent(this, Orders.class);
                startActivity(intentToOrdersFromProfile);
                break;
            case R.id.exitFromProfile:
                FirebaseAuth.getInstance().signOut();
                Intent intentToLoginFromProfile = new Intent(this, Auth.class);
                startActivity(intentToLoginFromProfile);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        toCatalogButtonFromProfile = (ImageButton) findViewById(R.id.toCatalogButtonFromProfile);
        toCatalogButtonFromProfile.setOnClickListener(this);
        toOrdersFromProfileButton = (ImageButton) findViewById(R.id.toOrdersFromProfileButton);
        toOrdersFromProfileButton.setOnClickListener(this);
        exitFromProfile = (ImageButton) findViewById(R.id.exitFromProfile);
        exitFromProfile.setOnClickListener(this);
        getData();

    }

    private void getData(){
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User post = dataSnapshot.getValue(User.class);
                TextView text = findViewById(R.id.textView5);
                text.setText("Hello, "+post.getName());

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };

    }

}