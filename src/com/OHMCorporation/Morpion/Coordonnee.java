package com.OHMCorporation.Morpion;



public class Coordonnee implements Comparable <Coordonnee> {

	private int ligne;
	private int colonne;
	
	 //*******************************************************************************//
    //
    //                                Constructeurs
    //
    //*******************************************************************************//
    
    public Coordonnee(int colonne, int ligne) {
        if(ligne < 0 || ligne > 25 || colonne < 0 || colonne > 25){
            throw new IllegalArgumentException("Veuillez fournir une coordonnée entre 0 et 25");
            }                                              //limitation du nb de lignes et de colonnes à 25 (nb de lettre dans l'alphabet)
        this.ligne = ligne;
        this.colonne = colonne;
    }
    
    // extraction des coordonnées en prenant le premier caractère pour la colonne et le deuxième pour la ligne
    public Coordonnee(String s) {

        char colonneLettre = s.charAt(0);                        //extraction de la colonne à l'indice 0
        int ligneEnCours = Integer.parseInt(s.substring(1)); //utilisation de la sous-chaine de l'indice 1 à la fin pour extraire la ligne

        //Si le nombre ne correspond pas à la taille de la grille
        if(ligneEnCours < 0 || ligneEnCours > 25) {
            throw new IllegalArgumentException("Ligne invalide");
            }  
        //Si le caractère n'est pas dans le tableau donc non valide
        if(colonneLettre <'A' || colonneLettre > 'Z') {
            throw new IllegalArgumentException("Colonne invalide");
            }
        
        this.ligne = ligneEnCours;
        this.colonne = colonneLettre -'A';
    
    }
    //*******************************************************************************//
    //
    //                                Méthodes
    //
    //*******************************************************************************//

    
    public String toString() {  //expression des coordonnées comme "C7"
        char t = (char) (this.colonne +'A');    
        String s = "" + t + this.ligne;
        return(s);
    }
    
    //getter pour la ligne car attribut private
    
    public int getLigne() {
        return this.ligne;
    }
    
    //getter pour la colonne car attribut private
    
    public int getColonne() {
        return this.colonne;
    }
    
    
    public boolean equals(Object obj) {
        //on verifie que l'objet est bien une coordonnes sinon message d'erreur
        
        if (! (obj instanceof Coordonnee)) 
            throw new IllegalArgumentException();
        else{
            Coordonnee m = (Coordonnee) obj;
           return (this.ligne == m.ligne && this.colonne == m.colonne);} // si coordonnées égales renvoie vrai sinon renvoie false  
    }
    
    public boolean voisine(Coordonnee c) {
        // on vérifie si this a une coordonnée voisine de c
        
        if((c.ligne == this.ligne - 1 || c.ligne == this.ligne + 1) && c.colonne == this.colonne){
        return true;
        }
        else if ((c.colonne == this.colonne - 1 || c.colonne == this.colonne + 1) && c.ligne == this.ligne){
            return true;
        }
        return false;
    }
    

    
    
    public int compareTo(Coordonnee c){
        
        /*Une coordonnée est considérée inférieure à une autre, si elle se trouve sur une ligne inférieure ou si elle se trouve sur la 
        même ligne mais sur une colonne inférieure.*/
        
        if(this.ligne < c.ligne || this.ligne > c.ligne ){   
            return (this.ligne - c.ligne);
        }
        else{
            return (this.colonne - c.colonne);
            }
        
    }
    
   public static void  main(String[]args) { // test 
	   
	   Coordonnee test = new Coordonnee(0,0);
	   Coordonnee test2 = new Coordonnee("A5");
	   Coordonnee test3 = new Coordonnee("A0");
	   
	   System.out.println("test :"+test.toString());
	   System.out.println("colonne : "+test.getColonne()+" ligne : "+ test.getLigne());
	   System.out.println("test2 :"+test2.toString());
	   System.out.println("colonne : "+test2.getColonne()+" ligne : "+ test2.getLigne());
	   System.out.println("test et test2 equals? "+ test.equals(test2));
	   System.out.println("test compare to test2 : "+ test.compareTo(test2));
	   System.out.println("test et test2 = voisine? "+ test.voisine(test2));
	   
	   System.out.println("equals" + test.equals(test3));
   }

}