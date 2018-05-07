package com.example.hmh.gonlayout.utils

import android.view.View
import android.widget.EditText
import java.util.*

/**
 * Created by HDM on 2018/1/24.
 * E-mail menghedianmo@163.com
 * author HDM
 */

object KTUtils {

        fun getETText(vararg editText: EditText): ArrayList<String> {
            val list: ArrayList<String> = ArrayList()
            for (et in editText) {
                list.add(et.text.toString())
            }
            return list

        }

        fun settvVisibility(boolean: Boolean, vararg view: View) {
            for (v in view) {
                if (boolean) {
                    v.visibility = View.VISIBLE
                } else {
                    v.visibility = View.GONE
                }
            }
        }

        fun isetEmpty(vararg edittext: EditText): Boolean {
            for (editText in edittext) {
                if (editText.text.toString().isEmpty()) {
                    return false
                }
            }
            return true
        }

    fun secToTime(time: Int): String {
        var timeStr: String? = null
        var hour = 0
        var minute = 0
        var second = 0
        if (time <= 0)
            return "00:00"
        else {
            minute = time / 60
            if (minute < 60) {
                second = time % 60
                timeStr = unitFormat(minute) + ":" + unitFormat(second)
            } else {
                hour = minute / 60
                if (hour > 99)
                    return "99:59:59"
                minute = minute % 60
                second = time - hour * 3600 - minute * 60
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second)
            }
        }
        return timeStr
    }

    private fun unitFormat(i: Int): String {
        var retStr: String? = null
        retStr = if (i in 0..9)
            "0" + Integer.toString(i)
        else
            "" + i
        return retStr
    }

}
