package interfaz;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.WindowConstants;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class DialogAcercaDe extends javax.swing.JDialog {

	
	private static final long serialVersionUID = 1L;
	private JLabel labelAutores;
	private JButton imagen;
	private JButton botonAceptar;
	private JLabel labelVersion;
	private JLabel autor3;
	private JLabel autor2;
	private JLabel autor1;


	/**
	* Es el constructor de la ventana
	*/
	public DialogAcercaDe() {
		super();
		initGUI();
		this.setVisible(true);
	}


	private void initGUI() {
		try {
			{
				this.setSize(351, 263);
				this.setLocation(400, 200);
				getContentPane().setLayout(null);
				this.setAlwaysOnTop(true);
				this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				this.setTitle("Acerca De elTotal (TotalLoco)....");
				getContentPane().setBackground(new java.awt.Color(157,253,130));
				this.setResizable(false);
				{
					labelAutores = new JLabel();
					getContentPane().add(labelAutores);
					labelAutores.setText("Autores:");
					labelAutores.setBounds(14, 49, 77, 28);
					labelAutores.setFont(new java.awt.Font("Tahoma",1,14));
					labelAutores.setForeground(new java.awt.Color(0,0,0));
				}
				{
					autor1 = new JLabel();
					getContentPane().add(autor1);
					autor1.setText("López Leandro J.");
					autor1.setBounds(70, 77, 126, 28);
					autor1.setFont(new java.awt.Font("Tahoma",3,12));
					autor1.setForeground(new java.awt.Color(0,0,0));
				}
				{
					autor2 = new JLabel();
					getContentPane().add(autor2);
					autor2.setText("Porcellatti Matias");
					autor2.setBounds(70, 105, 126, 28);
					autor2.setFont(new java.awt.Font("Tahoma",3,12));
					autor2.setForeground(new java.awt.Color(0,0,0));
				}
				{
					autor3 = new JLabel();
					getContentPane().add(autor3);
					autor3.setText("Vera Christian");
					autor3.setBounds(70, 133, 126, 28);
					autor3.setFont(new java.awt.Font("Tahoma",3,12));
					autor3.setForeground(new java.awt.Color(0,0,0));
				}
				{
					labelVersion = new JLabel();
					getContentPane().add(labelVersion);
					labelVersion.setText("Versión 1.4.4");
					labelVersion.setBounds(77, 7, 105, 28);
					labelVersion.setFont(new java.awt.Font("Tahoma",1,12));
					labelVersion.setForeground(new java.awt.Color(0,0,0));
				}
				{
					botonAceptar = new JButton();
					getContentPane().add(botonAceptar);
					botonAceptar.setText("Aceptar");
					botonAceptar.setBounds(126, 175, 98, 42);
					botonAceptar.setFont(new java.awt.Font("Tahoma",1,14));
					botonAceptar.setBackground(new java.awt.Color(0,0,255));
					botonAceptar.setForeground(new java.awt.Color(255,255,255));
					botonAceptar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							botonAceptarActionPerformed();
						}
					});
				}
				{
					imagen = new JButton();
					getContentPane().add(imagen);
					imagen.setBounds(224, 42, 98, 98);
					imagen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Avisos/AcercaDe.png")));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Al presionar el botón Aceptar, simplemente se destruye la ventana.
	 * 
	 */
	private void botonAceptarActionPerformed() {
		this.dispose();
	}


}
