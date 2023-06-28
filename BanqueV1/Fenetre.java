package visuel;

import operation.*;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Fenetre extends JFrame {
	JLabel labelMontant= new JLabel("Montant");
	JTextField champMontant= new JTextField(10);
    //JLabel textEx= new JLabel();
	JButton boutonRetrait= new JButton("WithDraw");
    JButton boutonDepot= new JButton("Deposit");
    JButton boutonHistorique= new JButton("Effacer Historique");
    Transaction transaction;
    double montant;
    public Fenetre() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width,screenSize.height);
        this.setTitle("Banque");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		add(this.labelMontant);
		add(this.champMontant);
        add(this.boutonRetrait);
        add(this.boutonDepot);
        add(this.boutonHistorique);

		boutonRetrait.addActionListener(new ActionListener() {
            @Override
           
            public void actionPerformed(ActionEvent faireRetrait) {
                try{
                    transaction= new Transaction();
                    transaction.setRetrait(Double.parseDouble(champMontant.getText()));
                    transaction.saveTransaction();
                    JOptionPane.showMessageDialog(null,"WithDraw successful at "+ transaction.getTemps().getTime());
                }
                catch(NumberFormatException erreurChiffre)
                {
                    JOptionPane.showMessageDialog(null,"Please insert number values eg:10000");  
                }
                catch(Exception erreurNegatif)
                {
                    JOptionPane.showMessageDialog(null,"Please insert a positive values eg:10000");
                }
                //SwingUtilities.updateComponentTreeUI();
                
            }
        });
        boutonDepot.addActionListener(new ActionListener() {
            @Override
           
            public void actionPerformed(ActionEvent faireDepot) {
                try{
                    transaction= new Transaction();
                    transaction.setDepot(Double.parseDouble(champMontant.getText()));
                    transaction.saveTransaction();
                    JOptionPane.showMessageDialog(null,"Deposit successful at " + transaction.getTemps().getTime());
                }
                catch(NumberFormatException erreurChiffre)
                {
                    JOptionPane.showMessageDialog(null,"Please insert number values eg:10000");  
                }
                catch(Exception erreurNegatif)
                {
                    JOptionPane.showMessageDialog(null,"Please insert a positive values eg:10000");
                }
                //SwingUtilities.updateComponentTreeUI();
                
            }
        });
        boutonHistorique.addActionListener(new ActionListener() {
            @Override
           
            public void actionPerformed(ActionEvent effacerHistorique) {
                try{
                    transaction.deleteTransaction();
                    JOptionPane.showMessageDialog(null,"History delete with success");
                }
                catch(NumberFormatException erreurChiffre)
                {  
                }
                //SwingUtilities.updateComponentTreeUI();
                
            }
        });

        setVisible(true);
    }
}