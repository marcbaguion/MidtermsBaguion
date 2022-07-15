package com.example.midterms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Pipe> pipeTypes;
    ArrayAdapter<Pipe> pipeAdapter;
    ArrayList<Bill> bills;
    int month;
    int last_consumption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bills = new ArrayList<>();
        month = 1;
        last_consumption = 0;
        setPipeAdapter();
        btnCalculateListenerMethod();
        setHistoryAdapter();
        nightModeListenerMethod();
    }

    // TODO Milestone A: Use Day-Night mode.
    private void nightModeListenerMethod() {
            Switch swnight = (Switch) findViewById(R.id.swNight);
            swnight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.clMain);
                    TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
                    TextView tvLblBill = (TextView) findViewById(R.id.tvLblBill);
                    TextView tvLblHistory = (TextView) findViewById(R.id.tvLblHistory);
                    TextView tvLblPrev = (TextView) findViewById(R.id.tvLblPrev);
                    TextView tvLblNew = (TextView) findViewById(R.id.tvLblNew);
                    TextView tvLblPipe = (TextView) findViewById(R.id.tvLblPipe);
                    TextView tvLblPackage = (TextView) findViewById(R.id.tvLblPackage);
                    EditText etPrev = (EditText) findViewById(R.id.etPrev);
                    EditText etNew = (EditText) findViewById(R.id.etNew);
                    EditText etResult = (EditText) findViewById(R.id.etResult);
                    RadioButton rbPremium = (RadioButton) findViewById(R.id.rbPremium);
                    RadioButton rbRegular = (RadioButton) findViewById(R.id.rbRegular);
                    RadioButton rbBasic = (RadioButton) findViewById(R.id.rbBasic);
                    Spinner spPipe = (Spinner) findViewById(R.id.spPipe);

                    TextView[] texts = {swnight, tvTitle, tvLblBill, tvLblHistory, tvLblPrev, tvLblNew, tvLblPipe, tvLblPackage, etPrev, etNew, etResult, rbBasic, rbPremium, rbRegular, spPipe};
                    boolean night = swnight.isChecked();
                    if (night) {
                        bgElement.setBackgroundColor(Color.BLACK);
                        for (TextView tv : texts){
                            tv.setTextColor(Color.WHITE);
                        }
                    } else {
                        bgElement.setBackgroundColor(Color.WHITE);
                        for (TextView tv : texts){
                            tv.setTextColor(Color.BLACK);
                        }
                    }
                }
            });
    }

    // TODO Milestone B: Show History.
    private void setHistoryAdapter() {

    }

    // // TODO Milestone 3: Calculate bill.
    private void btnCalculateListenerMethod() {

    }

    /**
     * The pipe list is already initialized. There is no need to revise this.
     */
    private void setPipeAdapter() {
        pipeTypes = new ArrayList<>();
        pipeTypes.add(new Pipe("Arad", 0.5));
        pipeTypes.add(new Pipe("Arad", 0.7));
        pipeTypes.add(new Pipe("Arad", 0.2));
        pipeTypes.add(new Pipe("Ace", 0.5));
        pipeTypes.add(new Pipe("Ace", 0.2));
        Spinner spPipe = findViewById(R.id.spPipe);
        pipeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pipeTypes);
        spPipe.setAdapter(pipeAdapter);
    }
}