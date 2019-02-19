package interfaz;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class VentanaEspera extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel superior;
	private JLabel titulo;
	private JLabel actividad;
	private JLabel esperar;


	/**
	 * Es el constructor de la ventana
	 */
	public VentanaEspera() {
		super();
		initGUI();
	}


	/**
	 * Inicializa la interfaz
	 */
	private void initGUI() {
		try {
			this.setVisible(false);
			this.setTitle("elTotal - Espere..");
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Iconos/Avisos/Icono.png")).getImage());
			getContentPane().setLayout(null);
			this.setResizable(false);
			{
				superior = new JPanel();
				superior.setLayout(null);
				getContentPane().add(superior);
				superior.setPreferredSize(new java.awt.Dimension(399, 49));
				superior.setBorder(BorderFactory.createTitledBorder(""));
				superior.setBounds(0, 0, 399, 49);
				{
					esperar = new JLabel();
					superior.add(esperar);
					esperar.setText("Espere por favor...");
					esperar.setPreferredSize(new java.awt.Dimension(161, 28));
					esperar.setBounds(7, 21, 161, 28);
				}
				{
					titulo = new JLabel();
					superior.add(titulo);
					titulo.setText("La operacion solicitada se esta llevando a cabo");
					titulo.setPreferredSize(new java.awt.Dimension(315, 28));
					titulo.setBounds(7, 0, 315, 28);
				}
				{
					actividad = new JLabel();
					superior.add(actividad);
					actividad.setPreferredSize(new java.awt.Dimension(217, 28));
					actividad.setBounds(119, 21, 217, 28);
				}
			}
			pack();
			this.setSize(407, 81);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Hace visible a la ventana y coloca una etiqueta 
	 * dependiendo del caracter ingersado:
	 * v para Pegar, d para Eliminar y m para Mover.
	 * @param accion El caracter que cambia a la etiqueta de la ventana
	 */
	public void Mostrar(char accion){
		switch (accion){
		case 'v': actividad.setText("Pegando");
		break;
		case 'd': actividad.setText("Eliminado");
		break;
		case 'm': actividad.setText("Moviendo");
		break;
		}
		this.setVisible(true);
	}

	/**
	 * Oculta la ventana
	 */
	public void Ocultar(){
		this.setVisible(false);
	}


}

	
	

