import java.util.Scanner;

/**
 * Created by RenCh1732786 on 2018-01-15.
 */
public class Main {
    public static void main(String[] args) {

        //Intro
        System.out.println("Bienvenue au jeu des allumettes");
        System.out.println("Tour à tour, les joueurs doivent retirer entre 1 et 3 allumettes d’un paquet d’allumettes.");
        System.out.println("Celui qui retire la dernière allumette perd la partie.");

        //Initialisation des variables
        String nom1;
        String nom2;
        boolean jeu=true;
        boolean erreur=true;
        int nbtour=1;
        int nbAllumettes=1000;
        int retirerAllumettes=0;
        int reponse;
        int coups1[]=new int[50];
        int coups2[]=new int[50];
        int nbCoups1=0;
        int nbCoups2=0;
        int valeur=1;
        int multi=0;

        //Initialisation du scanner
        Scanner sc = new Scanner(System.in);

        //Demander multi/solo
        erreur=true;
        while (erreur){
            System.out.println("Voulez-vous jouer en:");
            System.out.println("1-Multijoueur");
            System.out.println("Ou");
            System.out.println("2-Solo (contre l'ordinateur)");
            multi=sc.nextInt();
            if (multi==2){
                erreur=false;
            }
            else if (multi==1){
                erreur=false;
            }
            else{
                System.out.println("erreur");
            }
        }

        for (int i=0;i<coups1.length;i++){
            coups1[i]=0;
        }
        for (int i=0;i<coups2.length;i++){
            coups2[i]=0;
        }

        //demander le nom des joueurs
        System.out.println("Nom du joueur 1: ");
        nom1=sc.next();

        if (multi==1) {
            System.out.println("Nom du joueur 2: ");
            nom2 = sc.next();
        }
        else {
            nom2="Felicity";
        }

        //Boucle qui recommence à chaque partie
        while (jeu){
            System.out.println("------------------------------------------------------------");
            System.out.println("-----------------LE JEU DES ALLUMETTES----------------------");
            System.out.println("------------------------------------------------------------");
            nbAllumettes=(int)(20+(Math.random()*80));
            nbtour=0;

            //Boucle à chaque tour
            while (nbAllumettes>0){
                System.out.println("il reste "+nbAllumettes+" allumettes.");

                erreur=true;
                while (erreur){
                if (nbtour%2==0){
                    System.out.println(nom1+", combien d'allumettes voulez-vous retirer du paquet? (entre 1 et 3)");
                    retirerAllumettes=sc.nextInt();
                }

                else {
                    System.out.println(nom2+", combien d'allumettes voulez-vous retirer du paquet? (entre 1 et 3)");
                    if (multi==1){
                        retirerAllumettes=sc.nextInt();
                    }
                    else{
                        if (nbAllumettes==4){
                            retirerAllumettes=3;
                        }
                        else if (nbAllumettes==3){
                            retirerAllumettes=2;
                        }
                        else if (nbAllumettes==2){
                            retirerAllumettes=1;
                        }
                        else{
                            if ((nbAllumettes-1)/4==0){
                                retirerAllumettes=(int)(Math.random()*3)+1;
                            }
                            else{
                                retirerAllumettes=(nbAllumettes-1)%4;
                            }
                        }
                    }
                }


                if (retirerAllumettes<1 || retirerAllumettes>3){
                    System.out.println("erreur");
                }
                else{
                    erreur=false;
                }
                }

                //Enregistrer mes résultats
                if (nbtour%2==0){
                    coups1[nbCoups1]=retirerAllumettes;
                    nbCoups1++;
                }
                else{
                    coups2[nbCoups2]=retirerAllumettes;
                    nbCoups2++;
                }


                nbAllumettes-=retirerAllumettes;
                nbtour++;
            }
            if (nbtour%2==0){
                System.out.println("And the winner is...... "+nom1+"!!!!!!!!!!!!!!!");
            }
            else {
                System.out.println("And the winner is...... "+nom2+"!!!!!!!!!!!!!!!");
            }

            System.out.print("Décisions prises par "+nom1+": ");
            nbtour=0;
            while (valeur!=0){
                valeur=coups1[nbtour+1];
                System.out.print(coups1[nbtour]+", ");
                nbtour++;
            }
            System.out.println("");
            System.out.print("Décisions prises par "+nom2+": ");
            valeur=1;
            nbtour=0;
            while (valeur!=0){
                valeur=coups2[nbtour+1];
                System.out.print(coups2[nbtour]+", ");
                nbtour++;
            }

            erreur=true;
            while (erreur){
                System.out.println("");
                System.out.println("Voulez-vous rejouer?");
                System.out.println("1-oui");
                System.out.println("2-non");
                reponse=sc.nextInt();
                if (reponse==2){
                    System.out.println("Bonne journée");
                    jeu=false;
                    erreur=false;
                }
                else if (reponse==1){
                    erreur=false;
                }
                else{
                    System.out.println("erreur");
                }
            }
        }

        //Fermeture du scanner
        sc.close();
    }
}
