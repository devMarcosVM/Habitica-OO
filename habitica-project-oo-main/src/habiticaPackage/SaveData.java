package habiticaPackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SaveData implements Serializable {
	private static final long serialVersionUID = 1L;
	User users[] = new User[1000];
	
	public void saveData(User users[]) {
		try {
			FileOutputStream fos = new FileOutputStream("save.dat");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			SaveData saveData = new SaveData();
			saveData.users = users;
			
			oos.writeObject(saveData);
			oos.close();
			
			System.out.println("\nSave realizado com sucesso!");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void updateData(User user, int position) {
		try {
			SaveData updateSaveData = new SaveData();
			updateSaveData.users = loadData(updateSaveData.users);
			
			FileOutputStream fos = new FileOutputStream("save.dat");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			SaveData saveData = new SaveData();
			saveData = updateSaveData;
			 
			if(updateSaveData.users[position] != null) {
				saveData.users[position] = user;
			}
			else System.out.println("\nNao foi possivel atualizar o usuario");
			
			oos.writeObject(saveData);
			oos.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public User[] loadData(User[] users) {
		try {
			FileInputStream fis = new FileInputStream("save.dat");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			SaveData saveData =(SaveData)ois.readObject();
			System.out.println("\nSave carregado com sucesso!");
			ois.close();
			return users = saveData.users;
				
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteData(int position) {
		updateData(null, position);
	}
	
//	public void saveTagData(String tagName, boolean checked) {
//		try {
//			FileOutputStream fos = new FileOutputStream("save.dat");
//			BufferedOutputStream bos = new BufferedOutputStream(fos);
//			ObjectOutputStream oos = new ObjectOutputStream(bos);
//			
//			TagsSaveData tSaveData = new TagsSaveData();
//			tSaveData.tagName = tagName;
//			tSaveData.checked = checked;
//			oos.writeObject(tSaveData);
//			oos.close();
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public void loadTagData(String tagName, boolean checked) {
//		try {
//			FileInputStream fis = new FileInputStream("save.dat");
//			BufferedInputStream bis = new BufferedInputStream(fis);
//			ObjectInputStream ois = new ObjectInputStream(bis);
//			
//			TagsSaveData tSaveData = (TagsSaveData)ois.readObject();
//			tagName = tSaveData.tagName;
//			checked = tSaveData.checked;
//			
//			System.out.println("Save carregado com sucesso!");
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
