package visuel;

import operation.*;
import erreurclasses.*;
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
    JButton boutonPret= new JButton("Make A Loan");
    JButton boutonRemboursePret= new JButton("Repay the Loan");
    JLabel labelRevenue= new JLabel("Revenue");
    JTextField champRevenue= new JTextField(10);
    JButton boutonHistorique= new JButton("Clean History");
    Transaction transaction;

    public Fenetre() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width,screenSize.height);
        this.setTitle("Banque");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		add(this.labelMontant);
		add(this.champMontant);
        add(this.labelRevenue);
        add(this.champRevenue);
        add(this.boutonRetrait);
        add(this.boutonDepot);
        add(this.boutonPret);
        add(this.boutonRemboursePret);
        add(this.boutonHistorique);

		boutonRetrait.addActionListener(new ActionListener() {
            @Override
           
            public void actionPerformed(ActionEvent faireRetrait) {
                try{
                    Transaction transaction= new Transaction(Double.parseDouble(champMontant.getText()),true);
                    JOptionPane.showMessageDialog(null,"WithDrawal successful at "+ transaction.getTemps().getTime());
                }
                catch(NumberFormatException erreurChiffre)
                {
                    if(champMontant.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"Please fill the forms for a withdrawal"); 
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please insert number values eg:10000");
                    }
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
                    Transaction transaction= new Transaction(Double.parseDouble(champMontant.getText()),false);
                    JOptionPane.showMessageDialog(null,"Deposit successful at " + transaction.getTemps().getTime());
                }
                catch(NumberFormatException erreurChiffre)
                {
                    if(champMontant.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"Please fill the forms for a deposit"); 
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please insert number values eg:10000");
                    }
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
                catch(Exception e)
                {  
                }
                //SwingUtilities.updateComponentTreeUI();
                
            }
        });
        boutonPret.addActionListener(new ActionListener() {
            @Override
           
            public void actionPerformed(ActionEvent fairePret) {
                try{
                    Pret pret= 
                    new Pret(
                        Double.parseDouble(champMontant.getText()),
                        Double.parseDouble(champRevenue.getText())
                    );
                    
                    JOptionPane.showMessageDialog(null,"Loan successful at " + pret.getTransaction().getTemps().getTime());
                }
//                catch(NoValueException champNonRemplit)
//                {
//                    JOptionPane.showMessageDialog(null,"One of the field is not filled for a loans");
//                }
                catch(NumberFormatException erreurChiffre)
                {
                    if(champMontant.getText().isEmpty() || champRevenue.getText().isEmpty())
                    {
                        if(champMontant.getText().isEmpty() && champRevenue.getText().isEmpty())
                        {
                            JOptionPane.showMessageDialog(null,"Please fill the forms for a loan"); 
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"One of the field is not filled for a loan");
                        }
                    }
                    else{
                    JOptionPane.showMessageDialog(null,"Please insert number values eg:10000");
                    }  
                }

                catch(Exception rentreeInsuffisante)
                {    
                    JOptionPane.showMessageDialog(null,"Monthly income not enough");
                }
                //SwingUtilities.updateComponentTreeUI();
                
            }
        });

        setVisible(true);
    }
}