package com.gmail.ivanytskyy.vitaliy.hottrends.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gmail.ivanytskyy.vitaliy.hottrends.R;
import com.gmail.ivanytskyy.vitaliy.hottrends.model.Trend;
import com.squareup.picasso.Picasso;
import java.util.List;
/**
 * Created by Vitaliy Ivanytskyy on 08.06.2016.
 */
public class TrendListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Trend> mTrendList;
    public TrendListAdapter(Context context, List<Trend> trends){
        mContext = context;
        mTrendList = trends;
    }
    public static class ViewHolder{
        ImageView mImageView;
        TextView mCreator;
        TextView mTitle;
    }
    @Override
    public int getCount() {
        return mTrendList.size();
    }
    @Override
    public Object getItem(int position) {
        return mTrendList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        final Trend trend = mTrendList.get(position);
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.trend, parent, false);
            holder = new ViewHolder();
            holder.mImageView = (ImageView) view.findViewById(R.id.trendBlurImageView);
            holder.mTitle = (TextView) view.findViewById(R.id.productTitleTextView);
            holder.mCreator = (TextView) view.findViewById(R.id.creatorTextView);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Picasso.with(mContext)
                .load(trend.getImageBlur())
                .into(holder.mImageView);
        holder.mTitle.setText(trend.getTitle());
        holder.mCreator.setText(trend.getCreator());
        return view;
    }
}