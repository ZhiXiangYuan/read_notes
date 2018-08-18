package com.rpc.remoting.model;

/**
 * <p>  </p>
 *
 * @author zhixiang.yuan
 * @description
 * @create 2018/08/18 20:40
 */
public class ByteHolder {

    private transient byte[] bytes;

    public byte[] bytes() {
        return bytes;
    }

    public void bytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int size() {
        return bytes == null ? 0 : bytes.length;
    }

}
