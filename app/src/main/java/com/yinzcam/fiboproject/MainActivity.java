package com.yinzcam.fiboproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SeekBar;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    private RecyclerView recyclerView;
    private AmeyaAdapter adapter;
    private SeekBar seekBar;
    int progressVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.drawerList);
        adapter = new AmeyaAdapter(this, generateFibonacciNumbers());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(this);
    }


    public static List<FiboNumber> generateFibonacciNumbers () {
        List<FiboNumber> data = new ArrayList<>();
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        BigInteger c;
        FiboNumber current = new FiboNumber();
        current.id = 1;
        current.number = Integer.toString(1);
        data.add(current);
        current = new FiboNumber();
        current.id = 2;
        current.number = Integer.toString(1);
        data.add(current);

        for (int i = 3; i < 1001; i++){
            current = new FiboNumber();
            current.id = i;
            c = a.add(b);
            a = b;
            b = c;
            current.number = c.toString();
            data.add(current);
        }
        return data;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        progressVal = progress;
        recyclerView.scrollToPosition(progress * 10);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        recyclerView.scrollToPosition(progressVal * 10);
    }
}
