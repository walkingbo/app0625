package com.ssb.app0625;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        //ListView에 출력할 데이터 생성
        List<VO> list = new ArrayList<>();
        VO vo = new VO();
        vo.icon =R.drawable.ic_launcher_foreground;
        vo.name = "Java";
        list.add(vo);

        vo = new VO();
        vo.icon = R.drawable.ic_launcher_background;
        vo.name = "Oracle";
        list.add(vo);


        MyAdapter adapter = new MyAdapter(CustomActivity.this,R.layout.icontext,list);
        ListView listView = (ListView)findViewById(R.id.customlistview);
        listView.setAdapter(adapter);

        //여러 개의 애니메이션을 적용하기 위한 객체 생성
        AnimationSet set = new AnimationSet(true);
        //위치 이동 애니메이션
        Animation rtl = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,0.0f,
                Animation.RELATIVE_TO_SELF,0.0f, Animation.RELATIVE_TO_SELF,0.0f);
        rtl.setDuration(1000);
        //애니메이션 집합에 추가
        set.addAnimation(rtl);

        //알파 애니메이션
        Animation alpha = new AlphaAnimation(0.0f,1.0f);
        alpha.setDuration(1000);
        set.addAnimation(alpha);

        //레이아웃 애니메이션 객체 생성
        LayoutAnimationController controller = new LayoutAnimationController(set);
        listView.setLayoutAnimation(controller);

    }
}
