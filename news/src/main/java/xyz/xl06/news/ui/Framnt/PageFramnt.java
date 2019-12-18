package xyz.xl06.news.ui.Framnt;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.Request;

import java.util.List;

import xyz.xl06.news.R;
import xyz.xl06.news.ben.CateBen;
import xyz.xl06.news.ben.PageInfoBen;
import xyz.xl06.news.ben.Video_ben;
import xyz.xl06.news.net.OkhttpManager;
import xyz.xl06.news.ui.Actitvy.DetailsActivity;
import xyz.xl06.news.ui.adapter.Myadater;
import xyz.xl06.news.utils.DefineView;

public class PageFramnt extends BaseFramnt implements DefineView {
    private static final String KEY ="KES" ;
    private View inflate;
    private CateBen mess;
    private TextView tvs=null;
    private RecyclerView rv=null;
    private List<Video_ben.Resultli> video=null;
    private List<PageInfoBen.Datali.Listli> list;
    private PageInfoBen pageInfoBen=null;
    private FrameLayout fl=null;
    private LinearLayout loading=null;
    private LinearLayout empty=null;
    private LinearLayout  error=null;
    private SwipeRefreshLayout swipeRefreshLayout=null;

    public PageFramnt() {
        // Required empty public constructor
    }
    public static PageFramnt newInstance( CateBen titlelist) {
//        PageFramnt fragment = new PageFramnt();
        Bundle args = new Bundle();
        args.putSerializable(KEY,titlelist);
        PageFramnt pageFramnt = new PageFramnt();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(inflate==null){
            inflate = inflater.inflate(R.layout.fragment_page_framnt, container, false);
            initView();
            initData();
            initLisner();
        }
        return   inflate;
    }


    @Override
    public void initView() {
        //tvs = (TextView) inflate.findViewById(R.id.tv);
        swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.swrefer);
        rv = (RecyclerView) inflate.findViewById(R.id.rv);
        fl = (FrameLayout) inflate.findViewById(R.id. home_framelayout);
        loading=(LinearLayout)fl.findViewById(R.id.loading);
        empty=(LinearLayout)fl.findViewById(R.id.empty);
        error=(LinearLayout)fl.findViewById(R.id.error);
        //显示布局
        rv.setVisibility(View.GONE);
        fl.setVisibility(View.VISIBLE);
        loading.setVisibility(View.VISIBLE);
        empty.setVisibility(View.GONE);
        error.setVisibility(View.GONE);
    }

    @Override
    public void initData() {
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.color_lv_selector);
        swipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary);
        swipeRefreshLayout.setProgressViewOffset(false,0,50);

        OkhttpManager.getAsync(mess.getUrl(), new OkhttpManager.DataCallBack() {
            @Override
            public void requestFailure(Request request, Exception e) {

            }

            @Override
            public void requestSuccess(String result) {


               pageInfoBen = parse_json(result);
                BindData();
//                if(mess.getId()==1){
//
//                    BindData();
//                }else {
//                    parse_jsons(result);
//                    BindData();
//                }

                   // tvs.setText(result);
                Log.d("", "requestSuccess:------------------------ "+result);

            }


        });
    }

    private  PageInfoBen parse_json(String result) {
        PageInfoBen pageInfo = JSON.parseObject(result, PageInfoBen.class);
  return  pageInfo;
    }
    @Override
    public void initLisner() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //刷新完成
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(con, "更新了 "+" 条目数据", Toast.LENGTH_SHORT).show();
                    }

                }, 3000);
            }
        });
    }

    @Override
    public void BindData() {

             if(pageInfoBen.getCode().equals("200")&&pageInfoBen!=null){
                 rv.setVisibility(View.VISIBLE);
                 fl.setVisibility(View.GONE);
                 loading.setVisibility(View.GONE);
                 empty.setVisibility(View.GONE);
                 error.setVisibility(View.GONE);

                 //设置
                 rv.setLayoutManager(new LinearLayoutManager(con, LinearLayoutManager.VERTICAL, false));
                 //设置new Myadater(MainActivity.this)
                 Myadater myadater = new Myadater(con, pageInfoBen);
                 rv.setAdapter(myadater);
                 myadater.setOnclickLisner(new Myadater.OnclickLisner() {
                     @Override
                     public void click(int postin) {
                         Intent intent = new Intent(con, DetailsActivity.class);
                          intent.putExtra("PAGER", pageInfoBen);
                          intent.putExtra("id",postin);
                          con.startActivity(intent);

                     }
                 });
             }else{

                 rv.setVisibility(View.GONE);
                fl.setVisibility(View.VISIBLE);
                 loading.setVisibility(View.GONE);
                 empty.setVisibility(View.VISIBLE);
                 error.setVisibility(View.GONE);
             }
    }


}
