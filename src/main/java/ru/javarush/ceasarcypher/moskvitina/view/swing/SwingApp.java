package ru.javarush.ceasarcypher.moskvitina.view.swing;

import ru.javarush.ceasarcypher.moskvitina.commands.Encoder;
import ru.javarush.ceasarcypher.moskvitina.controller.MainController;
import ru.javarush.ceasarcypher.moskvitina.exceptions.ApplicationException;
import ru.javarush.ceasarcypher.moskvitina.util.PathFinder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.Files.readAllLines;

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
        initView();
        initListeners();

    }

    private void initView() {
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setBounds(540, 500, 1000, 600);
        int min = 1;
        int max = 500;
        int step = 1;
        int i = 1;
        SpinnerModel value = new SpinnerNumberModel(i, min, max, step);
        keyValue.setModel(value);
    }

    private void initListeners() {
        encodeButton.addActionListener(e -> {
            MainController mainController = new MainController();

            if(e.getSource() == encodeButton){
                String[] args = {originalFilePath.getText(), filePath.getText(), keyValue.getValue().toString()};
                mainController.execute("encode",args);
                printOriginalText();
                printProcessedText();
            }
        });
        decodeButton.addActionListener(e -> {
            MainController mainController = new MainController();

            if(e.getSource() == decodeButton){
                String[] args = {originalFilePath.getText(), filePath.getText(), keyValue.getValue().toString()};
                mainController.execute("decode",args);
                printOriginalText();
                printProcessedText();
            }
        });
        bruteforceButton.addActionListener(e -> {
            MainController mainController = new MainController();

            if(e.getSource() == bruteforceButton){
                String[] args = {originalFilePath.getText(), filePath.getText()};
                mainController.execute("bruteforce",args);
                printOriginalText();
                printProcessedText();
            }
        });

    }

    private void printOriginalText() {
        try {
            List<String> allLines = Files.readAllLines(Path.of(PathFinder.getRoot() + originalFilePath.getText()));
            StringBuilder sb = new StringBuilder();
            for (String allLine : allLines) {
                sb.append(allLine);
                sb.append("\n");
            }
            originalText.setText(sb.toString());
        } catch (IOException ex) {
            throw new ApplicationException("Ошибка", ex);
        }
    }

    private void printProcessedText() {
        try {
            List<String> allLines = Files.readAllLines(Path.of(PathFinder.getRoot() + filePath.getText()));
            StringBuilder sb = new StringBuilder();
            for (String allLine : allLines) {
                sb.append(allLine);
                sb.append("\n");
            }
            processedText.setText(sb.toString());
        } catch (IOException ex) {
            throw new ApplicationException("Ошибка", ex);
        }
    }

}
