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


      String getmMovieTitle(){
          return mMovieTitle;
      }

      String getmMovieImage(){
          return mMovieImage;
      }

      String getmMovieSipnosis(){
          return mMovieSipnosis;
      }

      int getmMovieRating(){
          return mMovieRating;
      }

      String getMreleaseDate(){
          return mreleaseDate;
      }

}
