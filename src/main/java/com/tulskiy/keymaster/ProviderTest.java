package com.tulskiy.keymaster;

import com.sun.jna.Platform;
import com.tulskiy.keymaster.common.Provider;
import com.tulskiy.keymaster.windows.WindowsProvider;
import com.tulskiy.keymaster.x11.X11Provider;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: Denis Tulskiy
 * Date: 6/13/11
 */
public class ProviderTest {
    public static void main(String[] args) {
        final Provider provider;

        if (Platform.isX11()) {
            provider = new X11Provider();
        } else if (Platform.isWindows()) {
            provider = new WindowsProvider();
        } else {
            System.out.println("No suitable provider!");
            return;
        }
        provider.init();

        provider.register(KeyStroke.getKeyStroke("control alt D"), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource());
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        provider.reset();
                        provider.stop();
                    }
                });
            }
        });
        provider.register(KeyStroke.getKeyStroke("control shift F1"), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource());
            }
        });

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource());
            }
        };
        provider.register(KeyStroke.getKeyStroke("control shift 0"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift PLUS"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift INSERT"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift ESCAPE"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift BACK_QUOTE"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift SLASH"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift BACK_SLASH"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift DIVIDE"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift MULTIPLY"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift ENTER"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift MINUS"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift BACK_QUOTE"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift UP"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift INSERT"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift DELETE"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift ADD"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift SUBTRACT"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift COMMA"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift PERIOD"), listener);
        provider.register(KeyStroke.getKeyStroke("control shift SEMICOLON"), listener);

        provider.register(KeyStroke.getKeyStroke("control alt HOME"), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource());
            }
        });

        provider.register(KeyStroke.getKeyStroke("control alt PAGE_UP"), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource());
            }
        });

        provider.register(KeyStroke.getKeyStroke("control alt NUMPAD0"), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource());
            }
        });
    }
}