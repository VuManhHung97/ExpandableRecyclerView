package com.driscan.expandablerecyclerview.screen.main.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.driscan.expandablerecyclerview.R;
import com.driscan.expandablerecyclerview.data.model.Child;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ChildHolder extends ChildViewHolder {
    private TextView childName;
    private ImageView userImage;

    public ChildHolder(View itemView) {
        super(itemView);

        childName = (TextView) itemView.findViewById(R.id.childName);
        userImage = (ImageView) itemView.findViewById(R.id.userImage);
    }

    public void onBind(Child childModel, ExpandableGroup group) {

        childName.setText(childModel.getName());
        userImage.setImageDrawable(childModel.getUserImage());

    }
}
