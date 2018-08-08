package com.example.bader.recihelp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder>{

    List<MainListModel> recipes;
    List<String> categories;
    Context context;
    String listName;
    int id;

    public MainListAdapter(List<MainListModel> myDataset, int itemLayout, Context context) {
        this.recipes = myDataset;
        this.context = context;
        this.id = itemLayout;

    }

    public MainListAdapter(List<String> categories, Context context, int itemLayout){
        this.categories = categories;
        this.context = context;
        this.id = itemLayout;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @NonNull
    @Override
    public MainListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(id, parent,false);
        return new ViewHolder(view, recipes, context, categories, id);




    }




    public static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView title, diff, time;
        List<MainListModel> mDataset;
        List<String> categories;
        Bundle bundle = new Bundle();
        Context context;

        public ViewHolder(View itemView, List<MainListModel> mDataset, Context context, List<String> categories, int id) {
            super(itemView);
            this.mDataset = mDataset;
            this.context = context;
            this.categories = categories;



            itemView.setOnClickListener(this);
            itemView.setClickable(true);



            title = itemView.findViewById(R.id.textView);
            diff =  itemView.findViewById(R.id.diff_level);
            time =  itemView.findViewById(R.id.time);


        }


        public void onClick(View view) {

            String t = mDataset.get(getLayoutPosition()).getTitle();



            for (int i = 0; i < mDataset.size(); i++){

                String titleS = mDataset.get(i).getTitle();

                if(t.equals(titleS)){

                    String title = mDataset.get(i).getTitle();
                    String ingredients = mDataset.get(i).getIngredients();
                    String directions = mDataset.get(i).getDesc();

                    bundle.putString("t", title);
                    bundle.putString("i", ingredients);
                    bundle.putString("d", directions);

                }

            }


            MainActivity mainActivity = (MainActivity) view.getContext();
            CommonDetailsFragment commonDetailsFragment = new CommonDetailsFragment();
            commonDetailsFragment.setArguments(bundle);


            mainActivity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, commonDetailsFragment).addToBackStack(null).commit();









        }



    }


    @Override
    public void onBindViewHolder(@NonNull MainListAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element


        if(recipes == null) {
            holder.title.setText(recipes.get(position).title);
            holder.diff.setText(recipes.get(position).difficultyLevel);
            holder.time.setText(recipes.get(position).time);
        } else {
            holder.title.setText(recipes.get(position).title);
        }



    }

    @Override
    public int getItemCount() {
        int x;

        if(recipes == null){

           x = categories.size();
        }else
           x = recipes.size();

        return x;

    }








    }


