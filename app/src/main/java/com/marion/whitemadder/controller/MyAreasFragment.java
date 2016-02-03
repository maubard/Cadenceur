package com.marion.whitemadder.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marion.whitemadder.R;

/**
 * Created by marion on 30/01/16.
 */
public class MyAreasFragment extends Fragment {

    public MyAreasFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_myareas, container, false);
        return view;
    }
}
