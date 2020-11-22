# ProxyPattern
Para um projeto em que há por exemplo uma classe de acesso ao banco dados ou acesso a dados pesados, onde a cada vez que é inicializado objeto é gasto grande por parte de recursos de hardware, o padrão Proxy pode ser de grande ajuda. Este padrão também vem para adicionar funcionalidade de controlar qual usuário pode ou não usar aquele metodo, isso se assemelha muito aos Proxy de *internet*, que fazem controle de acesso.

# Como fazer?

Para implementar esse padrão de projeto basta:  criar uma **interface** comum entre **ProxyClass** e **DataBaseClass** onde na primeira classe temos atributo do tipo DataBaseClass e fazemos inicialização dele no construtor do ProxyClass, isso faz com que **inicialização** seja mais "leve", pois só quando formos usar realmente proxy que ela será inicilizada, e também esse atributo nos permite ter acesso aos metodos de acesso a banco de dados. Lá dentro do ProxyClass podemos ter flag de **permissão**, se por exemplo determinado usuário pode acessar aquele metodo, e também podemos adicionar variáveis de **cache**, permitindo ganho de perfomance.

# Exemplo

Segue exemplo em java de uma classe de Proxy, onde vemos por exemplo funcionalidade de cache (evitando de toda hora acessar banco de dados), e também de controle de acesso.

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

# Vantagens

-   Você pode controlar o objeto do serviço sem os clientes ficarem sabendo.
-   Você pode gerenciar o ciclo de vida de um objeto do serviço quando os clientes não se importam mais com ele.
-   O proxy trabalha até mesmo se o objeto do serviço ainda não está pronto ou disponível.
-   _Princípio aberto/fechado_. Você pode introduzir novos proxies sem mudar o serviço ou clientes.
# Desvantagens
-   O código pode ficar mais complicado uma vez que você precisa introduzir uma série de novas classes.
-   A resposta de um serviço pode ter atrasos.
