package com.example.toolbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class new_group_Fragment extends Fragment
{
    View rootview;

    RecyclerView recyclerView;
    ArrayList<String> arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        rootview = inflater.inflate(R.layout.fragment_new_group_, container, false);
        RecyclerView recyclerView = rootview.findViewById(R.id.recycler);

        ArrayList<recycler_model>recyclerModelArrayList = new ArrayList<recycler_model>();
        recyclerModelArrayList.add(new recycler_model(R.drawable.recycler_img,"Oriflame","Oriflame company"));
        recyclerModelArrayList.add(new recycler_model(R.drawable.recycler_img,"Business","Business activities"));
        recyclerModelArrayList.add(new recycler_model(R.drawable.recycler_img,"GPTC Muttom","Diploma"));
        recyclerModelArrayList.add(new recycler_model(R.drawable.recycler_img,"HGCGHSS","Plus two"));
        recyclerModelArrayList.add(new recycler_model(R.drawable.recycler_img,"National High School","SSLC"));
        recyclerModelArrayList.add(new recycler_model(R.drawable.recycler_img,"NAV","Best frds"));
        recyclerModelArrayList.add(new recycler_model(R.drawable.recycler_img,"FFF","Fitness"));
        recyclerModelArrayList.add(new recycler_model(R.drawable.recycler_img,"Music zone","Songs space"));
        recyclerModelArrayList.add(new recycler_model(R.drawable.recycler_img,"Gtec","Students"));





        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getActivity(),recyclerModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        return rootview;
    }
}