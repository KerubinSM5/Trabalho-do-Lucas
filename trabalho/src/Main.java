package trabalho2;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Pokemon pokemon1 = new Pokemon("Pikachu", "Um Pokémon Elétrico amarelo e fofinho.", "Elétrico", "Terra", "Pichu -> Pikachu -> Raichu");
	    Pokemon pokemon2 = new Pokemon("Bulbasaur", "Um Pokémon do tipo Planta e Veneno.", "Planta/Veneno", "Fogo, Gelo, Psíquico", "Bulbasaur -> Ivysaur -> Venusaur");
	    Pokemon pokemon3 = new Pokemon("Charmander", "Um pequeno Pokémon do tipo Fogo.", "Fogo", "Água, Terra, Rocha", "Charmander -> Charmeleon -> Charizard");
	    Pokemon pokemon4 = new Pokemon("Squirtle", "Um Pokémon do tipo Água com casca.", "Água", "Planta, Elétrico", "Squirtle -> Wartortle -> Blastoise");
	    Pokemon pokemon5 = new Pokemon("Eevee", "Um Pokémon com incríveis capacidades de evolução.", "Normal", "Lutador", "Eevee -> Vaporeon/Jolteon/Flareon/Espeon/Umbreon/Glaceon/Leafeon/Sylveon");
		Pokemon pokemon6 = new Pokemon("Zorua", "Um Pokémon travesso e astuto que pode se disfarçar de outros Pokémon", "Noturno" ,"Lutador, Inseto, Fada.", "Zorua -> Zoroark" );
		Pokemon pokemon7 = new Pokemon("Zoroark", "Mestre das ilusões, ele confunde e assusta seus oponentes com suas habilidades.", "Noturno", "Lutador, Inseto, Fada.", "Zorua -> Zoroark" );
		Pokemon pokemon8 = new Pokemon("Gastly", "Um gás venenoso que se tornou um Pokémon assombroso, capaz de se solidificar quando necessário.", "Fantasma/Venenoso", "Psíquico, Fantasma.","Gastly -> Haunter -> Gengar.");
		Pokemon pokemon9 = new Pokemon("Haunter", "Um espectro sinistro que gosta de assustar e aprisionar suas vítimas com seus braços sombrios.", "Fantasma/Venenoso", "Psíquico, Fantasma." ,"Gastly -> Haunter -> Gengar.");
		Pokemon pokemon10 = new Pokemon("Gengar", "Ele pode se esconder nas sombras e lançar maldições, absorvendo a energia vital de seus adversários.", "Fantasma/Venenoso", "Psíquico, Fantasma.", "Gastly -> Haunter -> Gengar.");
		Pokemon pokemon11 = new Pokemon("Mew", "Um Pokémon mítico que dizem possuir a composição genética de todos os Pokémon.", "Psíquico" , "Inseto, Fantasma, Sombrio.", "Não tem evoluções");
		Pokemon pokemon12 = new Pokemon("Mewtwo", "Um Pokémon lendário criado artificialmente, possuindo poderes psíquicos incríveis.", "Psíquico" , "Inseto, Fantasma, Sombrio.", "Não tem evoluções");
		Pokemon pokemon13 = new Pokemon("Dratini", "Um Pokémon do tipo dragão com um corpo longo e esguio que habita rios e lagos profundos.", "Dragão", "Gelo, Dragão, Fada." ,"Dratini -> Dragonair -> Dragonite.");
		Pokemon pokemon14 = new Pokemon("Dragonair", "Com um corpo serpenteante e escamas brilhantes, ele parece uma criatura de conto de fadas.", "Dragão", "Gelo, Dragão, Fada.", "Dratini -> Dragonair -> Dragonite.");
		Pokemon pokemon15 = new Pokemon("Dragonite", "Um majestoso dragão que pode voar a grandes velocidades e lançar ataques devastadores.", "Dragão/Voador", "Gelo, Dragão, Fada, Rocha.", "Dratini -> Dragonair -> Dragonite");
	
		Menu menu = new Menu(Arrays.asList(pokemon1), Arrays.asList(pokemon2, pokemon3, pokemon4, pokemon5, pokemon6, pokemon7, pokemon8, pokemon9, pokemon10, pokemon11, pokemon12, pokemon13, pokemon14, pokemon15));
		
		menu.start();

	}

}