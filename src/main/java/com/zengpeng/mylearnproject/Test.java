package com.zengpeng.mylearnproject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newScheduledThreadPool(10);// 初始化线程池
        int count = 1000000; //总数
        int threadCount = 10000; //初始值
        int beginnum = 0;
        int endnum = 0;
        while (count > 0) {
            endnum = count > threadCount ? threadCount : count;
            UpdateMebinfoThread thread = new UpdateMebinfoThread(beginnum, endnum);
            threadPool.execute(thread);
            beginnum = beginnum + endnum;
            count = count - endnum;
        }
        threadPool.shutdown();
    }
}

