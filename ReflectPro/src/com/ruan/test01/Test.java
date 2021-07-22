package com.ruan.test01;

/**
 * @PackgeName: com.ruan.test01
 * @ClassName: Test
 * @Author: ruan
 * Date: 2021/7/3 9:36
 * project name: Data-structure-and-algorithm
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

        String str = "支付宝";
        if ("支付宝".equals(str)){
            //支付宝
            //new AliPay().payOnline();
            pay(new AliPay());
        }
        if ("微信".equals(str)){
            //微信
            //new WeChatPay().payOnline();
            pay(new WeChatPay());
        }
    }
    public static void pay(Mtwm mtwm){
        mtwm.payOnline();
    }
}
