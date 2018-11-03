package exception;

@SuppressWarnings("serial")
public class ListException extends Exception {
	public ListException(String mensaje) {
		super(mensaje);
	}
	
//	PriorityQueue<Hola> e = new PriorityQueue<>();
//	MainPracticoDos a = new MainPracticoDos();
//	e.add(a.new Hola(5));
//	e.add(a.new Hola(6));
//	e.add(a.new Hola(3));
//	e.add(a.new Hola(20));
//	e.add(a.new Hola(1));
//	System.out.println(""+e.poll().number);
//	System.out.println(""+e.poll().number);
//	System.out.println(""+e.poll().number);
//	System.out.println(""+e.poll().number);
//	System.out.println(""+e.poll().number);
//	
//	try {
//		MainPracticoDos practico = new MainPracticoDos();
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		String lector = "";
//
//		int numeroCasos = Integer.parseInt(br.readLine());
//
//		for (int i = 0; i < numeroCasos; i++) {
//
//			int tamañoSecuenciaPequeña = Integer.parseInt(br.readLine());
//			
//			practico.arreglos(tamañoSecuenciaPequeña, tamañoSecuenciaPequeña+1);
//
//			for (int j = 0; j < tamañoSecuenciaPequeña+1; j++) {
//				lector = br.readLine();
//				if(j < tamañoSecuenciaPequeña) {
//					practico.secuenciPequeña[j]=Integer.parseInt(lector.split(" ")[1]);
//				}
//				
//				practico.secuenciGrande[j]=Integer.parseInt(lector.split(" ")[0]);
//			}
//
//			bw.write(practico.ejecutar()+"\n");
//
//		}
//
//		bw.flush();
//
//		bw.close();
//
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
}
