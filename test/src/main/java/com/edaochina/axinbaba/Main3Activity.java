package com.edaochina.axinbaba;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;


public class Main3Activity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(i+"");
        }
        MyAdapter myAdapter=new MyAdapter(list);
        recyclerView.setAdapter(myAdapter);


        CoordinatorLayout.Behavior behavior;
        AppBarLayout.Behavior behavior1;

    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        private List<String> mList;

        public MyAdapter(List<String> list){
            this.mList=list;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(Main3Activity.this).inflate(R.layout.item_1,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mList.size();
        }


        class MyViewHolder extends RecyclerView.ViewHolder{

            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.tv);
            }
        }
    }
}
