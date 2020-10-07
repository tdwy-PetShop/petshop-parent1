package com.tdwy.petshopindex.util;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    //960d2201b1766877

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102900777340";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDBfothJvmL4txPgtU9lePt8QZJ9ug9+l6POzwlC81nBh+FUpAFEdWD267vZOV/pBeLuQ/RTmMYStYY4T59LhC7KrurUsM/cdxuqDhx8RCGbTWRMQLPldhsbcMFfgnO0I0PdsJ/NcMru3I6MSVRLxIrWmsmmXWedTd0Zwgy3II2u3bC8vMLvSuP/Ggok3ooHSwwxJBseb8IrlHvyghX8aVV+Rf/ZjoBOnaGialAM/QjO42YleLr0RHtCDgWs0iK73EEkAptO/AyC5h54bZ/zju5KxhH2wKHsJRDC5+MzqWGIravRwUn0hWJi2Japuqw33STaXbWN+bTBBfmVXusCisTAgMBAAECggEAFH7xCKN2P4kSSSHUsKdV83hacC9FPnts1MMzhcEQSt9tK1QpiT/wW/1DNHx9it242MYLlOI2wPX8Y7pIQj5E626FXopvwCKxdM9A22DrnTGoQO7uG0sGF8YwqD5Hj66ron2z8IGjYNiEKwHVsBnKVOlI/Fe5C8Xiz+OyDKEq8d0OPlweeRy272d6IX2Klelw3prSngSIzvDP/uLr58lBBs2uZw8AxGqNXyQUWVX9lMrJFiQe9l2GIC1MILZnjOcm1YpT0KW5F9TMK4tT4hoBQ2jNB24/yC3n8EheGABsVOtT3DMIL4DZmSBy4GNYL/lE7v4SltRcK8/vsRFmzrIL8QKBgQD1+9FL/3csc0dAPByv5ojTWEtWAnA0TU+OtcjzAf7M/L3Bw7X3Cjm/5e8SRND3tuqLnllhy9yTxinq/aaSKQEZ9U5FozCBAuKGgldDuLyekU7f1urRXXAJE5nFc5rkY++yS9xRJ8rz1GbSr3AfjkkeFXlLcN7B8EdKYoPl0g8fXQKBgQDJX5FJCjz/LneWqp0jqofHsjTjDvt/imlZQNRb90eO9hSSULr2WxysiM00LFjGL2HT/p33aILR36SwJiiCCvL/C6yDs8m6pqVYdpBLyGaHMtjiqCIBSG3TA8Vmu8+CsDAvjUaybnkdW2HspEXkT3Mfrt+p/4hiKzvTTfAfxI99LwKBgQDV3b83KEHhL8k/HASFGxbTSe0WNsB/eMg29+5i+dUjPItvME3BH+7d3XhildppxWtfQKnN0YVSJfTEDw0H/waqHxGSkjPVt0BkWmasxq2X4BaHn0BCD88c1SHY/o4pDIqWpkZDeSmHnaBYhZgil38S3PC8msHSNKqHDehHpL7pMQKBgQC5s+USW1u25A4qpno1SuzeTswQ3F831dejFHMBwH+AKhT8fXB9AbbmsV2zkHXphgaMbpEUeI+zpa+FNhtDGX/Pjd9wsRsGgumWM/iLumo6obx7ARwi3L1SzHZ9cBNEbOBy6bDZmaEdXolmpnNBwbbj7+uZJOqLxVztV0FqumSsxwKBgAH37O1dBAClM3290xD1ZE60d2QkWpoJqQwWMLpyFDNmge53lWbI7x9QUwpcxKqwmz5RwwgRPjeo6hLyy/MTzgey61Av7Td7je7rvu+NoaAw1Q/2tOmdHoRb+uztWVKOEJ01Al4d8TANgenLHaeFYE34weHI1QLOYe/Sr0JArzfL";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwX6LYSb5i+LcT4LVPZXj7fEGSfboPfpejzs8JQvNZwYfhVKQBRHVg9uu72Tlf6QXi7kP0U5jGErWGOE+fS4Quyq7q1LDP3Hcbqg4cfEQhm01kTECz5XYbG3DBX4JztCND3bCfzXDK7tyOjElUS8SK1prJpl1nnU3dGcIMtyCNrt2wvLzC70rj/xoKJN6KB0sMMSQbHm/CK5R78oIV/GlVfkX/2Y6ATp2hompQDP0IzuNmJXi69ER7Qg4FrNIiu9xBJAKbTvwMguYeeG2f847uSsYR9sCh7CUQwufjM6lhiK2r0cFJ9IViYtiWqbqsN90k2l21jfm0wQX5lV7rAorEwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://nw9a23.natappfree.cc/notify_url.view";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 即支付成功之后，需要跳转到的页面，一般为网站的首页
    // 便于测试，直接使用了 baidu
    public static String return_url = "http://nw9a23.natappfree.cc/return_url.view";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志存储路径
    public static String log_path = "C:\\";


    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

