package com.example.bader.recihelp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommonDetailsFragment extends Fragment {

    String title, ingredienst, details;
    TextView titleV, ingredientsV, detailsV;



    public CommonDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this mainFragment
        View v = inflater.inflate(R.layout.fragment_common_details, container, false);

        titleV = (TextView) v.findViewById(R.id.recipeTitle);
        ingredientsV = (TextView) v.findViewById(R.id.ingredientsList);
        detailsV = (TextView) v.findViewById(R.id.directions);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            title = bundle.getString("t");
            ingredienst = bundle.getString("i");
            details = bundle.getString("d");
        }

        titleV.setText(title);
        ingredientsV.setText(ingredienst);
        detailsV.setText(details);


        return v;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
