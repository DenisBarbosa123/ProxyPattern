package br.edu.univas.vo;

import java.util.Collections;
import java.util.List;

public class ProxyYoutube implements Video{
	Video video;
	
	//Aqui podemos filtrar quem pode ou n�o acessar determinado recurso, nesse caso todos est�o permitidos
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
			return "Acesso n�o permitido";
		}
		
		if(videoCached == null) {
			videoCached = video.getVideoInfo(1);
		}
		
		return videoCached;
	}
}
