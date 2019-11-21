package com.example.baselibrary;

import android.renderscript.RenderScript;
import android.util.Log;

import com.example.baselibrary.mvp.BaseModel;
import com.example.baselibrary.mvp.CommonModel;
import com.example.baselibrary.test.BaseA;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Test {


    public <E extends BaseA,K extends BaseModel>  void   setEKey(E e,K k){

    }

    private BlockingQueue<Runnable> mBlockMQ=new LinkedBlockingDeque<>(128);

    private final AtomicInteger mCount = new AtomicInteger(1);


    public void test() {

        List<String>[] ls = new ArrayList[10];



        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {

            }
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object result) throws Exception {

            }
        });


        Executors.newScheduledThreadPool(3, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {

                return new Thread(r);
            }
        });


        ThreadFactory factory=new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t=new Thread();
                t.setName("test #"+mCount.getAndIncrement());
                t.setDaemon(false);
                t.setPriority(Thread.NORM_PRIORITY);

                return t;
            }
        };

        ThreadPoolExecutor executor=new ThreadPoolExecutor(3, 20, 30, TimeUnit.SECONDS, mBlockMQ, factory, new ThreadPoolExecutor.DiscardOldestPolicy());


        for (int i=0;i<20;i++){
            executor.execute(factory.newThread(new RunnableImpl(i)));
        }
    }

    class RunnableImpl implements Runnable{

        private int mCount;

        public RunnableImpl(int count) {
            this.mCount=count;
        }

        @Override
        public void run() {
            Log.e("error","test:"+mCount);
        }
    }
}
