package br.com.gabriellpa.dashboardjobs.config;


import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.nosql.redis.JedisRedisStorageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;


@Configuration
public class JobrunrConfiguration {

    @Bean
    public StorageProvider storageProvider(JobMapper jobMapper) {
        JedisRedisStorageProvider jedisRedisStorageProvider = new JedisRedisStorageProvider(new JedisPool("redis", 6379));
        jedisRedisStorageProvider.setJobMapper(jobMapper);
        return jedisRedisStorageProvider;
    }
}
