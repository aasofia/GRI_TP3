import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	int nbAretes;
	int nbSommets;
	int[] sommets1;
    int[] sommets2;
    int[] compteur;		// Tableau qui compte le nombre de voisins de chaque sommet
    
    public ReadFile(int estimNbAretes, String file) {
    	this.nbAretes = 0;
		this.nbSommets = 0;
		this.sommets1 = new int[estimNbAretes];
	    this.sommets2 = new int[estimNbAretes];
	        
	    BufferedReader bufferedreader = null;
        FileReader filereader = null;
        
        try {
            filereader = new FileReader(file);

        	bufferedreader = new BufferedReader(filereader);
        	
        	// Ligne en cours
            String strCurrentLine;
         
            while ((strCurrentLine = bufferedreader.readLine()) != null) {    
            	if (!strCurrentLine.contains("#")) {
	            	// La methode edges ajoute les sommets aux deux tableaux et renvoie le plus grand des 2 sommets
	            	int maxSommet = edges(strCurrentLine, sommets1, sommets2, nbAretes);	          	
	            	nbAretes++;	            	
	            	if(maxSommet+1 > nbSommets) nbSommets = maxSommet+1;   
            	}
            } 
        } catch (IOException e) {
            e.printStackTrace();
          } finally {
            try {
              if (bufferedreader != null)
                bufferedreader.close();
              if (filereader != null)
                filereader.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        
        this.compteur = new int[nbSommets];
        
        try {
            filereader = new FileReader(file);
        	bufferedreader = new BufferedReader(filereader);
        	
            String strCurrentLine;
 
            while ((strCurrentLine = bufferedreader.readLine()) != null) {
            	if (!strCurrentLine.contains("#")) {
	            	String[] tmp = new String[2];         	
	            	// Split des sommets par espace
	            	tmp = strCurrentLine.split("\\s+");
	            	
	            	compteur[Integer.parseInt(tmp[0])]++;
	            	compteur[Integer.parseInt(tmp[1])]++;
            	}
            } 
        } catch (IOException e) {
            e.printStackTrace();
          } finally {
            try {
              if (bufferedreader != null)
                bufferedreader.close();
              if (filereader != null)
                filereader.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
    }	
	
    public int edges(String strCurrentLine, int[]sommets1, int[]sommets2, int i) {
    	String[] tmp = new String[2];        
    	
    	// Split des sommets par espace
    	tmp = strCurrentLine.split("\\s+");
    	
     	sommets1[i] = Integer.parseInt(tmp[0]);
     	sommets2[i] = Integer.parseInt(tmp[1]); 
     	
     	return Math.max(sommets1[i], sommets2[i]);
    }
}
