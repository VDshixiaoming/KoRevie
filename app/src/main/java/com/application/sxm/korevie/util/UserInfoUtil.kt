package com.application.sxm.korevie.util

import android.os.Build
import java.util.*

/**
 * 用户信息辅助类
 * Created by shixiaoming on 2019-07-11.
 */
class UserInfoUtil {



    companion object {
        private var deviceId = ""

        fun getDeviceId(): String {
            if (!deviceId.isEmpty()) {
                return deviceId
            }
            var serial: String
            val mDevShort = StringBuilder()
            mDevShort.append("35").append(Build.BOARD.length % 10)
                .append(Build.BRAND.length % 10).append(Build.CPU_ABI.length % 10)
                .append(Build.DEVICE.length % 10).append(Build.DISPLAY.length % 10)
                .append(Build.HOST.length % 10).append(Build.ID.length % 10)
                .append(Build.MANUFACTURER.length % 10).append(Build.MODEL.length % 10)
                .append(Build.PRODUCT.length % 10).append(Build.TAGS.length % 10)
                .append(Build.TYPE.length % 10).append(Build.USER.length % 10)
            try {
                serial = Build::class.java.getField("SERIAL").get(null).toString()
                deviceId = UUID(mDevShort.hashCode().toLong(), serial.hashCode().toLong()).toString()
                return deviceId
            } catch (e: Exception) {
                serial = "serial"
            }
            deviceId = UUID(mDevShort.hashCode().toLong(), serial.hashCode().toLong()).toString()
            return deviceId
        }

        /**
         * 手机品牌
         */
        fun getDeviceBrand(): String{
            return Build.BRAND
        }

        /**
         * 手机型号
         */
        fun getDeviceModel(): String{
            return Build.MODEL
        }

        /**
         * 系统版本
         */
        fun getOsVersion(): String{
            return Build.VERSION.RELEASE
        }
    }
}