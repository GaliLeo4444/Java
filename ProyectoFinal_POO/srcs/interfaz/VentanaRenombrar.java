package interfaz;


import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import implementacion.*;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import implementacion.ManejadorDeArchivos;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import java.io.*;


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
public class VentanaRenombrar extends javax.swing.JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel inferior;
	private JPanel superior;
	private JLabel titulo;
	private JTextField textNuevoNombre;
	private JLabel nombreNuevo;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private Ruta lugar;
	private String NombreArch;
	private ManejadorDeArchivos MDA; 


	/**
	* Es el constructor de la ventana
	*/
	public VentanaRenombrar() {
		super();
		initGUI(); 
		MDA = new ManejadorDeArchivos();
	}

	
	private void initGUI() {
		try {
			this.setTitle("elTotal - Cambiar Nombre");
			setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Botones/CambiarNombre.png")).getImage());
			this.setResizable(false);
			{
				superior = new JPanel();
				FlowLayout superiorLayout = new FlowLayout();
				superior.setLayout(superiorLayout);
				getContentPane().add(superior, new AnchorConstraint(3, 1001, 392, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				superior.setPreferredSize(new java.awt.Dimension(399, 49));
				superior.setBorder(BorderFactory.createTitledBorder(""));
				{
					titulo = new JLabel();
					superior.add(titulo);
					titulo.setText("CAMBIAR NOMBRE");
					titulo.setPreferredSize(new java.awt.Dimension(140, 28));
					titulo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Menu/CambiarNombre.png")));
				}
			}
			{
				inferior = new JPanel();
				AnchorLayout inferiorLayout = new AnchorLayout();
				inferior.setLayout(inferiorLayout);
				getContentPane().add(inferior, new AnchorConstraint(392, 1001, 1003, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				inferior.setPreferredSize(new java.awt.Dimension(399, 77));
				inferior.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				{
					textNuevoNombre = new JTextField();
					inferior.add(textNuevoNombre, new AnchorConstraint(159, 983, 467, 159, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					textNuevoNombre.setPreferredSize(new java.awt.Dimension(329, 28));
				}
				{
					nombreNuevo = new JLabel();
					inferior.add(nombreNuevo, new AnchorConstraint(159, 369, 467, 18, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					nombreNuevo.setText("Nombre:");
					nombreNuevo.setPreferredSize(new java.awt.Dimension(140, 28));
				}
				{
					btnAceptar = new JButton();
					inferior.add(btnAceptar, new AnchorConstraint(559, 667, 927, 387, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnAceptar.setText("Aceptar");
					btnAceptar.setPreferredSize(new java.awt.Dimension(112, 28));
					btnAceptar.addActionListener(new ActionListener()
					{	
						public void actionPerformed(ActionEvent e)
			            {	
							try{
							MDA.RenombrarArchivo(lugar,NombreArch, textNuevoNombre.getText());
							}
							catch(IOException ex){
								JOptionPane.showMessageDialog(new JInternalFrame(), "Se ha producido un error al renombrar");
							}
							catch (multipleExcepcion ex) {
								JOptionPane.showMessageDialog(new JInternalFrame(), ex.getMessage());
							}
							Ocultar();
			            }
					});
				}
				{
					btnCancelar = new JButton();
					inferior.add(btnCancelar, new AnchorConstraint(559, 983, 927, 685, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					btnCancelar.setText("Cancelar");
					btnCancelar.setPreferredSize(new java.awt.Dimension(119, 28));
					btnCancelar.addActionListener(new ActionListener()
					{	
						public void actionPerformed(ActionEvent e)
			            {	
							 Ocultar();
			            }
					});
				}
			}
			pack();
			this.setSize(407, 158);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Muestra la ventana, registra la ruta actual y coloca en el lugar del nombre 
	 * el nombre actual del archivo.
	 */
	public void Mostrar(Ruta r, String na){
		lugar = r;
		NombreArch = new String(na);
		textNuevoNombre.setText(NombreArch);
		this.setVisible(true);
	}

	/**
	 * Oculta la ventana
	 */
	private void Ocultar(){
		this.setVisible(false);
	}


}
