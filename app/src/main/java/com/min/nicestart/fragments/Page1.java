package com.min.nicestart.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.min.nicestart.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Page1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Page1 extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page1, container, false);
    }
}