package interfaz;


import implementacion.Ruta;
import implementacion.ManejadorDeArchivos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;


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
public class DialogoPropiedades extends javax.swing.JDialog {


	private static final long serialVersionUID = 1L;
	private JLabel labelTam;
	private JTextField mostrarUbi;
	private JButton botonCerrar;
	private JCheckBox checkBoxSoloLectura;
	private JLabel labelUbicacion;
	private JCheckBox checkBoxOculto;
	private JLabel mostrarMod;
	private JLabel mostrarTam;
	private JLabel mostrarExt;
	private JLabel labelModi;
	private JLabel labelExt;
	private ManejadorDeArchivos MDA; 

	
	/**
	* Es el constructor de la ventana de dialogo
	*/
	public DialogoPropiedades() {
		super();
		initGUI();
		MDA = new ManejadorDeArchivos();
	}


	private void initGUI() {
		try {
			{
				this.setSize(463, 305);
				this.setLocation(400, 200);
				this.setResizable(false);
				getContentPane().setLayout(null);
				{
					labelUbicacion = new JLabel();
					getContentPane().add(labelUbicacion);
					labelUbicacion.setText("Ubicación:");
					labelUbicacion.setFont(new java.awt.Font("Tahoma", 0, 12));
					labelUbicacion.setBounds(28, 70, 63, 28);
				}
				{
					labelTam = new JLabel();
					getContentPane().add(labelTam);
					labelTam.setText("Tamaño:");
					labelTam.setFont(new java.awt.Font("Tahoma", 0, 12));
					labelTam.setBounds(28, 112, 63, 28);
				}
				{
					labelExt = new JLabel();
					getContentPane().add(labelExt);
					labelExt.setText("Extensión:");
					labelExt.setFont(new java.awt.Font("Tahoma", 0, 12));
					labelExt.setBounds(28, 28, 63, 28);
				}
				{
					labelModi = new JLabel();
					getContentPane().add(labelModi);
					labelModi.setText("Modificado:");
					labelModi.setFont(new java.awt.Font("Tahoma", 0, 12));
					labelModi.setBounds(28, 154, 63, 28);
				}
				{
					botonCerrar = new JButton();
					getContentPane().add(botonCerrar);
					botonCerrar.setText("Cerrar");
					botonCerrar.setBounds(189, 231, 84, 28);
					botonCerrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							ocultarDialog();
						}
					});
				}
				{
					checkBoxSoloLectura = new JCheckBox();
					getContentPane().add(checkBoxSoloLectura);
					checkBoxSoloLectura.setText("Sólo Lectura");
					checkBoxSoloLectura.setFont(new java.awt.Font(
						"Tahoma",
						0,
						12));
					checkBoxSoloLectura.setEnabled(false);
					checkBoxSoloLectura.setBounds(133, 196, 98, 21);
				}
				{
					checkBoxOculto = new JCheckBox();
					getContentPane().add(checkBoxOculto);
					checkBoxOculto.setText("Oculto");
					checkBoxOculto.setEnabled(false);
					checkBoxOculto.setFont(new java.awt.Font("Tahoma", 0, 12));
					checkBoxOculto.setBounds(266, 196, 63, 21);
				}
				{
					mostrarExt = new JLabel();
					getContentPane().add(mostrarExt);
					mostrarExt.setBounds(119, 35, 315, 21);
				}
				{
					mostrarUbi = new JTextField();
					getContentPane().add(mostrarUbi);
					mostrarUbi.setBounds(119, 77, 315, 21);
					mostrarUbi.setFont(new java.awt.Font("Tahoma",0,12));
					mostrarUbi.setEditable(false);
				}
				{
					mostrarTam = new JLabel();
					getContentPane().add(mostrarTam);
					mostrarTam.setBounds(119, 119, 315, 21);
				}
				{
					mostrarMod = new JLabel();
					getContentPane().add(mostrarMod);
					mostrarMod.setBounds(119, 161, 308, 21);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Muestra información en la ventana Propiedades sobre la carpeta recibida.
	 * @param r Es la ruta completa de la carpeta mostrar. 
	 */
	public void mostrarInfoCarpeta(Ruta r) throws IOException{
		File carp = new File(r.getFullPath());
		this.setTitle("Propiedades de " + r.getNomCarpeta());
		mostrarUbi.setText(r.getPathDeCarpeta());
		labelExt.setVisible(false);
		mostrarExt.setText("");
		labelModi.setVisible(false);
		mostrarMod.setText("");
		mostrarTam.setText(MDA.tamanioCarpeta(r));
		if (carp.isHidden()){
			checkBoxOculto.setSelected(true);
		}
		else {
			checkBoxOculto.setSelected(false);
		}
		if (carp.canWrite()){
			checkBoxSoloLectura.setSelected(false);
		}
		else {
			checkBoxSoloLectura.setSelected(true);
		}
		this.setVisible(true);
	}
	
	/**
	 * Muestra información en la ventana Propiedades sobre el archivo recibido.
	 * @param r Es la ruta completa del archivo a mostrar.
	 */
	public void mostrarInfoArchivo(Ruta r)throws IOException{
		File arch = new File(r.getFullPath());
		this.setTitle("Propiedades de " + r.getNomArchivo());
		labelExt.setVisible(true);
		labelModi.setVisible(true);
		mostrarUbi.setText(r.getPathDeArchivo());
		mostrarExt.setText(r.getExtension());
		mostrarMod.setText(MDA.fechaModArchComun(r));
		mostrarTam.setText(MDA.tamanioArchivo(r));
		if (arch.isHidden()){
			checkBoxOculto.setSelected(true);
		}
		else {
			checkBoxOculto.setSelected(false);
		}
		if (arch.canWrite()){
			checkBoxSoloLectura.setSelected(false);
		}
		else {
			checkBoxSoloLectura.setSelected(true);
		}
		this.setVisible(true);
	}
	
	/**
	 * Oculta la ventana
	 */
	private void ocultarDialog (){
		this.setVisible(false);
	}


}
