package com.driscan.expandablerecyclerview.screen.main.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.driscan.expandablerecyclerview.R;
import com.driscan.expandablerecyclerview.data.model.Child;
import com.driscan.expandablerecyclerview.data.model.Parent;
import com.driscan.expandablerecyclerview.utils.OnClickRecyclerViewtListener;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class FamilyAdapter extends ExpandableRecyclerViewAdapter<ParentHolder, ChildHolder> {
    private OnClickRecyclerViewtListener mOnClickRecyclerViewtListener;
    private Activity activity;

    public FamilyAdapter(Activity activity, List<? extends ExpandableGroup> groups) {
        super(groups);
        this.activity = activity;
    }


    public void setmOnClickRecyclerViewtListener(OnClickRecyclerViewtListener onClickRecyclerViewtListener) {
        mOnClickRecyclerViewtListener = onClickRecyclerViewtListener;
    }

    @Override
    public ParentHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.group_view_holder, parent, false);

        return new ParentHolder(view);
    }

    @Override
    public ChildHolder onCreateChildViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.child_view_holder, parent, false);
        return new ChildHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ChildHolder holder, int flatPosition, ExpandableGroup group, final int childIndex) {
        final Child phone = (Child) group.getItems().get(childIndex);
        holder.onBind(phone, group);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnClickRecyclerViewtListener != null) {
                    mOnClickRecyclerViewtListener.onItemClickChilListener(phone);
                }
            }
        });
    }

    @Override
    public void onBindGroupViewHolder(ParentHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGroupName(group);
        if (group.getItems().size() > 0) {

        } else {
            final Parent parent = ((Parent) group);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnClickRecyclerViewtListener != null) {
                        mOnClickRecyclerViewtListener.onItemClickParentListener(parent);
                    }
                }
            });
        }
    }
}
