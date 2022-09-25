
package br.edu.utfpr.primeiraTela;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;

public class PrimeiraTela extends JFrame{
    private JTextField tfNome;
    private JTextArea taDados;
//    private JFrame frame;
    private JCheckBox cbJava;
    private JRadioButton rbMasculino;
    private JRadioButton rbFeminino;
    private JCheckBox cbDelphi;
    private JFormattedTextField ftCpf;
    public PrimeiraTela() {
//        frame = new JFrame("Primeira Tela");        
        super.setTitle("Primeira Tela");
        JLabel lbNome = new JLabel("Nome");
        JLabel lbGenero = new JLabel("Gênero");     
        tfNome = new JTextField();
        JPanel pnDados = new JPanel(new GridLayout(10,1));
        rbMasculino = new JRadioButton("Masculino");
        rbFeminino = new JRadioButton("Feminino");
        ButtonGroup bgGenero = new ButtonGroup();
        JLabel lbLivros = new JLabel("Livros");
        cbJava = new JCheckBox("Java");
        cbDelphi = new JCheckBox("Delphi");
        JLabel lbCpf = new JLabel("CPF");  
        ftCpf = null;
        JButton btFechar = new JButton("Fechar");
        JButton btSalvar = new JButton("Salvar");
        JPanel pnBotoes = new JPanel();
        taDados = new JTextArea();
        JScrollPane spDados = new JScrollPane(taDados);
        
        try{
            MaskFormatter mf = new MaskFormatter("###.###.###-##");
            ftCpf = new JFormattedTextField(mf);            
                           
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }        
        
//        tfNome.setColumns(10);                
//        ftCpf.setColumns(15);       
        
        bgGenero.add(rbMasculino);
        bgGenero.add(rbFeminino);
        pnDados.add(lbNome);
        pnDados.add(tfNome);  
        pnDados.add(lbGenero);
        pnDados.add(rbMasculino);
        pnDados.add(rbFeminino);
        pnDados.add(lbLivros);
        pnDados.add(cbJava);
        pnDados.add(cbDelphi);
        pnDados.add(lbCpf);
        pnDados.add(ftCpf);
        pnBotoes.add(btSalvar);
        pnBotoes.add(btFechar);
        super.setLayout(new BorderLayout(5,5));        
        super.add(pnDados, BorderLayout.NORTH);
        super.add(spDados, BorderLayout.CENTER);
        super.add(pnBotoes, BorderLayout.SOUTH);
        
        btSalvar.addActionListener((e) -> {
//            taDados.setText(getDados());            
            DlgDados dlgDados = new DlgDados(this, true);
        });
        
        btFechar.addActionListener((e) -> {
            System.exit(0);
        });
        
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400,500);
        super.setLocationRelativeTo(null);
        super.setVisible(true);           
    }    
    
    public static void main(String[] args) {
        new PrimeiraTela();
    }
    
    public String getGenero() {
        String genero = null;
        if (rbMasculino.isSelected()) {
            genero = rbMasculino.getActionCommand();
        } else if (rbFeminino.isSelected()) {
            genero = rbFeminino.getActionCommand();
        }
        return genero;
    }

    public String getLivros() {
        String livros = "";
        if (cbJava.isSelected()) {
            livros += cbJava.getActionCommand() + "\n";
        }
        if (cbDelphi.isSelected()) {
            livros += cbDelphi.getActionCommand() + "\n";
        }

        return livros;
    }

    public String getDados() {
        StringBuilder sb = new StringBuilder();
        sb.append(tfNome.getText()).append("\n")
                .append(getGenero()).append("\n")
                .append(getLivros())
                .append(ftCpf.getText());
        return sb.toString();
    }
}
