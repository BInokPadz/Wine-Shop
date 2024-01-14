package com.example.wineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editname,editItems,editAmount,editDate;
    TextView btnReserve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editname = (EditText)findViewById(R.id.ename);
        editItems = (EditText)findViewById(R.id.eItems);
        editAmount = (EditText)findViewById(R.id.eAmount);
        editDate = (EditText)findViewById(R.id.edate);
        btnReserve = (TextView) findViewById(R.id.btnreserve);
        AddData();
    }

    public void AddData(){
        btnReserve = (TextView) findViewById(R.id.btnreserve);
        btnReserve.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                String txtName = editname.getText().toString();
                String txtType = editItems.getText().toString();
                String txtLocation = editAmount.getText().toString();
                String txtDate = editDate.getText().toString();

                boolean isInserted =  myDb.insertData(txtName,txtType,txtLocation,txtDate);
                if(isInserted =  true){
                    Toast.makeText(MainActivity.this,"Sucessfully Saved",Toast.LENGTH_LONG).show();
                    editname.setText("");
                    editItems.setText("");
                    editAmount.setText("");
                    editDate.setText("");

                }else{
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}