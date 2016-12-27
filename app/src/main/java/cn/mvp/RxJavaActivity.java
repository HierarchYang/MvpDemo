package cn.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import rx.Observable;
import rx.Subscriber;

public class RxJavaActivity extends AppCompatActivity {
    private Button btn_rx_java;
    private static final String TAG = "RxJavaActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        btn_rx_java = (Button) findViewById(R.id.btn_rx_java);
        btn_rx_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRxJava();
            }
        });
    }

    private void initRxJava() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello World");
                subscriber.onCompleted();
            }
        });
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "---->" + s);
            }
        };
        observable.subscribe(subscriber);
    }
}
