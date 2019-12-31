package com.driscan.expandablerecyclerview.screen.main;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.driscan.expandablerecyclerview.R;
import com.driscan.expandablerecyclerview.data.model.Child;
import com.driscan.expandablerecyclerview.data.model.Parent;
import com.driscan.expandablerecyclerview.screen.main.adapter.FamilyAdapter;
import com.driscan.expandablerecyclerview.utils.OnClickRecyclerViewtListener;
import com.thoughtbot.expandablerecyclerview.listeners.GroupExpandCollapseListener;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickRecyclerViewtListener<Object> {
    private RecyclerView recyclerView;
    private ExpandableGroup expandedGroup;
    private ArrayList<Parent> relashionShipsList = new ArrayList<>();

    private FamilyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        setData();
        adapter = new FamilyAdapter(this, relashionShipsList);
        recyclerView.setAdapter(adapter);
        adapter.setmOnClickRecyclerViewtListener(this);
        adapter.setOnGroupExpandCollapseListener(new GroupExpandCollapseListener() {
            @Override
            public void onGroupExpanded(ExpandableGroup group) {
                if (expandedGroup != null
                        && !expandedGroup.equals(group)
                        && adapter.isGroupExpanded(expandedGroup)) {
                    adapter.toggleGroup(expandedGroup);
                    adapter.notifyDataSetChanged();
                }
                expandedGroup = group;
            }

            @Override
            public void onGroupCollapsed(ExpandableGroup group) {
            }
        });
    }

    @Override
    public void onItemClickParentListener(Object item) {
        Toast.makeText(this, ((Parent) item).getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClickChilListener(Object item) {
        Toast.makeText(this, ((Child) item).getName(), Toast.LENGTH_SHORT).show();
    }

    private void setData() {

        ArrayList<Child> brothersNames = new ArrayList<>();
        brothersNames.add(new Child("Hamdaan Shahzad", ContextCompat.getDrawable(getApplicationContext(), R.drawable.ahmad)));
        brothersNames.add(new Child("Haider Arif", ContextCompat.getDrawable(getApplicationContext(), R.drawable.ahmad)));
        brothersNames.add(new Child("Sabir Arif", ContextCompat.getDrawable(getApplicationContext(), R.drawable.ahmad)));
        brothersNames.add(new Child("Jafer Arif", ContextCompat.getDrawable(getApplicationContext(), R.drawable.ahmad)));
        brothersNames.add(new Child("Faryad Arif", ContextCompat.getDrawable(getApplicationContext(), R.drawable.ahmad)));
        brothersNames.add(new Child("Shahbaz Arif", ContextCompat.getDrawable(getApplicationContext(), R.drawable.ahmad)));
        brothersNames.add(new Child("Shahzad Arif", ContextCompat.getDrawable(getApplicationContext(), R.drawable.ahmad)));

        ArrayList<Child> cousinsNamesList = new ArrayList<>();
        cousinsNamesList.add(new Child("Umar Irshad", ContextCompat.getDrawable(getApplicationContext(), R.drawable.ahmad)));
        cousinsNamesList.add(new Child("Usman Irshad", ContextCompat.getDrawable(getApplicationContext(), R.drawable.ahmad)));
        cousinsNamesList.add(new Child("Ali Irshad", ContextCompat.getDrawable(getApplicationContext(), R.drawable.ahmad)));
        cousinsNamesList.add(new Child("Abubakar Irshad", ContextCompat.getDrawable(getApplicationContext(), R.drawable.ahmad)));

        ArrayList<Child> friendNames = new ArrayList<>();

        relashionShipsList.add(new Parent("Family Names", brothersNames));
        relashionShipsList.add(new Parent("Cousins Names", cousinsNamesList));
        relashionShipsList.add(new Parent("Friends Name", friendNames));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.onRestoreInstanceState(savedInstanceState);
    }
}
