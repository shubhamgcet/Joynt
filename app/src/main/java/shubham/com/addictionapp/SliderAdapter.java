package shubham.com.addictionapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter (Context context)
    {
        this.context=context;

    }
    public int[] slide_images = {
            R.drawable.firstaidkit,
            R.drawable.heartbeat,
            R.drawable.pharmacy

    };
    public String[] slide_headings = {

            "DRUG ABUSE IS LIFE ABUSE",
            "SAY NO TO DRUGS",
            "NO NEED FOR WEED"
        };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view ==(RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.slide_layout, container,false);
        ImageView slideImageview = (ImageView) view.findViewById(R.id.slide_images);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_headings);
        slideImageview.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object obj) {
        container.removeView((RelativeLayout)obj);
    }
}