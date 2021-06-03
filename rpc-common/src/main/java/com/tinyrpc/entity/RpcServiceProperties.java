package com.tinyrpc.entity;

import lombok.*;

/**
 * input description here
 *
 * @author wql
 * @date 2021/5/21
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RpcServiceProperties {

    private String version;

    /**
     * 当接口有多个实现类时，通过group进行区分
     */
    private String group;
    private String serviceName;

    public String toRpcServiceName() {
        return this.getServiceName() + this.getGroup() + this.getVersion();
    }
}
