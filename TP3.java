
public class TP3 {
	
	public static void main(String []args) {
		//String file = args[1];
		//int estimNbAretes = Integer.parseInt(args[2]);
		
		//ReadFile r = new ReadFile(estimNbAretes, file);
		
		ReadFile r = new ReadFile(11095298, "C:\\Users\\aitah\\Desktop\\MIDS\\S2\\GRI\\Graphes_TP2\\as-skitter-simple.txt");
		
		Graph g = new Graph(r.nbSommets, r.nbAretes, r.sommets1, r.sommets2, r.compteur);
		
		/*if(args[0].equals("triangles")) {
		 	int[] nbTriangles = new int[g.nbSommets];
			Triangles t = new Triangles(g,1,nbTriangles);
			//Triangles t = new Triangles(g,Integer.parseInt(args[3]),nbTriangles);
			nbTriangles = t.triangles(1);
			//System.out.println(nbTriangles[Integer.parseInt(args[3])]);
			System.out.println(nbTriangles[1]);
		}*/
		
		//if(args[0].equals("clust")) {
			int[] nbTriangles = new int[g.nbSommets];
			Triangles t = new Triangles(g,0,nbTriangles);
			t.clust(g);
		//}
	}

}
