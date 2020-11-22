package br.edu.univas.vo;

import java.util.List;

public class YoutubeClass implements Video{

	@Override
	public List<String> getVideoList() {
		System.out.println("getting video list");
		return null;
	}

	@Override
	public String getVideoInfo(int id) {
		System.out.println("getting video info");
		return null;
	}
}
