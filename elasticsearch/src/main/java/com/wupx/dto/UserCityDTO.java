package com.wupx.dto;

/**
 * 城市聚合dto
 *
 * @author wupx
 * @date 2020/07/06
 */
public class UserCityDTO {
    /**
     * 城市
     */
    private String city;
    /**
     * 用户数
     */
    private Long count;
    /**
     * 平均年龄
     */
    private Double avgAge;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getAvgAge() {
        return avgAge;
    }

    public void setAvgAge(Double avgAge) {
        this.avgAge = avgAge;
    }

    @Override
    public String toString() {
        return "UserCityDTO{" +
                "city='" + city + '\'' +
                ", count=" + count +
                ", avgAge=" + avgAge +
                '}';
    }
}
