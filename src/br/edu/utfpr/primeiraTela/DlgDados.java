package br.edu.utfpr.primeiraTela;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class DlgDados extends JDialog{
    private JTextArea taDados;
    private JScrollPane spDados;
    private JPanel pnDados;
    private JButton btFechar;
    public DlgDados(PrimeiraTela tela, boolean modal) { 
        super(tela, modal);
        taDados = new JTextArea();
        spDados = new JScrollPane(taDados);
        pnDados = new JPanel(new GridLayout(2,1));
        btFechar = new JButton("Fechar");
        
        pnDados.add(spDados);
        pnDados.add(btFechar);
        
        super.setTitle("Dados");        
        super.setSize(300, 200);
//        super.setLayout(new BorderLayout(5,5));        
        super.add(pnDados);
        super.setVisible(true);
    }    
}
