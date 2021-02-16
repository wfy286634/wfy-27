package com.wfy.utils;


/**
 * @Author wfy
 * @Description: 雪花id算法
 * @Date 16:49 2021/02/14
 **/
public class SmallSnowflake {

    public static final int NODE_SHIFT = 10;
    public static final int SEQ_SHIFT = 12;

    public static final short MAX_NODE = 1023;
    public static final short MAX_SEQUENCE = 4095;

    private short sequence;
    private long referenceTime;

    private final int node;


    public SmallSnowflake(int node) {
        if (node < 0 || node > MAX_NODE) {
            throw new IllegalArgumentException(String.format("node must be between %s and %s", 0, MAX_NODE));
        }
        this.node = node;
    }


    public synchronized long next() {
        long currentTime = this.getCurrentTimeMillis();
        long counter;
        if (currentTime < referenceTime) {
            throw new RuntimeException(String.format("Last referenceTime %s is after reference time %s", referenceTime, currentTime));
        } else if (currentTime > referenceTime) {
            this.sequence = 0;
        } else {
            if (this.sequence < SmallSnowflake.MAX_SEQUENCE) {
                this.sequence++;
            } else {
                throw new RuntimeException("Sequence exhausted at " + this.sequence);
            }
        }
        counter = this.sequence;
        referenceTime = currentTime;

        return currentTime << NODE_SHIFT << SEQ_SHIFT | node << SEQ_SHIFT | counter;
    }

    protected long getCurrentTimeMillis() {
        return System.currentTimeMillis() / 1000;
    }


    /*public static class LargeSnowflake extends SmallSnowflake {

        public LargeSnowflake(int node) {
            super(node);
        }

        @Override
        protected long getCurrentTimeMillis() {
            return System.currentTimeMillis();
        }
    }*/


    //测试
    public static void main(String[] args) {
        /*LargeSnowflake lsf = new LargeSnowflake(1);
        System.out.println(lsf.next());*/
        SmallSnowflake ssf = new SmallSnowflake(1);
        System.out.println(ssf.next());
    }

}