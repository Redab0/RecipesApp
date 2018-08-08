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

public class MainCategoriesAdapter extends RecyclerView.Adapter<MainCategoriesAdapter.ViewHolder> {



    Context context;
    List<String> categories;


    public MainCategoriesAdapter(Context context, List<String> myDataSet) {
        this.context = context;
        this.categories = myDataSet;

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
    public MainCategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_categories_item, parent,false);
        return new MainCategoriesAdapter.ViewHolder(view, context, categories);




    }

    @Override
    public void onBindViewHolder(@NonNull MainCategoriesAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

                holder.title.setText(categories.get(position));


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView title;
        Context context;
        List<String> categories;

        public ViewHolder(View itemView, Context context, List<String> categories) {
            super(itemView);

            this.context = context;
            this.categories = categories;



            itemView.setOnClickListener(this);
            itemView.setClickable(true);


            title = itemView.findViewById(R.id.catText);



        }


        public void onClick(View view) {

//            String t = mDataset.get(getLayoutPosition()).getTitle();
//
//
//
//            for (int i = 0; i < mDataset.size(); i++){
//
//                String titleS = mDataset.get(i).getTitle();
//
//                if(t.equals(titleS)){
//
//                    String title = mDataset.get(i).getTitle();
//                    String ingredients = mDataset.get(i).getIngredients();
//                    String directions = mDataset.get(i).getDesc();
//
//                    bundle.putString("t", title);
//                    bundle.putString("i", ingredients);
//                    bundle.putString("d", directions);
//
//                }
//
//            }


            MainActivity mainActivity = (MainActivity) view.getContext();
            CommonRecipesFragment commonRecipesFragment = new CommonRecipesFragment();



            mainActivity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,commonRecipesFragment ).addToBackStack(null).commit();


        }



    }

}
