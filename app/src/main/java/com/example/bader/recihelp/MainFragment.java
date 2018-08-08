package com.example.bader.recihelp;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    View v;
    RecyclerView categoriesRecyclerView;
    MainCategoriesAdapter mCadapter;
    RecyclerView.LayoutManager cLayoutManager;
    List<String> categories = new ArrayList<>();
    MainActivity mainActivity;
    boolean main;





    public MainFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//
//        listDataHeader = new ArrayList<>();
//        thirdLevelq1 = new LinkedHashMap<>();
//        thirdLevelq2 = new LinkedHashMap<>();
//        thirdLevelq3 = new LinkedHashMap<>();
//        listDataChild = new ArrayList<>();
//
//
//        parent = new String[]{"ابحث بـ"};
//        q1 = new String[]{"الصعوبة", "الإسم", "مكونات"};
//        String[] des1 = new String[]{"متوسط" , "صعب", "سهل"};
//
//
//        hint = "what";
//
//        previousGroup = -1;
//        listDataHeader.add(q1);
//        thirdLevelq1.put(q1[2], des1);
//        thirdLevelq1.put(q1[0], null);
//        thirdLevelq1.put(q1[1], null);
//
//        listDataChild.add(thirdLevelq1);





    }









    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
if(v == null) {
    v = inflater.inflate(R.layout.fragment_main, container, false);

    categories.add("test1");
    categories.add("test2");


    mainActivity = new MainActivity();
    categoriesRecyclerView = v.findViewById(R.id.categoriesRecyclerView);
    categoriesRecyclerView.setHasFixedSize(true);
    cLayoutManager = new LinearLayoutManager(getContext());
    categoriesRecyclerView.setLayoutManager(cLayoutManager);
    mCadapter = new MainCategoriesAdapter(getContext(), categories);
    categoriesRecyclerView.setAdapter(mCadapter);








//        ChildCategoryList = v.findViewById(R.id.ChildLevelList);
//        ChildCategoryList.setGroupIndicator(null);
//        ChildCategoryList.setGroupIndicator(getResources().getDrawable(R.drawable.ic_arrow_down));
//        ThreeLevelAdapter threeLevelAdapter = new ThreeLevelAdapter(getContext(), parent, listDataHeader, listDataChild, this, ChildCategoryList);
//        ChildCategoryList.setAdapter(threeLevelAdapter);
//        ChildCategoryList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                if (groupPosition != previousGroup)
//                    ChildCategoryList.collapseGroup(previousGroup);
//                    previousGroup = groupPosition;
//            }});


        }

        return v;

    }








    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);


    }





    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}




