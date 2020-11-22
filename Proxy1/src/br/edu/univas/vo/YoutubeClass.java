package br.edu.univas.vo;

import java.util.ArrayList;
import java.util.List;

public class YoutubeClass implements Video{
	List<String> listVideos = new ArrayList<String>();
	@Override
	public List<String> getVideoList() {
		listVideos.add("video1");
		return listVideos;
	}

	@Override
	public String getVideoInfo(int id) {
		System.out.println("getting video info");
		return "video1";
	}
}
