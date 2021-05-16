package com.zengpeng.mylearnproject;

public class UpdateMebinfoThread implements Runnable {
    private int beginnum = 0;// 开始行数
    private int endnum = 0;// 读取记录数

    public UpdateMebinfoThread(int beginnum, int endnum) {
        super();
        this.beginnum = beginnum;
        this.endnum = endnum;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "===beginnum:" + beginnum);
        System.out.println(Thread.currentThread().getName() + "====endnum:" + endnum);

    }
}
