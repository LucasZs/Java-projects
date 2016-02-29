package movies_v3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class ObjectServer {
	private static final int TCP = 5000;
	private static final String FILE_PATH = "products.ser";
	
	private static ServerSocket server = null;
	private static Socket socket = null;
	
	private static ObjectInputStream objectsFromSocket = null;
	private static ObjectOutputStream objectsToSocket = null;
	private static ObjectInputStream objectsFromFile = null;
	private static ObjectOutputStream objectsToFile = null;
	
	private static ServerMode mode;
	
	public static void main(String[] args) {
		try {
			startUp();
			while (true) {
				recieve();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(ClassCastException e) {
			e.printStackTrace();
		}
	}

	private static void startUp() throws IOException {
		server = new ServerSocket(TCP);
		socket = server.accept();
		objectsFromSocket = new ObjectInputStream(socket.getInputStream());
		objectsToSocket = new ObjectOutputStream(socket.getOutputStream());
	}
	
	private static void switchToGetMode() throws IOException {
		if (objectsToFile != null) {
			objectsToFile.close();
		}
		objectsFromFile = new ObjectInputStream(new FileInputStream(FILE_PATH));
		mode = ServerMode.LOAD;
	}
	
	private static void switchToPutMode() throws IOException {
		if (objectsFromFile != null) {
			objectsFromFile.close();
		}
		objectsToFile = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
		mode = ServerMode.SAVE;
	}
	
	private static void recieve() throws ClassCastException, ClassNotFoundException, IOException {
		Object objectReceived;
		try {
			objectReceived = objectsFromSocket.readObject();
			if (objectReceived instanceof Command) {
				switch((Command)objectReceived) {
					case GET:
						switchToGetMode();
						send(load());
						break;
					case PUT:
						switchToPutMode();
						break;
					case EXIT:
						shutDown();
				}
			} else {
				if (mode != null && mode.equals(ServerMode.SAVE)) {
					save((Product)objectReceived);
				}
			}
				
			
		} catch (EOFException e) {
			System.out.println("EOF");
			// nothing has arrived yet, nothing to do
		}
	}
	
	private static void send(List<Product> products) throws IOException {
			objectsToSocket.writeObject(products);
		
	}
	
	private static List<Product> load() throws ClassNotFoundException, IOException {
		List<Product> products = new ArrayList<>();
		try {
			while(true) {
				products.add((Product)objectsFromFile.readObject());
			}
		} catch (EOFException e) {
			// end of file, nothing to do
		}
		return products;
	}
	
	private static void save(Product productToStore) throws IOException {
		objectsToFile.writeObject(productToStore);
	}
	
	private static void shutDown() {
		if (objectsToFile != null) {
			try {
				objectsToFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (objectsFromFile != null) {
			try {
				objectsFromFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (objectsFromSocket != null) {
			try {
				objectsFromSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (objectsToSocket != null) {
			try {
				objectsToSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (server != null) {
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
}
