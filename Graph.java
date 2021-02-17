
public class Graph {
	
	public int nbSommets;
	public int nbAretes;
	public int[][] adjacence;
	
	public Graph(int nbSommets, int nbAretes, int[] sommets1, int[] sommets2, int[] compteur) {
		this.nbSommets = nbSommets;
		this.nbAretes = nbAretes;
		
		this.adjacence = new int[nbSommets][];
		
		for(int i=0; i<nbSommets; i++) {
			adjacence[i] = new int[compteur[i]];
    		compteur[i] = 0;
    	}
		
   		for(int j=0; j<nbAretes; j++) {
   			adjacence[sommets2[j]][compteur[sommets2[j]]] = sommets1[j];
   			compteur[sommets2[j]]++;
   			adjacence[sommets1[j]][compteur[sommets1[j]]] = sommets2[j];
   			compteur[sommets1[j]]++;   			
    	}
		
	}
	
    public int[] neighbors(int u) {
    	return adjacence[u];
    }
    
    public int degre(int u) {
    	return adjacence[u].length;
    }
    
}
