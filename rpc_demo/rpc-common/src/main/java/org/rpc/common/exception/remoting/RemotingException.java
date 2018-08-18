package org.rpc.common.exception.remoting;

/**
 *
 * @author zhixiang.yuan
 * @description
 * @create 2018/08/18 22:37
 */
public class RemotingException extends Exception {

    private static final long serialVersionUID = -298481855025395391L;

    public RemotingException(String message) {
        super(message);
    }

    public RemotingException(String message, Throwable cause) {
        super(message, cause);
    }
}
