package com.na.s03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.na.s03.entidades.Marcador;
import com.na.s03.modelo.DAOMarcador;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmento_listar_marcador #newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmento_listar_marcador extends Fragment {


    RecyclerView recyclerView;
    DAOMarcador daoMarcador;
    private ArrayList<Marcador> lista = new ArrayList<>();
    MarcadorListaAdapter marcadorListaAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmento_listar_marcador() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmento2.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmento_listar_marcador newInstance(String param1, String param2) {
        fragmento_listar_marcador fragment = new fragmento_listar_marcador();
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
        return inflater.inflate(R.layout.fragment_lista_marcador, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        asignarReferencias(view);

        listarMarcadores();

    }

    private void asignarReferencias(View view){
        recyclerView = view.findViewById(R.id.recyclerView);
    }

    private void listarMarcadores(){
        lista = daoMarcador.getAllMarcadores();
        marcadorListaAdapter = new MarcadorListaAdapter(this.getContext(),lista);
        recyclerView.setAdapter(marcadorListaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }
}