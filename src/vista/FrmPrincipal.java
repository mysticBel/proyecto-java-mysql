package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;

public class FrmPrincipal extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenu mnSistema;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenu mnReportes;
	private JMenuItem mntmClientesReporte;
	private JMenuItem mntmVentasReporte;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProductos;
	private JDesktopPane escritorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		// jtatoo
		try {
			// seleccionar el tipo de modelo de look and feel
			UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 399);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSistema = new JMenu("Sistema");
		mnSistema.setMnemonic('S');
		mnSistema.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/computer.png")));
		menuBar.add(mnSistema);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_DOWN_MASK));
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/exit.png")));
		mnSistema.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setMnemonic('M');
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/maintenance.png")));
		menuBar.add(mnMantenimiento);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/clients.png")));
		mnMantenimiento.add(mntmClientes);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mntmProductos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/products.png")));
		mnMantenimiento.add(mntmProductos);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setMnemonic('R');
		mnReportes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/print.png")));
		menuBar.add(mnReportes);
		
		mntmClientesReporte = new JMenuItem("Clientes");
		mntmClientesReporte.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/report.png")));
		mnReportes.add(mntmClientesReporte);
		
		mntmVentasReporte = new JMenuItem("Ventas");
		mntmVentasReporte.addActionListener(this);
		mntmVentasReporte.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
		mntmVentasReporte.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/sales.png")));
		mnReportes.add(mntmVentasReporte);
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(SystemColor.activeCaption);
		getContentPane().add(escritorio, BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmVentasReporte) {
			actionPerformedMntmVentasReporte(e);
		}
		if (e.getSource() == mntmProductos) {
			actionPerformedMntmProductos(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		//Para cerrar principal
		System.exit(0);
	}
	protected void actionPerformedMntmProductos(ActionEvent e) {
		FrmRegProd prod =new FrmRegProd();
		prod.setVisible(true);
		escritorio.add(prod);
	}
	protected void actionPerformedMntmVentasReporte(ActionEvent e) {
		FrmRptVtas ven =new FrmRptVtas();
		ven.setVisible(true);
		escritorio.add(ven);
	}
}