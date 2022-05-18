//TALLER N°17 | BRANDOOL CORTEZ [3-742-294] | 1SF141
package com.example.taller_n18_fragments_datos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class fragment_primero extends Fragment {

    private EditText et1;
    private Button btn1, btn2;
    private TextView tv1;

    public fragment_primero() {
        // Required empty public constructor
    }

    public static fragment_primero newInstance(String param1, String param2) {
        fragment_primero fragment = new fragment_primero();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primero, container, false);
        et1 = view.findViewById(R.id.et1);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1 = getActivity().findViewById(R.id.tv1);
                tv1.setText(et1.getText().toString());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et1.setText("");
                tv1.setText("");
            }
        });

        return view;
    }
}