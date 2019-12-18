package xyz.xl06.news.ui.Actitvy;

import android.app.Activity;
import android.os.Bundle;

import com.baidu.mapapi.map.MapView;

import xyz.xl06.news.R;

public class BaiduMapActivty extends Activity {


    private MapView mMapView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_map_activty);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mMapView.removeViewAt(1);
        //地图上比例尺
        mMapView.showScaleControl(false);
// 隐藏缩放控件
        mMapView.showZoomControls(false);
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
}

