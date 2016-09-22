package br.com.projetointegrador.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GUIUtil {

	public static int posX;
	public static int posY;

	public static void center(Component componente) {
		// Centraliza a janela de abertura no centro do desktop.
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle r = componente.getBounds();
		// Dimensões da janela
		int widthSplash = r.width;
		int heightSplash = r.height;

		// calculo para encontrar as cooredenadas X e Y para a centralização da
		// janela.
		posX = (screen.width / 2) - (widthSplash / 2);
		posY = (screen.height / 2) - (heightSplash / 2);

		componente.setBounds(posX, posY, widthSplash, heightSplash);
	}

	public static void setLookAndFeel(Component componente) {
		try {
			// com.jtattoo.plaf.acryl.AcrylLookAndFeel
			// org.fife.plaf.Office2003.Office2003LookAndFeel
			// com.sun.java.swing.plaf.windows.WindowsLookAndFeel
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(componente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
