package com.example.flagapp2.data;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flagapp2.R;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String name;

    private String capital;

    private int images;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(Country.countries[i].getName());
        viewHolder.itemDetail.setText(Country.countries[i].getCapital());
        String uri = Country.countries[i].getImgUri();
        Context c = viewHolder.itemImage.getContext();
        viewHolder.itemImage.setImageDrawable(c.getResources().getDrawable(c.getResources().getIdentifier (uri, null , c.getPackageName())));
        //viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return Country.countries.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;

        ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            int position = getAdapterPosition();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                    int position = getAdapterPosition();
                    /* Snackbar.make(v, "Click detected on chapter " + (position+1),
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                     */
                    //// Implementation with bundle
                    // Bundle bundle = new Bundle();
                    // bundle.putInt("numChapter", position);
                    // Navigation.findNavController(v).navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);

                    //FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
                    //action.setKeyChapterId(position);
                    //Navigation.findNavController(v).navigate(action);
                }
            });

        }
    }

}