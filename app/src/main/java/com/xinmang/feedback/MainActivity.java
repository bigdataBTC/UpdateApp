package com.xinmang.feedback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xinmang.feedback.app.Contants;
import com.xinmang.feedbackproject.utils.AppUpdateUtils;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        findViewById(R.id.feed_back).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                QuestionnaireUtils.Questionnaire(MainActivity.this,"https://www.wenjuan.in/s/vIZZniv/");
//                startActivity(new Intent(MainActivity.this, FeedBackActivity.class));
//            }
//        });
//
//
//        findViewById(R.id.to_webview).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                QuestionnaireUtils.Questionnaire(MainActivity.this,"https://www.wenjuan.in/s/vIZZniv/");
////                startActivity(new Intent(MainActivity.this, FeedBackActivity.class));
//            }
//        });

        //检测版本更新,一般放在MainActivity
        AppUpdateUtils.update(MainActivity.this);

//        SheildMannager.setRequest(Contants.SHILED,Contants.BASE_URL,Contants.REQUEST_URl);







    }
}
