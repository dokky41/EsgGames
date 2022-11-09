package com.esg.service;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService{

	
	@Override
	public JSONArray getgameMeca() {
			// Jsoup를 이용해서 크롤링 - 게임메카 게임순위
				String url = "https://www.gamemeca.com/ranking.php";

				Document doc = null; // Document에 페이지의 전체 소스가 저장됨

				try {
					doc = Jsoup.connect(url).get();

				} catch (IOException e) {
					e.printStackTrace();
				}

				// select를 이용하여 원하는 태그를 선택
				Elements gameRanking = doc.select(".game-name a"); //게임메카순위

				// JSON 형태로 로아 정보 저장
				JSONArray gameRankingList = new JSONArray();

				for (int i = 0; i < 10; i++) {
					// JSONObject에 키:값 형태로 데이터 저장
					JSONObject obj = new JSONObject();

					obj.put("rank", gameRanking.get(i).text());

					// RoaNews에 생성한 JSONObject 추가
//						log.info(obj+"");
					gameRankingList.add(obj);
				}

				return gameRankingList;
	}

}
