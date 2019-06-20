package com.bc.wb.gym.base.dataBean;

public class BeanStore {
    private int storeId; //门店ID
    private String storeName; //门店名称
    private String address; //门店地址
    private int coachCount; //教练的数量
    private int memberCount; //会员的数量
    private int storeOwnerId; //门店店长
    private String dsUrl; //大众点评的连接地址

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCoachCount() {
        return coachCount;
    }

    public void setCoachCount(int coachCount) {
        this.coachCount = coachCount;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public int getStoreOwnerId() {
        return storeOwnerId;
    }

    public void setStoreOwnerId(int storeOwnerId) {
        this.storeOwnerId = storeOwnerId;
    }

    public String getDsUrl() {
        return dsUrl;
    }

    public void setDsUrl(String dsUrl) {
        this.dsUrl = dsUrl;
    }
}
