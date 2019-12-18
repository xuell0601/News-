package xyz.xl06.news.ui.Actitvy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import xyz.xl06.news.R;
import xyz.xl06.news.leftmenu.LeftBen;
import xyz.xl06.news.utils.LeftMenu;

/**
 * Created by xueliang on 2019/2/15 0015.
 */
public class LeftMenusAdapter extends BaseAdapter {
    private List<LeftBen> leftMenu=null;
    private Context con;

    public LeftMenusAdapter(MainActivity mainActivity) {
        this.con = mainActivity.getApplicationContext();
        //获取数据
        leftMenu = LeftMenu.getLeftMenu();
    }

    @Override
    public int getCount() {
        return leftMenu != null ? leftMenu.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return leftMenu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder _Holder = null;
        if (convertView == null) {
            _Holder = new Holder();
            convertView = View.inflate(con,R.layout.item_left_menu_layout, null);
            _Holder.item_left_view_img = (ImageView) convertView.findViewById(R.id.item_left_view_img);
            _Holder.item_left_view_title = (TextView) convertView.findViewById(R.id.item_left_view_title);
            convertView.setTag(_Holder);
        } else {
            _Holder = (Holder) convertView.getTag();
        }
        _Holder.item_left_view_img.setImageResource(leftMenu.get(position).getIco());
        _Holder.item_left_view_title.setText(leftMenu.get(position).getTitle());
        return convertView;
    }

    private static class Holder {
        ImageView item_left_view_img=null;
        TextView item_left_view_title=null;
    }
}