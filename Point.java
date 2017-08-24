package com.ziytek.taozhu.base.util;

import java.io.Serializable;

/**
 * 类描述：
 *
 */
public class Point implements Serializable {
    private static final long serialVersionUID = -4333831679948500401L;

    public Point() {
    }

    public Point(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /* 经度 */
    private double longitude;

    /* 纬度 */
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
