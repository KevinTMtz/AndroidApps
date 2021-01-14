package com.kevintmtz.recyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ImageFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "firstName";
    private static final String ARG_PARAM2 = "lastName";

    private String firstName;
    private String lastName;

    public ImageFragment() {
        // Required empty public constructor
    }

    public static ImageFragment newInstance(String param1, String param2) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            firstName = getArguments().getString(ARG_PARAM1);
            lastName = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        TextView textView1 = view.findViewById(R.id.textView2);
        TextView textView2 = view.findViewById(R.id.textView3);

        textView1.setText(firstName);
        textView2.setText(lastName);

        return view;
    }

    public void Greet(String greet) {
        Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
    }
}