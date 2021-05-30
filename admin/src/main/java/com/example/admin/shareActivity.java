package com.example.admin;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.admin.Models.shareModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class shareActivity extends AppCompatActivity {
EditText Name,Number,Address,SharableItem;
Button button;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("ShareAbleItem");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        Name=findViewById(R.id.Share_Name);
        Number=findViewById(R.id.Share_Number);
        Address=findViewById(R.id.Share_Adrs);
        SharableItem=findViewById(R.id.Share_Avail);
        button=findViewById(R.id.share_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user_Name=Name.getText().toString();
                String user_Number=Number.getText().toString();
                String user_Address=Address.getText().toString();
                String user_item=SharableItem.getText().toString();
                String mdid=myRef.push().getKey();
                if(TextUtils.isEmpty(user_Name)  || TextUtils.isEmpty(user_Number) || TextUtils.isEmpty(user_Address) || TextUtils.isEmpty(user_item) )
                {
                    Toast.makeText(getApplicationContext(),"Please Fill Details",Toast.LENGTH_SHORT).show();
                }
                else{
                    shareModel shareModel=new shareModel(user_Name,user_Number,user_Address,user_item);
                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            myRef.child(mdid).setValue(shareModel);
                            Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
                            finish();
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            Toast.makeText(getApplicationContext(),"Please Check Your NetWork",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


    }
}