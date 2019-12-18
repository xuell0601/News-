package xyz.xl06.news.ui.Framnt;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.Request;

import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import xyz.xl06.news.R;
import xyz.xl06.news.ben.City;
import xyz.xl06.news.ben.Weather;
import xyz.xl06.news.net.OkhttpManager;
import xyz.xl06.news.ui.Actitvy.AboutActitvy;
import xyz.xl06.news.ui.Actitvy.BaiduMapActivty;
import xyz.xl06.news.ui.Actitvy.LoginActitvy;
import xyz.xl06.news.ui.Actitvy.WeatherActivity;
import xyz.xl06.news.utils.MyTextView;

/**
 * Created by xueliang on 2019/1/29 0029.
 */
public class User extends BaseFramnt {


    @InjectView(R.id.iv_user)
    ImageView ivUser;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.iv_now_level)
    ImageView ivNowLevel;
    @InjectView(R.id.tv_blance)
    TextView tvBlance;
    @InjectView(R.id.login_la)
    LinearLayout loginLa;
    @InjectView(R.id.iv_arrow_more)
    ImageView ivArrowMore;
    @InjectView(R.id.rl_logined)
    RelativeLayout rlLogined;
    @InjectView(R.id.tv_unlogin_notice)
    TextView tvUnloginNotice;
    @InjectView(R.id.btn_login)
    Button btnLogin;
    @InjectView(R.id.rl_unlogin)
    RelativeLayout rlUnlogin;
    @InjectView(R.id.tianqi)
    MyTextView tianqi;
    @InjectView(R.id.fujin)
    TextView fujin;
    @InjectView(R.id.tv_more_phone)
    TextView tvMorePhone;
    @InjectView(R.id.rl_more_contact)
    RelativeLayout rlMoreContact;
    @InjectView(R.id.fankui)
    TextView fankui;
    @InjectView(R.id.jiancha)
    TextView jiancha;
    @InjectView(R.id.shezhi)
    TextView shezhi;
    @InjectView(R.id.ll_touzi_zhiguan)
    TextView llTouziZhiguan;
    private View home_framnt;
    private TextView tv;
    private City citys=null;
    private Weather weather=null;
    boolean islogin=false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (home_framnt == null) {
            home_framnt = inflater.inflate(R.layout.fragment_mine, container, false);
            ButterKnife.inject(this, home_framnt);

            getLocation();//获取地理位置
            //判断是否登录
             if(islogin){
                 rlUnlogin.setVisibility(View.GONE);
                 rlLogined.setVisibility(View.VISIBLE);
             }else{
                 rlUnlogin.setVisibility(View.VISIBLE);
                 rlLogined.setVisibility(View.GONE);
                 initLogin();
             }
            indata();


        }

        return home_framnt;
    }

    private void toWeather(final Weather parse) {
        tianqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent intent = new Intent(con,WeatherActivity.class);
                    intent.putExtra("weath", parse);
                    con.startActivity(intent);
                 Toast.makeText(con, "sdsd", Toast.LENGTH_SHORT).show();
                //使用隐式意图，启动系统拨号应用界面

            }
        });
    }

    /**
     * 登录
     */
    private void initLogin() {
          btnLogin.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  //跳转到另一个页面
                  Intent intent = new Intent();
                  intent.setClass(con, LoginActitvy.class);
                  con.startActivity(intent);
              }
          });

    }


    private void indata() {

     //附近
    fujin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            Intent intent = new Intent(con, BaiduMapActivty.class);
            con.startActivity(intent);
        }
    });
        //关于我们

        llTouziZhiguan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(con, AboutActitvy.class);
                con.startActivity(intent);
            }
        });


        //联系客服
        contactService();
    }
    //联系客
    private void contactService() {
        rlMoreContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(con)
                        .setTitle("联系客服")
                        .setMessage("是否现在联系客服：010-56253825")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //获取手机号码
                                String phone = tvMorePhone.getText().toString().trim();
                                //使用隐式意图，启动系统拨号应用界面
                                Intent intent = new Intent(Intent.ACTION_CALL);
                                intent.setData(Uri.parse("tel:" + phone));
                                if (ActivityCompat.checkSelfPermission(con, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    return;
                                }
                                con.startActivity(intent);
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });
    }

    public void updateVersion(String wd, String jd) {

        String url = "http://api.map.baidu.com/geocoder?output=json&location=" + wd + "," + jd + "&ak=esNPFDwwsXWtsQfw4NMNmur1";
        OkhttpManager.getAsync(url, new OkhttpManager.DataCallBack() {
            @Override
            public void requestFailure(Request request, Exception e) {

            }

            @Override
            public void requestSuccess(String result) {
                citys = ParesJson(result);
                 GoWether();


            }
        });
//        OkHttpUtils
//                .get()
//                .url(path)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call arg0, Exception arg1, int arg2) {
//                    }
//
//                    @Override
//                    public void onResponse(String arg0, int arg1) {
//                        Gson gson = new Gson();
//                        City response = gson.fromJson(arg0, City.class);
//                        CMLog.d(TAG, arg0);
//                        if (response.getStatus().equals("OK")) {
//                            CMLog.d("地址为", response.getResult().getAddressComponent().getCity());
//                        }
//                    }
//
//                });
    }

    private void GoWether() {
        String urls="https://www.apiopen.top/weatherApi?";
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("city",citys.getResult().getAddressComponent().getCity());
        OkhttpManager.postAsyncParams(urls, stringStringHashMap, new OkhttpManager.DataCallBack() {
            @Override
            public void requestFailure(Request request, Exception e) {

            }

            @Override
            public void requestSuccess(String result) {
                Weather parse = Parse(result);
                tianqi.setText(parse.getData().getForecast().get(0).getType()+parse.getData().getGanmao());
                //跳转到天气
                toWeather(parse);
            }
        });

    }

    private  Weather Parse(String result) {
        Weather weather = JSON.parseObject(result, Weather.class);
        return  weather;
    }

    private City ParesJson(String result) {
        City city = JSON.parseObject(result, City.class);
        if (city.getStatus().equals("OK")) {
            //Log.d("地址为", city.getResult().getAddressComponent().getCity());
           // tv.setText(city.getResult().getFormatted_address());
            return city;
        }
      return null;
    }


    public void getLocation() {
        String locationProvider;
        //获取地理位置管理器
        LocationManager locationManager = (LocationManager) con.getSystemService(Context.LOCATION_SERVICE);
        //获取所有可用的位置提供器
        List<String> providers = locationManager.getProviders(true);
        if (providers.contains(LocationManager.GPS_PROVIDER)) {
            //如果是GPS
            locationProvider = LocationManager.GPS_PROVIDER;
        } else if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
            //如果是Network
            locationProvider = LocationManager.NETWORK_PROVIDER;
        } else {
            Toast.makeText(con, "没有可用的位置提供器", Toast.LENGTH_SHORT).show();
            return;
        }
        //获取Location
        if (ActivityCompat.checkSelfPermission(con, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(con, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(locationProvider);
        if (location != null) {
            //不为空,显示地理位置经纬度
            showLocation(location);
        }
        //监视地理位置变化
        locationManager.requestLocationUpdates(locationProvider, 3000, 1, locationListener);
    }

    /**
     * 显示地理位置经度和纬度信息
     *
     * @param location
     */
    private void showLocation(Location location) {
        String locationStr = "纬度：" + location.getLatitude() + "\n"
                + "经度：" + location.getLongitude();
        Log.d("", "showLocation:------------------------ " + "纬度：" + location.getLatitude() + "经度：" + location.getLongitude());
        updateVersion(location.getLatitude() + "", location.getLongitude() + "");
    }

    /**
     * LocationListern监听器
     * 参数：地理位置提供器、监听位置变化的时间间隔、位置变化的距离间隔、LocationListener监听器
     */

    LocationListener locationListener = new LocationListener() {

        @Override
        public void onStatusChanged(String provider, int status, Bundle arg2) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onLocationChanged(Location location) {
            //如果位置发生变化,重新显示
            showLocation(location);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}