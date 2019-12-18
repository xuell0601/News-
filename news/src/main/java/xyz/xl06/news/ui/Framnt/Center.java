package xyz.xl06.news.ui.Framnt;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.Request;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import xyz.xl06.news.R;
import xyz.xl06.news.ben.VideoBen;
import xyz.xl06.news.net.OkhttpManager;
import xyz.xl06.news.ui.adapter.NetVideoPagerAdapter;
import xyz.xl06.news.utils.Constants;
import xyz.xl06.news.utils.DefineView;
import xyz.xl06.news.utils.XListView;

/**
 * Created by xueliang on 2019/1/29 0029.
 */
public class Center extends BaseFramnt implements DefineView {





    /**
     * 装数据集合
     */
    private List<VideoBen.Trailersli> mediaItems=null;

    private NetVideoPagerAdapter adapter=null;

    /**
     * 是否已经加载更多了
     */
    private boolean isLoadMore = false;
    private View net_video = null;
    private XListView mListview=null;
    private ProgressBar pbLoading=null;
    private TextView tvNonet=null;
    private List<VideoBen.Trailersli> trailers=null;


    /**
     * 初始化当前页面的控件，由父类调用
     *
     * @return
     */

    public void initView() {
        tvNonet= (TextView) net_video.findViewById(R.id.tv_nonet);
        pbLoading= (ProgressBar) net_video.findViewById(R.id.pb_loading);
         mListview = (XListView) net_video.findViewById(R.id.listview);
        mListview.setOnItemClickListener(new MyOnItemClickListener());
        mListview.setPullLoadEnable(true);
        mListview.setXListViewListener(new MyIXListViewListener());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (net_video == null) {
            net_video = inflater.inflate(R.layout.netvideo_pager, container, false);


            initView();
            initData();
            initLisner();
        }
        ButterKnife.inject(this, net_video);
        return net_video;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    class MyIXListViewListener implements XListView.IXListViewListener {
        @Override
        public void onRefresh() {
            getDataFromNet();
        }

        @Override
        public void onLoadMore() {

            getMoreDataFromNet();
        }
    }

    private void getMoreDataFromNet() {
        //联网
        //视频内容
        OkhttpManager.getAsync(Constants.NET_URL, new OkhttpManager.DataCallBack() {
            @Override
            public void requestFailure(Request request, Exception e) {
                isLoadMore = false;
            }

            @Override
            public void requestSuccess(String result) {
                isLoadMore = true;
                processData(result);
            }
        });


    }


    class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//            //3.传递列表数据-对象-序列化
//            Intent intent = new Intent(con, SystemVideoPlayer.class);
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("videolist", mediaItems);
//            intent.putExtras(bundle);
//            intent.putExtra("position", position - 1);
//            con.startActivity(intent);

        }
    }


    @Override
    public void initData() {

//
//        String saveJson = CacheUtils.getString(con, Constants.NET_URL);
//        if (!TextUtils.isEmpty(saveJson)) {
//            processData(saveJson);
//        }
        getDataFromNet();

    }

    @Override
    public void initLisner() {

    }

    @Override
    public void BindData() {

    }

    private void getDataFromNet() {
        //联网
        //视频内容
        OkhttpManager.getAsync(Constants.NET_URL, new OkhttpManager.DataCallBack() {
            @Override
            public void requestFailure(Request request, Exception e) {
                showData();
            }

            @Override
            public void requestSuccess(String result) {
                processData(result);
            }
        });


    }

    private void processData(String json) {

        if (!isLoadMore) {
            mediaItems = parseJson(json);
            showData();


        } else {
            //加载更多
            //要把得到更多的数据，添加到原来的集合中
//            ArrayList<MediaItem> moreDatas = parseJson(json);
            isLoadMore = false;
            mediaItems.addAll(parseJson(json));
            //刷新适配器
            adapter.notifyDataSetChanged();
            onLoad();


        }


    }

    private  List<VideoBen.Trailersli>  parseJson(String json) {
        VideoBen videoBen = JSON.parseObject(json, VideoBen.class);
       trailers = videoBen.getTrailers();

        return  trailers;
    }

    private void showData() {
        //设置适配器
        if (mediaItems != null && mediaItems.size() > 0) {
            //有数据
            //设置适配器
            adapter = new NetVideoPagerAdapter(con, mediaItems);
            mListview.setAdapter(adapter);
            onLoad();
            //把文本隐藏
            tvNonet.setVisibility(View.GONE);
        } else {
            //没有数据
            //文本显示
            tvNonet.setVisibility(View.VISIBLE);
        }


        //ProgressBar隐藏
        pbLoading.setVisibility(View.GONE);
    }


    private void onLoad() {
        mListview.stopRefresh();
        mListview.stopLoadMore();
        mListview.setRefreshTime("更新时间:" + getSysteTime());
    }

    /**
     * 得到系统时间
     *
     * @return
     */
    public String getSysteTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(new Date());
    }

    /**
     * 解决json数据：
     * 1.用系统接口解析json数据
     * 2.使用第三方解决工具（Gson,fastjson）
     *
     * @param json
     * @return
     */
//    private ArrayList<MediaItem> parseJson(String json) {
//
//
//        ArrayList<MediaItem> mediaItems = new ArrayList<>();
//        try {
//            JSONObject jsonObject = null;
//            try {
//                jsonObject = new JSONObject(json);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            JSONArray jsonArray = jsonObject.optJSONArray("trailers");
//            if (jsonArray != null && jsonArray.length() > 0) {
//
//                for (int i = 0; i < jsonArray.length(); i++) {
//
//                    JSONObject jsonObjectItem = (JSONObject) jsonArray.get(i);
//
//                    if (jsonObjectItem != null) {
//
//                        MediaItem mediaItem = new MediaItem();
//
//
//                        String movieName = jsonObjectItem.optString("movieName");//name
//                        mediaItem.setName(movieName);
//
//                        String videoTitle = jsonObjectItem.optString("videoTitle");//desc
//                        mediaItem.setDesc(videoTitle);
//
//                        String imageUrl = jsonObjectItem.optString("coverImg");//imageUrl
//                        mediaItem.setImageUrl(imageUrl);
//
//                        String hightUrl = jsonObjectItem.optString("hightUrl");//data
//                        mediaItem.setData(hightUrl);
//
//                        //把数据添加到集合
//                        mediaItems.add(mediaItem);
//                    }
//                }
//            }
//
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return mediaItems;
//    }

}