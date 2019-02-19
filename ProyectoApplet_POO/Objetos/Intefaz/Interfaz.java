package Objetos.Intefaz;
import java.awt.CardLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Objetos.Modelo.Almacenamiento;
import Objetos.Modelo.CD;

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
public class Interfaz extends javax.swing.JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		try {
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JTabbedPane jTabbedPane1;
	private JPanel jPanel1;
	private JLabel jLabel4;
	private JTextField jTextField6;
	private JLabel jLabel13;
	private JButton jButton4;
	private JTextField jTextField13;
	private JTextField jTextField4;
	private JComboBox jComboBox2;
	private JButton jButton1;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JTable jTable2;
	private JScrollPane jScrollPane2;
	private JButton jButton14;
	private JButton jButton12;
	private JButton jButton13;
	private JComboBox jComboBox1;
	private JPanel jPanel6;
	private JTextField jTextField12;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private JCheckBox jCheckBox4;
	private JCheckBox jCheckBox3;
	private JCheckBox jCheckBox2;
	private JCheckBox jCheckBox1;
	private JLabel jLabel8;
	private JTextField jTextField11;
	private JPanel jPanel7;
	private JPanel jPanel5;
	private JTabbedPane jTabbedPane2;
	private JButton jButton10;
	private JButton jButton9;
	private JLabel jLabel10;
	private JTextField jTextField10;
	private JLabel jLabel9;
	private JTextField jTextField8;
	private JTextField jTextField7;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JButton jButton5;
	private JButton jButton3;
	private JButton jButton2;
	private JLabel jLabel5;
	private JTextField jTextField5;
	private JTextField jTextField3;
	private JLabel jLabel3;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JPanel jPanel2;
	private Almacenamiento A;
	private CD CDSeleccionado;
	
	/**
	* Auto-generated main method to display this 
	* JApplet inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Interfaz inst = new Interfaz();
		frame.getContentPane().add(inst);
		((JComponent)frame.getContentPane()).setPreferredSize(inst.getSize());
		frame.pack();
		frame.setVisible(true);
			
	}
	
	public Interfaz() {
		super();	
		initGUI();
	}
	
	private void initGUI() {
		try {
			{	
				A = new Almacenamiento();
				this.setSize(115, 51);
			}
			CardLayout thisLayout = new CardLayout();
			getContentPane().setLayout(thisLayout);
			this.setSize(534, 341);
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, "jTabbedPane1");
				{
					jPanel1 = new JPanel();
					jTabbedPane1.addTab("Coleccion", null, jPanel1, null);
					jPanel1.setLayout(null);
					jPanel1.setBounds(-49, 0, 532, 294);
					{
						jPanel6 = new JPanel();
						jPanel1.add(jPanel6);
						jPanel6.setBounds(7, 14, 378, 294);
						jPanel6.setLayout(null);
						{
							jScrollPane2 = new JScrollPane();
							jPanel6.add(jScrollPane2);
							jScrollPane2.setBounds(7, 7, 357, 280);
							jScrollPane2
								.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
							{
								TableModel jTable2Model = new DefaultTableModel(
									null,
									new String[] { "Album", "Artista" });
								jTable2 = new JTable();
								jScrollPane2.setViewportView(jTable2);
								jTable2.setModel(jTable2Model);
								jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								jTable2.getTableHeader().setBounds(
									0,
									0,
									336,
									91);
								jTable2
									.setPreferredSize(new java.awt.Dimension(
										336,
										315));
								jTable2
									.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
							}
						}
					}

					{
						jButton5 = new JButton();
						jPanel1.add(jButton5);
						jButton5.setText("Cargar");
						jButton5.setBounds(406, 35, 91, 28);
						jButton5.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								jButton5MouseClicked(evt);
							}

						});

					}
					{
						jButton1 = new JButton();
						jPanel1.add(jButton1);
						jButton1.setText("Detalle");
						jButton1.setBounds(413, 77, 77, 28);
						jButton1.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								jButton1MouseClicked(evt);
							}
						});
					}
				}
				{
					jPanel3 = new JPanel();
					jTabbedPane1.addTab("Detalles", null, jPanel3, null);
					jPanel3.setLayout(null);
					jPanel3.setBounds(105, 63, 63, 28);
					jPanel3.setPreferredSize(new java.awt.Dimension(364, 273));
					{
						jLabel6 = new JLabel();
						jPanel3.add(jLabel6);
						jLabel6.setText("Nombre");
						jLabel6.setBounds(28, 14, 70, 21);
					}
					{
						jLabel7 = new JLabel();
						jPanel3.add(jLabel7);
						jLabel7.setText("Interprete");
						jLabel7.setBounds(21, 46, 77, 28);
					}
					{
						jTextField6 = new JTextField();
						jPanel3.add(jTextField6);
						jTextField6.setBounds(84, 7, 231, 28);
						jTextField6.setEditable(false);
					}
					{
						jTextField7 = new JTextField();
						jPanel3.add(jTextField7);
						jTextField7.setBounds(84, 49, 231, 28);
						jTextField7.setEditable(false);
					}
					{
						jLabel8 = new JLabel();
						jPanel3.add(jLabel8);
						jLabel8.setText("Año");
						jLabel8.setBounds(49, 84, 35, 28);
					}
					{
						jTextField8 = new JTextField();
						jPanel3.add(jTextField8);
						jTextField8.setBounds(85, 84, 70, 28);
						jTextField8.setEditable(false);
					}
					{
						jLabel9 = new JLabel();
						jPanel3.add(jLabel9);
						jLabel9.setText("Genero");
						jLabel9.setBounds(175, 84, 42, 28);
					}
					{
						jTextField10 = new JTextField();
						jPanel3.add(jTextField10);
						jTextField10.setBounds(84, 122, 70, 28);
						jTextField10.setEditable(false);
					}
					{
						jLabel10 = new JLabel();
						jPanel3.add(jLabel10);
						jLabel10.setText("Duración");
						jLabel10.setBounds(26, 120, 63, 28);
					}
					{
						jButton9 = new JButton();
						jPanel3.add(jButton9);
						jButton9.setText("Editar");
						jButton9.setBounds(245, 210, 98, 28);
						jButton9.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								jButton9MouseClicked(evt);
							}
						});
					}
					{
						jButton10 = new JButton();
						jPanel3.add(jButton10);
						jButton10.setText("Guardar");
						jButton10.setBounds(133, 210, 98, 28);
						jButton10.setEnabled(false);
						jButton10.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								jButton10MouseClicked(evt);
							}
						});
					}
					{
						jTextField4 = new JTextField();
						jPanel3.add(jTextField4);
						jTextField4.setBounds(224, 85, 84, 28);
						jTextField4.setEditable(false);
					}
					{
						jButton4 = new JButton();
						jPanel3.add(jButton4);
						jButton4.setText("Eliminar");
						jButton4.setBounds(28, 210, 84, 28);
						jButton4.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								jButton4MouseClicked(evt);
							}
						});
					}
				}
				{
					jPanel2 = new JPanel();
					jTabbedPane1.addTab("Agregar CD", null, jPanel2, null);
					jPanel2.setLayout(null);
					jPanel2.setPreferredSize(new java.awt.Dimension(427, 294));
					{
						jLabel1 = new JLabel();
						jPanel2.add(jLabel1);
						jLabel1.setText("Nombre");
						jLabel1.setBounds(48, 19, 70, 21);
					}
					{
						jLabel2 = new JLabel();
						jPanel2.add(jLabel2);
						jLabel2.setText("Interprete");
						jLabel2.setBounds(42, 56, 77, 28);
						jLabel2.setLayout(null);
					}
					{
						jTextField1 = new JTextField();
						jPanel2.add(jTextField1);
						jTextField1.setBounds(98, 14, 217, 28);
					}
					{
						jTextField2 = new JTextField();
						jPanel2.add(jTextField2);
						jTextField2.setBounds(98, 56, 217, 28);
					}
					{
						jLabel3 = new JLabel();
						jPanel2.add(jLabel3);
						jLabel3.setText("Año");
						jLabel3.setBounds(61, 97, 35, 28);
					}
					{
						jTextField3 = new JTextField();
						jPanel2.add(jTextField3);
						jTextField3.setBounds(98, 98, 70, 28);
					}
					{
						jLabel4 = new JLabel();
						jPanel2.add(jLabel4);
						jLabel4.setText("Genero");
						jLabel4.setBounds(190, 98, 42, 28);
					}
					{
						jTextField5 = new JTextField();
						jPanel2.add(jTextField5);
						jTextField5.setBounds(98, 140, 70, 28);
					}
					{
						jLabel5 = new JLabel();
						jPanel2.add(jLabel5);
						jLabel5.setText("Duración");
						jLabel5.setBounds(41, 139, 63, 28);
					}
					{
						jButton2 = new JButton();
						jPanel2.add(jButton2);
						jButton2.setText("Resetear");
						jButton2.setBounds(147, 203, 105, 28);
						jButton2
							.setBorder(BorderFactory.createTitledBorder(""));
						jButton2.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								jButton2MouseClicked(evt);

							}

						});
					}
					{
						jButton3 = new JButton();
						jPanel2.add(jButton3);
						jButton3.setText("Cargar");
						jButton3.setBounds(273, 203, 98, 28);
						jButton3.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								jButton3MouseClicked(evt);
							}
						});
					}
					{
						ComboBoxModel jComboBox2Model = new DefaultComboBoxModel(
							new String[] { "Rock", "Pop", "Hip Hop", "Cumbia",
									"Clasico", "Electronico", "Metal", "Otros" });
						jComboBox2 = new JComboBox();
						jPanel2.add(jComboBox2);
						jComboBox2.setModel(jComboBox2Model);
						jComboBox2.setBounds(238, 98, 91, 28);
					}

				}
				{
					jPanel4 = new JPanel();
					jTabbedPane1.addTab("Busqueda", null, jPanel4, null);
					jPanel4.setEnabled(false);
					jPanel4.setLayout(null);
					jPanel4.setPreferredSize(new java.awt.Dimension(413, 287));
					{
						jTabbedPane2 = new JTabbedPane();
						jPanel4.add(jTabbedPane2);
						jTabbedPane2.setBounds(21, 14, 490, 287);
						jTabbedPane2.setBorder(BorderFactory
							.createTitledBorder(""));
						{
							jPanel5 = new JPanel();
							jTabbedPane2.addTab(
								"Colección",
								null,
								jPanel5,
								null);
							jPanel5.setLayout(null);

							{
								ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
									new String[] { "Artista", "Album" });
								jComboBox1 = new JComboBox();
								jPanel5.add(jComboBox1);
								jComboBox1.setModel(jComboBox1Model);
								jComboBox1.setBounds(14, 21, 84, 28);

							}
							{
								jButton13 = new JButton();
								jPanel5.add(jButton13);
								jButton13.setText("Detalles");
								jButton13.setBounds(357, 70, 112, 28);
								jButton13.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent evt) {
										jButton13MouseClicked(evt);
									}
								});
							}
							{
								jButton14 = new JButton();
								jPanel5.add(jButton14);
								jButton14.setText("Buscar");
								jButton14.setBounds(357, 21, 112, 28);
								jButton14.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent evt) {
										jButton14MouseClicked(evt);
									}
								});
							}
							{
								jScrollPane1 = new JScrollPane();
								jPanel5.add(jScrollPane1);
								jScrollPane1.setBounds(14, 63, 301, 168);
								{
									TableModel jTable1Model = new DefaultTableModel(
										new String[] { "CD", "Artista" },
										0);
									jTable1 = new JTable();
									jScrollPane1.setViewportView(jTable1);
									jTable1.setModel(jTable1Model);
									jTable1
										.setPreferredSize(new java.awt.Dimension(
											301,
											140));
								}
							}
							{
								jTextField13 = new JTextField();
								jPanel5.add(jTextField13);
								jTextField13.setBounds(133, 21, 175, 28);
							}
							{
								jLabel13 = new JLabel();
								jPanel5.add(jLabel13);
								jLabel13.setText("No se encontró nada!!!!");
								jLabel13.setBounds(322, 133, 147, 35);
								jLabel13.setFont(new java.awt.Font("Tahoma",1,12));
								jLabel13.setVisible(false);
							}
						}
						{
							jPanel7 = new JPanel();
							jTabbedPane2
								.addTab("Internet", null, jPanel7, null);

							jPanel7.setBounds(7, 42, 399, 266);
							jPanel7.setLayout(null);
							jPanel7.setPreferredSize(new java.awt.Dimension(
								399,
								217));
							{
								jCheckBox1 = new JCheckBox();
								jPanel7.add(jCheckBox1);
								jCheckBox1.setText("Google");
								jCheckBox1.setBounds(294, 7, 91, 35);
							}
							{
								jTextField11 = new JTextField();
								jPanel7.add(jTextField11);
								jTextField11.setBounds(77, 14, 161, 28);
							}
							{
								jCheckBox2 = new JCheckBox();
								jPanel7.add(jCheckBox2);
								jCheckBox2.setText("Yahoo");
								jCheckBox2.setBounds(294, 70, 77, 35);
							}
							{
								jCheckBox3 = new JCheckBox();
								jPanel7.add(jCheckBox3);
								jCheckBox3.setBounds(294, 42, 84, 28);
								jCheckBox3.setText("LasFm");
							}
							{
								jCheckBox4 = new JCheckBox();
								jPanel7.add(jCheckBox4);
								jCheckBox4.setText("IsoHunt");
								jCheckBox4.setBounds(294, 105, 84, 28);
							}
							{
								jLabel11 = new JLabel();
								jPanel7.add(jLabel11);
								jLabel11.setText("Artista");
								jLabel11.setBounds(28, 14, 49, 28);
							}
							{
								jLabel12 = new JLabel();
								jPanel7.add(jLabel12);
								jLabel12.setText("Album");
								jLabel12.setBounds(28, 56, 63, 28);
							}
							{
								jTextField12 = new JTextField();
								jPanel7.add(jTextField12);
								jTextField12.setBounds(77, 56, 161, 28);
							}
							{
								jButton12 = new JButton();
								jPanel7.add(jButton12);
								jButton12.setText("Buscar");
								jButton12.setBounds(273, 161, 98, 28);
								jButton12.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent evt) {
										jButton12MouseClicked(evt);
									}
								});
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		
		/**
		 * Abre la/s páginas selecionadas buscando la información requerida.
		 * @param evt
		 */
		
	private void jButton12MouseClicked(MouseEvent evt) {
		System.out.println("jButton12.mouseClicked, event=" + evt);
		try
		{	
		if (jCheckBox1.isSelected())	
			getAppletContext().showDocument(new URL ( "http://www.google.com.ar/search?hl=es&q="+jTextField11.getText()+"+"+jTextField12.getText()+"&btnG=B%C3%BAsqueda+en+Google&meta=" ),"_blank" );
		if (jCheckBox2.isSelected())
			getAppletContext().showDocument(new URL ( "http://ar.search.yahoo.com/search?p="+jTextField11.getText()+"+"+jTextField12.getText()+"&fr=FP-tab-web-t340&toggle=1&cop=&ei=UTF-8&meta=vl%3D"),"_blank" );
		if (jCheckBox3.isSelected())
			getAppletContext().showDocument(new URL ( "http://www.lastfm.es/music?m=all&q="+jTextField11.getText()+"+"+jTextField12.getText()),"_blank" );
		if (jCheckBox4.isSelected())
			getAppletContext().showDocument(new URL ( "http://www.isohunt.com/torrents/?ihq="+jTextField11.getText()+"+"+jTextField12.getText()),"_blank" );
				
		}
		catch ( Exception e )
		{
		}	
		
	}
	/**
	 * Busca un CD específico en la colección y retorna los resultados en un tabla.
	 * @param evt
	 */
	private void jButton14MouseClicked(MouseEvent evt) {
		System.out.println("jButton14.mouseClicked, event=" + evt);
		CD C;
		String N, nom;
		int i,j = 0;
		CD[] Resul;
		DefaultTableModel M = (DefaultTableModel)this.jTable1.getModel(); 
		
		jLabel13.setVisible(false);
		//Se elimina lo que esta cargado hasta el momento en la tabla de resultados
		while (M.getRowCount()!=0) 
			M.removeRow(0);	
		//Recupera del combobox el tipo de busqueda a realizar
		N = jComboBox1.getSelectedItem().toString();
//		Carga la tabla de resultados con los resultados de la busqueda
		if (N=="Album")
		{  nom = jTextField13.getText();
			C = A.BuscarCD(nom);
			if (C  != null) {
				 String[]fila = {C.getNombre(),C.getInterprete()};
				 M.addRow(fila);
			}
			else {jLabel13.setVisible(true);}
		}
		else  
		{
		Resul = A.BuscarPorArtista(jTextField13.getText());
		//Resul = A;
		i = 0;
		C = Resul[i];
		if (C == null)
		 	{jLabel13.setVisible(true);}
		while (C != null) {
			System.out.println(i);
			String[]fila = {C.getNombre(),C.getInterprete()};
			M.addRow(fila);
			i++;
			C = Resul[i];			
		}
		}
	}
	
	private void jButton3MouseClicked(MouseEvent evt) {
		System.out.println("jButton3.mouseClicked, event=" + evt);
	CD Cd = new CD();
	String S;
	DefaultTableModel M = (DefaultTableModel)this.jTable2.getModel();
	
	//Obtiene los datos del nuevo CD
	Cd.setInterprete(jTextField2.getText());
	Cd.setNombre(jTextField1.getText());
	S = jTextField3.getText();
	if (!(S.equals("")))// examina si es numero
		Cd.setAño(Integer.valueOf(S).intValue());
	else
		Cd.setAño(0);
	Cd.setGenero(jComboBox2.getSelectedItem().toString());	
	S = jTextField5.getText();
	if (!(S.equals("")))// examina si es numero
		Cd.setDuracion(Integer.valueOf(S)
			.intValue());
	else
		Cd.setDuracion(0);
	
	//agregar cd en el almacenamiento
	A.AgregarCD(Cd);
	String[]fila = {Cd.getNombre(),Cd.getInterprete()};
	M.addRow(fila);
	
	jTextField1.setText("");
	jTextField2.setText("");
	jTextField3.setText("");
	jTextField5.setText("");
	}
	
	/**
	 * carga en la lista por defecto
	 */
	  
	private void jButton5MouseClicked(MouseEvent evt) {
		System.out.println("jButton5.mouseClicked, event=" + evt);

		CD C;
		int i,j;
		DefaultTableModel M = (DefaultTableModel)this.jTable2.getModel();
				
		//	se elimina lo que esta cargado hasta el momento
		// en la tabla de coleccion
		while (M.getRowCount()!=0) 
			M.removeRow(0);
		//		Carga la tabla de la coleccion con los elementos de almacenamiento

		C = new CD("Appetite for Destruction", "Guns And Roses", 100, 1987, "Rock");
		A.AgregarCD(C);
		C = new CD("Un Bahión para el Ojo Idiota", "Los Redonditos de Ricota", 100, 1995, "Rock");
		A.AgregarCD(C);
		C = new CD("Go:The Very Best Of Moby", "Moby", 100, 2006, "Electronic");
		A.AgregarCD(C);
		C = new CD("X & Y", "Coldplay", 100, 2005, "Rock");
		A.AgregarCD(C);
		
		if (!A.AlmacenamientoVacio())
		{
			A.PrimerCD();		
			j = A.CantidadCD();
			i=0;
			while (i < j)
			{   C = A.RetornarCD();
				String[]fila = {C.getNombre(),C.getInterprete()};
				M.addRow(fila);
				A.SiguienteCD();			
				i++;
			}
		}	
		
	}
	/**
	 *  LLeva a la pantalla detalle el CD
	 * @param evt
	 */
	
	private void jButton1MouseClicked(MouseEvent evt) {
		System.out.println("jButton1.mouseClicked, event=" + evt);
			
	CD CDBuscado;
	String Album; 
			
	Album = (String)jTable2.getValueAt(jTable2.getSelectedRow(),jTable2.getSelectedColumn());

	CDBuscado = A.BuscarCD(Album);
	if (CDBuscado != null){
		jTabbedPane1.setSelectedComponent(jPanel3);
		jTextField6.setText(CDBuscado.getNombre());
		jTextField7.setText(CDBuscado.getInterprete());
		jTextField8.setText(String.valueOf(CDBuscado.getAño()));
		jTextField10.setText(String.valueOf(CDBuscado.getDuracion()));
		jTextField4.setText(CDBuscado.getGenero());
	}
	}
	

	/**
	 *  Setea los textField
	 * @param evt
	 */
	private void jButton2MouseClicked(MouseEvent evt) {
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField3.setText("");
		jTextField5.setText("");
	}
	
	
	private void jButton13MouseClicked(MouseEvent evt) {
		System.out.println("jButton13.mouseClicked, event=" + evt);
		CD CDBuscado;
		String Album; 
				
		Album = (String)jTable1.getValueAt(jTable1.getSelectedRow(),jTable1.getSelectedColumn());

		CDBuscado = A.BuscarCD(Album);
		if (CDBuscado != null){
			jTabbedPane1.setSelectedComponent(jPanel3);
			jTextField6.setText(CDBuscado.getNombre());
			jTextField7.setText(CDBuscado.getInterprete());
			jTextField8.setText(String.valueOf(CDBuscado.getAño()));
			jTextField10.setText(String.valueOf(CDBuscado.getDuracion()));
			jTextField4.setText(CDBuscado.getGenero());
		}

	}
	
	
	private void jButton4MouseClicked(MouseEvent evt) {
		System.out.println("jButton4.mouseClicked, event=" + evt);
		int i, j;
		CD C;
		DefaultTableModel M = (DefaultTableModel)this.jTable2.getModel(); 
		
		C = A.BuscarCD(jTextField6.getText());
		A.QuitarCD(C);
		//resetea los campos de detalles
		jTextField4.setText("");
		jTextField6.setText("");
		jTextField7.setText("");
		jTextField8.setText("");
		jTextField10.setText("");
		//deshabilita la edición de cds si no hay cds 
		if (A.AlmacenamientoVacio()) 
			{jButton9.setEnabled(false);}
		//se elimina lo que esta cargado hasta el momento en la tabla de coleccion
		while (M.getRowCount()!=0) 
			M.removeRow(0);
		//Carga la tabla de la coleccion con los elementos de almacenamiento
		if (!A.AlmacenamientoVacio())
		{
			A.PrimerCD();		
			j = A.CantidadCD();
			i=0;
			while (i < j)
			{   C = A.RetornarCD();
				String[]fila = {C.getNombre(),C.getInterprete()};
				M.addRow(fila);
				A.SiguienteCD();			
				i++;
			}
		}
		
	}
	
	private void jButton9MouseClicked(MouseEvent evt) {
		System.out.println("jButton9.mouseClicked, event=" + evt);
		jTextField4.setEditable(true);
		jTextField6.setEditable(true);
		jTextField7.setEditable(true);
		jTextField8.setEditable(true);
		jTextField10.setEditable(true);
		jButton10.setEnabled(true);
		jButton9.setEnabled(false);
		CDSeleccionado = A.BuscarCD(jTextField6.getText());
	}
	
	private void jButton10MouseClicked(MouseEvent evt) {
		System.out.println("jButton10.mouseClicked, event=" + evt);
		DefaultTableModel M = (DefaultTableModel)this.jTable2.getModel(); 
		int i, j;
		CD C;

		jTextField4.setEditable(false);
		jTextField6.setEditable(false);
		jTextField7.setEditable(false);
		jTextField8.setEditable(false);
		jTextField10.setEditable(false);
		jButton10.setEnabled(false);
		if (CDSeleccionado != null) {
			CDSeleccionado.setNombre(jTextField6.getText());
			CDSeleccionado.setInterprete(jTextField7.getText());
			CDSeleccionado.setAño(Integer.valueOf(jTextField8.getText()));
			CDSeleccionado.setDuracion(Integer.valueOf(jTextField10.getText()));
			CDSeleccionado.setGenero(jTextField4.getText());
		}
		jButton9.setEnabled(true);
		
		while (M.getRowCount()!=0) 
			M.removeRow(0);
		//Carga la tabla de la coleccion con los elementos de almacenamiento
		if (!A.AlmacenamientoVacio())
		{
			A.PrimerCD();		
			j = A.CantidadCD();
			i=0;
			while (i < j)
			{   C = A.RetornarCD();
				String[]fila = {C.getNombre(),C.getInterprete()};
				M.addRow(fila);
				A.SiguienteCD();			
				i++;
			}
		}
	}

}