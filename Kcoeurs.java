import java.util.PriorityQueue;


public class Kcoeurs {

	public Graph g;
	public boolean[] mark;
	public int[] degre;
	public PriorityQueue<Sommet> queue;
	
	
	public Kcoeurs(Graph g) {
		this.g = g;		
		this.mark = new boolean[g.nbSommets];		
		this.degre = new int[g.nbSommets];
		this.queue = new PriorityQueue<>();
		
		for(int i=0; i<g.nbSommets; i++) {
			this.mark[i] = true;
			this.degre[i] = this.g.degre(i);	
			this.queue.add(new Sommet(this.g, i, this.g.degre(i)));
		}
	}
	
	public void desactive(int sommet) {
		this.mark[sommet] = false;
		for(int v:this.g.neighbors(sommet)) this.degre[v]--;
	}

	public void decomposition() {
		int x = 0;
		int size = 0;
		for(int k=0; k<this.g.nbSommets; k++) {
			while(!this.queue.isEmpty() && this.degre[this.queue.peek().getSommet()] < k) {
				desactive(this.queue.peek().getSommet());
				this.queue.remove();
			}
			if(!this.queue.isEmpty()) {
				x = k;
				size = this.queue.size();
			}
		}
		System.out.println(x);
		System.out.println(size);		
	}
	
}