package com.tolet.sajib.todolist;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Today extends Fragment {
private LinearLayout linearLayout;

    public Today() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_today, container, false);
        linearLayout=view.findViewById(R.id.addtask);
        linearLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getActivity(),TaskActivity.class);
               startActivity(intent);
               //Toast.makeText(getContext(), "hi", Toast.LENGTH_SHORT).show();
           }
       });

        return view;
    }

}
