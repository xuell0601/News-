package xyz.xl06.news.ui.Framnt;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.squareup.okhttp.Request;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import xyz.xl06.news.R;
import xyz.xl06.news.ben.BannerBen;
import xyz.xl06.news.ben.CateBen;
import xyz.xl06.news.ben.HomeFramtInfoBen;
import xyz.xl06.news.ben.Techli;
import xyz.xl06.news.net.OkhttpManager;
import xyz.xl06.news.ui.adapter.HomeAdapter;
import xyz.xl06.news.utils.DefineView;

/**
 * Created by xueliang on 2019/1/29 0029.
 */
public class Home   extends BaseFramnt  implements DefineView {
    private static final String KEY ="KES" ;
    private View home_framnt;
    private CateBen mess;
    private View inflate;
    private TextView tvs;
    private List<Techli> techli;
    private ListView pull_list;
    public List<HomeFramtInfoBen.Datali.Autoli> data;
    private HomeFramtInfoBen homeFramtInfoBen;

    private FrameLayout home_framelayout;
    private LinearLayout loading;
    private LinearLayout empty;
    private LinearLayout  error;
    private Banner banner;

    private List<BannerBen> bannerBens;

    private List<Techli> tech;

    private List<String>    bannerList;
    private  String []   bannertitle;

//    //使用网络加载数据，最后一个参数为图片新闻的id
//    list.add(new BannerBen("http://www.3dmgame.com/uploads/allimg/130124/11111111111111111111111111-130124144424.jpg", "新年首款大作 《龙之信条：黑暗觉者》破解版发布"));
//    list.add(new ImageCycleView.ImageInfo("http://www.3dmgame.com/uploads/allimg/130124/11111111111111111111-130124145Q3.jpg", "3DM轩辕组制作 《暗黑地牢》正式版汉化补丁发布", "3544323"));
//    list.add(new ImageCycleView.ImageInfo("http://www.3dmgame.com/uploads/allimg/130124/1111111111-130124145Q7.jpg", "育碧旗下射击游戏《全境封锁》PC版详细配置公布", "3544277"));
//    list.add(new ImageCycleView.ImageInfo("http://www.3dmgame.com/uploads/allimg/130124/11111111111-130124145R1.jpg", "PS4《侠盗猎车5》重制版新截图展示华丽视觉效果", "3395945"));
//    list.add(new ImageCycleView.ImageInfo("http://www.3dmgame.com/uploads/allimg/130124/1111111111111111111111111111111-130124145R1-50.jpg", "1月31日3DM新游评测与推荐 老司机是时候开车了", "3545703"));

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(home_framnt==null){
            home_framnt = inflater.inflate(R.layout.home_framnt, container,false);

            initView();
            initData();
            initLisner();
        }
        return home_framnt;
    }
    public static Home  newInstance( CateBen titlelist) {
        Bundle args = new Bundle();
        args.putSerializable(KEY,titlelist);
        Home  pageFramnt = new Home ();
        pageFramnt.setArguments(args);
        return pageFramnt;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mess = (CateBen)getArguments().getSerializable(KEY);
        }
    }

    @Override
    public void initView() {
        pull_list = (ListView)home_framnt.findViewById(R.id.home_listview);
        home_framelayout=(FrameLayout)home_framnt.findViewById(R.id.home_framelayout);
        //加载头布局
        View headView = View.inflate(con, R.layout.headview, null);
        banner = (Banner) headView.findViewById(R.id.banner);
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR_TITLE);
        //轮播下面样式属性
        banner.setDelayTime(2000);//设置轮播时间
        banner.isAutoPlay(true);
        //设置图片集合
        // banner.setImages(list);//设置图片源
        loading=(LinearLayout)home_framnt.findViewById(R.id.loading);
        empty=(LinearLayout)home_framnt.findViewById(R.id.empty);
        error=(LinearLayout)home_framnt.findViewById(R.id.error);

        //显示布局
        pull_list.setVisibility(View.GONE);
        home_framelayout.setVisibility(View.VISIBLE);
        loading.setVisibility(View.VISIBLE);
        empty.setVisibility(View.GONE);
        error.setVisibility(View.GONE);
        //
        pull_list.addHeaderView( headView );
    }

    @Override
    public void initData() {
        //准备banner的数据
        bannerList = new ArrayList<>();

        // bannerList.add("http://www.3dmgame.com/uploads/allimg/130124/1111111111111111111111111111111-130124145R1-50.jpg");

        OkhttpManager.getAsync(mess.getUrl(), new OkhttpManager.DataCallBack() {

            @Override
            public void requestFailure(Request request, Exception e) {

            }
            @Override
            public void requestSuccess(String result) {
                //捷信数据
                homeFramtInfoBen = parse_json(result);

                tech = homeFramtInfoBen.getData().getTech();
                //推荐 = homeFramtInfoBen.get推荐();
                List<HomeFramtInfoBen.Datali.Dyli> dy = homeFramtInfoBen.getData().getDy();
                int size = dy.size();
                bannertitle = new  String[size];
                for(int i=0;i<dy.size();i++){
                    String url = dy.get(i).getPicInfo().get(0).getUrl();
                    bannerList.add(url);
                    bannertitle[i]=dy.get(i).getTitle();;

                }
                BindData();
            }
        });
    }


    private  HomeFramtInfoBen parse_json(String result) {
        HomeFramtInfoBen homeFramtInfoBen = JSON.parseObject(result, HomeFramtInfoBen.class);
        return homeFramtInfoBen;
    }
    @Override
    public void initLisner() {
        //显示数据
    }
    @Override
    public void BindData() {

        if( homeFramtInfoBen!=null){
            pull_list.setVisibility(View.VISIBLE);
            home_framelayout.setVisibility(View.GONE);
            loading.setVisibility(View.GONE);
            empty.setVisibility(View.GONE);
            error.setVisibility(View.GONE);
            banner.setBannerTitle(bannertitle);
            //设置bannner
            banner.setImages(bannerList, new Banner.OnLoadImageListener() {
                @Override
                public void OnLoadImage(ImageView view, Object url) {
                    Glide.with(con)
                            .load(url)
                            .into(view);
                }
            });

            //banner的点击事件
            //设置点击事件
            banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
                @Override
                public void OnBannerClick(View view, int position) {
                    Toast.makeText(con, "--"+position, Toast.LENGTH_SHORT).show();

                }

            });
            //设置数据
            pull_list.setAdapter(new HomeAdapter(con,tech));

        }else{
            pull_list.setVisibility(View.GONE);
            home_framelayout.setVisibility(View.VISIBLE);
            loading.setVisibility(View.GONE);
            empty.setVisibility(View.VISIBLE);
            error.setVisibility(View.GONE);
        }
    }

}
