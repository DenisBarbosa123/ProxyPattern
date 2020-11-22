package br.edu.univas.main;

import br.edu.univas.vo.ProxyYoutube;
import br.edu.univas.vo.YoutubeClass;

public class Runner {
	public static void main(String[] args) {
		ProxyYoutube proxy = new ProxyYoutube(new YoutubeClass());
		proxy.getVideoInfo(1);
		proxy.getVideoList();
	}
}
