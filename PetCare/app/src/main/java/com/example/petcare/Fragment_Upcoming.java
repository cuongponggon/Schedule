package com.example.petcare;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Fragment_Upcoming extends Fragment {

    LinearLayout primaryItem;
    Button btn_continue, btn_cancel;
    Animation fade, zoom_out, zoom_in;
    FloatingActionButton btn_add;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);


        //define
        primaryItem = (LinearLayout) view.findViewById(R.id.primaryItem);
        btn_continue = (Button) view.findViewById(R.id.btn_continue);
        btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
        btn_add = (FloatingActionButton) view.findViewById(R.id.btn_add);

        //load_animation
        fade = AnimationUtils.loadAnimation(getActivity(), R.anim.fade);
        zoom_out = AnimationUtils.loadAnimation(getActivity(),R.anim.zoom_out);
        zoom_in = AnimationUtils.loadAnimation(getActivity(),R.anim.zoom_in);

        //set alpha
        btn_continue.setAlpha(0);
        btn_cancel.setAlpha(0);
//
//        //action
        primaryItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primaryItem.setBackground(getActivity().getDrawable(R.drawable.bg_item_selected));
                btn_continue.setAlpha(1);
                btn_cancel.setAlpha(1);
                btn_continue.startAnimation(fade);
                btn_cancel.startAnimation(fade);
                btn_add.startAnimation(zoom_out);
            }
        });
//
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primaryItem.setBackground(getActivity().getDrawable(R.drawable.bg_item));
                btn_continue.setAlpha(0);
                btn_cancel.setAlpha(0);
                btn_add.startAnimation(zoom_in);
            }
        });


        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ViewDetailActivity.class);
                startActivity(intent);
            }
        });


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddSchedule.class);
                startActivity(intent);
            }
        });



        return view;
    }

}
