package xyz.xl06.news.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.Utils;
import xyz.xl06.news.R;
import xyz.xl06.news.ben.VideoBen;

/**
 * 作者：杨光福 on 2016/7/18 10:16
 * 微信：yangguangfu520
 * QQ号：541433511
 * 作用：NetVideoPager的适配器
 */
public class NetVideoPagerAdapter extends BaseAdapter {

    private  Context context;
    private List<VideoBen.Trailersli> mediaItems=null;
    private VideoBen.Trailersli trailersli=null;


    public NetVideoPagerAdapter(Context con, List<VideoBen.Trailersli> mediaItems) {
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
            convertView = View.inflate(context, R.layout.item_netvideo_pager,null);
            viewHoder = new ViewHoder();
            viewHoder.tv_img = (ImageView) convertView.findViewById(R.id.tv_img);
           // viewHoder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHoder.tv_play_nums = (TextView) convertView.findViewById(R.id.tv_play_nums);
            viewHoder.tv_video_duration = (TextView) convertView.findViewById(R.id.tv_video_duration);
           // viewHoder.iv_commant = (ImageView) convertView.findViewById(R.id.iv_commant);
            viewHoder.jcv_videoplayer = (JCVideoPlayer) convertView.findViewById(R.id.jcv_videoplayer);
            convertView.setTag(viewHoder);
        }else{
            viewHoder = (ViewHoder) convertView.getTag();
        }

        //根据position得到列表中对应位置的数据
        //MediaItem mediaItem = mediaItems.get(position);
        trailersli = mediaItems.get(position);
       // viewHoder.tv_name.setText( trailersli.getMovieName());
        //3.使用Picasso 请求图片
//        Glide.with(context)
//                .load(mediaItem.getImageUrl())
//                .into(viewHoder.tv_img);
        viewHoder.jcv_videoplayer.setUp(trailersli.getHightUrl(),trailersli.getCoverImg() , trailersli.getVideoTitle());
       // viewHoder.tv_play_nums.setText(trailersli. + "次播放");
        viewHoder.tv_video_duration.setText(Utils.stringForTime(trailersli.getVideoLength() * 1000) + "");

        return convertView;
    }


    static class ViewHoder{
        ImageView tv_img;
        TextView tv_name;
        TextView tv_desc;
        TextView tv_play_nums ;
        TextView tv_video_duration ;
        ImageView iv_commant;
        TextView  tv_commant_context;
        JCVideoPlayer  jcv_videoplayer ;
    }

}

