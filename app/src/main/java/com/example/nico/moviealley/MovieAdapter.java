package com.example.nico.moviealley;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MovieAdapter extends  RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder>{

    String sometext ;

    public MovieAdapter(String text){
        sometext = text;
    }


    @NonNull
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context content  = parent.getContext();
        int idForLayoutInflater = R.layout.movie_item_list;
        LayoutInflater inflater = LayoutInflater.from(content);
        boolean shouldAttachToParent = false;

        View view = inflater.inflate(idForLayoutInflater , parent , shouldAttachToParent);
        MovieAdapterViewHolder viewHolder = new MovieAdapterViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapterViewHolder holder, int position) {
        holder.movieTitle.setText(sometext);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MovieAdapterViewHolder extends RecyclerView.ViewHolder{

         TextView movieTitle;
        public MovieAdapterViewHolder(View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.movie_title);
        }
    }

}
