package com.example.administrator.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.base.scanlistlibrary.base.ScanBaseRecyclerViewAdapter;
import com.base.scanlistlibrary.base.ScanRecyclerViewHolder;
import com.base.scanlistlibrary.scanlist.ScanVideoPlayView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private ScanVideoPlayView scanView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        scanView = findViewById(R.id.scanView);

        List<Object> list = new ArrayList<>();
        for (int i=0;i<10;i++) {
            list.add(i);
        }


        TestAdapter testAdapter = new TestAdapter(this,list,R.layout.item_list_view);
        scanView.initPlayListView(testAdapter,false);
        scanView.setOnRefresh(false);
    }

    class TestAdapter extends ScanBaseRecyclerViewAdapter{


        public TestAdapter(Context context, List data, int layoutId) {
            super(context, data, layoutId);
        }

        @Override
        protected void onBindData(ScanRecyclerViewHolder holder, Object bean, int position) {

        }
    }
}
