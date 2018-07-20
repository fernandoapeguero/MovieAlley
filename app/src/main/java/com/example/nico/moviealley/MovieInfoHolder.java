package com.example.nico.moviealley;

public class MovieInfoHolder {

      String mMovieTitle ;
      String mMovieImage ;
      String mMovieSipnosis;
      int mMovieRating ;
      String mreleaseDate;

      public MovieInfoHolder(String movieTitle, String movieImage, String movieSipnosis , int movieRating , String releaseDate){

          mMovieTitle = movieTitle;
          mMovieImage = movieImage;
          mMovieSipnosis = movieSipnosis;
          mMovieRating = movieRating;
          mreleaseDate = releaseDate;

      }


     public String getmMovieTitle(){
          return mMovieTitle;
      }

     public String getmMovieImage(){
          return mMovieImage;
      }

     public   String getmMovieSipnosis(){
          return mMovieSipnosis;
      }

     public int getmMovieRating(){
          return mMovieRating;
      }

     public String getMreleaseDate(){
          return mreleaseDate;
      }

}
