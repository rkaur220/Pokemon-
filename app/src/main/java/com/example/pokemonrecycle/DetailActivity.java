package com.example.pokemonrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    String desc;
    String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView =  findViewById(R.id.image);
        textView =  findViewById(R.id.description);

        desc = getIntent().getStringExtra("description");
       image = getIntent().getStringExtra("image");


        textView.setText(desc);
        imageView.setImageURI(Uri.parse(getIntent().getStringExtra("image")));

        try {
            Picasso.get().load(image).error(R.drawable.ic_face).into(imageView);
        } catch (Exception e) {
            Picasso.get().load(R.drawable.ic_face).error(R.drawable.ic_face).into(imageView);
        }



    }
}
