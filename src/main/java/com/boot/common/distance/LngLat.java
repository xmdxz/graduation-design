package com.boot.common.distance;

import cn.hutool.core.text.CharSequenceUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author YuanXin
 * @ClassName LngLat
 * @Description TODO
 * @Date 2022/8/11 15:25
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LngLat {
    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;


    public LngLat(String position) {
        if (CharSequenceUtil.isNotBlank(position)) {
            String[] arr = position.split(",");
            this.lng = arr[0];
            this.lat = arr[1];
        }

    }

    public String getPosition() {
        if (CharSequenceUtil.isBlank(lat)) {
            lat = "0";
        }
        if (CharSequenceUtil.isBlank(lng)) {
            lng = "0";
        }
        return lng + "," + lat;
    }

    public String getInversePosition() {
        if (CharSequenceUtil.isBlank(lat)) {
            lat = "0";
        }
        if (CharSequenceUtil.isBlank(lng)) {
            lng = "0";
        }
        return lat + "," + lng;
    }


    public String getDistance(LngLat other) {
        return String.valueOf(getDistance(new Double(this.lng), new Double(this.lat), new Double(other.lng), new Double(other.lat)));
    }


    /**
     * 默认地球半径
     */
    private static final double EARTH_RADIUS = 6371000;

    /**
     * 转化为弧度(rad)
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * @param lon1 第一点的精度
     * @param lat1 第一点的纬度
     * @param lon2 第二点的精度
     * @param lat2 第二点的纬度
     * @return 返回的距离，单位m
     */
    public static double getDistance(double lon1, double lat1, double lon2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        return s;
    }

}
