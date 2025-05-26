package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomeCurso;
	private JTextField tfAreaConhecimentoCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setTitle("Processo Seletivo de Docentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 624, 441);
		contentPane.add(tabbedPane);
		
		JPanel TabCurso = new JPanel();
		TabCurso.setToolTipText("Cursos disponíveis");
		tabbedPane.addTab("Cursos", null, TabCurso, null);
		TabCurso.setLayout(null);
		
		JLabel lblNomeCurso = new JLabel("Nome");
		lblNomeCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCurso.setBounds(28, 28, 51, 27);
		TabCurso.add(lblNomeCurso);
		
		JLabel lblCursoAreaConhecimento = new JLabel("Area de Conhecimento");
		lblCursoAreaConhecimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCursoAreaConhecimento.setBounds(28, 75, 145, 17);
		TabCurso.add(lblCursoAreaConhecimento);
		
		tfNomeCurso = new JTextField();
		tfNomeCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeCurso.setBounds(180, 73, 217, 20);
		TabCurso.add(tfNomeCurso);
		tfNomeCurso.setColumns(10);
		
		tfAreaConhecimentoCurso = new JTextField();
		tfAreaConhecimentoCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfAreaConhecimentoCurso.setBounds(84, 31, 217, 20);
		TabCurso.add(tfAreaConhecimentoCurso);
		tfAreaConhecimentoCurso.setColumns(10);
		
		JButton btnCursoNomeBuscar = new JButton("Buscar");
		btnCursoNomeBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCursoNomeBuscar.setBounds(429, 72, 89, 23);
		TabCurso.add(btnCursoNomeBuscar);
		
		JButton btnBuscarAreaConhecimento = new JButton("Bucar");
		btnBuscarAreaConhecimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscarAreaConhecimento.setBounds(339, 31, 89, 23);
		TabCurso.add(btnBuscarAreaConhecimento);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 127, 599, 199);
		TabCurso.add(textArea);
		
		JTabbedPane TabDisciplina = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Discilinas", null, TabDisciplina, "Disciplinas disponíveis");
	}
}
