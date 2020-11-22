package br.edu.univas.main;

import java.io.File;

import br.edu.univas.vo.YoutubeClass;

public class Runner {
	public static void main(String[] args) {
		//aqui poderiamos usar diretamente a classe YoutubeClass, a desvantagem é que toda vez que fossemos carregar
		//lista de videos ou um unico video, objeto seria populado. sem cache, e tambem no teriamos nenhum controle de acesso, todos teriamos a permissão de usar
		YoutubeClass youtubeClass = new YoutubeClass();
		youtubeClass.getVideoInfo(1);
		youtubeClass.getVideoList();
	}
}
