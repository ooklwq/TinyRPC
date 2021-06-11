package com.tinyrpc.serialize.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.tinyrpc.exception.SerializeException;
import com.tinyrpc.remoting.dto.RpcRequest;
import com.tinyrpc.remoting.dto.RpcResponse;
import com.tinyrpc.serialize.Serializer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import lombok.extern.slf4j.Slf4j;


/**
 * Kryo serialization class, kryo serialization efficiency is very high, but not only compatible with Java Language
 *
 * @author wql
 * @date 2021/6/10
 */
@Slf4j
public class KryoSerializer implements Serializer {

    /**
     * because kryo is note thread safe. So use ThreadLocal to store kryo objects
     */
    private final ThreadLocal<Kryo> kryoThreadLocal = ThreadLocal.withInitial(() -> {
        Kryo kryo = new Kryo();
        kryo.register(RpcResponse.class);
        kryo.register(RpcRequest.class);
        return kryo;
    });

    @Override
    public byte[] serialize(Object obj) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Output output = new Output(byteArrayOutputStream)) {
            Kryo kryo = kryoThreadLocal.get();
            // Object -> byte: 将对象序列化为byte数组
            kryo.writeObject(output, obj);
            kryoThreadLocal.remove();
            return output.toBytes();
        } catch (Exception e) {
            throw new SerializeException("Serialization failed.");
        }
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            Input input = new Input(byteArrayInputStream)) {
            Kryo kryo = kryoThreadLocal.get();
            // byte -> Object:从byte数组中反序列化出对象
            Object o = kryo.readObject(input, clazz);
            kryoThreadLocal.remove();
            return clazz.cast(o);
        } catch (Exception e) {
            throw new SerializeException("Serialization failed.");
        }
    }
}
