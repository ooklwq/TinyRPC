package com.tinyrpc;

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
public class HelloObject implements Serializable {
    private String message;
    private String description;
}
