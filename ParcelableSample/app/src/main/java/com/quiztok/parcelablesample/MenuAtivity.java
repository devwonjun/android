package com.quiztok.parcelablesample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuAtivity extends AppCompatActivity {

    TextView textView;

    public static final String KEY_SAMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ativity);

        textView = findViewById(R.id.textView2);

        Button button = findViewById(R.id.btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "mike");
                setResult(RESULT_OK , intent);
                finish();
            }
        });

        Intent intent = getIntent();
        processIntent(intent);

    }
    private void processIntent(Intent intent){
        if(intent!=null) {
            Bundle bundle = intent.getExtras();
            SimpleData data = bundle.getParcelable(KEY_SAMPLE_DATA);
            if(intent != null) {
                textView.setText("전달 받은 데이터\nNumber:"+ data.number+ "\nMessage:"+ data.message);
            }
        }
    }
}
