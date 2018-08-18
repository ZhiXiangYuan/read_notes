package org.rpc.common.transport.body;

import org.rpc.common.exception.remoting.RemotingCommonCustomException;

/**
 *
 * @author zhixiang.yuan
 * @description
 * @create 2018/08/18 22:26
 */
public interface CommonCustomBody {

    void checkFields() throws RemotingCommonCustomException;

}
