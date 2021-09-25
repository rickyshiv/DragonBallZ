package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public int[] imageArray = {
            R.drawable.and18,R.drawable.logodragon,
            R.drawable.androidt,R.drawable.frieza,
            R.drawable.goten,R.drawable.goku,R.drawable.cell,R.drawable.balls,
            R.drawable.cooler,R.drawable.battles,
            R.drawable.kidboo,R.drawable.majin,

    };



    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView= new ImageView(mContext);
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(300,280));



        return imageView;
    }
}