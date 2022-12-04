package com.esg.sms;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class ydTrPwSms {

	public static String aa(String phNum) {
		String api_key = "NCSNNIAYLPPEFCX9";
		String api_secret = "6GXRFXL0COFUY678RWD4BJM2ADCVEFZV";
		Message coolsms = new Message(api_key, api_secret);

		Random rnd = new Random();

		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < 10; i++) {

			// rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. true일 시 랜덤 한 소문자를, false 일 시 랜덤 한
			// 숫자를 StringBuffer 에 append 한다.

			if (rnd.nextBoolean()) {

				buf.append((char) ((int) (rnd.nextInt(26)) + 97));

			} else {

				buf.append((rnd.nextInt(10)));

			}

		}

		String inJMail = buf + "";

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", phNum);
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