package com.example.administrator.coolweather.util;

import android.text.TextUtils;

import com.example.administrator.coolweather.model.City;
import com.example.administrator.coolweather.model.CoolWeatherDB;
import com.example.administrator.coolweather.model.County;
import com.example.administrator.coolweather.model.Province;

/**
 * Created by Administrator on 2015/10/19.
 */
public class Utility {
    /*
    处理省级数据
     */
    public synchronized static boolean handleProvinceResponse(CoolWeatherDB coolWeatherDB,String response){
        if(!TextUtils.isEmpty(response)){
            String[] allProvinces = response.split(",");
            if(allProvinces!=null && allProvinces.length>0){
                for (String p :allProvinces
                     ) {
                    String[] array = p.split("//|");
                    Province province =new Province();
                    province.setProvinceName(array[1]);
                    province.setProvinceCode(array[0]);
                    coolWeatherDB.savaProvince(province);
                }
                return  true;
            }
        }
    return false;
    }

    /*
   处理市级数据
    */
    public synchronized static boolean handleCityResponse(CoolWeatherDB coolWeatherDB,String response){
        if(!TextUtils.isEmpty(response)){
            String[] allCitys = response.split(",");
            if(allCitys!=null && allCitys.length>0){
                for (String p :allCitys
                        ) {
                    String[] array = p.split("//|");
                   City city =new City();
                    city.setCityName(array[1]);
                    city.setCityCode(array[0]);
                    coolWeatherDB.savaCity(city);
                }
                return  true;
            }
        }
        return false;
    }

    /*
   处理县级数据
    */
    public synchronized static boolean handleCountyResponse(CoolWeatherDB coolWeatherDB,String response){
        if(!TextUtils.isEmpty(response)){
            String[] allCountys = response.split(",");
            if(allCountys!=null && allCountys.length>0){
                for (String p :allCountys
                        ) {
                    String[] array = p.split("//|");
                    County county =new County();
                    county.setCountyName(array[1]);
                    county.setCountyCode(array[0]);
                    coolWeatherDB.savaCounty(county);
                }
                return  true;
            }
        }
        return false;
    }
}
