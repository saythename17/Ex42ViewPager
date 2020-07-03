package com.icandothisallday2020.ex42viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter {
    ArrayList<Integer> items;
    LayoutInflater inflater;
    //Constructor
    public MyAdapter(ArrayList<Integer> items, LayoutInflater inflater){
        this.items =items;
        this.inflater=inflater;
    }
    @Override
    public int getCount() {
        return items.size();//이 아답터가 만들 페이지 수를 리턴(데이터의 개수)
    }
    //이 아답터가 page.xml 설계도면을 기반으로 ViewPage 에 보여질 페이지(View 객체)를 만드는 작업
    //≒(ListView 에 사용되는 아답터의  getView()와 같은 메소드)
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //page.xml 의 문서를 읽어와 View 객체로 만들기(부풀려서 실체화)
        View page=inflater.inflate(R.layout.page,null);
        //이 page 안 ImageView 의 현재 position 인 이미지
        ImageView iv=page.findViewById(R.id.iv);
        iv.setImageResource(items.get(position));
        //만들어진 page 를  ViewPager(container) 에 추가
        container.addView(page);
        return page;//만들어진 페이지 뷰 객체 리턴 for 검증
    }
    //화면에 더이상 보이지 않을 때 memory 에서 page 를 제거 하는 메소드
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override           //instateItem() method 에서 만들어서 리턴한 page┐
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;//ViewPager 가 현재화면에 보여줄 view 객체와
        // 위에서 만든 page(object)가 같은지 검증
        }
}
