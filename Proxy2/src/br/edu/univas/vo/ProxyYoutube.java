package br.edu.univas.vo;

import java.util.Collections;
import java.util.List;

public class ProxyYoutube implements Video{
	Video video;
	
	//Aqui podemos filtrar quem pode ou não acessar determinado recurso, nesse caso todos estão permitidos
	boolean isAllowed = true;
	
	List<String> cachedVideos;
	
	String videoCached;
	
	public ProxyYoutube(Video video) {
		this.video = video;
	}
	@Override
	public List<String> getVideoList() {
		if(!isAllowed) {
			return Collections.emptyList();
		}
		
		if(cachedVideos == null) {
			cachedVideos = video.getVideoList();
		}
		return cachedVideos;
	}
	@Override
	public String getVideoInfo(int id) {
		if(!isAllowed) {
			return "Acesso não permitido";
		}
		
		if(videoCached == null) {
			videoCached = video.getVideoInfo(1);
		}
		
		return videoCached;
	}
}
