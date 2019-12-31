package com.driscan.expandablerecyclerview.utils;

public interface OnClickRecyclerViewtListener<T> {
    void onItemClickParentListener(T item);

    void onItemClickChilListener(T item);
}
