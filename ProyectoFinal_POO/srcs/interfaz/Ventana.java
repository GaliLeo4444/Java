package interfaz;


import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.util.Vector;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import implementacion.Ruta;
import implementacion.multipleExcepcion;
import java.lang.String;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
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
/**
 * @author Administrador
 *
 */
public class Ventana extends JFrame implements Serializable{


	private static final long serialVersionUID = 1L;
	static private JScrollPane jScrollPane1;
	static private JScrollPane jScrollPane2;
	static private JMenuItem menuItemAIzq;
	static private JMenuItem menuItemSeleccionarT;
	static private JMenuItem menuItemCortar;
	static private JMenuItem menuItemPegar;
	static private JMenuItem menuItemCopiar;
	static private JSeparator separador2;
	static private JMenuItem menuItemCerrar;
	private Tabla tablaIzq;
	private Tabla tablaDer;
	private JComboBox comboOrdenarDesc2;
	private JComboBox comboOrdenarDesc1;
	private JComboBox comboOrdenarAsc2;
	private JComboBox comboOrdenarAsc1;
	private JMenuItem menuItemADer;
	private JMenu menuItemMoverA;
	private JLabel labelTamanio2;
	private JLabel labelTamanio1;
	private JLabel datos2;
	private JLabel datos1;
	private JPanel barraDeEstado;
	private JTabbedPane pestaniaDer;
	private JTabbedPane pestaniaIzq;
	static private JLabel labelCarpeta2;
	static private JLabel labelCarpeta;
	static private JSeparator separador1;
	static private JMenuItem menuItemAbrirTerminal;
	static private JSeparator separador;
	static private JButton botonArriba2;
	static private JButton botonArriba1;
	static private JTextField textVentana2;
	static private JTextField textVentana1;
	static private JPanel panelBotones1;
	static private JButton botonEliminar;
	static private JComboBox comboUnidades2;
	static private JComboBox comboUnidades1;
	static private JButton botonPropiedades;
	static private JButton botonNuevo;
	static private JButton botonCambiarNom;
	static private JButton botonPegar;
	static private JButton botonCopiar;
	static private JButton botonCortar;
	private JMenuItem itemAscXNombre;
	private JMenuItem itemDescXFecha;
	private JMenuItem itemAscXFecha;
	private JMenuItem itemDescXExtencion;
	private JMenuItem itemDescXNombre;
	private JMenuItem itemDescXTamanio;
	private JMenuItem itemAscXTamanio;
	private JMenuItem itemAscXExtencion;
	private JMenu menuItemDescendente;
	private JMenu menuItemAscendente;
	private JMenu menuItemOrdenar;
	static private JCheckBoxMenuItem menuItemVerBarraEst;
	static private JMenuItem menuItemAcerca;
	static private JSeparator separador5;
	static private JSeparator separador4;
	static private JSeparator separador3;
	static private JMenuItem menuItemEliminar;
	static private JMenuItem menuItemCambiarNombre;
	static private JMenuItem menuItemPropiedades;
	static private JMenu menuAyuda;
	static private JMenu menuVer;
	static private JMenu menuEdicion;
	static private JMenu menuArchivo;
	static private JPanel panelPrincipal;
	private JMenuBar barraMenu;
	private int listaSeleccionada;
	private VentanaRenombrar vRenom;
	private VentanaNuevo vNuevo;
	private DialogoPropiedades dialogProp;
	private VentanaEspera vEspera;
	private ManejadorDeArchivos MDA;
	private LineBorder conBorde;
	private LineBorder sinBorde;


	/**
	 * Procedimiento principal de la clase.
	 * @param args
	 */
	public static void main(String[] args) {
		Ventana ventPrincipal = new Ventana();
		ventPrincipal.setVisible(true);
	}


	/**
	 * Es el constructor de la clase.
	 */
	public Ventana()
	{		
		super();
		initGUI();
		MDA = new ManejadorDeArchivos();
	}


	/**
	 * Inicializa la interfaz
	 */
	private void initGUI() {
		sinBorde=new LineBorder(new java.awt.Color(0,128,0), 0, false);
		conBorde=new LineBorder(new java.awt.Color(0,128,0), 3, false);
		vRenom = new VentanaRenombrar();
		vNuevo = new VentanaNuevo();
		vEspera = new VentanaEspera();
		dialogProp = new DialogoPropiedades();
		listaSeleccionada=0;
		this.pack();
		this.setSize(800, 600);
		this.setTitle("elTotal");
		this.setIconImage(new ImageIcon(("Iconos/Avisos/Icono.png")).getImage());
		panelPrincipal = new JPanel();
		AnchorLayout panelPrincipalLayout = new AnchorLayout();
		panelPrincipal.setLayout(panelPrincipalLayout);
		this.getContentPane().add(panelPrincipal);
		panelPrincipal.setPreferredSize(new java.awt.Dimension(799, 480));
		panelPrincipal.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		panelPrincipal.setOpaque(false);
		panelPrincipal.setBounds(0, 0, 792, 520);
		{
			ComboBoxModel comboOrdenarDesc2Model = new DefaultComboBoxModel(
				new String[] { "Orden descendente", "Por nombre", "Por extensión", "Por tamaño", "Por fecha" });
			comboOrdenarDesc2 = new JComboBox();
			panelPrincipal.add(comboOrdenarDesc2, new AnchorConstraint(141, 928, 180, 769, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			comboOrdenarDesc2.setModel(comboOrdenarDesc2Model);
			comboOrdenarDesc2.setPreferredSize(new java.awt.Dimension(134, 21));
			comboOrdenarDesc2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					int i;
					i = comboOrdenarDesc2.getSelectedIndex();
					if ((i == 1) || (i == 2)){			//Si es por nombre o por extensión
						ordenarTablaDer(false, i-1, "");
					}
					else {
						if ((i == 3) || (i == 4)){		//Si es por tamaño o por fecha
							ordenarTablaDer(false, i-1, textVentana2.getText());
						}
					}
					comboOrdenarDesc2.setSelectedIndex(0);
				}
			});
		}
		{
			ComboBoxModel comboOrdenarDesc1Model = new DefaultComboBoxModel(
				new String[] { "Orden descendente", "Por nombre", "Por extensión", "Por tamaño", "Por fecha" });
			comboOrdenarDesc1 = new JComboBox();
			panelPrincipal.add(comboOrdenarDesc1, new AnchorConstraint(141, 433, 180, 265, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			comboOrdenarDesc1.setModel(comboOrdenarDesc1Model);
			comboOrdenarDesc1.setPreferredSize(new java.awt.Dimension(134, 21));
			comboOrdenarDesc1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					int i;
					i = comboOrdenarDesc1.getSelectedIndex();
					if ((i == 1) || (i == 2)){			//Si es por nombre o por extensión
						ordenarTablaIzq(false, i-1, "");
					}
					else {
						if ((i == 3) || (i == 4)){		//Si es por tamaño o por fecha
							ordenarTablaIzq(false, i-1, textVentana1.getText());
						}
					}
					comboOrdenarDesc1.setSelectedIndex(0);
				}
			});
		}
		{
			ComboBoxModel comboOrdenar2Model = new DefaultComboBoxModel(
				new String[] { "Orden ascendente", "Por nombre", "Por extensión", "Por tamaño", "Por fecha" });
			comboOrdenarAsc2 = new JComboBox();
			panelPrincipal.add(comboOrdenarAsc2, new AnchorConstraint(141, 751, 180, 601, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			comboOrdenarAsc2.setModel(comboOrdenar2Model);
			comboOrdenarAsc2.setPreferredSize(new java.awt.Dimension(134, 21));
			comboOrdenarAsc2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					int i;
					i = comboOrdenarAsc2.getSelectedIndex();
					if ((i == 1) || (i == 2)){			//Si es por nombre o por extensión
						ordenarTablaDer(true, i-1, "");
					}
					else {
						if ((i == 3) || (i == 4)){		//Si es por tamaño o por fecha
							ordenarTablaDer(true, i-1, textVentana2.getText());
						}
					}
					comboOrdenarAsc2.setSelectedIndex(0);
				}
			});
		}
		{
			ComboBoxModel comboOrdenar1Model = new DefaultComboBoxModel(
				new String[] { "Orden ascendente", "Por nombre", "Por extensión", "Por tamaño", "Por fecha" });
			comboOrdenarAsc1 = new JComboBox();
			panelPrincipal.add(comboOrdenarAsc1, new AnchorConstraint(141, 248, 180, 97, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			comboOrdenarAsc1.setModel(comboOrdenar1Model);
			comboOrdenarAsc1.setPreferredSize(new java.awt.Dimension(134, 21));
			comboOrdenarAsc1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					int i;
					i = comboOrdenarAsc1.getSelectedIndex();
					if ((i == 1) || (i == 2)){			//Si es por nombre o por extensión
						ordenarTablaIzq(true, i-1, "");
					}
					else {
						if ((i == 3) || (i == 4)){		//Si es por tamaño o por fecha
							ordenarTablaIzq(true, i-1, textVentana1.getText());
						}
					}
					comboOrdenarAsc1.setSelectedIndex(0);
				}
			});
		}
		{
			barraDeEstado = new JPanel();
			AnchorLayout barraDeEstadoLayout = new AnchorLayout();
			barraDeEstado.setLayout(barraDeEstadoLayout);
			panelPrincipal.add(barraDeEstado, new AnchorConstraint(951, 990, 989, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			barraDeEstado.setPreferredSize(new java.awt.Dimension(777, 21));
			{
				labelTamanio2 = new JLabel();
				barraDeEstado.add(labelTamanio2, new AnchorConstraint(357, 1000, 1023, 865, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				labelTamanio2.setPreferredSize(new java.awt.Dimension(105, 14));
			}
			{
				labelTamanio1 = new JLabel();
				barraDeEstado.add(labelTamanio1, new AnchorConstraint(357, 478, 1023, 342, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				labelTamanio1.setPreferredSize(new java.awt.Dimension(105, 14));
			}
			{
				datos2 = new JLabel();
				barraDeEstado.add(datos2, new AnchorConstraint(357, 1000, 1023, 514, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				datos2.setPreferredSize(new java.awt.Dimension(378, 14));
			}
			{
				datos1 = new JLabel();
				barraDeEstado.add(datos1, new AnchorConstraint(357, 487, 1023, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				datos1.setPreferredSize(new java.awt.Dimension(378, 14));
			}
		}
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		{
			labelCarpeta2 = new JLabel();
			panelPrincipal.add(labelCarpeta2, new AnchorConstraint(180, 548, 231, 513, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			labelCarpeta2.setPreferredSize(new java.awt.Dimension(28, 28));
			labelCarpeta2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/Carpeta.png")));
		}
		{
			labelCarpeta = new JLabel();
			panelPrincipal.add(labelCarpeta, new AnchorConstraint(186, 44, 239, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			labelCarpeta.setPreferredSize(new java.awt.Dimension(28, 28));
			labelCarpeta.setSize(28, 28);
			labelCarpeta.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/Carpeta.png")));
		}
		{
			botonArriba1 = new JButton();
			panelPrincipal.add(botonArriba1, new AnchorConstraint(180, 486, 244, 451, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			botonArriba1.setPreferredSize(new java.awt.Dimension(28, 35));
			botonArriba1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/Arriba.png")));
			botonArriba1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jScrollPane1.setBorder(conBorde);
					jScrollPane2.setBorder(sinBorde);
					listaSeleccionada = 1;
					botonArriba1ActionPerformed(evt);
				}
			});
		}
		{
			botonArriba2 = new JButton();
			panelPrincipal.add(botonArriba2, new AnchorConstraint(180, 990, 244, 955, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			botonArriba2.setPreferredSize(new java.awt.Dimension(28, 35));
			botonArriba2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/Arriba.png")));
			botonArriba2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
						jScrollPane2.setBorder(conBorde);
						jScrollPane1.setBorder(sinBorde);
					listaSeleccionada=2;
					botonArriba2ActionPerformed(evt);
				}
			});
		}
		{
			panelBotones1 = new JPanel();
			AnchorLayout panelBotones1Layout = new AnchorLayout();
			panelPrincipal.add(panelBotones1, new AnchorConstraint(14, 522, 133, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelBotones1.setPreferredSize(new java.awt.Dimension(406, 63));
			panelBotones1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
			panelBotones1.setLayout(panelBotones1Layout);
			{
				botonNuevo = new JButton();
				AnchorLayout botonNuevoLayout = new AnchorLayout();
				botonNuevo.setLayout(botonNuevoLayout);
				panelBotones1.add(botonNuevo, new AnchorConstraint(91, 144, 941, 18, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				botonNuevo.setRolloverEnabled(true);
				botonNuevo.setToolTipText("Nuevo");
				botonNuevo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/Nuevo.png")));
				botonNuevo.setOpaque(false);
				botonNuevo.setPreferredSize(new java.awt.Dimension(51, 51));
				botonNuevo.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
					
					if (listaSeleccionada==1){
						vNuevo.Mostrar(new Ruta(textVentana1.getText()));
						actualizarRuta1(textVentana1.getText());
						actualizarRuta2(textVentana2.getText());
					}
					else 
					{
						vNuevo.Mostrar(new Ruta(textVentana2.getText()));
						actualizarRuta1(textVentana1.getText());
						actualizarRuta2(textVentana2.getText());
					}
	            }
	            });
			}
			{
				botonCambiarNom = new JButton();
				AnchorLayout botonCambiarNomLayout = new AnchorLayout();
				botonCambiarNom.setLayout(botonCambiarNomLayout);
				panelBotones1.add(botonCambiarNom, new AnchorConstraint(91, 282, 941, 156, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				botonCambiarNom.setRolloverEnabled(true);
				botonCambiarNom.setToolTipText("Cambiar nombre");
				botonCambiarNom.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/CambiarNombre.png")));
				botonCambiarNom.setPreferredSize(new java.awt.Dimension(51, 51));
				botonCambiarNom.addActionListener(new ActionListener()
				{	
					public void actionPerformed(ActionEvent e)
		            {	
						operacionCambiarNombre ();
		            }
				});
			}
			{
				botonCopiar = new JButton();
				AnchorLayout botonCopiarLayout = new AnchorLayout();
				botonCopiar.setLayout(botonCopiarLayout);
				panelBotones1.add(botonCopiar, new AnchorConstraint(91, 420, 941, 295, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				botonCopiar.setRolloverEnabled(true);
				botonCopiar.setToolTipText("Copiar");
				botonCopiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/Copiar.png")));
				botonCopiar.setPreferredSize(new java.awt.Dimension(51, 51));
				botonCopiar.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
		            {
						MDA.Copiar(buscarSeleccionados());
		            }
				});
			}
			{
				botonCortar = new JButton();
				AnchorLayout botonCortarLayout = new AnchorLayout();
				botonCortar.setLayout(botonCortarLayout);
				panelBotones1.add(botonCortar, new AnchorConstraint(91, 559, 941, 433, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				botonCortar.setRolloverEnabled(true);
				botonCortar.setToolTipText("Cortar");
				botonCortar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/Cut.png")));
				botonCortar.setPreferredSize(new java.awt.Dimension(51, 51));
				botonCortar.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						MDA.Cortar(buscarSeleccionados());
					}
				});
			}
			{
				botonPegar = new JButton();
				AnchorLayout botonPegarLayout = new AnchorLayout();
				botonPegar.setLayout(botonPegarLayout);
				panelBotones1.add(botonPegar, new AnchorConstraint(91, 697, 941, 571, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				botonPegar.setRolloverEnabled(true);
				botonPegar.setToolTipText("Pegar");
				botonPegar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/Pegar.png")));
				botonPegar.setPreferredSize(new java.awt.Dimension(51, 51));
				botonPegar.addActionListener(new ActionListener()
				{	
					public void actionPerformed(ActionEvent e)
		            {
						operacionPegar();
		            }
				});
			}
			{
				botonEliminar = new JButton();
				AnchorLayout botonEliminarLayout = new AnchorLayout();
				botonEliminar.setLayout(botonEliminarLayout);
				panelBotones1.add(botonEliminar, new AnchorConstraint(91, 835, 941, 709, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				botonEliminar.setRolloverEnabled(true);
				botonEliminar.setToolTipText("Eliminar");
				botonEliminar.setName("");
				botonEliminar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/Eliminar.png")));
				botonEliminar.setPreferredSize(new java.awt.Dimension(51, 51));
				botonEliminar.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e) {	
						operacionEliminar();
		        			}
				});
			}
			{
				botonPropiedades = new JButton();
				AnchorLayout botonPropiedadesLayout = new AnchorLayout();
				botonPropiedades.setLayout(botonPropiedadesLayout);
				panelBotones1.add(botonPropiedades, new AnchorConstraint(91, 974, 941, 848, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				botonPropiedades.setRolloverEnabled(true);
				botonPropiedades.setToolTipText("Propiedades");
				botonPropiedades.setName("");
				botonPropiedades.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/Propiedades.png")));
				botonPropiedades.setPreferredSize(new java.awt.Dimension(51, 51));
				botonPropiedades.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
		            {
						mostrarPropiedades();
		            }
					
				});
			}
		}
		{
			{	ComboBoxModel comboUnidadesModel = new DefaultComboBoxModel(File.listRoots());
				comboUnidades1 = new JComboBox();
				panelPrincipal.add(comboUnidades1, new AnchorConstraint(141, 71, 180, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				comboUnidades1.setModel(comboUnidadesModel);
				comboUnidades1.setPreferredSize(new java.awt.Dimension(49, 21));
				comboUnidades1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						jScrollPane1.setBorder(conBorde);
						jScrollPane2.setBorder(sinBorde);
						listaSeleccionada = 1;
						actualizarRuta1(comboUnidades1.getSelectedItem().toString());
					}
				});
			}
			{	ComboBoxModel comboUnidadesModel = new DefaultComboBoxModel(File.listRoots());
				comboUnidades2 = new JComboBox();
				panelPrincipal.add(comboUnidades2, new AnchorConstraint(141, 575, 180, 513, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				comboUnidades2.setModel(comboUnidadesModel);
				comboUnidades2.setPreferredSize(new java.awt.Dimension(49, 21));
				comboUnidades2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						jScrollPane2.setBorder(conBorde);
						jScrollPane1.setBorder(sinBorde);
						listaSeleccionada=2;
						actualizarRuta2(comboUnidades2.getSelectedItem().toString());
					}
				});
			}
		}
		
		{
			pestaniaIzq = new JTabbedPane();
			panelPrincipal.add(pestaniaIzq, new AnchorConstraint(244, 486, 951, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			pestaniaIzq.setPreferredSize(new java.awt.Dimension(378, 385));
			pestaniaIzq.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					jScrollPane1.setBorder(conBorde);
					jScrollPane2.setBorder(sinBorde);
					listaSeleccionada = 1;
				}
			});
			{
				jScrollPane1 = new JScrollPane();
				pestaniaIzq.addTab("", null, jScrollPane1, null);
				jScrollPane1.setPreferredSize(new java.awt.Dimension(378, 385));
				jScrollPane1.setVisible(true);
				jScrollPane1.setAutoscrolls(true);
				jScrollPane1.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent e) {
						jScrollPane1.setBorder(conBorde);
						jScrollPane2.setBorder(sinBorde);
						listaSeleccionada = 1;
					}
				});
				{
					tablaIzq = new Tabla();
					Ruta carpeta = new Ruta(comboUnidades1.getSelectedItem().toString());
					try {
						tablaIzq.asociarModeloConRuta(carpeta);
					}
					catch (IOException ex){
						JOptionPane.showMessageDialog(new JInternalFrame(), "Error al cargar la lista de archivos");
					}
					finally {
						jScrollPane1.setViewportView(tablaIzq);
						tablaIzq.setVerifyInputWhenFocusTarget(false);
						tablaIzq.addKeyListener(new KeyAdapter() {
							public void keyPressed(KeyEvent evt) {
								teclaApretada(evt);
							}
						});
						tablaIzq.addMouseListener(new MouseAdapter() {
							public void mousePressed(MouseEvent e) {
								jScrollPane1.setBorder(conBorde);
								jScrollPane2.setBorder(sinBorde);
								listaSeleccionada = 1;
								Click(e);
							}
						});
					}
				}
			}
		}
		{
			pestaniaDer = new JTabbedPane();
			panelPrincipal.add(pestaniaDer, new AnchorConstraint(244, 990, 951, 513, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			pestaniaDer.setPreferredSize(new java.awt.Dimension(378, 385));
			pestaniaDer.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					jScrollPane2.setBorder(conBorde);
					jScrollPane1.setBorder(sinBorde);
					listaSeleccionada = 2;
				}
			});
			{
				jScrollPane2 = new JScrollPane();
				pestaniaDer.addTab(comboUnidades1.getSelectedItem().toString(), null, jScrollPane2, null);
				jScrollPane2.setVisible(true);
				jScrollPane2.setPreferredSize(new java.awt.Dimension(378, 385));
				jScrollPane2.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent e) {
						jScrollPane2.setBorder(conBorde);
						jScrollPane1.setBorder(sinBorde);
						listaSeleccionada = 2;
					}
				});
				{
					tablaDer = new Tabla();
					Ruta carpeta = new Ruta(comboUnidades2.getSelectedItem().toString());
					try {
						tablaDer.asociarModeloConRuta(carpeta);
					}
					catch (IOException ex){
						JOptionPane.showMessageDialog(new JInternalFrame(), "Error al cargar la lista de archivos");
					}
					finally {
						jScrollPane2.setViewportView(tablaDer);
						tablaDer.addKeyListener(new KeyAdapter() {
							public void keyPressed(KeyEvent evt) {
								teclaApretada(evt);
							}
						});
						tablaDer.addMouseListener(new MouseAdapter() {
							public void mousePressed(MouseEvent e) {
								jScrollPane2.setBorder(conBorde);
								jScrollPane1.setBorder(sinBorde);
								listaSeleccionada = 2;
								Click(e);
							}
						});
					}
				}
			}
		}
		{
			textVentana2 = new JTextField();
			panelPrincipal.add(textVentana2, new AnchorConstraint(189, 955, 243, 548, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			actualizarRuta2(comboUnidades2.getSelectedItem().toString());
			textVentana2.setPreferredSize(new java.awt.Dimension(322, 28));
			textVentana2.setEditable(false);
			textVentana2.setDisabledTextColor(new java.awt.Color(255,255,255));
		}
		{
			textVentana1 = new JTextField();
			panelPrincipal.add(textVentana1, new AnchorConstraint(189, 451, 243, 43, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			actualizarRuta1(comboUnidades1.getSelectedItem().toString());
			textVentana1.setPreferredSize(new java.awt.Dimension(322, 28));
			textVentana1.setEditable(false);
			textVentana1.setDisabledTextColor(new java.awt.Color(255,255,255));
		}
	{
		barraMenu = new JMenuBar();
		this.setJMenuBar(barraMenu);
		this.setJMenuBar(barraMenu);
		
		barraMenu.setPreferredSize(new java.awt.Dimension(700, 23));
		{
			menuArchivo = new JMenu();
			barraMenu.add(menuArchivo);
			menuArchivo.setText("Archivo");
			{
				menuItemAbrirTerminal = new JMenuItem();
				menuArchivo.add(menuItemAbrirTerminal);
				menuItemAbrirTerminal.setText("Abrir terminal");
				menuItemAbrirTerminal.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/Abrir.png")));
				menuItemAbrirTerminal.addActionListener(new ActionListener()
				{	
					public void actionPerformed(ActionEvent e)
		            {	
						try{
							MDA.Abrir(new Ruta("C:"+File.separator+"WINDOWS"+File.separator+"system32"+File.separator+"cmd.exe"));
						}
						catch(IOException ex){
							JOptionPane.showMessageDialog(new JInternalFrame(), "Error al abrir la ventana de terminal");
						}
					}
				});
				
			}
			{
				separador = new JSeparator();
				menuArchivo.add(separador);
			}
			{
				menuItemEliminar = new JMenuItem();
				menuArchivo.add(menuItemEliminar);
				menuItemEliminar.setText("Eliminar");
				menuItemEliminar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/Eliminar.png")));
				menuItemEliminar.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e) {	
						operacionEliminar();
		        			}
				});
			}
			{
				menuItemCambiarNombre = new JMenuItem();
				menuArchivo.add(menuItemCambiarNombre);
				menuItemCambiarNombre.setText("Cambiar nombre");
				menuItemCambiarNombre.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/CambiarNombre.png")));
				menuItemCambiarNombre.addActionListener(new ActionListener()
				{	
					public void actionPerformed(ActionEvent e)
		            {	
						operacionCambiarNombre ();
		            }
				});
			}
			{
				separador1 = new JSeparator();
				menuArchivo.add(separador1);
			}
			{
				menuItemPropiedades = new JMenuItem();
				menuArchivo.add(menuItemPropiedades);
				menuItemPropiedades.setText("Propiedades");
				menuItemPropiedades.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/Propiedades.png")));
				menuItemPropiedades.addActionListener(new ActionListener()
				{	
					public void actionPerformed(ActionEvent e)
		            {	
						mostrarPropiedades ();
		            }
				});
			}
			{
				separador2 = new JSeparator();
				menuArchivo.add(separador2);
			}
			{
				menuItemCerrar = new JMenuItem();
				menuArchivo.add(menuItemCerrar);
				menuItemCerrar.setText("Salir");
				menuItemCerrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/Salir.png")));
				menuItemCerrar.addActionListener(new ActionListener()
				{	
					public void actionPerformed(ActionEvent e)
		            {	
						 System.exit(0);
		            }
				});
			}
		}
		{
			menuEdicion = new JMenu();
			barraMenu.add(menuEdicion);
			menuEdicion.setText("Edición");
			{
				separador5 = new JSeparator();
				menuEdicion.add(separador5);
			}
			{
				menuItemCopiar = new JMenuItem();
				menuEdicion.add(menuItemCopiar);
				menuItemCopiar.setText("Copiar");
				menuItemCopiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/Copiar.png")));
				menuItemCopiar.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						MDA.Copiar(buscarSeleccionados());
					}
				});
				
			}
			{
				menuItemCortar = new JMenuItem();
				menuEdicion.add(menuItemCortar);
				menuItemCortar.setText("Cortar");
				menuItemCortar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/Cortar.png")));
				menuItemCortar.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						MDA.Cortar(buscarSeleccionados());
					}
				});
			}
			{
				menuItemPegar = new JMenuItem();
				menuEdicion.add(menuItemPegar);
				menuItemPegar.setText("Pegar");
				menuItemPegar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/Pegar.png")));
				menuItemPegar.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						operacionPegar();
					}
				});
			}
			{
				separador3 = new JSeparator();
				menuEdicion.add(separador3);
			}
			{
				menuItemMoverA = new JMenu();
				menuEdicion.add(menuItemMoverA);
				menuItemMoverA.setText("Mover a....");
				menuItemMoverA.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/Mover.png")));
				{
					menuItemAIzq = new JMenuItem();
					menuItemMoverA.add(menuItemAIzq);
					menuItemAIzq.setText("Lista izquierda");
					menuItemAIzq.setBounds(-77, -56, 7, 7);
					menuItemAIzq.addActionListener(new ActionListener()
					{	public void actionPerformed(ActionEvent e)
						{
							operacionMoverAIzq();
						}
					});
				}
				{
					menuItemADer = new JMenuItem();
					menuItemMoverA.add(menuItemADer);
					menuItemADer.setText("Lista Derecha");
					menuItemADer.addActionListener(new ActionListener()
					{	public void actionPerformed(ActionEvent e)
						{
							operacionMoverADer();
						}
					});
				}
			}
			{
				separador4 = new JSeparator();
				menuEdicion.add(separador4);
			}
			{
				menuItemSeleccionarT = new JMenuItem();
				menuEdicion.add(menuItemSeleccionarT);
				menuItemSeleccionarT.setText("Seleccionar todo");
				menuItemSeleccionarT.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/SeleccionarTodo.png")));
				menuItemSeleccionarT.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						SeleccionarTodo();
					}
				});
				
			}
		}
		{
			menuVer = new JMenu();
			barraMenu.add(menuVer);
			menuVer.setText("Ver");
			{
				menuItemVerBarraEst = new JCheckBoxMenuItem();
				menuVer.add(menuItemVerBarraEst);
				menuItemVerBarraEst.setText("Barra de estado");
				menuItemVerBarraEst.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/BarraEstado.png")));
				menuItemVerBarraEst.setSelected(true);
				menuItemVerBarraEst.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						menuItemVerBarraEstActionPerformed(evt);
					}
				});
			}
			{
				menuItemOrdenar = new JMenu();
				menuVer.add(menuItemOrdenar);
				menuItemOrdenar.setText("Ordenar en forma");
				menuItemOrdenar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/Organizar.png")));
				{
					menuItemAscendente = new JMenu();
					menuItemOrdenar.add(menuItemAscendente);
					menuItemAscendente.setText("Ascendente");
					{
						itemAscXNombre = new JMenuItem();
						menuItemAscendente.add(itemAscXNombre);
						itemAscXNombre.setText("Por nombre");
						itemAscXNombre.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(listaSeleccionada==1){
								ordenarTablaIzq(true, 0, "");
								}
								if(listaSeleccionada==2){
								ordenarTablaDer(true, 0, "");
								}
							}
						});
					}
					{
						itemAscXExtencion = new JMenuItem();
						menuItemAscendente.add(itemAscXExtencion);
						itemAscXExtencion.setText("Por extención");
						itemAscXExtencion.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(listaSeleccionada==1){
									ordenarTablaIzq(true, 1, "");
								}
								if(listaSeleccionada==2){
									ordenarTablaDer(true, 1, "");
								}
							}
							});
					}
					{
						itemAscXTamanio = new JMenuItem();
						menuItemAscendente.add(itemAscXTamanio);
						itemAscXTamanio.setText("Por tamaño");
						itemAscXTamanio.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(listaSeleccionada==1){
									ordenarTablaIzq(true, 2, textVentana1.getText());
								}
								if(listaSeleccionada==2){
									ordenarTablaDer(true, 2, textVentana2.getText());
								}
							}
						});
					}
					{
						itemAscXFecha = new JMenuItem();
						menuItemAscendente.add(itemAscXFecha);
						itemAscXFecha.setText("Por fecha");
						itemAscXFecha.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(listaSeleccionada==1){
									ordenarTablaIzq(true, 3, textVentana1.getText());
								}
								if(listaSeleccionada==2){
									ordenarTablaDer(true, 3, textVentana2.getText());
								}
							}
						});
					}

				}
				{
					menuItemDescendente = new JMenu();
					menuItemOrdenar.add(menuItemDescendente);
					menuItemDescendente.setText("Descendente");
					{
						itemDescXNombre = new JMenuItem();
						menuItemDescendente.add(itemDescXNombre);
						itemDescXNombre.setText("Por nombre");
						itemDescXNombre.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(listaSeleccionada==1){
									ordenarTablaIzq(false, 0, "");
								}
								if(listaSeleccionada==2){
									ordenarTablaDer(false, 0, "");
								}
							}
						});
					}
					{
						itemDescXExtencion = new JMenuItem();
						menuItemDescendente.add(itemDescXExtencion);
						itemDescXExtencion.setText("Por extención");
						itemDescXExtencion.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(listaSeleccionada==1){
									ordenarTablaIzq(false, 1, "");
								}
								if(listaSeleccionada==2){
									ordenarTablaDer(false, 1, "");
								}
							}
							});
					}
					{
						itemDescXTamanio = new JMenuItem();
						menuItemDescendente.add(itemDescXTamanio);
						itemDescXTamanio.setText("Por tamaño");
						itemDescXTamanio.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(listaSeleccionada==1){
									ordenarTablaIzq(false, 2, textVentana1.getText());
								}
								if(listaSeleccionada==2){
									ordenarTablaDer(false, 2, textVentana2.getText());
								}
							}
							});
					}
					{
						itemDescXFecha = new JMenuItem();
						menuItemDescendente.add(itemDescXFecha);
						itemDescXFecha.setText("Por fecha");
						itemDescXFecha.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								if(listaSeleccionada==1){
									ordenarTablaIzq(false, 3, textVentana1.getText());
								}
								if(listaSeleccionada==2){
									ordenarTablaDer(false, 3, textVentana2.getText());
								}
							}
						});
					}
				}
			}
		}
		{
			menuAyuda = new JMenu();
			barraMenu.add(menuAyuda);
			menuAyuda.setText("Ayuda");
			{
				menuItemAcerca = new JMenuItem();
				menuAyuda.add(menuItemAcerca);
				menuItemAcerca.setText("Acerca de....");
				menuItemAcerca.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/AcercaDe.png")));
				menuItemAcerca.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						final DialogAcercaDe ventanita = new interfaz.DialogAcercaDe();
					}
				});
			}
		}			
	}
	}


	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}




	/**
	 * Actualiza los elementos a mostrar del lado izquierdo, como la tabla con 
	 * directorios y archivos y la cantidad de elementos,
	 * dependiendo de la ruta que se encuentra en el campo de texto izquierdo.
	 * @param ruta Es la ruta completa a actualizar.
	 */
	private void actualizarRuta1(String ruta){
		Ruta r = new Ruta(ruta);
		pestaniaIzq.setTitleAt(0, r.getDirActual());
		textVentana1.setText(ruta);
		if (textVentana1.getText().equals(String.valueOf(comboUnidades1.getSelectedItem().toString())))
			{botonArriba1.setEnabled(false);}		//Si se está en la raíz de una unidad no se puede ir al directorio padre.
		else {botonArriba1.setEnabled(true);}
		listaDirectorios(tablaIzq, r);
	}

	/**
	 * Actualiza los elementos a mostrar del lado derecho, como la tabla con 
	 * directorios y archivos y la cantidad de elementos,
	 * dependiendo de la ruta que se encuentra en el campo de texto derecho.
	 * @param ruta Es la ruta completa a actualizar.
	 */
	private void actualizarRuta2(String ruta){
		Ruta r = new Ruta(ruta);
		pestaniaDer.setTitleAt(0, r.getDirActual());
		textVentana2.setText(ruta);
		if (textVentana2.getText().equals(String.valueOf(comboUnidades2.getSelectedItem())))
			{botonArriba2.setEnabled(false);}
		else {botonArriba2.setEnabled(true);}
		listaDirectorios(tablaDer,r);
	}
	
	/**
	 * Carga la lista de directorios y archivos en la tabla y actualiza la cantidad de elementos.
	 * @param act es la referencia a la tabla seleccionada actualmente.
	 * @param lugar Es el nuevo directorio seleccionado.
	 */
	private void listaDirectorios(Tabla act, Ruta lugar) {
		try {
		act.asociarModeloConRuta(lugar);
		int elementos = act.getRowCount();
		if (listaSeleccionada == 0)
			{datos1.setText(String.valueOf(elementos) + " elemento(s)");
			 datos2.setText(String.valueOf(elementos) + " elemento(s)");}
		if (listaSeleccionada == 1)
			{datos1.setText(String.valueOf(elementos) + " elemento(s)");}
		if (listaSeleccionada == 2)
			{datos2.setText(String.valueOf(elementos) + " elemento(s)");}
		}
		catch(IOException ex){
			JOptionPane.showMessageDialog(new JInternalFrame(), "Error al cargar la lista de archivos");
		}
	}

	/**
	 * Actualiza la etiqueta del tamaño a partir de la fila inferior a la actual.
	 */
	private void ActualizarLabelTamanioAbajo(){
		if (listaSeleccionada == 1){
			String archivo = (String)tablaIzq.getValueAt(tablaIzq.getSelectedRow()+1, 0);
			if (!archivo.endsWith(" ]")){		//Si no es carpeta
				labelTamanio1.setText("Tamaño: " + tablaIzq.getValueAt(tablaIzq.getSelectedRow()+1, 2));}
			else {labelTamanio1.setText("");}
			}
		else {
			  String archivo = (String)tablaDer.getValueAt(tablaDer.getSelectedRow()+1, 0);
			  if (!archivo.endsWith(" ]")){
				 labelTamanio2.setText("Tamaño: " + tablaDer.getValueAt(tablaDer.getSelectedRow()+1, 2));}
			  else {labelTamanio2.setText("");}
			}
	}

	/**
	 * Actualiza la etiqueta del tamaño a partir de la fila superior a la actual.
	 */
	private void ActualizarLabelTamanioArriba(){
		if (listaSeleccionada == 1){
			String archivo = (String)tablaIzq.getValueAt(tablaIzq.getSelectedRow()-1, 0);
			if (!archivo.endsWith(" ]")){		//Si no es carpeta
				labelTamanio1.setText("Tamaño: " + tablaIzq.getValueAt(tablaIzq.getSelectedRow()-1, 2));}
			else {labelTamanio1.setText("");}
			}
		else {
			  String archivo = (String)tablaDer.getValueAt(tablaDer.getSelectedRow()-1, 0);
			  if (!archivo.endsWith(" ]")){
				 labelTamanio2.setText("Tamaño: " + tablaDer.getValueAt(tablaDer.getSelectedRow()-1, 2));}
			  else {labelTamanio2.setText("");}
			}
	}

	/**
	 * Actualiza la etiqueta del tamaño a partir de la fila actual
	 */
	private void ActualizarLabelTamanio(){
		if (listaSeleccionada == 1){
			String archivo = (String)tablaIzq.getValueAt(tablaIzq.getSelectedRow(), 0);
			if (!archivo.endsWith(" ]")){		//Si no es carpeta
				labelTamanio1.setText("Tamaño: " + tablaIzq.getValueAt(tablaIzq.getSelectedRow(), 2));}
			else {labelTamanio1.setText("");}
			}
		else {
			  String archivo = (String)tablaDer.getValueAt(tablaDer.getSelectedRow(), 0);
			  if (!archivo.endsWith(" ]")){
				 labelTamanio2.setText("Tamaño: " + tablaDer.getValueAt(tablaDer.getSelectedRow(), 2));}
			  else {labelTamanio2.setText("");}
			}
	}

	/**
	 * Registra la cantidad de clicks que se hacen y actua en consecuencia.
	 */
	private void Click(MouseEvent evt) {
		if (evt.getClickCount() >= 2){
			entrar();
			}
		else 		//Se seleccionó un archivo
			{ActualizarLabelTamanio();}
	}

	/**
	 * Selecciona el primer item de la tabla seleccionada actualmente.
	 */
	private void seleccionarPrimerItem(){
		if (listaSeleccionada == 1){
			if (tablaIzq.getRowCount()>0){
				tablaIzq.addRowSelectionInterval(0, 0);
			}
		}
		if (listaSeleccionada == 2){
			if (tablaDer.getRowCount()>0){
				tablaDer.addRowSelectionInterval(0, 0);
			}
		}
	}

	/**
	 * Abre un archivo con el programa predefinido o entra en una carpeta
	 * dependiendo del elemento seleccionado.
	 */
	private void entrar(){
		int fila;
		if (listaSeleccionada == 1){
			fila = tablaIzq.getSelectedRow();
			String seleccion = (String)tablaIzq.getValueAt(fila, 0);
			tablaIzq.setColumnSelectionAllowed(false);
			if (seleccion.endsWith(" ]")){
				seleccion = seleccion.substring(2, seleccion.length()-2);
				actualizarRuta1(textVentana1.getText()+seleccion+File.separator);
				seleccionarPrimerItem();
			}else
			{
				try{
					MDA.Abrir(new Ruta(textVentana1.getText()+seleccion));
				}
				catch(IOException ex){
					JOptionPane.showMessageDialog(new JInternalFrame(), "Error al abrir el achivo");
				}
			}
		}
		else{
			if (listaSeleccionada == 2){
				fila = tablaDer.getSelectedRow();
				String seleccion = (String)tablaDer.getValueAt(fila, 0);
				if (seleccion.endsWith(" ]")){
					seleccion = seleccion.substring(2, seleccion.length()-2);
					actualizarRuta2(textVentana2.getText()+seleccion+File.separator);
					seleccionarPrimerItem();
				}
				else
				{
					try{
					MDA.Abrir(new Ruta(textVentana2.getText()+seleccion));
					}
					catch(IOException ex){
						JOptionPane.showMessageDialog(new JInternalFrame(), "Error al abrir el archivo");
					}
				}
			}
		}
	}

	/**
	 * Hace visible u oculta a la barra de estado.
	 */
	private void menuItemVerBarraEstActionPerformed(ActionEvent evt) {
		if (menuItemVerBarraEst.isSelected())
			{barraDeEstado.setVisible(true);}
		else {barraDeEstado.setVisible(false);}
	}

	/**
	 * Accion del boton "Arriba" izquierdo.
	 * Vuelve a la carpeta padre de la actual en la tabla izquierda.
	 */
	private void botonArriba1ActionPerformed(ActionEvent evt) {
		labelTamanio1.setText("");
		Ruta r = new Ruta(textVentana1.getText());
		actualizarRuta1(r.getPathDeCarpeta());
		seleccionarPrimerItem();
	}

	/**
	 * Accion del boton "Arriba" derecho.
	 * Vuelve a la carpeta padre de la actual en la tabla derecha.
	 */
	private void botonArriba2ActionPerformed(ActionEvent evt) {		
		labelTamanio2.setText("");
		Ruta r = new Ruta(textVentana2.getText());
		actualizarRuta2(r.getPathDeCarpeta());
		seleccionarPrimerItem();
	}

	/**
	 * Capta distintos eventos de teclado (ENTER, BackSpace, Up y Down).
	 * @param evt Evento del teclado.
	 */
	private void teclaApretada(KeyEvent evt) {		
		int tecla =	evt.getKeyCode();
		int seleccion;
		switch (tecla) {
	      case 10: 		//Si se apretó "ENTER"
	    	  		entrar();
	    	  		
	    	  	break;
	      case 8:		//Si se apretó "BackSpace"
			  		if (listaSeleccionada == 1){
			  			labelTamanio1.setText("");
			  			Ruta r = new Ruta(textVentana1.getText());
			  			actualizarRuta1(r.getPathDeCarpeta());
			  			seleccionarPrimerItem();}
			  		else 		//listaSeleccionada es igual a 2
			  			{labelTamanio2.setText("");
			  			Ruta r = new Ruta(textVentana2.getText());
			  			actualizarRuta2(r.getPathDeCarpeta());
			  			seleccionarPrimerItem();
						}			  		
			  break;
	      case 38: 		//Si se apretó "Up"
	    	  		if (listaSeleccionada == 1){
	    	 		seleccion = tablaIzq.getSelectedRow();
	    	 			if (seleccion>0){
	    	 				ActualizarLabelTamanioArriba();
	    	 			};
	    	  		}
	    	  		if (listaSeleccionada == 2){
		    	 		seleccion = tablaDer.getSelectedRow();
		    	 			if (seleccion>0){
		    	 				ActualizarLabelTamanioArriba();
		    	 			};
		    	  	}
 	    	  break;
	      case 40: 		//Si se apretó "Down"
	    	  		if (listaSeleccionada == 1){
	    	  			seleccion = tablaIzq.getSelectedRow();
	    	  			if (seleccion<tablaIzq.getRowCount()-1){
	    	  				ActualizarLabelTamanioAbajo();
	    	  			};
	    	  		}
	    	  		if (listaSeleccionada == 2){
	    	  			seleccion = tablaDer.getSelectedRow();
	    	  			if (seleccion<tablaDer.getRowCount()-1){
	    	  				ActualizarLabelTamanioAbajo();
	    	  			};
	    	  		}
			  break;
	      case 35: 	//Si se apretó "Fin"
	    	  		if (listaSeleccionada == 1){
	    	  			seleccion = tablaIzq.getRowCount();
	    	  			if (seleccion > 0){
	    	  				tablaIzq.setRowSelectionInterval(seleccion-1, seleccion-1);
	    	  				ActualizarLabelTamanio();
	    	  			}
	    	  		}
	    	  		if (listaSeleccionada == 2){
	    	  			seleccion = tablaDer.getRowCount();
	    	  			if (seleccion > 0){
	    	  				tablaDer.setRowSelectionInterval(seleccion-1, seleccion-1);
	    	  				ActualizarLabelTamanio();
	    	  			}
	    	  		}
	    	  break;
	      case 36: 	//Si se apretó "Inicio"
  	  		if (listaSeleccionada == 1){
  	  			seleccion = tablaIzq.getRowCount();
  	  			if (seleccion > 0){
  	  				tablaIzq.setRowSelectionInterval(0, 0);
  	  				ActualizarLabelTamanio();
  	  			}
  	  		}
  	  		if (listaSeleccionada == 2){
  	  			seleccion = tablaDer.getRowCount();
  	  			if (seleccion > 0){
  	  				tablaDer.setRowSelectionInterval(0, 0);
  	  				ActualizarLabelTamanio();
  	  			}
  	  		}
  	  break;
	    }  
	}

	/**
	 * Busca los items seleccionados de la lista que está seleccionada.
	 * @return Un Vector<Ruta> dónde se almacenan las rutas completas
	 * de los archivos y carpetas seleccionados.
	 */
	private Vector<Ruta> buscarSeleccionados (){
		int selecciones[];
		String seleccion;
		Vector<Ruta> dirs = new Vector<Ruta>(5,2);
		if (listaSeleccionada == 1){
			selecciones = tablaIzq.getSelectedRows();
			int i = 0;		
			while (i < selecciones.length){
				seleccion = (String) tablaIzq.getValueAt(selecciones[i], 0);
				if (seleccion.endsWith(" ]")){
					seleccion = seleccion.substring(2, seleccion.length()-2);
				}
				Ruta rutaDeCopia = new Ruta(textVentana1.getText()+seleccion);
				dirs.add(rutaDeCopia);
				i++;
			}
		}
		else {
			if (listaSeleccionada == 2){
				selecciones = tablaDer.getSelectedRows();
				int i=0;
				while (i < selecciones.length){
					seleccion = (String)tablaDer.getValueAt(selecciones[i], 0);
					if (seleccion.endsWith(" ]")){
						seleccion = seleccion.substring(2, seleccion.length()-2);
					}
					Ruta rutaDeCopia = new Ruta(textVentana2.getText()+seleccion);
					dirs.add(rutaDeCopia);
					i++;
				}
			}
		}
		return (dirs);
	}

	/**
	 * Se fija cuál es la lista seleccionada y la ruta destino para luego llamar
	 * al procedimiento Pegar de la clase Archivos.
	 * 
	 */
	private void operacionPegar (){
		Ruta rutaDestino = new Ruta();
		if (listaSeleccionada == 1){
			rutaDestino.setPath(textVentana1.getText());
			vEspera.Mostrar('v');
			try{
				MDA.Pegar(rutaDestino);
				actualizarRuta1(textVentana1.getText());
				actualizarRuta2(textVentana2.getText());
			}
			catch (IOException ex) {
				JOptionPane.showMessageDialog(new JInternalFrame(), "Se ha producido un error al mover o copiar");
			}
			catch(SecurityException ex){
				JOptionPane.showMessageDialog(new JInternalFrame(), "No se tienen permisos para mover");
			}
			catch(multipleExcepcion m_ex){
				JOptionPane.showMessageDialog(new JInternalFrame(), m_ex.getMessage());
			}
			finally{
				vEspera.Ocultar();
			}
		}
		else {
				if (listaSeleccionada == 2){
					rutaDestino.setPath(textVentana2.getText());
					vEspera.Mostrar('v');
					try{
						MDA.Pegar(rutaDestino);
						actualizarRuta1(textVentana1.getText());
						actualizarRuta2(textVentana2.getText());
					}
					catch (IOException ex) {
						JOptionPane.showMessageDialog(new JInternalFrame(), "Se ha producido un error al mover o copiar");
					}
					catch(SecurityException ex){
						JOptionPane.showMessageDialog(new JInternalFrame(), "No se tienen permisos para mover");
					}
					catch(multipleExcepcion m_ex){
						JOptionPane.showMessageDialog(new JInternalFrame(), m_ex.getMessage());
					}
					finally{
						vEspera.Ocultar();
					}
				}
		}
	}

	/**
	 * Sirve para mover uno o varios archivos o carpetas de la lista derecha
	 * a la lista izquierda.
	 * 
	 */
	private void operacionMoverAIzq(){
		listaSeleccionada = 2;
		vEspera.Mostrar('m');
		try{
			MDA.Mover(buscarSeleccionados(), new Ruta(textVentana1.getText()));
			actualizarRuta1(textVentana1.getText());
			actualizarRuta2(textVentana2.getText());
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(new JInternalFrame(), "Se ha producido un error al mover");
		}
		catch(SecurityException ex){
			JOptionPane.showMessageDialog(new JInternalFrame(), "No se tienen permisos para mover archivo");
		}
		finally{
			vEspera.Ocultar();
		}
	}

	/**
	 * Sirve para mover uno o varios archivos o carpetas de la lista izquierda
	 * a la lista derecha.
	 * 
	 */
	private void operacionMoverADer(){
		listaSeleccionada = 1;
		vEspera.Mostrar('m');
		try{
			MDA.Mover(buscarSeleccionados(), new Ruta(textVentana2.getText()));
			actualizarRuta1(textVentana1.getText());
			actualizarRuta2(textVentana2.getText());
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(new JInternalFrame(), "Se ha producido un error al mover");
		}
		catch(SecurityException ex){
			JOptionPane.showMessageDialog(new JInternalFrame(), "No se tienen permisos para mover archivo");
		}
		finally{
			vEspera.Ocultar();
		}
	}

	/**
	 * Se fija cuál es la lista seleccionda y el archivo seleccionado
	 * para luego mostrar la ventana Renombrar que permitirá cambiar el nombre.
	 *
	 */
	private void operacionCambiarNombre (){
		if (listaSeleccionada == 1){
			int seleccion = tablaIzq.getSelectedRow();
			String archivo=(String)tablaIzq.getValueAt(seleccion, 0);
			if (archivo.endsWith(" ]")){
				archivo = archivo.substring(2, archivo.length()-2);
			}
			vRenom.Mostrar(new Ruta(textVentana1.getText()), archivo);
		}
		else {
			if (listaSeleccionada == 2){
				int seleccion = tablaDer.getSelectedRow();
				String archivo = (String)tablaDer.getValueAt(seleccion, 0);
				if (archivo.endsWith(" ]")){
					archivo = archivo.substring(2, archivo.length()-2);
				}
				vRenom.Mostrar(new Ruta(textVentana2.getText()), archivo);
			}
		}
	}

	/**
	 * Obtiene los elementos seleccionados para luego eliminarlos
	 *
	 */
	private void operacionEliminar (){			
		vEspera.Mostrar('d');
		try{
			MDA.EliminarVarios(buscarSeleccionados());
			actualizarRuta1(textVentana1.getText());
			actualizarRuta2(textVentana2.getText());
		}
		catch(SecurityException ex){
			JOptionPane.showMessageDialog(new JInternalFrame(), "No se tienen permisos para eliminar este archivo");
		}
		finally{
			vEspera.Ocultar();
		}
	}

	/**
	 * Se fija cuál es la lista seleccionda y si el item selecciondo
	 * es un archivo o una carpeta para luego mostra la ventana Propiedades
	 * y pasarle el archivo o la carpeta seleccionada.
	 *
	 */
	private void mostrarPropiedades (){
		String seleccion;
		Ruta rutaProp;
		if ((listaSeleccionada == 1) && (tablaIzq.getRowCount()>0)){
			seleccion = (String)tablaIzq.getValueAt(tablaIzq.getSelectedRow(), 0);
			if (seleccion.endsWith(" ]")){			//Si es carpeta se sacan los corchetes
				seleccion = seleccion.substring(2, seleccion.length()-2);
				rutaProp = new Ruta(textVentana1.getText()+seleccion);
				try {
					dialogProp.mostrarInfoCarpeta(rutaProp);
				}
				catch (IOException ex){
					JOptionPane.showMessageDialog(new JInternalFrame(), "No se encontró el elemento seleccionado");
					actualizarRuta1(textVentana1.getText());
				}
			}
			else {
				 rutaProp = new Ruta(textVentana1.getText()+seleccion);
				 try {
					 dialogProp.mostrarInfoArchivo(rutaProp);
				 }
				catch (IOException ex){
					JOptionPane.showMessageDialog(new JInternalFrame(), "No se encontró el elemento seleccionado");
					actualizarRuta1(textVentana1.getText());
				}
			}
		}
		if ((listaSeleccionada == 2)&&(tablaDer.getRowCount()>0)){
			seleccion = (String)tablaDer.getValueAt(tablaDer.getSelectedRow(), 0);
			if (seleccion.endsWith(" ]")){			//Si es carpeta se sacan los corchetes
				seleccion = seleccion.substring(2, seleccion.length()-2);
				rutaProp = new Ruta(textVentana2.getText()+seleccion);
				try {
					dialogProp.mostrarInfoCarpeta(rutaProp);
				}
				catch (IOException ex){
					JOptionPane.showMessageDialog(new JInternalFrame(), "No se encontró el elemento seleccionado");
					actualizarRuta2(textVentana2.getText());
				}
			}
			else {
				 rutaProp = new Ruta(textVentana2.getText()+seleccion);
				 try {
					 dialogProp.mostrarInfoArchivo(rutaProp);
				 }
				catch (IOException ex){
					JOptionPane.showMessageDialog(new JInternalFrame(), "No se encontró el elemento seleccionado");
					actualizarRuta2(textVentana2.getText());
				}
			}	
		}
	}

	/**
	 * Permite seleccionar todos los items de la tabla seleccionada actual.
	 *
	 */
	private void SeleccionarTodo(){
		if ((listaSeleccionada == 1) && (tablaIzq.getRowCount() > 0)){
			tablaIzq.setRowSelectionInterval(0,tablaIzq.getRowCount()-1);
		}
		if ((listaSeleccionada == 2) && (tablaIzq.getRowCount() > 0)){
			tablaDer.setRowSelectionInterval(0,tablaDer.getRowCount()-1);
		}
	}

	/**
	 * Se encarga de ordenar la tabla izquierda.
	 * Para eso recibe distintos parámetros desde el menú ordenar o desde los comboBox ordenar
	 * para luego llamar al método ordenar que se encuentra en la clase Tabla.
	 * En el caso de haber una excepción, actualiza la tabla izquierda
	 * por si hubo modificaciones desde afuera, y luego vuelve a reintentar.
	 * @param ascendente Indica si se ordenará de forma ascendente o descendente.
	 * @param columna Es la columna por la cuál se ordenará.
	 * @param directorio Es el directorio padre de los elementos a ordenar.
	 */
	private void ordenarTablaIzq (boolean ascendente, int columna, String directorio){
		try {
			tablaIzq.ordenarPor(ascendente, columna, directorio);
		}
		catch (IOException ex){
			try {
				actualizarRuta1(textVentana1.getText());
				tablaIzq.ordenarPor(ascendente, columna, directorio);
			}
			catch (IOException ex2){
				JOptionPane.showMessageDialog(new JInternalFrame(), "Error al ordenar la tabla izquierda");
			}
		}
	}

	/**
	 * Se encarga de ordenar la tabla derecha.
	 * Para eso recibe distintos parámetros desde el menú ordenar o desde los comboBox ordenar
	 * para luego llamar al método ordenar que se encuentra en la clase Tabla.
	 * En el caso de haber una excepción, actualiza la tabla derecha
	 * por si hubo modificaciones desde afuera, y luego vuelve a reintentar.
	 * @param ascendente Indica si se ordenará de forma ascendente o descendente.
	 * @param columna Es la columna por la cuál se ordenará.
	 * @param directorio Es el directorio padre de los elementos a ordenar.
	 */
	private void ordenarTablaDer (boolean ascendente, int columna, String directorio){
		try {
			tablaDer.ordenarPor(ascendente, columna, directorio);
		}
		catch (IOException ex){
			try {
				actualizarRuta2(textVentana2.getText());
				tablaDer.ordenarPor(ascendente, columna, directorio);
			}
			catch (IOException ex2){
				JOptionPane.showMessageDialog(new JInternalFrame(), "Error al ordenar la tabla derecha");
			}
		}
	}


}