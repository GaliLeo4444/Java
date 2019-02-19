package interfaz;


import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import implementacion.*;

import javax.swing.WindowConstants;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import implementacion.ManejadorDeArchivos;


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
public class VentanaNuevo extends javax.swing.JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel panelCarpeta;
	private JPanel panelArchivo;
	private JLabel titulo;
	private JTextField textCarpeta;
	private JLabel nombreNuevo;
	private JButton btnCancelar;
	private JPanel arriba;
	private JButton btnCCarpeta;
	private JLabel textoFinal;
	private JLabel imgCarpeta;
	private JButton btnCrearArchivo;
	private JButton btnCArchivo;
	private JTextField textArchivo;
	private JButton btnAceptar;
	private Ruta lugar;
	private ManejadorDeArchivos MDA;


	/**
	* Es el constructor de la ventana
	*/
	public VentanaNuevo() {
		super();
		initGUI();
		MDA = new ManejadorDeArchivos();
	}


	private void initGUI() {
		try {
			this.setTitle("elTotal - Nuevo..");
			setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/Nuevo.png")).getImage());
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			this.setResizable(false);
			{
				arriba = new JPanel();
				AnchorLayout panelArribaLayout = new AnchorLayout();
				arriba.setLayout(panelArribaLayout);
				getContentPane().add(arriba, new AnchorConstraint(4, 1001, 298, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				arriba.setPreferredSize(new java.awt.Dimension(399, 35));
				{
					btnCArchivo = new JButton();
					arriba.add(btnCArchivo, new AnchorConstraint(214, 457, 814, 36, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnCArchivo.setText("Crear Archivo de Texto");
					btnCArchivo.setPreferredSize(new java.awt.Dimension(168, 21));
					btnCArchivo.addActionListener(new ActionListener()
					{	
						public void actionPerformed(ActionEvent e)
			            {	
							panelArchivo.setVisible(true);
							panelCarpeta.setVisible(false);
			            }
					});
				}
				{
					btnCCarpeta = new JButton();
					arriba.add(btnCCarpeta, new AnchorConstraint(214, 738, 814, 457, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnCCarpeta.setText("Crear Carpeta");
					btnCCarpeta.setPreferredSize(new java.awt.Dimension(112, 21));
					btnCCarpeta.addActionListener(new ActionListener()
					{	
						public void actionPerformed(ActionEvent e)
			            {	
							panelCarpeta.setVisible(true);
							panelArchivo.setVisible(false);
			            }
					});
				}
				{
					btnCancelar = new JButton();
					arriba.add(btnCancelar, new AnchorConstraint(214, 966, 814, 738, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnCancelar.setText("Cancelar");
					btnCancelar.setPreferredSize(new java.awt.Dimension(91, 21));
					btnCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Ocultar();
						}
					});
				}
			}
			{
				panelArchivo = new JPanel();
				AnchorLayout superiorLayout = new AnchorLayout();
				panelArchivo.setLayout(superiorLayout);
				getContentPane().add(panelArchivo, new AnchorConstraint(298, 1001, 1004, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelArchivo.setPreferredSize(new java.awt.Dimension(399, 84));
				panelArchivo.setBorder(BorderFactory.createTitledBorder(""));
				panelArchivo.setVisible(false);
				{
					textoFinal = new JLabel();
					panelArchivo.add(textoFinal, new AnchorConstraint(339, 1001, 589, 843, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					textoFinal.setText(".txt");
					textoFinal.setPreferredSize(new java.awt.Dimension(63, 21));
				}
				{
					btnCrearArchivo = new JButton();
					panelArchivo.add(btnCrearArchivo, new AnchorConstraint(589, 895, 839, 492, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnCrearArchivo.setText("Crear");
					btnCrearArchivo.setPreferredSize(new java.awt.Dimension(161, 21));
					btnCrearArchivo.addActionListener(new ActionListener()
					{	
						public void actionPerformed(ActionEvent e)
			            {	
							try{
								MDA.CrearArchivoTexto(lugar,textArchivo.getText()+".txt");
							}
							catch(IOException ex){
								JOptionPane.showMessageDialog(new JInternalFrame(), "Se ha producido un error al crear el archivo");							
							}
							catch (multipleExcepcion ex) {
								JOptionPane.showMessageDialog(new JInternalFrame(), ex.getMessage());
							}
							finally{
								textArchivo.setText("");
								panelArchivo.setVisible(false);
								Ocultar();
							}
							
			            }
					});
				}
				{
					titulo = new JLabel();
					panelArchivo.add(titulo, new AnchorConstraint(89, 761, 339, 71, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					titulo.setText("Nombre del archivo:");
					titulo.setPreferredSize(new java.awt.Dimension(140, 21));
				}
				{
					textArchivo = new JTextField();
					panelArchivo.add(textArchivo, new AnchorConstraint(339, 843, 589, 71, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					textArchivo.setPreferredSize(new java.awt.Dimension(308, 21));
				}
			}
			{
				panelCarpeta = new JPanel();
				AnchorLayout inferiorLayout = new AnchorLayout();
				panelCarpeta.setLayout(inferiorLayout);
				getContentPane().add(panelCarpeta, new AnchorConstraint(298, 1001, 1004, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelCarpeta.setPreferredSize(new java.awt.Dimension(399, 84));
				panelCarpeta.setBorder(BorderFactory.createTitledBorder(""));
				panelCarpeta.setVisible(false);
				{
					imgCarpeta = new JLabel();
					panelCarpeta.add(imgCarpeta, new AnchorConstraint(255, 106, 589, 18, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					imgCarpeta.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/Carpeta.png")));
					imgCarpeta.setPreferredSize(new java.awt.Dimension(35, 28));
				}
				{
					textCarpeta = new JTextField();
					panelCarpeta.add(textCarpeta, new AnchorConstraint(339, 948, 589, 124, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					textCarpeta.setPreferredSize(new java.awt.Dimension(329, 21));
				}
				{
					nombreNuevo = new JLabel();
					panelCarpeta.add(nombreNuevo, new AnchorConstraint(89, 738, 339, 124, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					nombreNuevo.setText("Nombre de la carpeta:");
					nombreNuevo.setPreferredSize(new java.awt.Dimension(245, 21));
				}
				{
					btnAceptar = new JButton();
					panelCarpeta.add(btnAceptar, new AnchorConstraint(589, 948, 839, 545, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnAceptar.setText("Crear");
					btnAceptar.setPreferredSize(new java.awt.Dimension(161, 21));
					btnAceptar.addActionListener(new ActionListener()
					{	
						public void actionPerformed(ActionEvent e)
			            {	
							MDA.CrearCarpeta(lugar,textCarpeta.getText());
							textCarpeta.setText("");
							panelCarpeta.setVisible(false);
							Ocultar();
			            }
					});
				}
			}
			pack();
			this.setSize(449, 151);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Muestra la ventana y registra la ruta actual donde se colocara
	 * el nuevo elemento
	 */
	public void Mostrar(Ruta r){
		lugar=r;
		this.setVisible(true);
	}

	/**
	 * Oculta la ventana
	 */
	private void Ocultar(){
		this.setVisible(false);
	}


}
