package com.application.sxm.korevie.model

/**
 * 设备信息
 * Created by shixiaoming on 2019-07-11.
 */
data class DeviceInfo (
    val deviceId: String, // 设备ID
    val deviceBrand: String, //手机品牌
    val deviceModel: String, //手机型号
    val osVersion: String //android系统版本
)