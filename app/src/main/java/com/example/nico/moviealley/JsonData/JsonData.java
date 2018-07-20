package com.example.nico.moviealley.JsonData;

import com.example.nico.moviealley.MovieInfoHolder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonData {



    public static MovieInfoHolder jsonParse(String data) {

        JSONObject jsonMainObject;
        String movieTitle = "";
        String moviePoster = "";
        String movieSypnosis = "";
        int movieRating = 0;
        String releaseDate = "";

        try{

            jsonMainObject = new JSONObject(data);
            JSONArray results = jsonMainObject.getJSONArray("results");
            for (int i = 0; i < results.length(); i++){
                JSONObject movie = results.getJSONObject(i);
                movieTitle = movie.getString("original_title");
                moviePoster = movie.getString("backdrop_path");
                movieSypnosis = movie.getString("overview");
                releaseDate = movie.getString("release_date");

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new MovieInfoHolder(movieTitle , moviePoster , movieSypnosis , movieRating , releaseDate);


    }


}
