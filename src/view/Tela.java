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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomeCurso;
	private JTextField tfAreaConhecimentoCurso;
	private JTextField txtInsiraOCodigo;
	private JTextField tfNomeDisciplina;
	private JTextField tfDiaSemanaDisciplina;
	private JTextField tfHoraAulaDisciplina;
	private JTextField tfCpfProfessor;
	private JTextField tfAreaConhecimentoProfessor;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		tfAreaConhecimentoCurso.setBounds(180, 31, 217, 20);
		TabCurso.add(tfAreaConhecimentoCurso);
		tfAreaConhecimentoCurso.setColumns(10);
		
		JButton btnCursoNomeBuscar = new JButton("Buscar");
		btnCursoNomeBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCursoNomeBuscar.setBounds(429, 72, 89, 23);
		TabCurso.add(btnCursoNomeBuscar);
		
		JButton btnBuscarAreaConhecimento = new JButton("Bucar");
		btnBuscarAreaConhecimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarAreaConhecimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscarAreaConhecimento.setBounds(429, 31, 89, 23);
		TabCurso.add(btnBuscarAreaConhecimento);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 127, 599, 199);
		TabCurso.add(textArea);
		
		JPanel TabDisciplina = new JPanel();
		tabbedPane.addTab("Disciplinas", null, TabDisciplina, "Consultar disciplinas");
		TabDisciplina.setLayout(null);
		
		JLabel lblCodDisciplina = new JLabel("Codigo da Disciplina");
		lblCodDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodDisciplina.setBounds(28, 39, 128, 17);
		TabDisciplina.add(lblCodDisciplina);
		
		JLabel lblNomeDisciplina = new JLabel("Disciplina");
		lblNomeDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDisciplina.setBounds(28, 79, 128, 17);
		TabDisciplina.add(lblNomeDisciplina);
		
		JLabel lblDiaDisciplina = new JLabel("Dia da Semana");
		lblDiaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiaDisciplina.setBounds(28, 116, 107, 17);
		TabDisciplina.add(lblDiaDisciplina);
		
		JLabel lblHoraAulaDisciplina = new JLabel("Horário de aula");
		lblHoraAulaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoraAulaDisciplina.setBounds(28, 155, 107, 23);
		TabDisciplina.add(lblHoraAulaDisciplina);
		
		txtInsiraOCodigo = new JTextField();
		txtInsiraOCodigo.setBounds(166, 39, 220, 20);
		TabDisciplina.add(txtInsiraOCodigo);
		txtInsiraOCodigo.setColumns(10);
		
		tfNomeDisciplina = new JTextField();
		tfNomeDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfNomeDisciplina.setBounds(166, 79, 220, 20);
		TabDisciplina.add(tfNomeDisciplina);
		tfNomeDisciplina.setColumns(10);
		
		tfDiaSemanaDisciplina = new JTextField();
		tfDiaSemanaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDiaSemanaDisciplina.setBounds(166, 116, 220, 20);
		TabDisciplina.add(tfDiaSemanaDisciplina);
		tfDiaSemanaDisciplina.setColumns(10);
		
		tfHoraAulaDisciplina = new JTextField();
		tfHoraAulaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfHoraAulaDisciplina.setBounds(166, 158, 220, 20);
		TabDisciplina.add(tfHoraAulaDisciplina);
		tfHoraAulaDisciplina.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(128, 128, 128));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.setBounds(28, 199, 166, 36);
		TabDisciplina.add(btnBuscar);
		
		JTextArea taDisciplinas = new JTextArea();
		taDisciplinas.setBounds(10, 246, 599, 156);
		TabDisciplina.add(taDisciplinas);
		
		JPanel TabProfessor = new JPanel();
		TabProfessor.setToolTipText("Cadastrar professores");
		tabbedPane.addTab("Professores", null, TabProfessor, null);
		TabProfessor.setLayout(null);
		
		JLabel lblCpfProfessor = new JLabel("CPF");
		lblCpfProfessor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpfProfessor.setBounds(26, 42, 56, 19);
		TabProfessor.add(lblCpfProfessor);
		
		tfCpfProfessor = new JTextField();
		tfCpfProfessor.setToolTipText("cpf do professor");
		tfCpfProfessor.setBounds(182, 42, 140, 20);
		TabProfessor.add(tfCpfProfessor);
		tfCpfProfessor.setColumns(10);
		
		JLabel lblAreaConhecimentoProfessor = new JLabel("Area de Conhecimento");
		lblAreaConhecimentoProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAreaConhecimentoProfessor.setBounds(28, 72, 154, 19);
		TabProfessor.add(lblAreaConhecimentoProfessor);
		
		tfAreaConhecimentoProfessor = new JTextField();
		tfAreaConhecimentoProfessor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfAreaConhecimentoProfessor.setBounds(182, 73, 174, 20);
		TabProfessor.add(tfAreaConhecimentoProfessor);
		tfAreaConhecimentoProfessor.setColumns(10);
		
		JLabel lblpontuacaoProfessor = new JLabel("Pontuação");
		lblpontuacaoProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblpontuacaoProfessor.setBounds(26, 111, 147, 19);
		TabProfessor.add(lblpontuacaoProfessor);
		
		textField = new JTextField();
		textField.setBounds(182, 112, 174, 20);
		TabProfessor.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscarProfessor = new JButton("Buscar");
		btnBuscarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscarProfessor.setBounds(32, 165, 89, 23);
		TabProfessor.add(btnBuscarProfessor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.setBounds(182, 164, 121, 25);
		TabProfessor.add(btnCadastrar);
		
		JTextArea taProfessores = new JTextArea();
		taProfessores.setBounds(10, 209, 599, 193);
		TabProfessor.add(taProfessores);
		
		JPanel TabInscricao = new JPanel();
		tabbedPane.addTab("Inscrição", null, TabInscricao, null);
		TabInscricao.setLayout(null);
		
		JLabel lblCodProcessoInscricao = new JLabel("Processo");
		lblCodProcessoInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcessoInscricao.setBounds(28, 44, 69, 17);
		TabInscricao.add(lblCodProcessoInscricao);
		
		JLabel lblCpfInscricao = new JLabel("Cpf Candidato");
		lblCpfInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpfInscricao.setBounds(28, 84, 99, 17);
		TabInscricao.add(lblCpfInscricao);
		
		JLabel lblDiscilinaInscricao = new JLabel("Disciplina");
		lblDiscilinaInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiscilinaInscricao.setBounds(28, 126, 83, 17);
		TabInscricao.add(lblDiscilinaInscricao);
		
		JLabel lblAreaAplicacaoInscricao = new JLabel("Area de Aplicação");
		lblAreaAplicacaoInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAreaAplicacaoInscricao.setBounds(27, 167, 113, 17);
		TabInscricao.add(lblAreaAplicacaoInscricao);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 44, 163, 20);
		TabInscricao.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 84, 163, 20);
		TabInscricao.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(150, 126, 163, 20);
		TabInscricao.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(150, 167, 163, 20);
		TabInscricao.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(28, 206, 99, 27);
		TabInscricao.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(146, 207, 113, 26);
		TabInscricao.add(btnNewButton_1);
		
		JTextArea taInscricoes = new JTextArea();
		taInscricoes.setBounds(10, 254, 599, 128);
		TabInscricao.add(taInscricoes);
	}
}
