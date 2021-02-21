

public class Sommet implements Comparable<Sommet>{
	public int sommet;
	public int degre;
	
	public Sommet(int sommet, int degre) {
		this.sommet = sommet;
		this.degre = degre;
	}
	
	public int getSommet() {
		return sommet;
	}
	
	public int getDegre() {
		return degre;
	}

	@Override
	public int compareTo(Sommet u) {
		if(this.getDegre() > u.getDegre()) {
            return 1;
        } else if (this.getDegre() < u.getDegre()) {
            return -1;
        } else {
            return 0;
        }
	}
	
}
