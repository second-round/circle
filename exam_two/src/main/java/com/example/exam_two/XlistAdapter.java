package com.example.exam_two;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exam_two.bean.UserBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

class XlistAdapter extends BaseAdapter {
    private List<UserBean.DataBean> list;
    private Context context;
    private final int NUMBER=2;

    public XlistAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<UserBean.DataBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    public void addList(List<UserBean.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public UserBean.DataBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return NUMBER;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getThumbnail_pic_s02()==null&&list.get(position).getThumbnail_pic_s03()==null?0:1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(
                    getItemViewType(position)==0?R.layout.item_one:R.layout.item_two
                    ,parent,false
            );
            holder=new ViewHolder(convertView);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        if (getItemViewType(position)==0){
            holder.initText(list.get(position));
        }else {
            holder.initImage(list.get(position));
        }
        return convertView;
    }
    class ViewHolder{
        TextView textView1,textView2;
        ImageView imageView1,imageView2,imageView3;

        public ViewHolder(View convertView) {
            textView1=convertView.findViewById(R.id.textView1);
            textView2=convertView.findViewById(R.id.textView2);

            imageView1=convertView.findViewById(R.id.imageView1);
            imageView2=convertView.findViewById(R.id.imageView2);
            imageView3=convertView.findViewById(R.id.imageView3);
            convertView.setTag(this);
        }
        public void initText(UserBean.DataBean dataBean) {
            textView1.setText(dataBean.getTitle());
            textView2.setText(dataBean.getCategory());
            ImageLoader.getInstance().displayImage(dataBean.getThumbnail_pic_s(),imageView1);

        }

        public void initImage(UserBean.DataBean dataBean) {
            textView1.setText(dataBean.getTitle());
            ImageLoader.getInstance().displayImage(dataBean.getThumbnail_pic_s(),imageView1);
            ImageLoader.getInstance().displayImage(dataBean.getThumbnail_pic_s02(),imageView2);
            ImageLoader.getInstance().displayImage(dataBean.getThumbnail_pic_s03(),imageView3);

        }
    }


}
