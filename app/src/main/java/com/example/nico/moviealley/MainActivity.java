package com.example.nico.moviealley;

import android.annotation.SuppressLint;
import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView placeholder;
    TextView jsonHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeholder = findViewById(R.id.pladeholder);
        jsonHolder = findViewById(R.id.json_tv_holder);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_show_url){

            displayUrl();
        }

        return super.onOptionsItemSelected(item);
    }





    public void displayUrl(){

        URL tmdb_url = MovieNetworkUtils.urlBuilder("deadpool");
        placeholder.setText(tmdb_url.toString());
        new MovieTask().execute(tmdb_url);


    }


    @SuppressLint("StaticFieldLeak")
    class MovieTask extends AsyncTask<URL, Void , String>{

        @Override
        protected String doInBackground(URL... urls) {

            URL movieUrl = urls[0];

            String jsonResults = null;

            try{

                jsonResults = MovieNetworkUtils.getResponseFromHttpUrl(movieUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }


            return jsonResults;
        }


        @Override
        protected void onPostExecute(String s) {
            if(s != null && !s.equals("")){
                jsonHolder.setText(s);
            }
            super.onPostExecute(s);
        }
    }

}
