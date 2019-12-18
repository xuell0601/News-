package xyz.xl06.news.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import xyz.xl06.news.R;
import xyz.xl06.news.ben.ImageBen;

/**
 * Created by xueliang on 2019/2/22 0022.
 */
public class ImagePagerAdapter extends BaseAdapter {

    private Context context;
    private List<ImageBen.Resultsli> mediaItems=null;
    private ImageBen.Resultsli resultsli=null;


    public ImagePagerAdapter(Context con, List<ImageBen.Resultsli> mediaItems) {
        this.context = con;
        this.mediaItems = mediaItems;
    }


    @Override
    public int getCount() {
        return mediaItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder viewHoder;
        if(convertView ==null){
            convertView = View.inflate(context, R.layout.item_image_pager,null);
            viewHoder = new ViewHoder();
            viewHoder.tv_img = (ImageView) convertView.findViewById(R.id.tv_img);
             viewHoder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(viewHoder);
        }else{
            viewHoder = (ViewHoder) convertView.getTag();
        }

         resultsli = mediaItems.get(position);
        viewHoder.tv_title.setText(resultsli.getDesc());
        Glide.with(context)
                .load(resultsli.getUrl())
                .into(viewHoder.tv_img);

        return convertView;
    }


    static class ViewHoder{
        ImageView tv_img;
        TextView tv_title;
    }

}