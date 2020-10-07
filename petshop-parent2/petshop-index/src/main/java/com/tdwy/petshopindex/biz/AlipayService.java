package com.tdwy.petshopindex.biz;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.tdwy.petshopindex.IAction.IProductAction;
import com.tdwy.petshopindex.util.AlipayConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class AlipayService {

    // 跳转到支付界面
    public String toPay(String orderId, double price, String orderName, String orderDesc) throws Exception{
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                AlipayConfig.merchant_private_key, "json",
                AlipayConfig.charset, AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = orderId;
        //付款金额，必填
        String total_amount = String.valueOf(price);
        //订单名称，必填
        String subject = orderName;
        //商品描述，可空
        String body = orderDesc;

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String form = "";
        AlipayTradePagePayResponse response = alipayClient.pageExecute(alipayRequest);
        if (response.isSuccess()) {
            form = alipayClient.pageExecute(alipayRequest).getBody();

        }
        return form;
    }

    // 更新订单
    public String updateOrder(Map<String, String> params) {
        if (params == null || params.isEmpty()){
            return "success";
        }
        String orderId = params.get("out_trade_no");
        System.out.println("service订单id：" + orderId);
        String tradeStatus = params.get("trade_status");
        // 支付成功
        if ("TRADE_SUCCESS".equals(tradeStatus)){
            // 更新订单信息
            // ...

            System.out.println("订单支付成功service");
            return "success";
        }
        return "failure";
    }
}