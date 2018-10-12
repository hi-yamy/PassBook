package com.imooc.passbook.passbook.mapper;

import com.imooc.passbook.passbook.constant.Constants;
import com.imooc.passbook.passbook.vo.User;
import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * <H1>HBase User Row To User  Object</H1>
 * Create by hanbian
 */
public class UserRowMapper implements RowMapper<User> {
    private  static  byte[] FAMILY_B= Constants.UserTable.FAMLIY_B.getBytes();
    private  static  byte[] NAME =Constants.UserTable.NAME.getBytes();
    private  static  byte[]  AGE =Constants.UserTable.AGE.getBytes();
    private  static  byte[] SEX =Constants.UserTable.SEX.getBytes();

    private static byte[] FAMILY_O =Constants.UserTable.FAMLIY_O.getBytes();
    private static byte[] PHONE  = Constants.UserTable.PHONE.getBytes();
    private static byte[]  ADDRESS = Constants.UserTable.ADDRESS.getBytes();
    @Override
    public User mapRow(Result result, int i) throws Exception {
        User.BaseInfo baseInfo =new User.BaseInfo(
                Bytes.toString(result.getValue(FAMILY_B,NAME)),
                Bytes.toInt(result.getValue(FAMILY_B,AGE)),
                Bytes.toString(result.getValue(FAMILY_B,SEX))
        );
        User.OtherInfo  otherInfo = new User.OtherInfo(
                Bytes.toString(result.getValue(FAMILY_O,PHONE)),
                Bytes.toString(result.getValue(FAMILY_O,ADDRESS))
        );
        return new User(
               Bytes.toInt(result.getRow()),baseInfo,otherInfo
        );
    }
}
