package com.na.s03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.na.s03.modelo.DAOMarcador;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmento_modify_marcador #newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmento_modify_marcador extends Fragment {

    DAOMarcador daoMarcador;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmento_modify_marcador() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmento3.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmento_modify_marcador newInstance(String param1, String param2) {
        fragmento_modify_marcador fragment = new fragmento_modify_marcador();
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
        daoMarcador.clearDB();

        return inflater.inflate(R.layout.fragment_fragmento3, container, false);
    }
}