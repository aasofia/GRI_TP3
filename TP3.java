
public class TP3 {
	
	public static void main(String []args) {
		//String file = args[1];
		//int estimNbAretes = Integer.parseInt(args[2]);
		
//		ReadFile r = new ReadFile(estimNbAretes, file);
		ReadFile r = new ReadFile(12572, "C:\\Users\\aitah\\Desktop\\MIDS\\S2\\GRI\\Graphes_TP2\\as20000102-simple.txt");
		
		Graph g = new Graph(r.nbSommets, r.nbAretes, r.sommets1, r.sommets2, r.compteur);
		
		Kcoeurs k = new Kcoeurs(g);
		
		k.decomposition();
		
//		if(args[0].equals("triangles")) {
//			Triangles t = new Triangles(g,Integer.parseInt(args[3]));
//			System.out.println(t.triangles());
//		}
//		
//		if(args[0].equals("clust")) {
//			Triangles t = new Triangles(g,0);
//			t.clust();
//		}
	}

}
