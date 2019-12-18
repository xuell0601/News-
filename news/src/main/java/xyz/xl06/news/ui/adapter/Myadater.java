package xyz.xl06.news.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.lang.ref.SoftReference;

import xyz.xl06.news.R;
import xyz.xl06.news.ben.PageInfoBen;

/**
 * Created by xueliang on 2019/1/31 0031.
 */
public class Myadater extends RecyclerView.Adapter<Myadater.MyViewHoder> {

    private FrameLayout fl;
    private LinearLayout loading;
    private LinearLayout empty;
    private LinearLayout  error;
    private final Context con;
    private  PageInfoBen data=null;
    //设置布局类型
    private final  static int FOOTER=1;
    private final  static int ITEM=0;
    SoftReference<PageInfoBen.Datali.Listli> listli = null;
    private View inflate=null;
    private MyViewHoder myViewHoder=null;

    public Myadater(Context con, PageInfoBen pageInfoBen) {
        this.con=con.getApplicationContext();
        this.data=pageInfoBen;
       initView();
    }

    private void initView() {

    }

    @Override
    public MyViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
      inflate = View.inflate(con, R.layout.item_home_news_layout, null);
        myViewHoder = new MyViewHoder(inflate);
        return myViewHoder;
    }

    @Override
    public void onBindViewHolder(MyViewHoder holder, final int position) {


        listli  = new SoftReference<PageInfoBen.Datali.Listli>(data.getData().getList().get(position));
        if(listli!=null){
            holder.tv.setText(data.getData().getList().get(position).getSource());
            // holder.time.setText(data.getData().getList().get(position).getPub_time());
            //holder.img.setText(data.getData().getList().get(position).getPub_time());
            holder.title.setText(data.getData().getList().get(position).getTitle());
            Glide.with(con).load(data.getData().getList().get(position).getHeadpic()).placeholder(R.drawable.icon_back_gray).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.img);
            if(onclickLisner!=null){
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onclickLisner.click(position);
                        Toast.makeText(con, "点击了"+position, Toast.LENGTH_SHORT).show();
                    }
                });
            }


        }


    }
    @Override
    public int getItemCount() {
        return data.getData().getCount();
    }
    public class MyViewHoder extends RecyclerView.ViewHolder{
        private  TextView tv=null;
        private  TextView time=null;
        private  ImageView img=null;
        private TextView title=null;


        public MyViewHoder(View itemView) {
            super(itemView);
             tv = (TextView) itemView.findViewById(R.id.item_news_tv_name);
            time = (TextView) itemView.findViewById(R.id.item_news_tv_time);
            img = (ImageView) itemView.findViewById(R.id.item_news_tv_img);
            title = (TextView) itemView.findViewById(R.id. item_news_tv_title);


        }
    }

    /**
     * 创建接口
     */
    public interface  OnclickLisner{
        void click(int postin);
    }

    public void setOnclickLisner(OnclickLisner onclickLisner) {
        this.onclickLisner = onclickLisner;
    }

    private OnclickLisner onclickLisner;
}
