package com.example.shivam.learningfragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwomain extends Fragment{
    TextView textView;
    public FragmentTwomain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_twomain, container, false);
        textView =(TextView)view.findViewById(R.id.text_box_my);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView.setText("testing");
        Log.e("From Secong Fragment : ","testing");

    }
}
