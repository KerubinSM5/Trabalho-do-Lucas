package trabalho2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.text.Normalizer;


public class Menu {
	
	Scanner sc = new Scanner(System.in);
	int opcao;
	
	private List<Pokemon> meusPokemons = new ArrayList<>();
	private List<Pokemon> todosPokemons = new ArrayList<>();
	
	public Menu(List<Pokemon> meusPokemons, List<Pokemon> todosPokemons) {
		this.meusPokemons.addAll(meusPokemons);
		this.todosPokemons.addAll(todosPokemons);
	}
	
	public void start() {
		
		menuPrincipal();
		
//		System.out.println("MEUS POKEMONS");
//		meusPokemons.forEach(System.out::println);
//		
//		System.out.println();
//		
//		System.out.println("TODOS POKEMONS");
//		todosPokemons.forEach(System.out::println);
	}
	
	private void menuPrincipal() {
		
//		meusPokemons.forEach(System.out::println);
//		todosPokemons.forEach(System.out::println);
		System.out.println(" ____       _            _           \r\n"
				+ "|  _ \\ ___ | | _____  __| | _____  __\r\n"
				+ "| |_) / _ \\| |/ / _ \\/ _` |/ _ \\ \\/ /\r\n"
				+ "|  __/ (_) |   <  __/ (_| |  __/>  < \r\n"
				+ "|_|   \\___/|_|\\_\\___|\\__,_|\\___/_/\\_\\");
		
		System.out.println();
		System.out.println("1 - Listar todos os Pokemons");
		System.out.println("2 - Listar os meus Pokemons");
		System.out.println("3 - Batalhar");
		System.out.println("4 - Adicionar Pokemon");
		System.out.println("5 - Remover Pokemon");
		System.out.println();

		System.out.print("Selecione uma opção: ");
		opcao = sc.nextInt();
		
		switch(opcao) {
			case 1:
		    	listarTodosPokemons();
		    	break;
			case 2:
				listarMeusPokemons();
				break;
			case 3:
				batalhar();
				break;
			case 4:
				adicionarPokemon();
				break;
			case 5:
				removerPokemon();
				break;
			
		}
		
	}
	
	private void listarTodosPokemons() {
	    System.out.println("TODOS OS POKEMONS DISPONÍVEIS:");
	    todosPokemons.forEach(System.out::println);
	    System.out.println();
	    System.out.println("1 - Filtrar por tipo");
	    System.out.println("0 - Voltar ao menu principal");
	    System.out.print("Escolha uma opção: ");
	    opcao = sc.nextInt();
	    switch (opcao) {
	        case 1:
	            Filtrar();
	            break;
	        case 0:
	            menuPrincipal();
	            break;
	        default:
	            System.out.println("Opção inválida.");
	            listarTodosPokemons();
	            break;
	    }
	}

	private void Filtrar() {
	    System.out.println("Digite o tipo de Pokémon que deseja filtrar:");
	    sc.nextLine(); 
	    String tipo = sc.nextLine().toLowerCase(); 
	    List<Pokemon> pokemonsFiltrados = new ArrayList<>();
	    for (Pokemon pokemon : todosPokemons) {
	        if (pokemon.getTipagem().toLowerCase().contains(tipo)) {
	            pokemonsFiltrados.add(pokemon);
	        }
	    }
	    if (pokemonsFiltrados.isEmpty()) {
	        System.out.println("Nenhum Pokémon encontrado com o tipo '" + tipo + "'.");
	    } else {
	        System.out.println("POKÉMONS DO TIPO '" + tipo.toUpperCase() + "':");
	        pokemonsFiltrados.forEach(System.out::println);
	    }
	    System.out.println();
	    System.out.print("Digite 0 para voltar ao menu principal: ");
	    opcao = sc.nextInt();
	    if (opcao == 0) {
	        menuPrincipal();
	    } else {
	        System.out.println("Opção inválida.");
	        Filtrar();
	    }
	}

	
	private void listarMeusPokemons() {
		System.out.println();
		meusPokemons.forEach(System.out::println);
		System.out.println();
		
		System.out.print("Digite 0 para voltar ou o id do pokemon para visualizar: ");
		opcao = sc.nextInt();
		
		Optional<Pokemon> pokemonOpt = meusPokemons.stream().filter(pokemon -> pokemon.id == opcao).findFirst();
		
		if(pokemonOpt.isEmpty()) {
			System.out.println("Pokemon com o id: " + opcao + " não existe.");
			menuPrincipal();
		}else {
			interagirComPokemon(pokemonOpt.get());
		}
	}
	
	public void interagirComPokemon(Pokemon pokemon) {
		System.out.println("POKEMON SELECIONADO: " + pokemon.getNome());
		
		System.out.println(pokemon);
	}
	
	private void adicionarPokemon(){
		System.out.println();
		System.out.println("TODOS OS POKEMONS");
		todosPokemons.forEach(System.out::println);
		System.out.println();
		
		System.out.print("Digite 0 para voltar ou o id do pokemon para adicionar ao seu deck: ");
		opcao = sc.nextInt();
		
		if(opcao != 0) {
			Optional<Pokemon> pokemonOpt = todosPokemons.stream().filter(pokemon -> pokemon.id == opcao).findFirst();
			
			if(pokemonOpt.isEmpty()) {
				System.out.println("Pokemon com o id: " + opcao + " não existe.");
				menuPrincipal();
			}
			
			Optional<Pokemon> pokemonNoMeuDeck = meusPokemons.stream().filter(pokemon -> pokemon.equals(pokemonOpt.get())).findFirst();
			
			if(pokemonNoMeuDeck.isEmpty()) {
				meusPokemons.add(pokemonOpt.get());
				System.out.println("Parabéns! \nPokemon " + pokemonOpt.get().nome + " adicionado ao seu deck.");
				menuPrincipal();
			}else {
				System.out.println("Pokemon " + pokemonOpt.get().nome + " já existe no seu deck.");
				menuPrincipal();
			}
		}else {
			menuPrincipal();
		}
		
	}
	
	private void removerPokemon() {
		System.out.println();
		System.out.println("SEUS POKEMONS");
		meusPokemons.forEach(System.out::println);
		System.out.println();
		
		System.out.print("Digite 0 para voltar ou o id do pokemon para removê-lo do seu deck: ");
		opcao = sc.nextInt();
		
		Optional<Pokemon> pokemonRemover = meusPokemons.stream().filter(pokemon -> pokemon.id == opcao).findFirst();
		
		 if (meusPokemons.size() <= 1) {
		        System.out.println("Você só tem um Pokémon no seu deck. Não é possível removê-lo.");
		        menuPrincipal();
		        return;
		    }
		if(pokemonRemover.isEmpty()) {
			System.out.println("Pokemon com o id: " + opcao + " não existe.");
			menuPrincipal();
		}else {
			meusPokemons.remove(pokemonRemover.get());
			System.out.println("Pokemon com o id: " + opcao + " removido com sucesso.");
			menuPrincipal();
		}
	}
	
	private void batalhar() {
		System.out.println("SUA POKEDEX");
		
		meusPokemons.forEach(System.out::println);
		System.out.print("Escolha o pokemon que vai à batalha: ");
		opcao = sc.nextInt();
		
		Pokemon pokemonAliado = meusPokemons.stream().filter(pokemon -> pokemon.id == opcao).findFirst().get();
		
		System.out.println();
		
		System.out.println("POKEDEX DO SISTEMA");
		todosPokemons.forEach(System.out::println);
		System.out.print("Escolha o pokemon que quer capturar: ");
		opcao = sc.nextInt();
		
		Pokemon pokemonInimigo = todosPokemons.stream().filter(pokemon -> pokemon.id == opcao).findFirst().get();
		
		campoDeBatalha(pokemonAliado, pokemonInimigo);
	}
	
	private void campoDeBatalha(Pokemon pokemonAliado, Pokemon pokemonInimigo) {
		System.out.println(" _____                                                                                                 _____ \r\n"
				+ "( ___ )                                                                                               ( ___ )\r\n"
				+ " |   |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|   | \r\n"
				+ " |   |  ___ _   _ ___ ____ ___    _    _   _ ____   ___    ____    _  _____  _    _     _   _    _     |   | \r\n"
				+ " |   | |_ _| \\ | |_ _/ ___|_ _|  / \\  | \\ | |  _ \\ / _ \\  | __ )  / \\|_   _|/ \\  | |   | | | |  / \\    |   | \r\n"
				+ " |   |  | ||  \\| || | |    | |  / _ \\ |  \\| | | | | | | | |  _ \\ / _ \\ | | / _ \\ | |   | |_| | / _ \\   |   | \r\n"
				+ " |   |  | || |\\  || | |___ | | / ___ \\| |\\  | |_| | |_| | | |_) / ___ \\| |/ ___ \\| |___|  _  |/ ___ \\  |   | \r\n"
				+ " |   | |___|_| \\_|___\\____|___/_/   \\_\\_| \\_|____/ \\___/  |____/_/   \\_\\_/_/   \\_\\_____|_| |_/_/   \\_\\ |   | \r\n"
				+ " |___|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|___| \r\n"
				+ "(_____)                                                                                               (_____)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(pokemonAliado);
		System.out.println();
		System.out.println(pokemonInimigo);
		
			
		FotoPokemon.mostrar(pokemonAliado.nome);
		System.out.print("\r\n"
				+ "\\ \\/ /\r\n"
				+ " \\  / \r\n"
				+ " /  \\ \r\n"
				+ "/_/\\_\\");
		FotoPokemon.mostrar(pokemonInimigo.nome);
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(pokemonInimigo.fraquezas.contains(pokemonAliado.tipagem)) {
			System.out.println(pokemonAliado.getNome() + " ganhou a batalha pois a tipagem é melhor!");
			try {
				Thread.sleep(1000);
				
				System.out.println("  ____    _    ____ _____ _   _ ____      _    ____   ___  \r\n"
						+ " / ___|  / \\  |  _ \\_   _| | | |  _ \\    / \\  |  _ \\ / _ \\ \r\n"
						+ "| |     / _ \\ | |_) || | | | | | |_) |  / _ \\ | | | | | | |\r\n"
						+ "| |___ / ___ \\|  __/ | | | |_| |  _ <  / ___ \\| |_| | |_| |\r\n"
						+ " \\____/_/   \\_\\_|    |_|  \\___/|_| \\_\\/_/   \\_\\____/ \\___/ ");
				
				System.out.println("PARABÉNS, você ganhou e capturou o pokemon: " + pokemonInimigo.nome);
				meusPokemons.add(pokemonInimigo);
				todosPokemons.remove(pokemonInimigo);
				
				Thread.sleep(1000);
				menuPrincipal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}else  {
			System.out.println(pokemonAliado.getNome() + " perdeu a batalha pois a tipagem é pior!");
			try {
				Thread.sleep(1000);
				menuPrincipal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		/*} else if  {
		System.out.println("Não há vantagem de tipo ou fraqueza na batalha!");
		System.out.println("Decidindo o vencedor no impar ou par:");
		try {
	        Thread.sleep(1000);
	        menuPrincipal();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	
	    Random random = new Random();
	    boolean venceu = random.nextBoolean();
	    if (venceu) {
	    	System.out.println("  ____    _    ____ _____ _   _ ____      _    ____   ___  \r\n"
					+ " / ___|  / \\  |  _ \\_   _| | | |  _ \\    / \\  |  _ \\ / _ \\ \r\n"
					+ "| |     / _ \\ | |_) || | | | | | |_) |  / _ \\ | | | | | | |\r\n"
					+ "| |___ / ___ \\|  __/ | | | |_| |  _ <  / ___ \\| |_| | |_| |\r\n"
					+ " \\____/_/   \\_\\_|    |_|  \\___/|_| \\_\\/_/   \\_\\____/ \\___/ ");
			
			System.out.println("PARABÉNS, você ganhou e capturou o pokemon: " + pokemonInimigo.nome);
			meusPokemons.add(pokemonInimigo);
			todosPokemons.remove(pokemonInimigo);
	    } else {
	        System.out.println("Você perdeu!");
	    }*/
	}
	    
	
	
	







		
		
	}
	
}