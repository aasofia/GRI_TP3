
public class TP3 {
	
	public static void main(String []args) {
		String file = args[1];
		int estimNbAretes = Integer.parseInt(args[2]);
		
		ReadFile r = new ReadFile(estimNbAretes, file);
		
		Graph g = new Graph(r.nbSommets, r.nbAretes, r.sommets1, r.sommets2, r.compteur);
		
		if(args[0].equals("triangles")) {
			Triangles t = new Triangles(Integer.parseInt(args[3]), g);
			int nbTriangles = t.triangles();
			System.out.println(nbTriangles);
		}
	}

}
