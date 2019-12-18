package xyz.xl06.news.ui.Actitvy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import xyz.xl06.news.R;
import xyz.xl06.news.ben.Weather;
import xyz.xl06.news.ben.WeatherBean;
import xyz.xl06.news.utils.OnePlusWeatherView;

public class WeatherActivity extends Activity {

    private Weather weath=null;
    private OnePlusWeatherView weatherview;
    private Button btn_back;
    private Calendar cale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

       weath = (Weather) getIntent().getSerializableExtra("weath");
        Log.d("", "onCreate: --------------------"+weath.getData().getGanmao());
        initView();
        initListner();
    }

    private void initListner() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initView() {
        weatherview = (OnePlusWeatherView) findViewById(R.id.weather_view);
        btn_back=(Button)this.findViewById(R.id.btn_back);
        //initTime
        initTime();
        List<WeatherBean> data = new ArrayList<>();
        List<Weather.Datali.Forecastli> forecast = weath.getData().getForecast();
//        for(int i=0;i<forecast.size();i++){
//
//            WeatherBean NEW = new WeatherBean(1+i, , , 20, 15);
//            data.add(NEW);
//          }
//        initTime();
        ;
//        ArrayList<String> riqi = new ArrayList<>();
//        for(int i=0;i<forecast.size();i++){
//            riqi.add(i,forecast.get(i).getDate().substring(0,3));
//        }
//        ArrayList<String> ti = new ArrayList<>();
//        for(int i=0;i<forecast.size();i++){
//            ti.add(i,forecast.get(i).getDate().substring(3,6));
//        }
        WeatherBean w1 = new WeatherBean(1, weath.getData().getYesterday().getDate().substring(0,3), weath.getData().getYesterday().getDate().substring(3,6),9, 1);
        WeatherBean w2 = new WeatherBean(2, forecast.get(0).getDate().substring(0,3), forecast.get(0).getDate().substring(3,6), 12, 0);
        WeatherBean w3 = new WeatherBean(3, forecast.get(1).getDate().substring(0,3), forecast.get(1).getDate().substring(3,6), 10, 2);
        WeatherBean w4 = new WeatherBean(3, forecast.get(2).getDate().substring(0,3), forecast.get(2).getDate().substring(3,6),13, 3);
       WeatherBean w5= new WeatherBean(5, forecast.get(3).getDate().substring(0,3), forecast.get(3).getDate().substring(3,6), 10, 6);
        WeatherBean w6 = new WeatherBean(6, forecast.get(4).getDate().substring(0,2), forecast.get(4).getDate().substring(3,5), 10, 5);
        Log.d("", "initView: --------------"+forecast.get(0).getDate().substring(0,3)+"--"+forecast.get(0).getDate().substring(3,6));
       //
      //  WeatherBean w1 = new WeatherBean(1, "10/19", "今日", 20, 15);
//        WeatherBean w2 = new WeatherBean(2, riqi.get(0), ti.get(0), 23, 16);
//        WeatherBean w3 = new WeatherBean(3, riqi.get(1), ti.get(1), 21, 16);
//        WeatherBean w4 = new WeatherBean(4, riqi.get(2), ti.get(2), 18, 16);
//        WeatherBean w5 = new WeatherBean(5, riqi.get(3), ti.get(3), 18, 14);
//        WeatherBean w6 = new WeatherBean(6, riqi.get(4), ti.get(4), 21, 14);

        //weath.getData().getYesterday().getDate().substring(0,3), weath.getData().getYesterday().getDate().substring(3,6);
        data.add(w1);
        data.add(w2);
        data.add(w3);
        data.add(w4);
        data.add(w5);
        data.add(w6);
//
        weatherview.setData(data);

//        WeatherBean w1 = new WeatherBean(1, "10/19", "今日", 20, 15);
//        WeatherBean w2 = new WeatherBean(2, "10/20", "周五", 23, 16);
//        WeatherBean w3 = new WeatherBean(3, "10/21", "周六", 21, 16);
//        WeatherBean w4 = new WeatherBean(4, "10/22", "周日", 18, 16);
//        WeatherBean w5 = new WeatherBean(5, "10/23", "周一", 18, 14);
//        WeatherBean w6 = new WeatherBean(6, "10/24", "周二", 21, 14);
//
//        data.add(w1);
//        data.add(w2);
//        data.add(w3);
//        data.add(w4);
//        data.add(w5);
//        data.add(w6);

       // weatherview.setData(data);

    }

    private int initTime() {
        cale = Calendar.getInstance();
        //int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
   return month;
    }
}
