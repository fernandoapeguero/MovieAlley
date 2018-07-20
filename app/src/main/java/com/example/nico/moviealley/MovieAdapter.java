package com.example.nico.moviealley;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nico.moviealley.Utils.MovieNetworkUtils;
import com.squareup.picasso.Picasso;

public class MovieAdapter extends  RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder>{

    String[] mData ;

    public MovieAdapter(String[] data){

        this.mData = data;
    }


    @NonNull
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context content  = parent.getContext();
        int idForLayoutInflater = R.layout.movie_item_list;
        LayoutInflater inflater = LayoutInflater.from(content);
        boolean shouldAttachToParent = false;

        View view = inflater.inflate(idForLayoutInflater , parent , shouldAttachToParent );
        MovieAdapterViewHolder viewHolder = new MovieAdapterViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapterViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    class MovieAdapterViewHolder extends RecyclerView.ViewHolder{

         TextView moviePoster;
        public MovieAdapterViewHolder(View itemView) {
            super(itemView);
            moviePoster = itemView.findViewById(R.id.movie_poster);
        }
    }

}
