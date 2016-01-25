package com.yalantis.flip.sample.FiveFilm;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yalantis.flip.sample.R;

/**
 * Created by kraft on 25.01.2016.
 */
public class FiveFilmsTrailer extends Fragment {
    public FiveFilmsTrailer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fivefilmstrailer_layout, container, false);
    }
}
