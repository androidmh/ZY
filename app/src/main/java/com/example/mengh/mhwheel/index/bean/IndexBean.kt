package com.example.mengh.mhwheel.index.bean

/**
 * Author by HDM, Email menghedianmo@163.com, Date on 2018/4/10.
 * PS: Not easy to write code, please indicate.
 */
class IndexBean{
    var orderId: Int = 0
    var orderNo: String? = null
    var orderInfo: String? = null

    constructor(orderId: Int, orderNo: String?, orderInfo: String?) {
        this.orderId = orderId
        this.orderNo = orderNo
        this.orderInfo = orderInfo
    }
}