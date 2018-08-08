package com.example.bader.recihelp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class SearchCategoryAdapter extends BaseExpandableListAdapter {

    Boolean hasChild;
    List<String[]> data;
    private Context context;
    String[] headers;
    MainFragment mf;
    ExpandableListView expandableListView;



    public SearchCategoryAdapter(Context context, String[] headers, List<String[]> data, MainFragment mainFragment, ExpandableListView expandableListView) {
        this.context = context;
        this.data = data;
        this.headers = headers;
        this.mf = mainFragment;
        this.expandableListView = expandableListView;
    }



    @Override
    public Object getGroup(int groupPosition) {
        return headers[groupPosition];
    }

    @Override
    public int getGroupCount() {
        return headers.length;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }


    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent)  {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.expandable_list_group, null);
        final ImageView arrow = convertView.findViewById(R.id.arrowInd);
        final TextView text = convertView.findViewById(R.id.listTitle);
        final String groupText = getGroup(groupPosition).toString();
        text.setText(groupText);


        if(isExpanded){
            arrow.setImageResource(R.drawable.ic_arrow_up);
        }

        if (getChildrenCount(groupPosition) < 1) {
            arrow.setVisibility(View.GONE);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    mf.getSearchCategory(groupText);
                }
            });

        }

        return convertView;
    }





    @Override
    public Object getChild(int groupPosition, int childPosition) {
        String[] childData = data.get(groupPosition);
        return childData[childPosition];
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent)  {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.third_item, null);

        final TextView textView = convertView.findViewById(R.id.thirditemtext);

        final String[] childArray = data.get(groupPosition);
        if(childArray != null && (childArray.length > 0)) {
            String text = childArray[childPosition];
            textView.setText(text);
        }


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = textView.getText().toString();



            }
        });
            return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        String[] children = data.get(groupPosition);
        if (children != null && (children.length > 0)) {
            return children.length;
        } else
        return 0;
    }


    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
