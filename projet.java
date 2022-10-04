/*     les classes utilisées */

package projet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


//Définition de la classe projet qui hérite de la classe JFrame 


public class projet extends JFrame {
	
    /**
	 * 
	 */
	
	private static final long serialVersionUID = 533077946568244022L;  // ajuster le style 

	
	//////////////*******   DECLARATION  DES ELEMENTS   DE L INTERFACE :   *******///////////////////
	
	
	private static JTextField head   = new JTextField("JAVA TO SEND SMS");        // inserer l'en-tete
	private static JTextField footer = new JTextField("   ABIR MOUAOUYA - SICOM - FSTFES  "); // inserer le footer de l'interface 
	private static JTextField msg    = new JTextField ("tapez votre message");    // zone d'ecriture du text du message à envoyer 
	private static JTextField num    = new JTextField ();    // zone d'ecriture de numero 
	 
	 /*   Insertion des icons */
	
	 private ImageIcon iconF    = new ImageIcon("smsicon.png");
	 private ImageIcon icon     = new ImageIcon("D:\\iconSicom.png");
	 private ImageIcon headIcon = new ImageIcon("iconframe.png");
	  
	private JLabel arriere = new JLabel(icon); 
	
	 // les  buttons pour composé le numero
	private static JButton B1= new JButton("1");
	private static JButton B2= new JButton("2");
	private static JButton B3= new JButton("3");
	private static JButton B4= new JButton("4");
	private static JButton B5= new JButton("5");
	private static JButton B6= new JButton("6");
	private static JButton B7= new JButton("7");
	private static JButton B8= new JButton("8");
	private static JButton B9= new JButton("9");
	private static JButton B0= new JButton("0");
	private static JButton BE= new JButton("*");
	private static JButton BD= new JButton("#");
	
	
	private static JButton Benvoyer   = new JButton("Envoyer");      // button d'envoie
	private static JButton Bannuler   = new JButton("X");           // button supprimer 
	private static JButton Bsupprimer = new JButton(" FERMER  ");// fermer l'interface 
	private static JButton FastSMS    = new JButton(" FAST SMS");// inserer un msg rapide 

	
	
	 // définition de la methode d'ajout des element 
     JPanel contentpane = (JPanel) this.getContentPane() ;  

     
     
  // la methode de génération de signal sonneur à patrir de deux frequences 
     
    	 public static void createTone(int Hertz1,int Hertz2) // les deux frequences en entrée 
    	 
    	       // throws lancer exception de maniere explicite 
 			    throws LineUnavailableException {
    		 
 			    /** Exception is thrown when line cannot be opened */
    		 
 			    int volume=5;          // definir le volume 
 			    float rate = 2000 ;    // definir la duréé 
 			    byte[] buf;          // table de byte
 			    AudioFormat audioF; // audio format 
 			    
 			    buf = new byte[1];
 			    audioF = new AudioFormat(rate,8,1,true,false);
 			    //sampleRate, sampleSizeInBits,channels,signed,bigEndian
 			 
 			    SourceDataLine sourceDL = AudioSystem.getSourceDataLine(audioF); // defenir la donnée 
 			    sourceDL = AudioSystem.getSourceDataLine(audioF);     // extraire le buf 
 			    sourceDL.open(audioF);             // open 
 			    sourceDL.start();                // commencer 
 			    
 			
 			   for(int i=0; i<270; i++){
 				   
 			      double angle0= (i/rate)*Hertz1*2.0*Math.PI;  // generer la premiere sinusoide
 			      double angle = (i/rate)*Hertz2*2.0*Math.PI;  //generer la deuxieme sinusoide
 			      
 			      buf[0]=(byte)((Math.cos(angle0)+Math.cos(angle))*volume); /// generer le signal final
 			      
 			      sourceDL.write(buf,0,1); // play 
 			      
 			    }
 			      
 			  }
    	 
    	 
    	 
  /**************************************************  LE CONSTRUCTEUR  **************************************************/
    	 
    	 
	public projet(String s) {

		
    	 super(s);
    	 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //definir la methode de fermuture d'interface 
    	 this.setSize( new Dimension(480,600));        // definir la taille de l'interface 
    	 this.setVisible(true);                    // rendre l'interace visible
    	 this.setLocationRelativeTo(null);       // centré l'interface 
   
    	 
    	 // definir les fonts d'ecriture 
    	 Font fond = new Font ("Times New Roman",Font.ROMAN_BASELINE,25);
    	 Font fondhead = new Font ("Times New Roman", Font.BOLD,30);
    	 Font fond1 = new Font ("Times New Roman",Font.ROMAN_BASELINE,17);
    	 Font fondnum = new Font ("Times New Roman",Font.ITALIC, 17);
    	 
    	 
    	 contentpane.setLayout(null); 
    	 contentpane.setBackground(new Color (135, 45, 101));  // choisir la couleur de background
    	 contentpane.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 this.setIconImage(iconF.getImage());                  // inserer l icon 
    	 
    	 
/***********************************************************************************************************************************/
    	
    	 /*  logo */
    	 arriere.setSize(190,80);
    	 arriere.setLocation(120,50);  //  l'emplacement
    	 contentpane.add(arriere);
    	
    	 
    	 
    	 // la zone du texte
    	 
    	 msg.setSize(300,80);   
    	 msg.setLocation(30,130);  // taille de la zone
    	 msg.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(msg);        //  ajouter au composant de l'interface 
    	 
    	 
    	 FastSMS.setSize(120,60);
    	 FastSMS.setLocation(335,140);
    	 FastSMS.setBackground(new Color(210, 137, 155));
    	 FastSMS.setFont(fond1);
    	 contentpane.add(FastSMS);
    	 
    	 
    	 // zone de numero
    
    	 num.setSize(200,35);         // taille de la zone de saisie de num
    	 num.setLocation(90,220);    //l'emplacent 
    	 num.setBackground(Color.white);
    	 num.setFont(fondnum);
    	 num.setBorder(BorderFactory.createLineBorder(Color.black));
    	 contentpane.add(num);   // l'ajout de composant 
    	 
    	 
    	 head.setSize(300,40);
    	 head.setLocation(70,5);
    	 head.setFont(fondhead);
    	 head.setBackground(new Color(135, 45, 101));
    	 head.setForeground(new Color (240, 241, 240));
    	 head.setBorder(BorderFactory.createLineBorder(Color.white));
    	 contentpane.add(head);
    	 
    	 
    	 footer.setSize(290,20); //taille du footer 
    	 footer.setLocation(80,530); //l'emplacement 
    	 footer.setBackground(new Color(135, 45, 101)); // definit la couleur de background
    	 footer.setForeground(new Color (219, 219, 219));  	
    	 footer.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 footer.setFont(fond1);
    	 contentpane.add(footer);    // ajouter au element de l'interface 
    	 
    	 
/************************************************************************************************************************************/
    	
    	 /* definir la taille , l"emplacement , la couleur de background des butoons de 10 à *et # 
    	    afin de les ajouter au elements de l'interface */
    	 
    	
    	 B1.setLocation(100,280);
    	 B1.setSize(60,30);
    	 B1.setBackground(new Color(239, 180, 195));
    	 B1.setFont(fond);
       	 B1.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(B1);
    	 
    	 
    	 B2.setLocation(180,280);
    	 B2.setSize(60,30);
    	 B2.setBackground(new Color(239, 180, 195));
    	 B2.setFont(fond);
     	 B2.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(B2);
    	 
    	 
    	 B3.setLocation(260,280);
    	 B3.setSize(60,30);
    	 B3.setBackground(new Color(239, 180, 195));
    	 B3.setFont(fond);
         B3.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(B3);
    	 
    	 
    	 B4.setLocation(100,320);
    	 B4.setSize(60,30);
    	 B4.setBackground(new Color (239, 180, 195));
    	 B4.setFont(fond);
         B4.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(B4);
    	 
    	 
    	 B5.setLocation(180,320);
    	 B5.setSize(60,30);
    	 B5.setBackground(new Color(239, 180, 195));
    	 B5.setFont(fond);
         B5.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(B5);
    	 
    	 
    	 B6.setLocation(260,320);
    	 B6.setSize(60,30);
    	 B6.setBackground(new Color(239, 180, 195));
    	 B6.setFont(fond);
    	 contentpane.add(B6);
    	 
    	 
    	 B7.setLocation(100,360);
    	 B7.setSize(60,30);
    	 B7.setBackground(new Color(239, 180, 195));
    	 B7.setFont(fond);
         B7.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(B7);
    	 
    	 
    	 B8.setLocation(180,360);
    	 B8.setSize(60,30);
    	 B8.setBackground(new Color(239, 180, 195));
    	 B8.setFont(fond);
         B8.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(B8);
    	 
    	 
    	 B9.setLocation(260,360);
    	 B9.setSize(60,30);
    	 B9.setBackground(new Color(239, 180, 195));
    	 B9.setFont(fond);
         B9.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(B9);

    	 
    	 B0.setLocation(180,410);
    	 B0.setSize(60,30);
    	 B0.setBackground(new Color(239, 180, 195));
    	 B0.setFont(fond);
         B0.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(B0);
    	 
    	 
    	 BE.setLocation(100,410);
    	 BE.setSize(60,30);
    	 BE.setBackground(new Color(210, 137, 155));
    	 BE.setFont(fond);
         BE.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(BE);
    	 
    	 
    	 BD.setLocation(260,410);
    	 BD.setSize(60,30);
    	 BD.setBackground(new Color(210, 137, 155));
    	 BD.setFont(fond);
         BD.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(BD);
         
    	 
    	 Benvoyer.setLocation(320,470);
    	 Benvoyer.setSize(100,40);
     	 Benvoyer.setBackground(new Color(210, 137, 155));
    	 Benvoyer.setFont(fond1);
         Benvoyer.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(Benvoyer);
    	 
    	 Bsupprimer.setSize(100,40);
    	 Bsupprimer.setLocation(10,470);
    	 Bsupprimer.setBackground(new Color(210, 137, 155));
    	 Bsupprimer.setFont(fond1);
         Bsupprimer.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(Bsupprimer);
    	 
    	
    	 Bannuler.setLocation(300,225);
    	 Bannuler.setSize(45,30);
    	 Bannuler.setBackground(new Color(210, 137, 155));
    	 Bannuler.setForeground(new Color (219, 219, 219));
         Bannuler.setBorder(BorderFactory.createLineBorder(new Color (226,200,230)));
    	 contentpane.add(Bannuler);
    
    	 
 /************************************************************************************************************************************/    	 

    	 /***  listener ****/
    	 
    	 // definir le listener du button 1
    	 
    	 
    	 B1.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e) {
    		    	B1Linstener(e);  // fonction d'ajout de 1 et le son .
    		    }
    		    
    	 });
    	 
    	 
    	 // definir le listener du button 2
    	 B2.addActionListener(new ActionListener() {
 		    public void actionPerformed(ActionEvent e) {
 		    	B2Linstener(e);  // fonction d'ajout de 2 et le son .
 		    }
 		    
 	   });

    	 
    	 B3.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e) {
    		    	B3Linstener(e);// fonction d'ajout de 3 et le son .
    		    }
    		    
    	 });

    	 B4.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e) {
    		    	B4Linstener(e); // fonction d'ajout de 4 et le son .
    		    }
    		    
    	 });

    	 B5.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e) {
    		    	B5Linstener(e);  // fonction d'ajout de 5 et le son .
    		    }
    		    
    	 });

    	 B6.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e) {
    		    	B6Linstener(e);   // fonction d'ajout de 6 et le son .
    		    }
    	 });

    	 B7.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e) {
    		    	B7Linstener(e);   // fonction d'ajout de 7 et le son .
    		    }	    
    	 });

    	 B8.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e) {
    		    	B8Linstener(e);	// fonction d'ajout de 8 et le son .
    		    }
    	 });

    	 B9.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e) {
    		    	B9Linstener(e);   // fonction d'ajout de 9 et le son .
    		    }
    	 });

    	 B0.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e) {
    		    	B0Linstener(e);    // fonction d'ajout de 0 et le son .
    		    }
    	 });

    	 BE.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e) {
    		    	BELinstener(e);    // fonction d'ajout * et le son .
    		    }
    	 });
    	 
    	 BD.addActionListener(new ActionListener() {
 		    public void actionPerformed(ActionEvent e) {
 		    	BDLinstener(e);  // fonction d'ajout #   et le son .
 		    }
 	 });
    	 
    	 Bannuler.addActionListener(new ActionListener() {
 		    public void actionPerformed(ActionEvent e) {
 		          Bannuler(e);	// fonction pour supprimer le dernier element ajouter au numero
 		    }

 	 });
    	 
    	Benvoyer.addActionListener(new ActionListener() {
  		    public void actionPerformed(ActionEvent e) {
  		          Benvoyer(e);	 // fonction d'envoie du message 
  		    }

  	 });	
    	
    	
    	msg.addMouseListener( new  MouseAdapter(){
    		 
			 public void mousePressed(MouseEvent e) {
			      //TODO : effacer le texte
               msg.setText("");
			  
			 }

		});
    	
    	FastSMS.addActionListener(new ActionListener() {
  		    public void actionPerformed(ActionEvent e) {
  		    	FastSMSLinstener(e);	 // fonction d'envoie du message 
  		    }

  	 });
    	
    	Bsupprimer.addActionListener(new ActionListener() {
  		    public void actionPerformed(ActionEvent e) {
  		          Bsupprimer(e);	
  		    }

  	 });	
    
    	
	}// fin de constructeur 
	
	
/******************************************************************************************************************************/
	
//definition des methodes des evenements
	private void Bsupprimer(ActionEvent event) {
		   this.setVisible(false);
	   }
	   
	
	
   private void B1Linstener(ActionEvent event) {
	   num.setText(num.getText() +"1");  // ajouter 1 à la fin du contenu de la zone numero 
	   try {
	         projet.createTone(1209,697);  // appel à la fonction de generation du son avec deux frequences
	     } catch (LineUnavailableException lue) {
	         System.out.println(lue);
	     }
   }
   
   
   
   private void B2Linstener(ActionEvent event) {
	   num.setText(num.getText() +"2");  // ajouter 2 à la fin du contenu de la zone numero 
	   try {
	         projet.createTone(1336,697);
	     } catch (LineUnavailableException lue) {
	         System.out.println(lue);
	     }
   }
   
   
   private void B3Linstener(ActionEvent event) {
	   num.setText(num.getText() +"3");// ajouter 3 à la fin du contenu de la zone numero 
	   try {
	         projet.createTone(1477,697);
	     } catch (LineUnavailableException lue) {
	         System.out.println(lue);
	     }
   }
   

   
   private void B4Linstener(ActionEvent event) {
	   num.setText(num.getText() +"4"); // ajouter 4 à la fin du contenu de la zone numero 
	   try {
	         projet.createTone(1209,770);
	     } catch (LineUnavailableException lue) {
	         System.out.println(lue);
	     }
   }

   
   private void B5Linstener(ActionEvent event) {
	   num.setText(num.getText() +"5");  // ajouter 5 à la fin du contenu de la zone numero 
	   try {
	         projet.createTone(1336,770);
	     } catch (LineUnavailableException lue) {
	         System.out.println(lue);
	     }
   }

   
   private void B6Linstener(ActionEvent event) {
	   num.setText(num.getText() +"6");  // ajouter 6 à la fin du contenu de la zone numero 
	   try {
	         projet.createTone(1477,770);
	     } catch (LineUnavailableException lue) {
	         System.out.println(lue);
	     }
   }

   
   private void B7Linstener(ActionEvent event) {
	   num.setText(num.getText() +"7");   // ajouter 7 à la fin du contenu de la zone numero 
	   try {
	         projet.createTone(852,1209);
	     } catch (LineUnavailableException lue) {
	         System.out.println(lue);
	     }
   }

   
   private void B8Linstener(ActionEvent event) {
	   num.setText(num.getText() +"8");   // ajouter 8 à la fin du contenu de la zone numero 
	   try {
	         projet.createTone(852,1336);
	     } catch (LineUnavailableException lue) {
	         System.out.println(lue);
	     }
   }

   
   private void B9Linstener(ActionEvent event) {
	   num.setText(num.getText() +"9");     // ajouter 9 à la fin du contenu de la zone numero 
	   try {
	         projet.createTone(852,1477);
	     } catch (LineUnavailableException lue) {
	         System.out.println(lue);
	     }
   }

   
   private void B0Linstener(ActionEvent event) {
	   num.setText(num.getText() +"0");   // ajouter 0 à la fin du contenu de la zone numero 
	   try {
	         projet.createTone(941,13336);
	     } catch (LineUnavailableException lue) {
	         System.out.println(lue);
	     }
   }

   
   private void BELinstener(ActionEvent event) {
	   num.setText(num.getText() +"*");   // ajouter *  au  contenu de la zone numero
	   try {
	         projet.createTone(941,1209);
	     } catch (LineUnavailableException lue) {
	         System.out.println(lue);
	     }
   }

   
   private void BDLinstener(ActionEvent event) {
	   num.setText(num.getText() +"#");   // ajouter #  au  contenu de la zone numero
	   try {
	         projet.createTone(941,1477);
	     } catch (LineUnavailableException lue) {
	         System.out.println(lue);
	     }
   }
 
   
   private void Bannuler(ActionEvent event) {
	// supprimer le dernier element du contenu de la zone du nemuro 
	   num.setText(num.getText().substring(0, num.getText().length()-1)); 
	   try {
	         projet.createTone(800,4414);
	     } catch (LineUnavailableException lue) {
	         System.out.println(lue);
	     }
   }

  
   
   private void FastSMSLinstener(ActionEvent event) {
	   
	   JOptionPane Fast = new JOptionPane();
	   String options[]={ "Bonjour", "Salut cv ! ", "Merci de m'appeler" , "Douce nuit Maman!"};
	   int retour = Fast.showOptionDialog(this, "choisissez un des messages ", "FAST SMS ",
                                           JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	   
	   if(retour != -1) { // si un des choix est cliquée on l'insere dans 
		   
		    msg.setText(options[retour]);
	   }
	    
	   Toolkit.getDefaultToolkit().beep();
	   
   }
   
   
   private void Benvoyer(ActionEvent event) {
	   
	   // principe : avant d'envoyer le message , il faut d=s'assurer qu'il est attient qlq condition 
	   
	  /*** le champs du numero est rempli ***/
	 /***  le numero attient 14 caractere ***/
	/***   le numero commance par 00212  ***/
   /***    apres il faut s'assurer que le client veut bien envoyer au numero saisi ***/ 
	   
	 if(num.getText().length() == 14) {     // tester la longueur de champs num 
		
		 if(msg.getText().length() <1 ) {  // tester si le chmps de message est rempli 
			  
		      JOptionPane.showMessageDialog(this," Veuillez saisir  un message  ","ERREUR MESSAGE ! ",JOptionPane.ERROR_MESSAGE);   }	 
		    
		 else {
			 
			 String s="00212";
			 String debutNum = new String(num.getText().substring(0,5));
			 
			 
			if(!s.equals(debutNum)) {
					
		        JOptionPane.showMessageDialog(this,"Veuillez saisir un numero du opérateur marocain commençons par 00212 ",
		        		"ERREUR MESSAGE ! ",JOptionPane.ERROR_MESSAGE);  	
			
			}
			
			else {
				
			JOptionPane d = new JOptionPane();
			
			// 0 pour ok , et 1 pour non 
			
			int retour = d.showConfirmDialog(this, " voulez-vous envoyer un sms à "+num.getText() 
			              ,"CONFIRMATION", JOptionPane.YES_NO_OPTION);


			
					if(retour == 0 ) {
					 
					  SMSSender  msgp= new SMSSender();
					 int a= msgp.send(num.getText(),msg.getText());
					 if(a==0) {
					     JOptionPane.showMessageDialog(this," Message n'est pas envoyé  ",
					        		"ERREUR  ! ",JOptionPane.ERROR_MESSAGE); 
					 }
					 
					 else {
						 JOptionPane.showMessageDialog(this," Message est bien envoyé  ",
					        		" ENVOIE REUSSI  ! ",JOptionPane.INFORMATION_MESSAGE);  
						 Toolkit.getDefaultToolkit().beep();
						 
					 }
				
					}
	                }
			        }
	                }
	 
	 else {
		 
		 JOptionPane.showMessageDialog(this," Veuillez saisir 14 caractère ","ERREUR NUMERO ! ",JOptionPane.ERROR_MESSAGE);
		 
	 }
	 
	 
   }
	 
   
  
/**********************************************************************************************************************************/

   
   
   
   
// la FONTION MAIN :   
	public static void main(String[] args) {
		
	projet  window1 = new projet("Send SMS");
	
}
	}

/*****************************           FIN          ***************************************/