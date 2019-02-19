package Objetos;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
public class Interface extends javax.swing.JApplet {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private Almacenamiento A;
	private String album_artista[][] = new String [40][2];	//Un arreglo de 20 filas y 2 columnas.
	int ultima_fila = 0;		//Es la última fila agregada en la ListaCDs.
	private JTabbedPane jTabbedPane1;
	private JPanel ColeccionCD;
	private JLabel jLabel4;
	private JTextField jTextField6;
	private JScrollPane jScrollPane1;
	private JTable ListaCDs;
	private JTextField jTextField15;
	private JTextField jTextField14;
	private JTextField jTextField13;
	private JTextField jTextField12;
	private JTextField jTextField11;
	private JLabel jLabel8;
	private JButton jButton8;
	private JButton jButton7;
	private JButton jButton6;
	private JLabel jLabel10;
	private JTextField jTextField10;
	private JTextField jTextField9;
	private JLabel jLabel9;
	private JTextField jTextField8;
	private JTextField jTextField7;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JPanel Internet;
	private JPanel DetallesCD;
	private JButton jButton5;
	private JButton jButton4;
	private JButton jButton3;
	private JButton jButton2;
	private JButton jButton1;
	private JLabel jLabel5;
	private JTextField jTextField5;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JLabel jLabel3;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JPanel AgregarCD;

	/**
	* Auto-generated main method to display this 
	* JApplet inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Interface inst = new Interface();
		frame.getContentPane().add(inst);
		((JComponent)frame.getContentPane()).setPreferredSize(inst.getSize());
		frame.pack();
		frame.setVisible(true);
	}
	
	public Interface() {
		super();
		A = new Almacenamiento();
		initGUI();
	}
	
	private void initGUI() {
		try {
			CardLayout thisLayout = new CardLayout();
			getContentPane().setLayout(thisLayout);
			this.setSize(560, 350);
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, "jTdsd");
				jTabbedPane1.setPreferredSize(new java.awt.Dimension(700, 291));
				{
					ColeccionCD = new JPanel();
					jTabbedPane1.addTab("Colección CD", null, ColeccionCD, null);
					ColeccionCD.setLayout(null);
					ColeccionCD.setPreferredSize(new java.awt.Dimension(
						504,
						420));
					{
						jButton4 = new JButton();
						ColeccionCD.add(jButton4);
						jButton4.setText("Detalles");
						jButton4.setBounds(441, 98, 91, 28);
						jButton4.setEnabled(false);
						jButton4.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								jButton4MouseClicked(evt);
							}
						});
					}
					{
						jButton5 = new JButton();
						ColeccionCD.add(jButton5);
						jButton5.setText("Cargar CDs");
						jButton5.setBounds(427, 28, 112, 49);
						jButton5.setToolTipText("Cargo los CDs por defecto del Applet!!!!");
						jButton5.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								jButton5MouseClicked(evt);
							}
						});
					}
					{
						jScrollPane1 = new JScrollPane();
						ColeccionCD.add(jScrollPane1);
						jScrollPane1.setBounds(7, 7, 378, 315);
						{
							ListaCDs = new JTable();
							jScrollPane1.setViewportView(ListaCDs);
							ListaCDs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							ListaCDs.setBounds(7, 7, 35, 28);
							ListaCDs.setPreferredSize(new java.awt.Dimension(266, 483));
							ListaCDs.addMouseListener(new MouseAdapter() {
								public void mouseClicked(MouseEvent evt) {
									ListaCDsMouseClicked(evt);
								}
							});
						}
					}
					ColeccionCD.setFocusCycleRoot(true);
				}
				{
					DetallesCD = new JPanel();
					jTabbedPane1.addTab("Detalles CD", null, DetallesCD, null);
					DetallesCD.setLayout(null);
					DetallesCD.setBounds(105, 63, 63, 28);
					{
						jLabel6 = new JLabel();
						DetallesCD.add(jLabel6);
						jLabel6.setText("Nombre");
						jLabel6.setBounds(28, 14, 70, 21);
					}
					{
						jLabel7 = new JLabel();
						DetallesCD.add(jLabel7);
						jLabel7.setText("Interprete");
						jLabel7.setBounds(21, 42, 77, 28);
					}
					{
						jTextField6 = new JTextField();
						DetallesCD.add(jTextField6);
						jTextField6.setBounds(84, 7, 217, 28);
						jTextField6.setEnabled(false);
						jTextField6.setFont(new java.awt.Font("Tahoma", 1, 11));
					}
					{
						jTextField7 = new JTextField();
						DetallesCD.add(jTextField7);
						jTextField7.setBounds(84, 42, 217, 28);
						jTextField7.setEnabled(false);
						jTextField7.setFont(new java.awt.Font("Tahoma", 1, 11));
					}
					{
						jLabel8 = new JLabel();
						DetallesCD.add(jLabel8);
						jLabel8.setText("Año");
						jLabel8.setBounds(49, 84, 35, 28);
					}
					{
						jTextField8 = new JTextField();
						DetallesCD.add(jTextField8);
						jTextField8.setBounds(84, 84, 70, 28);
						jTextField8.setEnabled(false);
						jTextField8.setFont(new java.awt.Font("Tahoma", 1, 11));
					}
					{
						jLabel9 = new JLabel();
						DetallesCD.add(jLabel9);
						jLabel9.setText("Genero");
						jLabel9.setBounds(175, 84, 42, 28);
					}
					{
						jTextField9 = new JTextField();
						DetallesCD.add(jTextField9);
						jTextField9.setBounds(224, 84, 77, 28);
						jTextField9.setEnabled(false);
						jTextField9.setFont(new java.awt.Font("Tahoma", 1, 11));
					}
					{
						jTextField10 = new JTextField();
						DetallesCD.add(jTextField10);
						jTextField10.setBounds(84, 119, 70, 28);
						jTextField10.setEnabled(false);
						jTextField10
							.setFont(new java.awt.Font("Tahoma", 1, 11));
					}
					{
						jLabel10 = new JLabel();
						DetallesCD.add(jLabel10);
						jLabel10.setText("Duración");
						jLabel10.setBounds(21, 119, 63, 28);
					}
					{
						jButton6 = new JButton();
						DetallesCD.add(jButton6);
						jButton6.setEnabled(false);
						jButton6.setText("Temas");
						jButton6
							.setBorder(BorderFactory.createTitledBorder(""));
						jButton6.setBounds(42, 182, 91, 28);
					}
					{
						jButton7 = new JButton();
						DetallesCD.add(jButton7);
						jButton7.setText("Anterior");
						jButton7.setBounds(266, 182, 98, 28);
					}
					{
						jButton8 = new JButton();
						DetallesCD.add(jButton8);
						jButton8.setText("Siguiente");
						jButton8.setBounds(266, 147, 98, 28);
					}
					{
						jTextField11 = new JTextField();
						DetallesCD.add(jTextField11);
						jTextField11.setEnabled(false);
						jTextField11.setBounds(84, 119, 70, 28);
					}
					{
						jTextField12 = new JTextField();
						DetallesCD.add(jTextField12);
						jTextField12.setEnabled(false);
						jTextField12.setBounds(224, 84, 77, 28);
					}
					{
						jTextField13 = new JTextField();
						DetallesCD.add(jTextField13);
						jTextField13.setEnabled(false);
						jTextField13.setBounds(84, 84, 70, 28);
					}
					{
						jTextField14 = new JTextField();
						DetallesCD.add(jTextField14);
						jTextField14.setEnabled(false);
						jTextField14.setBounds(84, 42, 217, 28);
					}
					{
						jTextField15 = new JTextField();
						DetallesCD.add(jTextField15);
						jTextField15.setEnabled(false);
						jTextField15.setBounds(84, 7, 217, 28);
					}
				}
				{
					AgregarCD = new JPanel();
					jTabbedPane1.addTab("Agregar CD", null, AgregarCD, null);
					AgregarCD.setLayout(null);
					AgregarCD.setPreferredSize(new java.awt.Dimension(399, 245));
					{
						jLabel1 = new JLabel();
						AgregarCD.add(jLabel1);
						jLabel1.setText("Nombre");
						jLabel1.setBounds(26, 13, 70, 21);
					}
					{
						jLabel2 = new JLabel();
						AgregarCD.add(jLabel2);
						jLabel2.setText("Interprete");
						jLabel2.setBounds(19, 42, 77, 28);
					}
					{
						jTextField1 = new JTextField();
						AgregarCD.add(jTextField1);
						jTextField1.setBounds(84, 7, 217, 28);
					}
					{
						jTextField2 = new JTextField();
						AgregarCD.add(jTextField2);
						jTextField2.setBounds(84, 42, 217, 28);
					}
					{
						jLabel3 = new JLabel();
						AgregarCD.add(jLabel3);
						jLabel3.setText("Año");
						jLabel3.setBounds(47, 83, 35, 28);
					}
					{
						jTextField3 = new JTextField();
						AgregarCD.add(jTextField3);
						jTextField3.setBounds(84, 81, 70, 28);
					}
					{
						jLabel4 = new JLabel();
						AgregarCD.add(jLabel4);
						jLabel4.setText("Genero");
						jLabel4.setBounds(175, 82, 42, 28);
					}
					{
						jTextField4 = new JTextField();
						AgregarCD.add(jTextField4);
						jTextField4.setBounds(224, 81, 77, 28);
					}
					{
						jTextField5 = new JTextField();
						AgregarCD.add(jTextField5);
						jTextField5.setBounds(84, 120, 70, 28);
					}
					{
						jLabel5 = new JLabel();
						AgregarCD.add(jLabel5);
						jLabel5.setText("Duración");
						jLabel5.setBounds(24, 121, 63, 28);
					}
					{
						jButton1 = new JButton();
						AgregarCD.add(jButton1);
						jButton1.setText("Temas");
						jButton1.setBounds(42, 185, 91, 28);
												jButton1.setEnabled(false);
					}
					{
						jButton2 = new JButton();
						AgregarCD.add(jButton2);
						jButton2.setText("Resetear");
						jButton2.setBounds(148, 184, 105, 28);
											}
					{
						jButton3 = new JButton();
						AgregarCD.add(jButton3);
						jButton3.setText("Cargar");
						jButton3.setBounds(266, 185, 91, 28);
						jButton3
							.setBorder(BorderFactory.createTitledBorder(""));
					}
				}
				{
					Internet = new JPanel();
					jTabbedPane1.addTab("En internet", null, Internet, null);
					Internet.setEnabled(false);
					Internet.setLayout(null);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButton5MouseClicked(MouseEvent evt) {
		System.out.println("jButton5.mouseClicked, event=" + evt);
		CD nuevoCD;
		
		nuevoCD = new CD("Appetite for Destruction", "Guns And Roses", 100, 1987, "Rock");
		A.AgregarCD(nuevoCD);
		nuevoCD = new CD("Un Bahión para el Ojo Idiota", "Los Redonditos de Ricota", 100, 1995, "Rock");
		A.AgregarCD(nuevoCD);
		nuevoCD = new CD("Go:The Very Best Of Moby", "Moby", 100, 2006, "Electronic");
		A.AgregarCD(nuevoCD);
		nuevoCD = new CD("X & Y", "Coldplay", 100, 2005, "Rock");
		A.AgregarCD(nuevoCD);
		ActualizarListaCDs();
	}
	
	private void AgregarAListaCDs(CD nuevoCD) {
		ultima_fila += 1;
		album_artista[ultima_fila][0] = nuevoCD.getNombre();
		album_artista[ultima_fila][1] = nuevoCD.getInterprete();
	}
	
	private void ActualizarListaCDs() {
		CD actualCD;
		int fila = 0;
		
		A.PrimerCD();
		while (A.ExisteCD()) {			//Cargo los CDs que están en el almacenamiento a la ListaCDS.
			actualCD = A.RetornarCD();
			album_artista[fila][0] = actualCD.getNombre();
			album_artista[fila][1] = actualCD.getInterprete();
			A.SiguienteCD();
			fila += 1;
		}
		
		TableModel ListaCDsModel = new DefaultTableModel(album_artista, new String[] { "Álbum", "Artista" });
		ListaCDs.setModel(ListaCDsModel);
	}
	
	private void ListaCDsMouseClicked(MouseEvent evt) {
		System.out.println("ListaCDs.mouseClicked, event=" + evt);
		jButton4.setEnabled(true);
	}
	
	private void jButton4MouseClicked(MouseEvent evt) {
		System.out.println("jButton4.mouseClicked, event=" + evt);
		int fila_selec;
		CD CDBuscado;
		
		fila_selec = ListaCDs.getSelectedRow();
		CDBuscado = A.BuscarCD(album_artista[fila_selec][0]);	//Busco el CD por su nombre.
		if (CDBuscado != null)
			{jTabbedPane1.setSelectedComponent(DetallesCD);
			jTextField15.setText(CDBuscado.getNombre());
			jTextField14.setText(CDBuscado.getInterprete());
			}
	}

}