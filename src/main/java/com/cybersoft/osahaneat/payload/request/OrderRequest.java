package com.cybersoft.osahaneat.payload.request;

public class OrderRequest {
    private int userID,resID;
    private int []foodIds;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public int[] getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(int[] foodIds) {
        this.foodIds = foodIds;
    }
}
