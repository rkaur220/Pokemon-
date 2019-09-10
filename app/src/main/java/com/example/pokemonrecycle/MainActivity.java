package com.example.pokemonrecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    ArrayList<Pokemon> pokelst;
    Poekrecyadapter adapter;

    String img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokelst = new ArrayList<>();
        //String link = "https://api.myjson.com/bins/8aje7";
        String link = "https://next.json-generator.com/api/json/get/E14trR2lD";
        try {
            String data = new Asycdata().execute(link).get();
            System.out.println("This is from Main Activity :"+data);


            JSONObject mainobj = new JSONObject(data);
            JSONArray pokearray = mainobj.getJSONArray("Pokemon");

            for (int i=0;i<pokearray.length();i++)
            {
                JSONObject child = pokearray.getJSONObject(i);

                 img = child.getString("image");
                String name = child.getString("name");
                String type = child.getString("type");
                String ability = child.getString("ability");
                String height = child.getString("height");
                String weight = child.getString("weight");
                String desc = child.getString("description");

                String keyname = child.toString();


                pokelst.add(new Pokemon(name,img,type,ability,height,weight,desc));
            }

                adapter = new Poekrecyadapter(pokelst,getApplication());
                initView();


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public void initView()
    {
        @SuppressLint("WrongConstant") LinearLayoutManager linearLayout = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView = findViewById(R.id.recycle_poke);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListner(onItemclclickpoke);
    }

    public View.OnClickListener onItemclclickpoke = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();

            Intent intent = new Intent(MainActivity.this, Main2Activity.class);

            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            //Bitmap.compress(Bitmap.CompressFormat.PNG,50,bs);
            intent.putExtra("image", pokelst.get(position).getImage());
            intent.putExtra("description", pokelst.get(position).getDesc());

            startActivity(intent);


        }
    };
}
