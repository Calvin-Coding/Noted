package Java.Swing.Noted;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
//import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
//import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import java.io.BufferedWriter;
import java.io.File;

//import javax.swing.JPanel;
import javax.swing.ImageIcon;
//import java.io.FileWriter;
//import java.awt.FlowLayout;
//import java.io.IOException;
//import java.io.File;


public class MainFramenote extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextArea textArea1;
    private JButton okay;
    private String text;
    private String User;
    private String saved;
    //private String nameOfFile;
    private JButton stick;
    private Color color;
    private Color color1;
    private Color red;
    private Color blue;
    private Color black;
    private Color btndark;
    private ImageIcon icon;
    //private JButton info;
    //private JPanel tb;
    //private JFileChooser filechoose;
  

    public MainFramenote() {
        super("C/\\LV()N - N()TED - LIMETED EDTI()N");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());
        icon = new ImageIcon("Calvin-Coding/Noted/icon32x32.png"); //You may have to edit this to the path of the icon is you download it to your computer.
        setIconImage(icon.getImage());
        //tb.setLayout(new FlowLayout());
        User = JOptionPane.showInputDialog(null, "What is your Username: ");
        if (User.equals("admin01")) {
            JOptionPane.showMessageDialog(null,
                    "Welcome Adin01 to N()TED. Everythig is good.\n\tIf you wish to imporve the code go to CALVON.COM. This is version 0.1.8.Java ");
        } else {
            JOptionPane.showMessageDialog(null, "Welcome, " + User + " to N()TED Protype edition.\nYou have verison 0.1.8.Java.");
        }
        textArea1 = new JTextArea("\n\n\tWelcome to N()TED. The text edtior for simple people.\n\tN()TED doesn't have tons of features that are hard to get around,\ninsted, we have the only features you need. To save, choose a theme, and coming soon to open.\n\n\n\t- Calvin Forsberg founder or C/\\LV()N.");
        okay = new JButton("Save your text");
        stick = new JButton("Delete All Text");
        color = new Color(253,251,206);
        red = new Color(255,105,97);
        blue = new Color(203,227,255);
        color1 = new Color(236,236,236);
        black = new Color(64,80,100);
        btndark = new Color(122,142,167);
        //info = new JButton("Info");
        String[] list = {"Dark Theme", "Light Theme", "Red", "Default", "Blue"};
        String colorlist = (String)JOptionPane.showInputDialog(null, "Select Theme", "Theme Chooser - N()TED", JOptionPane.QUESTION_MESSAGE, icon, list, list[3]);
        System.out.println(colorlist);
        //tb.add(stick);
        //tb.add(info);
        add(new JScrollPane(textArea1), BorderLayout.CENTER);
        add(okay, BorderLayout.SOUTH);
        
        if (colorlist.equalsIgnoreCase("red")) {
            textArea1.setBackground(red);
            textArea1.setForeground(Color.LIGHT_GRAY);
            textArea1.setCaretColor(Color.LIGHT_GRAY);
        } else if (colorlist.equals("Light Theme")) {
            textArea1.setBackground(Color.WHITE);
            stick.setBackground(blue);
            okay.setBackground(blue);
        } else if (colorlist.equalsIgnoreCase("Dark Theme")) {
            textArea1.setBackground(black);
            textArea1.setForeground(new Color(241,249,249));
            stick.setBackground(btndark);
            okay.setBackground(btndark);
            textArea1.setCaretColor(new Color(241, 249, 249));
        } else if (colorlist.equalsIgnoreCase("blue")) {
            textArea1.setBackground(blue);
        } else {
            textArea1.setBackground(color);
            stick.setBackground(color1);
            okay.setBackground(color1);
        }
        
        okay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text = textArea1.getText();
                int input1 = JOptionPane.showConfirmDialog(null, User + " typed:\n\t " + text + ". Do you wish to save?", "C()NFERM TEXT",
                        JOptionPane.YES_NO_OPTION);
                if (input1 == 1) {
                    JOptionPane.showMessageDialog(null, "Okay, you do not wish to save.");
                } else {
                    ///*
                    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                    //int returnValue = jfc.showOpenDialog(null); // To open files
                    int returnValue = jfc.showSaveDialog(null);

                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = jfc.getSelectedFile();
                        String filename12 = selectedFile.getAbsolutePath();
                        System.out.println(selectedFile.getAbsolutePath());
                        int nameyn = JOptionPane.showConfirmDialog(null, "Do you want header?", "Yes/No", JOptionPane.YES_NO_OPTION);
                        if (nameyn == 0) {
                            saved = User + " typed:\n " + text;
                        } else {
                            saved = text;
                        }
                        
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter(filename12));
                            writer.write(saved);
                            writer.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    
                    
                }
            }   
        });
        stick.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
            }
            
        });
    }
}
