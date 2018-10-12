package com.imooc.passbook.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>User  Object</h1>
 * Create by  hanbian
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /** 用户id */
    private Integer  id;

    /** 用户基本信息*/
    private BaseInfo  baseInfo;

    /** 用户额外信息*/
    private OtherInfo otherInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public OtherInfo getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(OtherInfo otherInfo) {
        this.otherInfo = otherInfo;
    }

    public User(Integer id, BaseInfo baseInfo, OtherInfo otherInfo) {
        this.id = id;
        this.baseInfo = baseInfo;
        this.otherInfo = otherInfo;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static  class BaseInfo{
        private  String name;
        private  Integer age;
        private  String sex;

        public BaseInfo(String name, Integer age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OtherInfo{
        private  String phone;
        private  String address;

        public OtherInfo(String phone, String address) {
            this.phone = phone;
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
