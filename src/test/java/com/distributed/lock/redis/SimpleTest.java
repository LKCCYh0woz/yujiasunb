package com.distributed.lock.redis;

import com.distributed.lock.Callback;
import org.junit.Test;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunyujia@aliyun.com on 2016/2/24.
 */
public class SimpleTest {



    public static void main(String[] args) throws Exception {
        JedisPool jedisPool=new JedisPool("127.0.0.1",6379);//实际应用时可通过spring注入
        RedisReentrantLock lock=new RedisReentrantLock(jedisPool,"订单流水号");
        try {
            if (lock.tryLock(5000L, TimeUnit.MILLISECONDS)) {
                //TODO 获得锁后要做的事
            }else{
                //TODO 获得锁超时后要做的事
            }
        }finally {
            lock.unlock();
        }
    }
}
