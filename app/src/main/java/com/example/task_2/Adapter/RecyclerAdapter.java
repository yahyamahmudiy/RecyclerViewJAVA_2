package com.example.task_2.Adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.task_2.Model.Member;
import com.example.task_2.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_AVIALABLE_YES = 0;
    private static final int TYPE_AVIALABLE_NOT = 1;

    Context context;
    ArrayList<Member> members;

    public RecyclerAdapter(Context context, ArrayList<Member> members){
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {

        if(members.get(position).isAvialable()){
            return TYPE_AVIALABLE_YES;
        }
        return TYPE_AVIALABLE_NOT;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


         if(viewType == TYPE_AVIALABLE_YES) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_yes, parent, false);
            return new MemberViewYesHolder(view);
        }else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_no, parent, false);
            return new MemberViewNoHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);

        if(holder instanceof MemberViewYesHolder){
            ImageView iv_profile = ((MemberViewYesHolder)holder).iv_profile;
            TextView tv_name = ((MemberViewYesHolder)holder).tv_name;
            TextView tv_surname = ((MemberViewYesHolder)holder).tv_surname;

            iv_profile.setImageResource(member.getProfile());
            tv_name.setText(member.getName());
            tv_surname.setText(member.getSurname());
        }
        if(holder instanceof MemberViewNoHolder){
            ImageView iv_profile = ((MemberViewNoHolder)holder).iv_profile;
            TextView tv_name = ((MemberViewNoHolder)holder).tv_name;
            TextView tv_surname = ((MemberViewNoHolder)holder).tv_surname;

            iv_profile.setImageResource(member.getProfile());
            tv_name.setText("Not Avialable");
            tv_surname.setText("Not Avialable");
        }
    }



    public class MemberViewYesHolder extends RecyclerView.ViewHolder{
        public View view;
        public ImageView iv_profile;
        public TextView tv_name;
        public TextView tv_surname;

        public MemberViewYesHolder(View v){
            super(v);
            this.view = v;

            iv_profile = view.findViewById(R.id.iv_profile);
            tv_name = view.findViewById(R.id.tv_name);
            tv_surname = view.findViewById(R.id.tv_surname);
        }
    }
    public class MemberViewNoHolder extends RecyclerView.ViewHolder{
        public View view;
        public ImageView iv_profile;
        public TextView tv_name;
        public TextView tv_surname;

        public MemberViewNoHolder(View v){
            super(v);
            this.view = v;

            iv_profile = view.findViewById(R.id.iv_profile);
            tv_name = view.findViewById(R.id.tv_name);
            tv_surname = view.findViewById(R.id.tv_surname);
        }
    }

}