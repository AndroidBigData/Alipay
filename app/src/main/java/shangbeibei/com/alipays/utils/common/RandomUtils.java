package shangbeibei.com.alipays.utils.common;

/**
 * Created by Administrator on 2016/2/20.
 */
public class RandomUtils {

    public static String getFixLenthString() {
        String result = "";
        for(int i = 0; i < 4; i++){
            int key = (int)((Math.random()*9+1)*10000);
            result += String.valueOf(key);
        }

        return result;
    }

}
