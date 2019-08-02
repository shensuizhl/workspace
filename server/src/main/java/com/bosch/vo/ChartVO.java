package com.bosch.vo;

import java.io.Serializable;

/**
 * @program: demo
 * @description: VO for chart value
 * @author: wjy
 * @create: 2019-06-06 10:27
 */

public class ChartVO implements Serializable {

    //Axis label
    String label;

    //Data value
    float value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ChartVO{" +
                ", label='" + label + '\'' +
                ", value=" + value +
                '}';
    }
}
