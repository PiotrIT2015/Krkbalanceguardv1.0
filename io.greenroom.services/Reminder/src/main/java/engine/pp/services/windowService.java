package engine.pp.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;

import javax.annotation.PostConstruct;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

@Service
@Component
public class windowService {

    windowService() {

    }

    @PostConstruct
    String initUI() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv files", "csv");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.showOpenDialog(null);

        String path = fileChooser.getSelectedFile().getAbsolutePath();

        return path;
    }
}