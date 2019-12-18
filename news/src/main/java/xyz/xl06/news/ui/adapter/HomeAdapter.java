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
import xyz.xl06.news.ben.Techli;

/**
 * Created by xueliang on 2019/2/21 0021.
 */
public class HomeAdapter extends BaseAdapter {
        private Context ctx=null;
        private List<Techli> list=null;
        public HomeAdapter(Context ctx, List<Techli> list) {
            this.ctx=ctx.getApplicationContext();
            this.list=list;


        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Techli.PicInfoli url1 = list.get(position).getPicInfo().get(position)
            ViewHolder holder;
            if(convertView==null){
                holder=new ViewHolder();
                convertView=View.inflate(ctx, R.layout.item_home_news_layout, null);
                holder.name=(TextView) convertView.findViewById(R.id.item_news_tv_name);
                holder.time=(TextView) convertView.findViewById(R.id.item_news_tv_time);
                holder.title=(TextView) convertView.findViewById(R.id.item_news_tv_title);
                holder.image=(ImageView) convertView.findViewById(R.id.item_news_tv_img);
                convertView.setTag(holder);
            }else{
                holder=(ViewHolder) convertView.getTag();
            }
            if(list.size()>0&&list!=null){
                holder.name.setText(list.get(position).getCategory());
                holder.time.setText(list.get(position).getPtime());
                holder.title.setText(list.get(position).getTitle());
                List<Techli.PicInfoli> picInfo = list.get(position).getPicInfo();

                if(picInfo.size()>0&&picInfo!=null){
                    String url = picInfo.get(0).getUrl();
                    Glide.with(ctx.getApplicationContext())
                            .load(url)
                            .into(holder.image);
                }
            }
            return convertView;
        }
        private  class ViewHolder{
            public TextView title=null;
            public TextView time=null;
            public TextView name=null;
            public ImageView image=null;
        }
    }