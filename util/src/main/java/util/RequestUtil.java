package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class RequestUtil {
	
	private static final String CHAR_SET = "UTF-8";
	
	public static Map<String, String> bodyToMap(BufferedReader body) throws IOException {
		return bodyToMap(body, CHAR_SET);
	}

	public static Map<String, String> bodyToMap(BufferedReader body, String charset) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
        String line;
        // BufferedReader를 사용하여 요청 본문을 읽습니다.
        while ((line = body.readLine()) != null) {
            stringBuilder.append(line);
        }
        String bodyString = stringBuilder.toString();
        String[] paramAndValue = bodyString.split("&");
        
        Map<String, String> map = new HashMap<String, String>();
        
        if( paramAndValue != null )
        for (String str : paramAndValue) {
			String[] param = str.split("=");
			if( param == null ) continue;
			String p = param[0];
			String v = URLDecoder.decode(param[1], "UTF-8");
			System.out.println(p + "=" + v);
			map.put(p, v);
		}
		return map;
	}
	
}
