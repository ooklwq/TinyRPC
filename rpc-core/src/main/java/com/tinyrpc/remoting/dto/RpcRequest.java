package com.tinyrpc.remoting.dto;

import com.tinyrpc.entity.RpcServiceProperties;
import lombok.*;

import java.io.Serializable;

/**
 * input description here
 *
 * @author wql
 * @date 2021/5/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RpcRequest implements Serializable {
    private static final long serialVersionUID  = 1905122041950251207L;
    private String requestId;
    private String interfaceName;
    private String methodName;
    private Object[] parameters;
    private Class<?>[] paramTypes;
    private String version;
    private String group;

    public RpcServiceProperties toRpcpropertiese() {
        return RpcServiceProperties.builder().serviceName(this.getInterfaceName())
                .version(this.getVersion())
                .group(this.getGroup()).build();
    }

}
