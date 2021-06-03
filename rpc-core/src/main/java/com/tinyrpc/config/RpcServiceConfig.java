package com.tinyrpc.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RpcServiceConfig {

    /**
     * service version
     */
    private String version = "";

    /**
     * when the interface has multiple implementation classes, distinguish by group;
     */
    private String group = "";

    /**
     * target service
     */
    private Object service;

    public String getRpcServiceName() {
        return this.getServiceName() + this.getGroup() + this.getVersion();
    }

    public String getServiceName() {
        return this.service.getClass().getInterfaces()[0].getCanonicalName();
    }
}
