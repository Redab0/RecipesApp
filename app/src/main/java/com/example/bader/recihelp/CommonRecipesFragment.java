package com.example.bader.recihelp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CommonRecipesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CommonRecipesFragment extends Fragment {

    RadioGroup searchByGroup;
    RadioButton nameRadioButton, ingredientRadioButton;
    RadioButton easyRadioButton, mediumRadioButton, hardRadioButton;
    LinearLayout filterLayout;
    android.support.v7.widget.SearchView searchBox;
    String fDifficulty;
    ImageView showFilterButton, closeFilterButton;
    ListsClass listsClass;
    private OnFragmentInteractionListener mListener;
    String listName;
    String ingredients;
    RecyclerView listsRecyclerView;
    MainListAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManger;
    List<MainListModel> recipes = new ArrayList<>();
    List<String> categories = new ArrayList<>();

    String [] parent;
    String hint;

    public CommonRecipesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_common_recipes, container, false);
        listsClass = new ListsClass();

        showFilterButton = v.findViewById(R.id.showFilter);
        searchBox = v.findViewById(R.id.search_box);
        searchBox.setFocusable(false);


        closeFilterButton = v.findViewById(R.id.closeFilter);
        filterLayout = v.findViewById(R.id.filterLayout);

        searchByGroup = v.findViewById(R.id.search_category_group);
        nameRadioButton = v.findViewById(R.id.name_category);
        ingredientRadioButton = v.findViewById(R.id.ingredient_category);


        easyRadioButton = v.findViewById(R.id.difficulty_easy);
        mediumRadioButton = v.findViewById(R.id.difficulty_medium);
        hardRadioButton = v.findViewById(R.id.difficulty_hard);

//            mAdapter = new MainListAdapter(categories, getContext(),R.layout.main_categories_item );
            listsRecyclerView.setLayoutManager(mLayoutManger);
            mLayoutManger = new LinearLayoutManager(getContext());
            listsRecyclerView.setHasFixedSize(true);

            listsRecyclerView.setAdapter(mAdapter);
            mAdapter = new MainListAdapter(recipes, R.layout.mainlist_item ,getContext() );

             listsRecyclerView = v.findViewById(R.id.listsRecyclerView);



        showFilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterLayout.setVisibility(View.VISIBLE);
                showFilterButton.setVisibility(View.INVISIBLE);
            }
        });

        closeFilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterLayout.setVisibility(View.GONE);
                showFilterButton.setVisibility(View.VISIBLE);
            }
        });


        easyRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fDifficulty = "easy";
                getListByDifficulty(fDifficulty, listName);
            }
        });

        mediumRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fDifficulty = "medium";
                getListByDifficulty(fDifficulty, listName);
            }
        });

        hardRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fDifficulty = "hard";
                getListByDifficulty(fDifficulty, listName);
            }
        });

        searchByGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.name_category:
                        getSearchBoxCategory("name");
                        break;
                    case R.id.ingredient_category:
                        getSearchBoxCategory("ingredient");
                        break;
                }
            }
        });


        searchBox.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = searchBox.getQuery().toString();
                if (!newText.isEmpty())
                    recipes.clear();
                recipes.addAll(listsClass.getIngredientList(newText, listName));
                mAdapter.notifyDataSetChanged();


                return true;
            }
        });




        return v;



    }


    public void getRecipes(String category) {

        switch (category){
            case ("Salad"):
                recipes.addAll(ListsClass.getSaladList());
                listName = "salad";
                mAdapter.notifyDataSetChanged();
                break;
            case ("Desert"):
                recipes.clear();
                recipes.addAll(ListsClass.getDesertList());
                listName = "desert";
                mAdapter.notifyDataSetChanged();
                break;
            case ("Sandwich"):
                recipes.clear();
                recipes.addAll(listsClass.getSandwichesList());
                listName = "sandwiches";
                mAdapter.notifyDataSetChanged();
                break;
            case ("Main"):
                categories.clear();
                categories.addAll(ListsClass.getCategories());
                listName = "mainList";
                mAdapter.notifyDataSetChanged();
                break;
            case ("MainDishes"):
                recipes.clear();
                recipes.addAll(listsClass.getMainDishList());
                listName = "mianDishes";
                mAdapter.notifyDataSetChanged();
                break;
        }

    }

    public void  getSearchBoxCategory(String searchBy){
        switch (searchBy){
            case "name":
                searchBox.setQueryHint("إسم الطبق");
                break;
            case "ingredient":
                searchBox.setQueryHint("أدخل المكوانات بينهم مسافة");
                ingredients = searchBox.getQuery().toString();
                recipes.clear();
                recipes.addAll(listsClass.getIngredientList(ingredients, listName));
                mAdapter.notifyDataSetChanged();
                break;
        }


    }

    public void getListByDifficulty(String difficulty, String listName){

        switch (difficulty){
            case "easy":
                recipes.clear();
                recipes.addAll(listsClass.getEasyRecList(listName));
                mAdapter.notifyDataSetChanged();
                break;
            case "medium":
                recipes.clear();
                recipes.addAll(listsClass.getMediumRecList(listName));
                mAdapter.notifyDataSetChanged();
                break;
            case "hard":
                recipes.clear();
                recipes.addAll(listsClass.getHardRecList(listName));
                mAdapter.notifyDataSetChanged();
                break;
        }
    }

    public void getRecipesByIng(String ingredients){
        recipes.clear();
        recipes.addAll(listsClass.getIngredientList(ingredients, listName));
        mAdapter.notifyDataSetChanged();
    }









    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
