package xyz.xl06.news.ui.Actitvy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.sharesdk.onekeyshare.OnekeyShare;
import xyz.xl06.news.R;
import xyz.xl06.news.ben.PageInfoBen;
import xyz.xl06.news.utils.ThemeManager;
import xyz.xl06.news.widget.RoundAngleImageView;

public class DetailsActivity extends BaseActivity implements ThemeManager.OnThemeChangeListener {
    private Button btn_back, btn_share, btn_font, btn_night;
    private TextView details_title, details_name, details_time;
    private RoundAngleImageView details_avatar = null;
    private ImageView details_ad = null;
    private WebView details_content = null;
    private FrameLayout home_framelayout = null;
    private LinearLayout loading, empty, error;
    private String titleUrl, titleId;
    private RelativeLayout relative_content;
    //    private Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            bindData();
//        }
//    };
    private int defaultValue;
    private PageInfoBen pager = null;
    private PageInfoBen.Datali.Listli listli = null;
    private int tempSize = 2;
    private int realSize = tempSize;
    private WebSettings webSettings;
    private LinearLayout linearLayout=null;
    private ActionBar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        //setStatusBar();
        ThemeManager.registerThemeChangeListener(this);
        initView();
        initValidata();
        initListener();
    }

    public void initView() {
       linearLayout = (LinearLayout) findViewById(R.id.relativeLayout);
        //supportActionBar = getSupportActionBar();
        btn_back = (Button) this.findViewById(R.id.btn_back);
        btn_share = (Button) this.findViewById(R.id.btn_share);
        btn_font = (Button) this.findViewById(R.id.btn_font);
        btn_night = (Button) this.findViewById(R.id.btn_night);
//        details_title=(TextView)this.findViewById(R.id.details_title);
//        details_name=(TextView)this.findViewById(R.id.details_name);
//        details_time=(TextView)this.findViewById(R.id.details_time);
//        details_avatar=(RoundAngleImageView)this.findViewById(R.id.details_avatar);
//        details_ad=(ImageView) this.findViewById(R.id.details_ad);

        details_content = (WebView) this.findViewById(R.id.details_content);
        home_framelayout = (FrameLayout) this.findViewById(R.id.prompt_framelayout);
        loading = (LinearLayout) this.findViewById(R.id.loading);
        empty = (LinearLayout) this.findViewById(R.id.empty);
        error = (LinearLayout) this.findViewById(R.id.error);

        relative_content = (RelativeLayout) this.findViewById(R.id.relative_content);

    }

    @Override
    public void onThemeChanged() {
        initTheme();
    }


    public void initTheme() {

       // btn_theme.setTextColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.textColor)));
        linearLayout.setBackgroundColor(getResources().getColor(ThemeManager.getCurrentThemeRes(DetailsActivity.this, R.color.backgroundColor)));
        // 设置标题栏颜色
//        if(supportActionBar != null){
//            supportActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(ThemeManager.getCurrentThemeRes(DetailsActivity.this, R.color.colorPrimary))));
//        }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.setStatusBarColor(getResources().getColor(ThemeManager.getCurrentThemeRes(DetailsActivity.this, R.color.colorPrimary)));
//        }
    }
    public void initValidata() {
        Intent mIntent = getIntent();
        pager = (PageInfoBen) mIntent.getSerializableExtra("PAGER");
        int id = mIntent.getIntExtra("id", defaultValue);
        String source_url = pager.getData().getList().get(id).getSource_url();
        listli = pager.getData().getList().get(id);
        relative_content.setVisibility(View.GONE);
        home_framelayout.setVisibility(View.VISIBLE);
        loading.setVisibility(View.VISIBLE);
        empty.setVisibility(View.GONE);
        error.setVisibility(View.GONE);
        webSettings = details_content.getSettings();
        //设置webview

        webSettings.setTextZoom(100);
        webSettings = details_content.getSettings();

// 设置可以支持缩放
        // details_content.getSettings().setSupportZoom(true);
// 设置出现缩放工具
        details_content.getSettings().setBuiltInZoomControls(true);
//扩大比例的缩放
        details_content.getSettings().setUseWideViewPort(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setJavaScriptEnabled(true);  //开启javascript
        webSettings.setDomStorageEnabled(true);  //开启DOM
        webSettings.setDefaultTextEncodingName("utf-8"); //设置编码
        // // web页面处理
        webSettings.setAllowFileAccess(true);// 支持文件流
//设置支持javaScript
        webSettings = details_content.getSettings();
        //提高网页加载速度，暂时阻塞图片加载，然后网页加载好了，在进行加载图片
        webSettings.setBlockNetworkImage(true);
        //开启缓存机制
        webSettings.setAppCacheEnabled(true);
        //设置自适应
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        details_content.loadUrl(source_url);
        details_content.setWebChromeClient(new MyWebChromeClient());
        details_content.setWebViewClient(new MyWebViewClient());

//        OkhttpManager.getAsync(source_url, new OkhttpManager.DataCallBack() {
//            @Override
//            public void requestFailure(Request request, Exception e) {
//                Log.d("zttjiangqq","数据加载失败...");
//                relative_content.setVisibility(View.GONE);
//                home_framelayout.setVisibility(View.VISIBLE);
//                loading.setVisibility(View.GONE);
//                empty.setVisibility(View.GONE);
//                error.setVisibility(View.VISIBLE);
//            }
//            @Override
//            public void requestSuccess(String result) {

//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        handler.sendMessage(handler.obtainMessage());
//                    }
//                }).start();
//            }
//        });
    }


    public void initListener() {
        btn_back.setOnClickListener(new CustomOnClickListener());
        btn_share.setOnClickListener(new CustomOnClickListener());
        btn_font.setOnClickListener(new CustomOnClickListener());
        btn_night.setOnClickListener(new CustomOnClickListener());
    }


    public void bindData() {
        //     if(  listli!=null){
//            relative_content.setVisibility(View.VISIBLE);
//            home_framelayout.setVisibility(View.GONE);
//            loading.setVisibility(View.GONE);
//            empty.setVisibility(View.GONE);
//            error.setVisibility(View.GONE);
        //Log.d("zttjiangqq","文章详情的数据为:"+articleBean);
//            details_title.setText( listli.getTitle());
        // mImageLoader.displayImage(articleBean.getAuthorBean().getAvatar(),details_avatar);
//            Glide.with(DetailsActivity.this)
//                    .load(listli.getHeadpic())
//                    .into(details_avatar);
//            details_name.setText( listli.getSource());
//            details_time.setText(" 发表于"+ listli.getPub_time());
//            Glide.with(DetailsActivity.this)
//                    .load(listli.getHeadpic())
//                    .into(details_avatar);
        //mImageLoader.displayImage(articleBean.getHeadImage(),details_ad);
        details_content.loadUrl(listli.getSource_url());
        //details_content.loadData(listli.getSource_url(),"text/html","UTF-8");
        //details_content.loadDataWithBaseURL(listli.getSource_url(),articleBean.getContext(),"text/html","UTF-8","");
        // }else{
//            relative_content.setVisibility(View.GONE);
//            home_framelayout.setVisibility(View.VISIBLE);
//            loading.setVisibility(View.GONE);
//            empty.setVisibility(View.VISIBLE);
//            error.setVisibility(View.GONE);
        // }
    }

    class CustomOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_back:
                    DetailsActivity.this.finish();
                    break;
                case R.id.btn_share:
                    // Toast.makeText(DetailsActivity.this,"点击了分享按钮",Toast.LENGTH_SHORT).show();
                    showShare();
                    break;
                case R.id.btn_night:
                    Toast.makeText(DetailsActivity.this, "点击了白天/黑夜切换按钮", Toast.LENGTH_SHORT).show();
                    ThemeManager.setThemeMode(ThemeManager.getThemeMode() == ThemeManager.ThemeMode.DAY
                            ? ThemeManager.ThemeMode.NIGHT : ThemeManager.ThemeMode.DAY);

                    break;

                case R.id.btn_font:
                    Toast.makeText(DetailsActivity.this, "点击了字体按钮", Toast.LENGTH_SHORT).show();
                    showChangeTextSizeDialog();
                    break;
            }
        }
    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle(getString(R.string.share));
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网使用
        oks.setComment("我是测试评论文本");
        // 启动分享GUI
        oks.show(this);
    }


    private void showChangeTextSizeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("设置文字大小");
        String[] items = {"超大字体","大字体","正常字体","小字体","超小字体"};
        builder.setSingleChoiceItems(items, realSize, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tempSize = which;
            }
        });
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                realSize = tempSize;
                changeTextSize(realSize);
            }
        });
        builder.show();

    }

    private void changeTextSize(int realSize) {

        switch (realSize){
            case 0://超大字体
                webSettings.setTextZoom(200);
                break;
            case 1://大字体
                webSettings.setTextZoom(150);
                break;
            case 2://正常字体
                webSettings.setTextZoom(100);
                break;
            case 3://小字体
                webSettings.setTextZoom(75);
                break;
            case 4://超小字体
                webSettings.setTextZoom(50);
                break;
        }

    }

    class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
//            Log.d("zttjiangqq","加载进度发生变化:"+newProgress);
//            relative_content.setVisibility(View.GONE);
//            home_framelayout.setVisibility(View.VISIBLE);
//            loading.setVisibility(View.GONE);
//            empty.setVisibility(View.VISIBLE);
//            error.setVisibility(View.GONE);
        }
    }
    class MyWebViewClient extends WebViewClient {
//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            super.onPageStarted(view, url, favicon);
//            Log.d("zttjiangqq","网页开始加载:"+url);
//            relative_content.setVisibility(View.GONE);
//            home_framelayout.setVisibility(View.VISIBLE);
//            loading.setVisibility(View.GONE);
//            empty.setVisibility(View.VISIBLE);
//            error.setVisibility(View.GONE);
//        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("zttjiangqq","网页加载完成..."+url);

        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            Log.d("zttjiangqq","加载的资源:"+url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            relative_content.setVisibility(View.VISIBLE);
            home_framelayout.setVisibility(View.GONE);
            loading.setVisibility(View.GONE);
            empty.setVisibility(View.GONE);
            error.setVisibility(View.GONE);
            //显示
            view.loadUrl(url);
            return true;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
           finish();
        ThemeManager.unregisterThemeChangeListener(this);
    }
}

