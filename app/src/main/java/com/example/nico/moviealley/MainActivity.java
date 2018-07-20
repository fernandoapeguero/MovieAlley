package com.example.nico.moviealley;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nico.moviealley.JsonData.JsonData;
import com.example.nico.moviealley.Utils.MovieNetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecycleView ;
    MovieAdapter mAdapter;
    int numberOfColumns = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48"};
        mRecycleView = findViewById(R.id.rv_layout);

        GridLayoutManager layoutManager = new GridLayoutManager(this , numberOfColumns);
         mRecycleView.setLayoutManager(layoutManager);

         mAdapter = new MovieAdapter(data);

         mRecycleView.setAdapter(mAdapter);


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
                Toast.makeText(MainActivity.this, "Yeah Json is here", Toast.LENGTH_SHORT).show();
                JsonData.jsonParse(s);

            }
            super.onPostExecute(s);
        }
    }

}
