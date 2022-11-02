package com.boot.common.util;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.boot.common.distance.DistanceVo;
import com.boot.common.distance.LngLat;
import com.boot.common.enums.SuffixEnum;
import com.boot.common.util.ro.InverseResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TateBrown
 * @date 2020/11/9 2:43 下午
 * 地图工具类
 */
@Slf4j
public class LngLatUtil {


    public static final BigDecimal ZERO = new BigDecimal(0);

    public static final BigDecimal LOW_LNG = new BigDecimal(-180);

    public static final BigDecimal HIHG_LNG = new BigDecimal(180);


    public static final BigDecimal LOW_LAT = new BigDecimal(-90);

    public static final BigDecimal HIGH_LAT = new BigDecimal(90);

    private static ObjectMapper PARSE;

    public static void setPARSE(ObjectMapper parse) {
        LngLatUtil.PARSE = parse;
    }

    /**
     * Baidu地图url
     */


    private static final String BAIDU_URL = "https://api.map.baidu.com";

    private static final String BAIDU_INVERSE = "/reverse_geocoding/v3";

    private static final String BAIDU_AK = "mnnhyIuLpiDInYKbHnlKQZUGI6RLdhB8";

    private static final String BAIDU_OUT_PUT = "json";

    //沙河市百度地图地区code
    private static final String DEFAULT_DISTRICT_CODE = "130582";

    public static String getDistrictIdByBaiDu(LngLat lngLat) {
        Map<String, Object> params = new HashMap<>(3);
        params.put("ak", BAIDU_AK);
        params.put("coordtype", "wgs84ll");
        params.put("output", BAIDU_OUT_PUT);
        params.put("location", lngLat.getInversePosition());
        String result = HttpUtil.get(BAIDU_URL + BAIDU_INVERSE, params);
        try {
            InverseResponse response = PARSE.readValue(result, InverseResponse.class);
            if (ObjectUtil.equal(response.getStatus(), 0)) {
                return response.getResult().getAddressComponent().getAdcode().toString();
            } else {
                log.error("百度地图接口获取失败:{}", response.getStatus());
                return DEFAULT_DISTRICT_CODE;
            }
        } catch (JsonProcessingException e) {
            log.error("百度地图接口获取失败:{}", lngLat);
            return DEFAULT_DISTRICT_CODE;
        }
    }


    private static final String URL = "https://restapi.amap.com";

    /**
     * Path
     */
    private static final String POSITION = "/v3/geocode/geo";

    private static final String ADDRESS = "/v3/geocode/regeo";

    /**
     * key
     */
    private static final String AK = "d904ad0a0105446b16380fa73190572f";

    /**
     * 返回值删除JSON
     */
    private static final String OUTPUT = "json";

    private static final String COMMA = ",";
    private static final String DEFAULT_LNG_LAT = "0,0";

    ///?address=宁波亚细亚&output=json&ak=Xi6wBHhMumyoPhqPc3GZWlmNgqY962na&callback=showLocation

    private static final String STREET = "街道";
    private static final String PROVINCE = "省";

    public static String getLngLat(String address) {
        HashMap<String, Object> query = new HashMap<>(3);
        int min = Math.min(address.length(), 40);
        //需要限制下地址最大长度
        address = address.substring(0, min);
        //地址里不包含省, 需要截取到街道, 否则可能获取不到经纬度
        int pos = address.indexOf(STREET);
        if (!address.contains(PROVINCE) && pos != -1) {
            address = address.substring(0, pos + 2);
        }
        query.put("address", address);
        query.put("output", OUTPUT);
        query.put("key", AK);
        try {
            String requestAddress = URL + POSITION;
            //发送请求
            String res = HttpUtil.get(requestAddress, query);
            JSONObject resObj = new JSONObject(res);
            String status = (String) resObj.get("status");
            if (!"1".equals(status)) {
                return DEFAULT_LNG_LAT;
            }
            List<JSONObject> geocodesArray = (List<JSONObject>) resObj.get("geocodes");
            if (ObjectUtil.isEmpty(geocodesArray)) {
                return DEFAULT_LNG_LAT;
            }
            JSONObject geocode = geocodesArray.get(0);
            String result = (String) geocode.get("location");
            if (ObjectUtil.isNull(result)) {
                return DEFAULT_LNG_LAT;
            }
            return result;
        } catch (Exception e) {
            log.info(e.getMessage());
            return DEFAULT_LNG_LAT;
        }
    }

    public static String getAddress(String position) {
        if (!checkPosition(position)) {
            return null;
        }
        Map<String, Object> params = new HashMap<>(1);
        params.put("location", position);
        params.put("output", OUTPUT);
        params.put("key", AK);
        String resString = HttpUtil.get(URL + ADDRESS, params);
        System.out.println(resString);
        try {
            AddressData addressData = PARSE.readValue(resString, AddressData.class);
            if (addressData.getStatus() == 1) {
                return addressData.getRegeocode().getFormatted_address();
            }
            return null;
        } catch (JsonProcessingException e) {
            log.error("发生异常:{}", e);
            return null;
        }
    }

    @Data

    private static class AddressData {
        private Integer status;

        private String info;

        private Integer infocode;

        private RegeoCode regeocode;

        @Data
        private static class RegeoCode {
            private String formatted_address;
        }
    }

    public static boolean checkPosition(String position) {
        String[] split = position.split(",");
        BigDecimal lng = new BigDecimal(split[0]);
        BigDecimal lat = new BigDecimal(split[1]);
        return !(lat.compareTo(ZERO) == 0 && lng.compareTo(ZERO) == 0)
                ||
                !(lng.compareTo(LOW_LNG) < 0 || lng.compareTo(HIHG_LNG) > 0)
                ||
                !(lat.compareTo(LOW_LAT) < 0 || lat.compareTo(HIGH_LAT) > 0);
    }

    private static final String ERROR = "ERROR";

    public static DistanceVo getDistance(String my, String her) {
        DistanceVo vo = new DistanceVo();
        if (CharSequenceUtil.isNotBlank(my)
                && CharSequenceUtil.isNotBlank(her) && !"0,0".equals(my) && !"0,0".equals(her)) {
            LngLat myPosition = new LngLat(my);
            LngLat herPosition = new LngLat(her);
            String distance = myPosition.getDistance(herPosition);
            if (new BigDecimal(distance).compareTo(new BigDecimal("1000")) < 0) {
                vo.setDistance(new BigDecimal(distance).setScale(0, RoundingMode.HALF_UP).toString());
                vo.setSuffix(SuffixEnum.M.getMark());
            } else {
                vo.setDistance(new BigDecimal(distance).divide(new BigDecimal("1000"), 2, RoundingMode.HALF_UP).toString());
                vo.setSuffix(SuffixEnum.KM.getMark());
            }

        } else {
            vo.setDistance("另一半的定位未设置");
            vo.setSuffix("请提醒他去小程序");
        }
        return vo;
    }
}
