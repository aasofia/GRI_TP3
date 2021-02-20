
public class Triangles {
	public int sommet;
	public Graph g;
	public boolean[] voisins;
	public boolean[] visited;
	
	public Triangles(Graph g, int u) {
		this.sommet = u;
		this.g = g;
		
		this.voisins = new boolean[g.nbSommets];
		this.visited = new boolean[g.nbSommets];
		
		for(int v: g.neighbors(this.sommet)) {
			this.voisins[v] = true;
		}
	}
	
	public int triangles() {
		int nbTriangles = 0;
		
		for(int i=0; i<voisins.length; i++) {	
			if(voisins[i] && !visited[i]) {
				for(int w: g.neighbors(i)) {
					if(voisins[w] && !visited[w]) {				
						nbTriangles++;
					}
				}
				visited[i] = true;
			}
		}		
		return nbTriangles;				
	}
	
	public void clust() {
		// pour le sommet 0
		int triX = triangles();
		double cluLx = 0.0;									// clustering local d'un sommet
		if(g.degre(sommet)>1) cluLx = (2.0*triX)/(g.degre(sommet)*(g.degre(sommet)-1.0));
		double sommeCluL = cluLx;
		double triG = triX;
		double nv = g.degre(sommet)*(g.degre(sommet)-1.0);
		
		// pour les sommets à partir de 1
		for(int i=1; i<g.nbSommets; i++) {	
			Triangles t = new Triangles(g,i);
			triX = t.triangles();
			
			if(t.g.degre(t.sommet)>1) cluLx = (2.0*triX)/(t.g.degre(t.sommet)*(t.g.degre(t.sommet)-1.0));
			else cluLx = 0;
			
			sommeCluL += cluLx;
			triG += triX;
			nv += t.g.degre(t.sommet)*(t.g.degre(t.sommet)-1.0);
		}		
		double cluL = sommeCluL/g.nbSommets;
		System.out.format("%.5f\n", cluL);
		
		double cluG = triG/(nv/2);
		System.out.format("%.5f\n", cluG);
	}
}