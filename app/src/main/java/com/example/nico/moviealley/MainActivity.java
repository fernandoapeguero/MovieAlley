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

import com.example.nico.moviealley.Utils.MovieNetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecycleView ;
    MovieAdapter mAdapter;
    int numberOfColumns = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = findViewById(R.id.rv_layout);

        GridLayoutManager layoutManager = new GridLayoutManager(this , numberOfColumns);
         mRecycleView.setLayoutManager(layoutManager);

         mRecycleView.setHasFixedSize(true);
         mAdapter = new MovieAdapter("romo cono");

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

            }
            super.onPostExecute(s);
        }
    }

}
