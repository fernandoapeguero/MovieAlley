package com.example.nico.moviealley.Utils;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MovieNetworkUtils {

    public static final String TMDB_Base_URl = "https://api.themoviedb.org/3/movie";
    public static final String TMDB_IMAGE_URL = "https://image.tmdb.org/t/p/w185";

    public static final String PARAM_API_KEY = "api_key";
    public static final String TMDB_API_KEY = "";
    public static final String PARAM_SEARCH = "query";
    public static final String TMDB_SORT_POPULARITY = "popular";
    public static final String TMDB_SORT_HIGHEST_RATED = "top_rated" ;



    public static URL urlBuilder(String theMovieDbSearchTerm) {


            Uri uriBuilder = Uri.parse(TMDB_Base_URl).buildUpon()
                    .appendPath(TMDB_SORT_POPULARITY)
                    .appendQueryParameter(PARAM_API_KEY , TMDB_API_KEY).build();


            URL url = null;

            try{
                url = new URL( uriBuilder.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        return url;
    }


    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }


}
