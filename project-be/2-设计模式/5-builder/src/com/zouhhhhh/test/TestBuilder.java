package com.zouhhhhh.test;

import com.zouhhhhh.builder.TicketBuilder;
import com.zouhhhhh.helper.TicketHelper;


/**
 * @author zouhao
 * @date 2022/5/6
 */
public class TestBuilder {

    public static void main(String[] args) {
        TicketHelper helper = new TicketHelper();
        helper.buildAdult("成人票");
        helper.buildChildrenForSeat("有座儿童");
        helper.buildChildrenNoSeat("无座儿童");
        helper.buildElderly("老人票");
        helper.buildSoldier("军人票");
        Object ticket = TicketBuilder.builder(helper);
    }

}
