package com.example.proyecto2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class principal extends Fragment {

    Button botonLimpiar, botonEnviar;
    TextView textViewFragmentNombre, textViewFragmentApellido;
    EditText inputNombre, inputApellido;

    public principal() {}

    public static principal newInstance(String param1, String param2) {
        principal fragment = new principal();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_principal, container, false);

        botonEnviar = view.findViewById(R.id.botonEnviar);
        botonLimpiar = view.findViewById(R.id.botonLimpiar);
        inputNombre = view.findViewById(R.id.editTextNombre);
        inputApellido = view.findViewById(R.id.editTextApellido);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputNombre.getText().toString().equals("") || inputApellido.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "El nombre o el apellido no pueden ir vacios", Toast.LENGTH_SHORT).show();
                    return;
                }

                textViewFragmentNombre = getActivity().findViewById(R.id.textViewFragmentNombre);
                textViewFragmentNombre.setText(inputNombre.getText().toString());
                textViewFragmentApellido = getActivity().findViewById(R.id.textViewFragmentApellido);
                textViewFragmentApellido.setText(inputApellido.getText().toString());
            }
        });

        botonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNombre.setText("");
                inputApellido.setText("");
                textViewFragmentNombre = getActivity().findViewById(R.id.textViewFragmentNombre);
                textViewFragmentNombre.setText("Nombre Ingresado");
                textViewFragmentApellido = getActivity().findViewById(R.id.textViewFragmentApellido);
                textViewFragmentApellido.setText("Apellido Ingresado");
            }
        });

        return view;
    }
}