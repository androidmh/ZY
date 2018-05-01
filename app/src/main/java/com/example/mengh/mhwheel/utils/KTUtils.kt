package com.example.hmh.gonlayout.utils

import android.view.View
import android.widget.EditText
import java.util.*

/**
 * Created by HDM on 2018/1/24.
 * E-mail menghedianmo@163.com
 * author HDM
 */

class KTUtils {
    companion object {
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
    }

}
