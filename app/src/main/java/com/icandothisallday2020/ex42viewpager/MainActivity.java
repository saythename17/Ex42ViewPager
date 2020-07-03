package com.icandothisallday2020.ex42viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> items=new ArrayList<>();
    MyAdapter adapter;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items.add(new Integer(R.drawable.b));
        items.add(new Integer(R.drawable.b2));
        items.add(new Integer(R.drawable.b3));

        //Create Adapter Class
        adapter=new MyAdapter(items,getLayoutInflater());
        //ViewPager 에 Adapter 설정
        pager=findViewById(R.id.pager);
        pager.setAdapter(adapter);
    }

    public void clickPrev(View view) {
        //현재 ViewPager 의 page 번호-1 :이전 페이지로 이동
        pager.setCurrentItem(pager.getCurrentItem()-1,true);
        //-1한 결과가 가지고 있는 페이지보다 적으면 연산되지 않음
        //parameter2: default:true(smooth)/false 로 하면 효과X
    }

    public void clickNext(View view) {
        //다음 페이지로 이동
        pager.setCurrentItem(pager.getCurrentItem()+1);
    }
}
