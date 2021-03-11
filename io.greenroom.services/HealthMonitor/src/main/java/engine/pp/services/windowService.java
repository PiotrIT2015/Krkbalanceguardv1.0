package engine.pp.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

@Service
@Component
public class windowService implements Window {

    public windowService(){

    }

    @PostConstruct
    public String initUI() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv files", "csv");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.showOpenDialog(null);
        String path=fileChooser.getSelectedFile().getAbsolutePath();
        return path;
    }

}
