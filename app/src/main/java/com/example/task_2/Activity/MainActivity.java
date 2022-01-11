package com.example.task_2.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.task_2.Adapter.RecyclerAdapter;
import com.example.task_2.Model.Member;
import com.example.task_2.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews(){
        context =this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

        ArrayList<Member> members = new ArrayList<>();

        for (int i=0;i<=20;i++){
            if(i == 0 ||i == 5 || i == 10 || i == 15 || i == 20) {
                members.add(new Member(R.mipmap.ic_profile, "Yahya " + i, "Mahmudiy " + i, false));
            }else {
                members.add(new Member(R.mipmap.ic_profile, "Yahya " + i, "Mahmudiy " + i, true));
            }
        }

        refreshAdapter(members);
    }

    void refreshAdapter(ArrayList<Member> members){
        RecyclerAdapter adapter = new RecyclerAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
}