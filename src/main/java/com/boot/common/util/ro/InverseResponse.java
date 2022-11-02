package com.boot.common.util.ro;

import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName InverseResponse
 * @Description TODO
 * @Date 2022/10/31 13:43
 */

@Data
public class InverseResponse {

    /**
     * 返回状态码
     */
    private Integer status;


    private Result result;


    @Data
    public static class Result {
        /**
         * 地址话结构信息
         */
        private String formatted_address;

        /**
         * 具体信息
         */
        private AddressComponent addressComponent;


        @Data
        public static class AddressComponent {
            private Integer adcode;
        }

    }


}
