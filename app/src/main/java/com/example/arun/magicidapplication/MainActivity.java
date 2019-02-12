package com.example.arun.magicidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etId;
    Button btSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etId);
        btSubmit = findViewById(R.id.btSubmit);
        tvResult=findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idNumber = etId.getText().toString().trim();

                String dob = idNumber.substring(0,5);

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sGender;
                if(gender<5)
                    sGender=getString(R.string.famale);
                else
                    sGender=getString(R.string.male);


                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String sNationality;

                if(nationality==0)
                    sNationality =getString(R.string.sacitizen);
                else
                    sNationality=getString(R.string.permanetcitizen);

                String text = getString(R.string.dob) +dob+ "\n" +
                        getString(R.string.gender)+sGender+ "\n"+
                        getString(R.string.nationality)+sNationality;

                tvResult.setText(text);
                tvResult.setVisibility(View.VISIBLE);
            }
        });

    }


}
