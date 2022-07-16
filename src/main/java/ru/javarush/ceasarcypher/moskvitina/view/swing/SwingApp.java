package ru.javarush.ceasarcypher.moskvitina.view.swing;

import ru.javarush.ceasarcypher.moskvitina.controller.MainController;

import javax.swing.*;
@SuppressWarnings("unused")
public class SwingApp extends JFrame{
    private JPanel mainPanel;
    private JTextArea originalText;
    private JTextArea processedText;
    private JPanel topPanel;
    private JPanel leftBottomPanel;
    private JPanel rightBottomPanel;
    private JLabel pathText;
    private JLabel commandText;
    private JTextField filePath;
    private JSpinner keyValue;
    private JLabel key;
    private JLabel original;
    private JLabel processed;
    private JTextField originalFilePath;
    private JLabel originalPathText;
    private JButton encodeButton;
    private JButton decodeButton;
    private JButton bruteforceButton;


    public SwingApp(){
        super("Криптоанализатор");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        encodeButton.addActionListener(e -> {
            MainController mainController = new MainController();

            if(e.getSource() == encodeButton){
                String[] args = {originalFilePath.getText(), filePath.getText(), keyValue.getValue().toString()};
                mainController.execute("encode",args);
            }
        });
        decodeButton.addActionListener(e -> {
            MainController mainController = new MainController();

            if(e.getSource() == decodeButton){
                String[] args = {originalFilePath.getText(), filePath.getText(), keyValue.getValue().toString()};
                mainController.execute("decode",args);
            }
        });
        bruteforceButton.addActionListener(e -> {
            MainController mainController = new MainController();

            if(e.getSource() == bruteforceButton){
                String[] args = {originalFilePath.getText(), filePath.getText()};
                mainController.execute("bruteforce",args);
            }
        });
    }

}
