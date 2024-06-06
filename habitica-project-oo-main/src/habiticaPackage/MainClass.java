package habiticaPackage;

import java.util.Scanner;

public class MainClass {
	SaveData saveData = new SaveData();
	User users[] = new User[1000];
//	Tag tag = new Tag();
//	TagsSaveData tSaveData = new TagsSaveData();
//	private String name;
//	private boolean checked;
	
	public static void main(String[] args) {
		MainClass instance = new MainClass();
		
//		instance.tarefa.tag = new Tag[10];
//		instance.tarefa.tag[0] = new Tag();
//		instance.habito.doHabit(1);
//		
//		instance.habito.ResetLimit("daily");
		
//		instance.loadTagData();
//		instance.tag.setTagName(instance.name);
//		instance.tag.setChecked(instance.checked);
//		
//		if(instance.name != null ) {
//
//			instance.tarefa.tag[0].setTagName(instance.name);
//			instance.tarefa.tag[0].setChecked(instance.checked);
//			System.out.println("tarefa tag: " + instance.tarefa.tag[0].getTagName());
//			
//		}
//		
//		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("TagName: ");
//		instance.tag.setTagName(scan.next());
//		System.out.println("check" + instance.tag.getChecked());
//		scan.close();
//		
//		
//		
//		
//		
//		instance.tSaveData.saveTagData(instance.tag.getTagName(), instance.tag.getChecked());
		
		//instance.menuUI();
		instance.menuTeste();
	}
	
	public void menuTeste() {
		int count = 0;
		System.out.println("Seja bem vindo! selecione uma das opçôes a seguir: ");	
		Scanner scanString = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		
		do {
			System.out.println("\n1-criar conta\n2-entrar com conta existente\n3-sair");
			count = scanInt.nextInt();
			
			switch(count) {
			case 1:
				criarUsuario(scanString, scanInt);
				break;
			case 2:
				users = saveData.loadData(users);
				logarUsuario(scanString, scanInt);
				break;
			case 4:
				saveData.deleteData(1);
				users = saveData.loadData(users);
				for(int i = 0; i < users.length; i++) {
					if(users[i] == null) break;
					System.out.println("usuarios ativos: " + users[i].getUserName() + " " + users[i].getPassword());
					
				}
				break;
			}
		}while(count != 3);
	}
	public void criarUsuario(Scanner scanString, Scanner scanInt) {
		String userName = "";
		String password = "";
		int count = 0;
		
			
		do {
			System.out.println("digite o nome de usuario:");
			userName = scanString.nextLine();
			System.out.println("\nDigite sua senha:");
			password = scanString.nextLine();
			System.out.println("\nDeseja confirmar seus dados?\n1-Sim\n2-Nao");
			count = scanInt.nextInt();
			
			
		}while(count != 1);
		
		User user = new User(userName, password);
		for(int i=0; i < users.length; i++) {
			if(users[i] == null) {
				users[i] = user;
				break;
			}
		}
		saveData.saveData(users);
	}
	
	public boolean logarUsuario(Scanner scanString, Scanner scanInt) {
		String userName = "";
		String password = "";
		boolean logged = false;
		int count = 0;
		
		do {
			System.out.println("\nEscreva seu nome de usuario: ");
			userName = scanString.nextLine();
			System.out.println("\nEscreva sua senha: ");
			password = scanString.nextLine();
			
			System.out.println("\nNome de usuario: " + userName + "\nSenha: " + password);
			
			System.out.println("\nDeseja confimar suas credenciais?\n1-Sim\n2-Nao");
			count = scanInt.nextInt();
			if(count == 1) {
				for(int i = 0; i< users.length; i++) {
					if(users[i] != null) {
						if(users[i].getUserName().equals(userName) && users[i].getPassword().equals(password)) {
							logged = true;
							System.out.println("logado com sucesso!");
							break;
						}
					}
				}
				if(logged == false) System.out.println("\nNao foi possivel realizar o login, tente novamente");
			}
			
		}while(logged == false);
		
		return logged;
	}
	public void menuUI() {
		int count = 0;
		int count1 = 0;
		Habit habito = new Habit();

		
		System.out.println("Seja bem vindo! selecione uma das opçôes a seguir: ");	
		Scanner scanString = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		
		do {
			System.out.println("\n1-criar um habito \n2-Ver um habito \n3-sair");
			count = scanInt.nextInt();
			
			switch(count) {
			case 1:
				System.out.println("\nDigite o titulo: ");
				habito.setTitle(scanString.nextLine());
				System.out.println("\nAgora, digite a descricao: ");
				habito.setNote(scanString.nextLine());
				
				do {
					
					System.out.print("\nAgora, selecione se o seu habito será um habito positivo ou negativo(pode pode tanto selecionar os dois ao mesmo tempo, quanto deixar de seleionar)\n\nAssim que terminar pressione a tecla para continuar");
					if(habito.getPositiveSelected() == false && habito.getNegativeSelected() == false) {
						System.out.print("\n\n 1-Habilitar habito positivo           2-Habilitar habito negativo\n\n");

					}
					else if(habito.getPositiveSelected() == true && habito.getNegativeSelected() == false) {
						System.out.print("\n\n 1-Desabilitar habito positivo           2-Habilitar habito negativo\n\n");
					}
					else if(habito.getPositiveSelected() == false && habito.getNegativeSelected() == true) {
						System.out.print("\n\n 1-Habilitar Habito positivo           2-Desabilitar Habito negativo\n\n");
					}
					else if(habito.getPositiveSelected() == true && habito.getNegativeSelected() == true) {
						System.out.print("\n\n 1-Desabilitar Habito positivo           2-Desabilitar Habito negativo\n\n");
					}
					System.out.println("3-Continuar");
					
					count1 = scanInt.nextInt();
					switch(count1) {
					case 1:
						if(habito.getPositiveSelected() == false) habito.setPositiveSelected(true);
						else habito.setPositiveSelected(false);
						break;
						
					case 2:
						if(habito.getNegativeSelected() == false) habito.setNegativeSelected(true);
						else habito.setNegativeSelected(false);
						break;
					case 3:
						break;
						default:
							System.out.println("\nOpcao invalida! tente novamente\n");
					}
				}while(count1 != 3);
				break;
			case 2:
				if(habito.getTitle() != null) {
					System.out.print("\nTitulo: " + habito.getTitle() + "\nNota: " + habito.getNote());
					System.out.print("\nHabito positivo: " + habito.getPositiveSelected() + "\nHabito negativo: " + habito.getNegativeSelected() + "\n\n");
				}
				else System.out.println("Não há habitos ainda");
				break;
			case 3:
				System.out.print("\nSaindo\n");
				System.exit(0);
				break;
				
				default:
					System.out.println("\nOpcao invalida! tente novamente\n");
					break;
			}
			
		}while(count != 3);
		
		scanString.close();
		scanInt.close();
	}
	
	
//	public void loadTagData() {
//		try {
//			FileInputStream fis = new FileInputStream("save.dat");
//			BufferedInputStream bis = new BufferedInputStream(fis);
//			ObjectInputStream ois = new ObjectInputStream(bis);
//			
//			TagsSaveData tSaveData = (TagsSaveData)ois.readObject();
//			name = tSaveData.tagName;
//			checked = tSaveData.checked;
//			
//			System.out.println("Save carregado com sucesso!: " + name);
//			
//			ois.close();
//			
//		}catch(IOException e) {
//			e.printStackTrace();
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

}
