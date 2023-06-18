package com.example.i200902;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.Objects;


public class register_fragment extends Fragment {

    public register_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View views= inflater.inflate(R.layout.fragment_register_fragment, container, false);

        Button register=views.findViewById(R.id.signup_btn);

        //gender buttons
        ImageButton gender_women_btn=(ImageButton)(views.findViewById(R.id.gender_women));
        ImageButton gender_men_btn=(ImageButton)(views.findViewById(R.id.gender_men));
        ImageButton other_gender_btn=(ImageButton)(views.findViewById(R.id.gender_other));


        register.setOnClickListener(view->{
            Intent send_to_main_activity= new Intent(getActivity(), main_page.class);
            startActivity(send_to_main_activity);
            getActivity().finish();
        });

        gender_men_btn.setOnClickListener(view->{
           //set background of gender_men_button to drawable gender_selected_shape
            //chech if background is alredy selected shape then change it to selector shape
//            if(flag==1) return;
            if (Objects.equals(view.getBackground().getConstantState(), getActivity().getResources().getDrawable(R.drawable.gender_selector_shape).getConstantState())) {
                // Do what you have to do...
                gender_men_btn.setBackgroundResource(R.drawable.gender_selected_shape);
                gender_women_btn.setBackgroundResource(R.drawable.gender_selector_shape);
                other_gender_btn.setBackgroundResource(R.drawable.gender_selector_shape);


            }

        });
        gender_women_btn.setOnClickListener(view->{
           //set background of gender_men_button to drawable gender_selected_shape
//            if(flag==1)return;
            if (Objects.equals(view.getBackground().getConstantState(), getActivity().getResources().getDrawable(R.drawable.gender_selector_shape).getConstantState())) {
                // Do what you have to do...
                gender_men_btn.setBackgroundResource(R.drawable.gender_selector_shape);
                gender_women_btn.setBackgroundResource(R.drawable.gender_selected_shape);
                other_gender_btn.setBackgroundResource(R.drawable.gender_selector_shape);
            }

        });
        other_gender_btn.setOnClickListener(view->{
           //set background of gender_men_button to drawable gender_selected_shape
//            if(flag==1)return;
            if (Objects.equals(view.getBackground().getConstantState(), getActivity().getResources().getDrawable(R.drawable.gender_selector_shape).getConstantState())) {
                // Do what you have to do...
                gender_men_btn.setBackgroundResource(R.drawable.gender_selector_shape);
                gender_women_btn.setBackgroundResource(R.drawable.gender_selector_shape);
                other_gender_btn.setBackgroundResource(R.drawable.gender_selected_shape);

            }
        });
        return  views;
    }
}