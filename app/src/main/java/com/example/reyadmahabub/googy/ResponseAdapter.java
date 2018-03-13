package com.example.reyadmahabub.googy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ReyadMahabub on 3/12/2018.
 */

public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ResponseViewHolder> {
    private Context context;
    private List<Response>responses;
    private int lastPosition=0;

    public ResponseAdapter(Context context, List<Response> responses) {
        this.context = context;
        this.responses = responses;
    }

    @Override
    public ResponseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from( context );
        View view =inflater.inflate( R.layout.curstom_row_rv,null,false );
        return new ResponseViewHolder( view );
    }

    @Override
    public void onBindViewHolder(ResponseViewHolder holder, int position) {
        holder.titleTV.setText( responses.get( position ).getTitle() );
        setAnimation(holder.itemView,position);

    }

    private void setAnimation(View itemView, int position) {
        if (position>lastPosition){
            Animation animation= AnimationUtils.loadAnimation( context,android.R.anim.slide_in_left );
            itemView.startAnimation( animation );

        }else {
            Animation animation= AnimationUtils.loadAnimation( context,android.R.anim.slide_in_left );
            itemView.startAnimation( animation );

        }
        lastPosition=position;
    }

    @Override
    public int getItemCount() {
        return responses.size();
    }

    public class ResponseViewHolder extends RecyclerView.ViewHolder{
        TextView titleTV;

        public ResponseViewHolder(View itemView) {
            super( itemView );
            titleTV=itemView.findViewById( R.id.title );
            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    Toast.makeText( context, ""+responses.get( position ).getId(), Toast.LENGTH_SHORT ).show();
                }
            } );

        }
    }
}
