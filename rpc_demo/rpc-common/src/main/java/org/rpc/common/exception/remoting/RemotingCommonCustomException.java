package org.rpc.common.exception.remoting;

/**
 *
 * @author zhixiang.yuan
 * @description
 * @create 2018/08/18 22:29
 */
public class RemotingCommonCustomException extends RemotingException {


    private static final long serialVersionUID = 1546308581637799641L;


    public RemotingCommonCustomException(String message) {
        super(message, null);
    }


    public RemotingCommonCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
