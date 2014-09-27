package com.devahoy.android.spinnerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MyActivity extends Activity {

    private Spinner mEnglishSpinner;
    private Spinner mThaiSpinner;

    private ArrayList<String> mThaiClub = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mEnglishSpinner = (Spinner) findViewById(R.id.english_club);
        mThaiSpinner = (Spinner) findViewById(R.id.thai_club);

        createThaiClubData();

        // Adapter ตัวแรก
        ArrayAdapter<String> adapterThai = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, mThaiClub);
        mThaiSpinner.setAdapter(adapterThai);


        // Adapter ตัวที่สอง
        final String[] englishClub = getResources().getStringArray(R.array.club);
        ArrayAdapter<String> adapterEnglish = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, englishClub);
        mEnglishSpinner.setAdapter(adapterEnglish);

        // setOnItemSelectedListener
        mThaiSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MyActivity.this,
                        "Select : " + mThaiClub.get(position),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mEnglishSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MyActivity.this,
                        "Select : " + englishClub[position],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner with CustomAdapter
        Spinner spinnerMenu = (Spinner) findViewById(R.id.spinner_menu);
        ArrayList<String> data = new ArrayList<String>();
        for (int i = 1; i <= 5; i++) {
            data.add("Menu#" + i);
        }

        CustomAdapter customAdapter = new CustomAdapter(this, data);
        spinnerMenu.setAdapter(customAdapter);
    }

    private void createThaiClubData() {

        mThaiClub.add("Air Force Central");
        mThaiClub.add("Army United");
        mThaiClub.add("Bangkok Glass");
        mThaiClub.add("Bangkok United");
        mThaiClub.add("BEC Tero");
        mThaiClub.add("Buriram United");
        mThaiClub.add("Chainat Hornbill");
        mThaiClub.add("Chiangrai United");
        mThaiClub.add("Chonburi");
        mThaiClub.add("Muangthong United");
        mThaiClub.add("Osotspa Saraburi");
        mThaiClub.add("Police United");
        mThaiClub.add("PTT Rayong");
        mThaiClub.add("Ratchaburi");
        mThaiClub.add("Samut Songkhram");
        mThaiClub.add("Singhtarua");
        mThaiClub.add("Sisaket");
        mThaiClub.add("Songkhla United");
        mThaiClub.add("Supanburi");
        mThaiClub.add("TOT Bangkok");
    }
}
