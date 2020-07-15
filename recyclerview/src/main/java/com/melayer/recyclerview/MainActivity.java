package com.melayer.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerViewModel vmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vmp = new ViewModelProvider(this).get(RecyclerViewModel.class);

//        List<WaData> list = new ArrayList<WaData>();
//        list.add(
//                new WaData(
//                        R.drawable.ic_android_black_24dp,
//                        "Android",
//                        "Hey Hi",
//                        "7.45 Am",
//                        3,
//                        true
//                )
//        );
//
//        list.add(
//                new WaData(
//                        R.drawable.ic_launcher_background,
//                        "Volume",
//                        "its okay",
//                        "8.00 Pm",
//                        45,
//                        false
//                )
//        );

        LinearLayoutManager mgr = new LinearLayoutManager(this);
        WaAdapter adapter = new WaAdapter(this, null);

        RecyclerView recLst = findViewById(R.id.waList);
        recLst.setLayoutManager(mgr);
        recLst.setAdapter(adapter);
    }
}
