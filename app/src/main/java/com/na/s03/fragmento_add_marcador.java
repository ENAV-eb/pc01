package com.na.s03;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.na.s03.entidades.Marcador;
import com.na.s03.modelo.DAOMarcador;
import com.na.s03.util.AlertDialogUtil;
import com.na.s03.util.Constantes;
import com.na.s03.util.HintAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmento_add_marcador#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmento_add_marcador extends Fragment {

    EditText txtNombre,txtModelo,txtLongitud,txtColor;
    Spinner spnMarca;
    Button btnGuardar;

    DAOMarcador daoMarcador;
    Marcador marcador;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmento_add_marcador() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_fragmento1.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmento_add_marcador newInstance(String param1, String param2) {
        fragmento_add_marcador fragment = new fragmento_add_marcador();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        daoMarcador = new DAOMarcador(getActivity());

        daoMarcador
                .openDB();


        return inflater.inflate(R.layout.fragment_add_marcador, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        // daoMarcador.openDB();
        //Hooks
        asignarRegerencias(view);

        //Llenar lista de marcas
        poblarSpinner();

        //Action guardar
        setBtnGuardarAction();



    }

    private void asignarRegerencias(View view) {

        spnMarca = view.findViewById(R.id.spnMarca);
        txtNombre = view.findViewById(R.id.txtNombre);
        txtModelo = view.findViewById(R.id.txtModelo);
        txtColor = view.findViewById(R.id.txtColor);
        txtLongitud = view.findViewById(R.id.txtLongitud);
        btnGuardar = view.findViewById(R.id.btnGuardar);

    }

    private void poblarSpinner(){

        String[] lista =  new String[]{"Artesco","Pilot","Mongol","Lego","Disney","Faber Castell","Selecciona una Marca ..."};

        HintAdapter hintAdapter = new HintAdapter(this.getContext(),android.R.layout.simple_list_item_1,lista);
        //hintAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnMarca.setAdapter(hintAdapter);
        spnMarca.setSelection(hintAdapter.getCount());

            /*
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.marca_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spnMarca.setAdapter(adapter);

         */
    }

    private void setBtnGuardarAction(){

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre,modelo,marca,color,longitud;

                nombre = txtNombre.getText().toString();
                modelo = txtModelo.getText().toString();
                marca = spnMarca.getSelectedItem().toString();
                color = txtColor.getText().toString();
                longitud = txtLongitud.getText().toString();

                marcador = new Marcador(nombre,marca,modelo,color,longitud);

                if(verificarNonNullNorEmpty(marcador)) {

                    daoMarcador.registrarMarcador(marcador);
                    abrirFragmento(new fragmento_listar_marcador());

                }

            }
        });

    }

    private boolean verificarNonNullNorEmpty(Marcador marcador){

        String[] stringVerificar = {marcador.getNombre(),marcador.getModelo(),
                marcador.getMarca(),marcador.getColor(),marcador.getLongitud()};
        int counter = 0;
        boolean indice = true;

        for (String s: stringVerificar) {
            if(s == null | s.trim().isEmpty()) {
                AlertDialogUtil.showAlertDialog(Constantes.MARCADOR_LABEL[counter],getContext());
                indice = false;
                break;
            }
            counter++;
        }

        return indice;
    }

    private void abrirFragmento(Fragment fragment){
        this.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }


}