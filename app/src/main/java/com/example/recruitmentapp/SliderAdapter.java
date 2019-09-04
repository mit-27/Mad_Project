package com.example.recruitmentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter
{
    public String[] slide_headings = {
            "Heading 1","Heading 2","Heading 3"
    };
    public String[] slide_descs = {
            "Hello THis is First Description 1",
            "Hello THis is First Description 2",
            "Hello THis is First Description 3"
    };
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        TextView slideHeading = (TextView)view.findViewById(R.id.heading_id);
        TextView slideDesc = (TextView)view.findViewById(R.id.desc_id);

        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(slide_descs[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
