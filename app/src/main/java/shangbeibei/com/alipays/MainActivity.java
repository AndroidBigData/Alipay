package shangbeibei.com.alipays;

import android.os.Handler;
import android.os.Message;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import shangbeibei.com.alipays.utils.alipay.Result;
import shangbeibei.com.alipays.utils.alipay.SignUtils;
import shangbeibei.com.alipays.utils.common.Constants;
import shangbeibei.com.alipays.utils.common.RandomUtils;

public class MainActivity extends AppCompatActivity {


    private Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pay = ((Button) findViewById(R.id.pay));
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay();
            }
        });
    }

    private String P_NAME ="滑板鞋";
    private String P_ADDRESS ="滑板鞋";
    private String CHARGE ="0.01";
    /**
     * 进行支付
     */
    public  void pay(){
        String orderInfo =getOrderInfo(P_NAME,P_ADDRESS,CHARGE);
        String sign =sign(orderInfo);

        try {
            sign = URLEncoder.encode(sign,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        final  String payInfo =orderInfo+"&sign=\""+sign +"\"&" +getSignType();

        Runnable payRunnable =new Runnable() {
            @Override
            public void run() {
//                构造payTask 对象
                PayTask alipay =new PayTask(MainActivity.this);
//                调用支付接口
                String result =alipay.pay(payInfo);

                Message msg =new Message();
                msg.what = Constants.SDK_PAY_FLAG;
                msg.obj =result;
                mHandler.sendMessage(msg);
            }
        };
        Thread payThread =new Thread(payRunnable);
        payThread.start();
    }
    Handler mHandler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case Constants.SDK_PAY_FLAG:{
                    Result resultObj =new Result((String) msg.obj);
                    String resultStatus =resultObj.resultStatus;
//                    判断resultstatus  为9000 支付成功
                    if (TextUtils.equals(resultStatus,"9000")){

                        //实际项目中支付成功后,可根据项目要求,在这里进行操作
                        Toast.makeText(MainActivity.this,"支付成功",Toast.LENGTH_SHORT).show();
                    }else {
//                        判断resultstatus 为非 9000  则代表 失败
//                        8000
//                        代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认
                        if (TextUtils.equals(resultStatus,"8000")){
                            Toast.makeText(MainActivity.this,"支付结果确认中",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this,"支付失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                }
                case Constants.SDK_CHECK_FLAG:{
                    Toast.makeText(MainActivity.this,"检查结果为："+msg.obj,Toast.LENGTH_SHORT).show();
                    break;
                }

                default:
                    break;
            }
        }
    };

    /**
     * sign the order info. 对订单信息进行签名
     *
     * @param content
     *            待签名订单信息
     */
    public String sign(String content) {
        return SignUtils.sign(content, Constants.RSA_PRIVATE);
    }

    /**
     * get the sign type we use. 获取签名方式
     *
     */
    public String getSignType() {
        return "sign_type=\"RSA\"";
    }


    /**
     * get the out_trade_no for an order. 获取外部订单号
     *
     */
    public String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);

        key = key + RandomUtils.getFixLenthString();
        key = key.substring(0, 15);
        return key;
    }

    /**
     * create the order info. 创建订单信息
     *
     */
    public String getOrderInfo(String subject, String body, String price) {
        // 合作者身份ID
        String orderInfo = "partner=" + "\"" + Constants.PARTNER + "\"";

        // 卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + Constants.SELLER + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + getOutTradeNo() + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + subject + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + body + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + price + "\"";

        // 服务器异步通知页面路径
        // *******如果是公司项目,这里需要将http://notify.msp.hk/notify.htm改为
        //公司后台提供的网址,以便支付宝将支付结果通知到自己的服务器,不然公司的服务器是不知道用户是否
        //支付及支付结果;如果是个人练习,这里不必更改;******
        orderInfo += "&notify_url=" + "\"" + "http://notify.msp.hk/notify.htm" + "\"";
        // 接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";

        // 调用银行卡支付，需配置此参数，参与签名， 固定值
        // orderInfo += "&paymethod=\"expressGateway\"";

        return orderInfo;
    }


}
