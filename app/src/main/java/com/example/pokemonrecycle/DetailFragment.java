package com.example.pokemonrecycle;


import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class DetailFragment extends Fragment {

    ImageView imageView;
    TextView textView;
    String desc;
    String image;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        imageView = view.findViewById(R.id.image);
        textView = view.findViewById(R.id.description);

        Bundle b3 = getArguments();
        desc = b3.getString("description");
        image = b3.getString("image");

        imageView.setImageURI(Uri.parse(image));
        textView.setText(desc);

        return view;
    }
}
