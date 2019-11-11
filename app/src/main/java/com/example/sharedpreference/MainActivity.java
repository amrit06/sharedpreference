package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
// hello
    public void save(View view){
        saveToDevice();
    }

    public void display(View view){
        readFromMemory();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editText1);
        password = findViewById(R.id.editText2);

    }

    // saving to device memory
    public void saveToDevice(){
        // creating shared prefrence kinda like database pointer to write and read from userInfo file
        SharedPreferences saveData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = saveData.edit(); // editor kinda like cursor

        // save data as those var names. if run twice this line will overwrite previous value
        edit.putString("username", username.getText().toString());
        edit.putString("password", password.getText().toString());

        edit.apply(); // saving
        Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_LONG).show();

    }

    public void readFromMemory(){
        SharedPreferences savedData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String userName = savedData.getString("username", "default");
        String Password = savedData.getString("password", "default");

        username.setText(userName);
        password.setText(Password);
    }
}
