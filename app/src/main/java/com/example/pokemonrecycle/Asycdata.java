package com.example.pokemonrecycle;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.ProgressBar;

public class Asycdata extends AsyncTask<String, Void, String> {


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }

    @Override
    protected String doInBackground(String... strings) {



        String jsonurl = strings[0];

        Httphandler sh = new Httphandler();

        String json = sh.makeServiceCall(jsonurl);
        System.out.println("This is Json :"+json);

        return json;
    }
}
