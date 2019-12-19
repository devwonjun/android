package com.example.sampleorientation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;

    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("onCreate 호출");

        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                name = editText.getText().toString(); // 변수 저정
                showToast("입력된 값을 변수에 저장하였습니다.:"+ name );
            }
        });

        if(savedInstanceState!=null) {
            name = savedInstanceState.getString("name"); // 불러오기 
            showToast("값을 복원했습니다.:"+ name);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", name); // 값 저장
    }


    @Override
    protected void onStart(){
        super.onStart();
        showToast("onStart ");
    }

    @Override
    protected void onStop(){
        super.onStop();
        showToast("onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        showToast("onDestroy");
    }

    public void showToast(String data){
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}
