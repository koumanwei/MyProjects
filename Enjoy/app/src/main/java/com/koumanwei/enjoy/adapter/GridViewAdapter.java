package com.koumanwei.enjoy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.koumanwei.enjoy.R;
import com.koumanwei.enjoy.bean.GridData;

import java.util.List;


/**
 * Created by koumanwei on 2016-05-24.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<GridData> datas;

    public GridViewAdapter(Context context, List<GridData> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.grid_view_item, null);
            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.text.setText(datas.get(position).getText());
        viewHolder.image.setImageResource(datas.get(position).getImage());
        return convertView;
    }

    static class ViewHolder {
        TextView text;
        ImageView image;
    }
}
