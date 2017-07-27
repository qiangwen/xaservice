package com.xa.gtsorderserver.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * twitter snowflake 
 * @author qiang.wen
 * @date 2017年7月27日 上午9:52:19
 */
public class SnowflakeIdService{

    protected static final Logger LOG = LoggerFactory.getLogger(SnowflakeIdService.class);
    
    private static SnowflakeIdService snowflakeIdService = new SnowflakeIdService();

    private long workerId;
    private long datacenterId;
    private long sequence = 0L;

    private long twepoch = 1288834974657L;

    private long workerIdBits = 5L;
    private long datacenterIdBits = 5L;
    private long sequenceBits = 12L;

    private long workerIdShift = sequenceBits;
    private long datacenterIdShift = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long lastTimestamp = -1L;
    
    public static SnowflakeIdService getInstance(int appId){
    	if(snowflakeIdService == null){
    		snowflakeIdService = new SnowflakeIdService();
    	}
    	snowflakeIdService.datacenterId = appId;
    	snowflakeIdService.workerId = appId;
    	return snowflakeIdService;
    }

    public synchronized Long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            LOG.error(String.format("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp));
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }
}
