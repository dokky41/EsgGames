package com.esg.sms;

import java.util.HashMap;
import org.json.simple.JSONObject;


import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class ydTrSms {
  
	public static String aa(String phNum) {
    String api_key = "NCSNNIAYLPPEFCX9";
    String api_secret = "6GXRFXL0COFUY678RWD4BJM2ADCVEFZV";
    Message coolsms = new Message(api_key, api_secret);

    int authNo = (int)(Math.random() * (99999 - 10000 + 1)) + 10000;
	String inJMail= authNo+"";
    
    // 4 params(to, from, type, text) are mandatory. must be filled
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to",  phNum);
    params.put("from", "01037959228");
    params.put("type", "SMS");
    params.put("text", inJMail);
    params.put("app_version", "test app 1.2"); // application name and version

    
    try {
      JSONObject obj = (JSONObject) coolsms.send(params);
      System.out.println(obj.toString());
    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
    }
    return params.get("text");
  
	}
    
	
}