package frc.robot;

import javax.swing.JFrame;

import org.opencv.core.Core;

import edu.wpi.first.cameraserver.CameraServer;

import java.awt.Dimension;
import java.awt.EventQueue;

public class CameraTesting extends JFrame{
    
    public CameraTesting(){

        setSize(new Dimension(640,560));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                CameraTesting camera = new CameraTesting();
            }

        });
    }
}
