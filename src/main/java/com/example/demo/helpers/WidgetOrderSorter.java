package com.example.demo.helpers;

import com.example.demo.models.Widget;

import java.util.Comparator;

public class WidgetOrderSorter implements Comparator<Widget> {
    @Override
    public int compare(Widget o1, Widget o2) {
        return o1.getOrd().compareTo(o2.getOrd());
    }
}
