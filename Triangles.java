
public class Triangles {
	public int sommet;
	public Graph g;
	public boolean[] voisins;
	public boolean[] visited;
	public int[] nbTriangles;
	//public double degre;
	
	public Triangles(Graph g, int u, int[] nbTriangles) {
		this.sommet = u;
		this.g = g;
		this.nbTriangles = nbTriangles;
		//this.degre = 0;
		
		this.voisins = new boolean[g.nbSommets];
		this.visited = new boolean[g.nbSommets];
		
		for(int v: g.neighbors(this.sommet)) {
			this.voisins[v] = true;
			//this.degre++;
		}
	}
	
	public int[] triangles(int exo) {
		//int nbTriangles = 0;
		
		//for(int v: g.neighbors(sommet)) {
		
		for(int i=0; i<voisins.length; i++) {
			if(voisins[i] && (exo==1 || i>sommet) && !visited[i]) {
				for(int w: g.neighbors(i)) {
					if((exo==1 || w>sommet) && voisins[w] && !visited[w]) {
						this.nbTriangles[sommet]++;
						this.nbTriangles[i]++;
						this.nbTriangles[w]++;
					}
				}
				visited[i] = true;
			}
		}		
		return nbTriangles;				
	}
	
	public void clust(Graph g) {
		int[] x = triangles(2);
		double cluLx;									// clustering local d'un sommet
		if(g.degre(sommet)==0.0 || g.degre(sommet)==1.0) cluLx = 0.0;
		else cluLx = (2.0*x[0])/(g.degre(sommet)*(g.degre(sommet)-1.0));
		double sommeCluL = cluLx;
		
	//	System.out.println(degre);
		//System.out.println(tri);
//		System.out.format("%.5f\n", cluLx);
//		System.out.format("%.5f\n", sommeCluL);
		
		for(int i=1; i<g.nbSommets; i++) {		// voir si c'est pas nbSommets-1
			Triangles t = new Triangles(g,i,x);
			int[] y = t.triangles(2);
			if(t.g.degre(t.sommet)==0.0 || t.g.degre(t.sommet)==1.0) cluLx = 0.0;
			else cluLx = (2.0*y[i])/(t.g.degre(t.sommet)*(t.g.degre(t.sommet)-1.0));	
			sommeCluL += cluLx;

		}
		
		double cluL = sommeCluL/g.nbSommets;
		System.out.format("%.5f\n", cluL);
	}
}
