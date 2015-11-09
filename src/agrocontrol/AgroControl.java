package agrocontrol;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AgroControl {

    public static void main(String[] args) {
        
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgroPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgroPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgroPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgroPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       AgroPrincipalView apv = new AgroPrincipalView();
       
        apv.setLayout(new BorderLayout());
	JLabel background = new JLabel(new ImageIcon("src\\icones\\buttons\\doggy_and_kat_in_a_bath.png"));
	apv.add(background);
	background.setLayout(new FlowLayout());
       
       
       apv.setVisible(true);
       apv.setLocationRelativeTo(null);
    }
    
}
