package controle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
public class Serializar {
 
	/**
	* Esse método recebe um objeto arquivo e o objeto que será serializado. 
        * O método irá serializar o objeto passado no arquivo (referenciado pelo objeto file).
	*/
	public static void salvarObjeto(File file, Object objeto) throws FileNotFoundException,
 IOException {
 
		if (objeto == null) {
			throw new NullPointerException("Objeto passado é nulo");
		}
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;

 
		try {
			fileOut = new FileOutputStream(file, false);
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(objeto);
 
		} 
		catch (FileNotFoundException e) {
			throw new FileNotFoundException("O arquivo não pode ser encontrado");
		} 
		catch (IOException e) {
			throw new IOException("Erro de entrada e saída");
		}
		finally {
			if (fileOut != null) {
				fileOut.close();
			}
 
			if (objOut != null) {
				objOut.close();
			}
		}
 
	}
 
	/**
	* Para ler o objeto serializado, nós somente precisamos no arquivo onde 
        * esse objeto está salvado.
	* Sabendo o arquivo, nós conseguimos recuperar o objeto tranquilamente.
	*/
	public static Object recuperarObjeto(File file) throws FileNotFoundException, IOException,
ClassNotFoundException {
		Object obj = null;
 
		if (file == null) {
			throw new NullPointerException("Objeto FILE é Nulo.");
		}
 
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
 
		try {
			fileIn = new FileInputStream(file);
			objIn = new ObjectInputStream(fileIn);
 
			obj = objIn.readObject();
		}
		catch (FileNotFoundException e) {
			throw new FileNotFoundException("Arquivo não encontrado");
		}
		catch (IOException e) {
			throw new IOException("Erro de entrada e saída");
		}
		catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Erro ao recuperar objeto do arquivo");
		}
		finally {
			if (fileIn != null) {
				fileIn.close();
			}
 
			if (objIn != null) {
				objIn.close();
			}
		}
 
		return obj;
	}
}