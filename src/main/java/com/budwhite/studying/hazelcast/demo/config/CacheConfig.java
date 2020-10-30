package com.budwhite.studying.hazelcast.demo.config;

import com.hazelcast.cluster.Member;
import com.hazelcast.cluster.impl.MemberImpl;
import com.hazelcast.config.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class CacheConfig {

    @Value("${server.port}")
    private int serverPort;

    @Bean
    public Config hazelcastConfig() {
        System.out.println("Configuring hazelcast for node on port " + serverPort);
        return new Config()
                .setClusterName("dev")
                .setNetworkConfig(
                        new NetworkConfig()
                        .setPort(5701)
                        .setPortAutoIncrement(true)
                        .setJoin(
                                new JoinConfig()
                                .setMulticastConfig(
                                        new MulticastConfig()
                                        .setEnabled(false)
                                )
                                .setTcpIpConfig(
                                        new TcpIpConfig()
                                        .setEnabled(true)
                                        .setMembers(
                                                Collections.singletonList(
                                                        "localhost"
                                                )
                                        )
                                )
                        )
                );
    }
}
