
public class Triangles {
	public int sommet;
	public Graph g;
	public boolean[] voisins;
	public boolean[] visited;
	
	public Triangles(int u, Graph g) {
		this.sommet = u;
		this.g = g;
		
		this.voisins = new boolean[g.nbSommets];
		this.visited = new boolean[g.nbSommets];
		for(int v: g.neighbors(sommet)) voisins[v] = true;
	}
	
	public int triangles() {
		int nbTriangles = 0;
		
		for(int v: g.neighbors(sommet)) {
			if(!visited[v]) {
				for(int w: g.neighbors(v)) {
					if(voisins[w] && !visited[w]) {
						nbTriangles++;
					}
				}
				visited[v] = true;
			}
		}		
		return nbTriangles;				
	}
}
