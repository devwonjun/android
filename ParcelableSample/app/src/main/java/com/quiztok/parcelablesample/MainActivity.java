package com.quiztok.parcelablesample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , MenuAtivity.class);
                SimpleData data = new SimpleData(100, "Hello Android!!");
                intent.putExtra(KEY_SIMPLE_DATA , data);
                startActivityForResult(intent , REQUEST_CODE_MENU);
            }
        });
    }

    /**
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //MenuActivity name 값 전달 받음
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext() , "응답으로 전달된 name:"+ name, Toast.LENGTH_LONG).show();
        }
    }
}
