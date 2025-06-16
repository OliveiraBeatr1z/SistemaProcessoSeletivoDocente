package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CursoController;
import controller.DisciplinaController;
import controller.InscricaoController;
import controller.ProfessorController;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomeCurso;
	private JTextField tfAreaConhecimentoCurso;
	private JTextField tfCodDisciplina;
	private JTextField tfNomeDisciplina;
	private JTextField tfDiaSemanaDisciplina;
	private JTextField tfHoraAulaDisciplina;
	private JTextField tfCpfProfessor;
	private JTextField tfAreaConhecimentoProfessor;
	private JTextField tfCodProcesso;
	private JTextField tfCpfCandidato;
	private JTextField tfDisciplinaInscricao;
	private JTextField tfCodigoCurso;
	private JTextField tfNomeProfessor;
	private JTextField tfPontuacao;
	private JTextField tfHorasDiariasDisciplina;
	private JTextField tfCodigoCursoDisciplina;

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
		
		JPanel TabDisciplina = new JPanel();
		tabbedPane.addTab("Disciplinas", null, TabDisciplina, "Consultar disciplinas");
		TabDisciplina.setLayout(null);
		
		JLabel lblCodDisciplina = new JLabel("Codigo da Disciplina");
		lblCodDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodDisciplina.setBounds(28, 11, 128, 17);
		TabDisciplina.add(lblCodDisciplina);
		
		JLabel lblNomeDisciplina = new JLabel("Disciplina");
		lblNomeDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDisciplina.setBounds(28, 49, 128, 17);
		TabDisciplina.add(lblNomeDisciplina);
		
		JLabel lblDiaDisciplina = new JLabel("Dia da Semana");
		lblDiaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiaDisciplina.setBounds(28, 84, 107, 17);
		TabDisciplina.add(lblDiaDisciplina);
		
		JLabel lblHoraAulaDisciplina = new JLabel("Horário de aula");
		lblHoraAulaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoraAulaDisciplina.setBounds(28, 122, 107, 23);
		TabDisciplina.add(lblHoraAulaDisciplina);
		
		tfCodDisciplina = new JTextField();
		tfCodDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodDisciplina.setBounds(166, 11, 220, 20);
		TabDisciplina.add(tfCodDisciplina);
		tfCodDisciplina.setColumns(10);
		
		tfNomeDisciplina = new JTextField();
		tfNomeDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeDisciplina.setBounds(166, 48, 220, 20);
		TabDisciplina.add(tfNomeDisciplina);
		tfNomeDisciplina.setColumns(10);
		
		tfDiaSemanaDisciplina = new JTextField();
		tfDiaSemanaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDiaSemanaDisciplina.setBounds(166, 82, 220, 20);
		TabDisciplina.add(tfDiaSemanaDisciplina);
		tfDiaSemanaDisciplina.setColumns(10);
		
		tfHoraAulaDisciplina = new JTextField();
		tfHoraAulaDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfHoraAulaDisciplina.setBounds(166, 124, 220, 20);
		TabDisciplina.add(tfHoraAulaDisciplina);
		tfHoraAulaDisciplina.setColumns(10);
		
		JButton btnBuscarDisciplina = new JButton("Buscar");
		btnBuscarDisciplina.setBackground(new Color(255, 255, 255));
		btnBuscarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarDisciplina.setBounds(420, 11, 166, 36);
		TabDisciplina.add(btnBuscarDisciplina);
		
		JTextArea taDisciplinasLista = new JTextArea();
		taDisciplinasLista.setBounds(10, 246, 599, 156);
		TabDisciplina.add(taDisciplinasLista);
		
		JLabel lblHorasDiariasDisciplina = new JLabel("Horas Diárias");
		lblHorasDiariasDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHorasDiariasDisciplina.setBounds(28, 156, 107, 23);
		TabDisciplina.add(lblHorasDiariasDisciplina);
		
		JLabel lblCodigoCursoDisciplina = new JLabel("Código do Curso");
		lblCodigoCursoDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoCursoDisciplina.setBounds(22, 190, 113, 23);
		TabDisciplina.add(lblCodigoCursoDisciplina);
		
		tfHorasDiariasDisciplina = new JTextField();
		tfHorasDiariasDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfHorasDiariasDisciplina.setBounds(166, 159, 220, 20);
		TabDisciplina.add(tfHorasDiariasDisciplina);
		tfHorasDiariasDisciplina.setColumns(10);
		
		tfCodigoCursoDisciplina = new JTextField();
		tfCodigoCursoDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCodigoCursoDisciplina.setBounds(166, 193, 220, 20);
		TabDisciplina.add(tfCodigoCursoDisciplina);
		tfCodigoCursoDisciplina.setColumns(10);
		
		JButton btnCadastrarDisciplina = new JButton("Cadastrar");
		btnCadastrarDisciplina.setBackground(new Color(255, 255, 255));
		btnCadastrarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarDisciplina.setBounds(420, 61, 166, 36);
		TabDisciplina.add(btnCadastrarDisciplina);
		
		JButton btnAtualizarDisciplina = new JButton("Atualizar");
		btnAtualizarDisciplina.setBackground(new Color(255, 255, 255));
		btnAtualizarDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarDisciplina.setBounds(420, 110, 166, 36);
		TabDisciplina.add(btnAtualizarDisciplina);
		
		JButton btnRemoverDisciplina = new JButton("Deletar");
		btnRemoverDisciplina.setBackground(new Color(255, 255, 255));
		btnRemoverDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoverDisciplina.setBounds(420, 171, 166, 36);
		TabDisciplina.add(btnRemoverDisciplina);
		
		JPanel TabCurso = new JPanel();
		TabCurso.setToolTipText("Cursos disponíveis");
		tabbedPane.addTab("Cursos", null, TabCurso, null);
		TabCurso.setLayout(null);
		
		JLabel lblNomeCurso = new JLabel("Nome");
		lblNomeCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCurso.setBounds(28, 49, 51, 27);
		TabCurso.add(lblNomeCurso);
		
		JLabel lblCursoAreaConhecimento = new JLabel("Area de Conhecimento");
		lblCursoAreaConhecimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCursoAreaConhecimento.setBounds(28, 75, 145, 17);
		TabCurso.add(lblCursoAreaConhecimento);
		
		tfNomeCurso = new JTextField();
		tfNomeCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNomeCurso.setBounds(177, 52, 276, 20);
		TabCurso.add(tfNomeCurso);
		tfNomeCurso.setColumns(10);
		
		tfAreaConhecimentoCurso = new JTextField();
		tfAreaConhecimentoCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfAreaConhecimentoCurso.setBounds(177, 76, 276, 20);
		TabCurso.add(tfAreaConhecimentoCurso);
		tfAreaConhecimentoCurso.setColumns(10);
		
		JButton btnBuscarCurso = new JButton("Buscar");
		btnBuscarCurso.setBackground(new Color(255, 255, 255));
		btnBuscarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarCurso.setBounds(153, 122, 102, 26);
		TabCurso.add(btnBuscarCurso);
		
		JTextArea taCursoLista = new JTextArea();
		taCursoLista.setBounds(10, 188, 599, 199);
		TabCurso.add(taCursoLista);
		
		
		
		JLabel lblCodCurso = new JLabel("Codigo do curso");
		lblCodCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodCurso.setBounds(28, 27, 131, 17);
		TabCurso.add(lblCodCurso);
		
		tfCodigoCurso = new JTextField();
		tfCodigoCurso.setBounds(177, 27, 145, 20);
		TabCurso.add(tfCodigoCurso);
		tfCodigoCurso.setColumns(10);
		
		JButton btnCadastrarCurso = new JButton("Cadastrar");
		btnCadastrarCurso.setBackground(new Color(255, 255, 255));
		btnCadastrarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarCurso.setBounds(28, 122, 99, 27);
		TabCurso.add(btnCadastrarCurso);
		
		JButton btnAtualizarCurso = new JButton("Atualizar");
		btnAtualizarCurso.setBackground(new Color(255, 255, 255));
		btnAtualizarCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarCurso.setBounds(279, 122, 89, 26);
		TabCurso.add(btnAtualizarCurso);
		
		JButton btnRemoverCurso = new JButton("Deletar");
		btnRemoverCurso.setBackground(new Color(255, 255, 255));
		btnRemoverCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoverCurso.setBounds(388, 123, 94, 24);
		TabCurso.add(btnRemoverCurso);
		
		JPanel TabInscricao = new JPanel();
		tabbedPane.addTab("Inscrição", null, TabInscricao, null);
		TabInscricao.setLayout(null);
		
		JLabel lblCodProcessoInscricao = new JLabel("Processo");
		lblCodProcessoInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodProcessoInscricao.setBounds(75, 30, 69, 17);
		TabInscricao.add(lblCodProcessoInscricao);
		
		JLabel lblCpfInscricao = new JLabel("Cpf Candidato");
		lblCpfInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpfInscricao.setBounds(45, 58, 99, 17);
		TabInscricao.add(lblCpfInscricao);
		
		JLabel lblDiscilinaInscricao = new JLabel("Codigo disciplina");
		lblDiscilinaInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiscilinaInscricao.setBounds(31, 96, 113, 17);
		TabInscricao.add(lblDiscilinaInscricao);
		
		JLabel lblPontuacao = new JLabel("Pontuação");
		lblPontuacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPontuacao.setBounds(60, 128, 81, 14);
		TabInscricao.add(lblPontuacao);
		
		tfCodProcesso = new JTextField();
		tfCodProcesso.setBounds(151, 30, 163, 20);
		TabInscricao.add(tfCodProcesso);
		tfCodProcesso.setColumns(10);
		
		tfCpfCandidato = new JTextField();
		tfCpfCandidato.setBounds(151, 58, 163, 20);
		TabInscricao.add(tfCpfCandidato);
		tfCpfCandidato.setColumns(10);
		
		tfDisciplinaInscricao = new JTextField();
		tfDisciplinaInscricao.setBounds(151, 93, 163, 20);
		TabInscricao.add(tfDisciplinaInscricao);
		tfDisciplinaInscricao.setColumns(10);
		
		tfPontuacao = new JTextField();
		tfPontuacao.setBounds(151, 124, 86, 20);
		TabInscricao.add(tfPontuacao);
		tfPontuacao.setColumns(10);
		
		JButton btnBuscarInscricao = new JButton("Buscar");
		btnBuscarInscricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscarInscricao.setBounds(154, 195, 99, 27);
		TabInscricao.add(btnBuscarInscricao);
		
		JButton btnCadastrarInscricao = new JButton("Cadastrar");
		btnCadastrarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrarInscricao.setBounds(16, 195, 113, 26);
		TabInscricao.add(btnCadastrarInscricao);
		
		JButton btnAtualizarInscricao = new JButton("Atualizar");
		btnAtualizarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarInscricao.setBounds(273, 195, 99, 27);
		TabInscricao.add(btnAtualizarInscricao);
		
		JButton btnDeletarInscricao = new JButton("Deletar");
		btnDeletarInscricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletarInscricao.setBounds(390, 195, 99, 27);
		TabInscricao.add(btnDeletarInscricao);
		
		JTextArea taInscricoesLista = new JTextArea();
		taInscricoesLista.setBounds(10, 254, 599, 128);
		TabInscricao.add(taInscricoesLista);
		
		JPanel TabProfessor = new JPanel();
		TabProfessor.setToolTipText("Cadastrar professores");
		tabbedPane.addTab("Professores", null, TabProfessor, null);
		TabProfessor.setLayout(null);
		
		JLabel lblCpfProfessor = new JLabel("CPF");
		lblCpfProfessor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpfProfessor.setBounds(29, 26, 56, 19);
		TabProfessor.add(lblCpfProfessor);
		
		tfCpfProfessor = new JTextField();
		tfCpfProfessor.setToolTipText("cpf do professor");
		tfCpfProfessor.setBounds(193, 26, 174, 20);
		TabProfessor.add(tfCpfProfessor);
		tfCpfProfessor.setColumns(10);
		
		JLabel lblAreaConhecimentoProfessor = new JLabel("Area de Conhecimento");
		lblAreaConhecimentoProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAreaConhecimentoProfessor.setBounds(29, 101, 154, 19);
		TabProfessor.add(lblAreaConhecimentoProfessor);
		
		tfAreaConhecimentoProfessor = new JTextField();
		tfAreaConhecimentoProfessor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfAreaConhecimentoProfessor.setBounds(193, 101, 174, 20);
		TabProfessor.add(tfAreaConhecimentoProfessor);
		tfAreaConhecimentoProfessor.setColumns(10);
		
		JButton btnBuscarProfessor = new JButton("Buscar");
		btnBuscarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscarProfessor.setBounds(171, 173, 99, 27);
		TabProfessor.add(btnBuscarProfessor);
		
		JButton btnCadastrarProfessor = new JButton("Cadastrar");
		btnCadastrarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrarProfessor.setBounds(29, 173, 121, 27);
		TabProfessor.add(btnCadastrarProfessor);
		
		JTextArea taProfessoresLista = new JTextArea();
		taProfessoresLista.setBounds(10, 209, 599, 193);
		TabProfessor.add(taProfessoresLista);
		
		JLabel lblNomeProfessor = new JLabel("Nome");
		lblNomeProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeProfessor.setBounds(29, 66, 56, 14);
		TabProfessor.add(lblNomeProfessor);
		
		tfNomeProfessor = new JTextField();
		tfNomeProfessor.setBounds(192, 65, 175, 20);
		TabProfessor.add(tfNomeProfessor);
		tfNomeProfessor.setColumns(10);
		
		JButton btnAtualizarProfessor = new JButton("Atualizar");
		btnAtualizarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarProfessor.setBounds(288, 173, 99, 27);
		TabProfessor.add(btnAtualizarProfessor);
		
		JButton btnDeletarProfessor = new JButton("Deletar");
		btnDeletarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletarProfessor.setBounds(408, 173, 99, 27);
		TabProfessor.add(btnDeletarProfessor);
		
		// quando clicar no botao vai chamar essa classe. Por essa classe ter o actionListener vai chamar o action  performance. 
				ProfessorController pCont = new ProfessorController(tfCpfProfessor, tfNomeProfessor, tfAreaConhecimentoProfessor, taProfessoresLista );
		btnCadastrarProfessor.addActionListener(pCont);
		btnBuscarProfessor.addActionListener(pCont);
		btnAtualizarProfessor.addActionListener(pCont);
		btnDeletarProfessor.addActionListener(pCont);
		

//		inicialização DisciplinaController e ação dos respectivos botões da tela disciplina
		DisciplinaController dCont = new DisciplinaController(tfCodDisciplina, tfNomeDisciplina, tfDiaSemanaDisciplina, tfHoraAulaDisciplina, tfHorasDiariasDisciplina, taDisciplinasLista);
		btnCadastrarDisciplina.addActionListener(dCont);
		btnBuscarDisciplina.addActionListener(dCont);
		btnAtualizarDisciplina.addActionListener(dCont);
		btnRemoverDisciplina.addActionListener(dCont);
		
		//inicialização CursoController e ação dos respectivos botões da tela curso
		CursoController cCont = new CursoController(tfCodigoCurso, tfNomeCurso, tfAreaConhecimentoCurso, taCursoLista);
		btnCadastrarCurso.addActionListener(cCont);
		btnBuscarCurso.addActionListener(cCont);
		btnAtualizarCurso.addActionListener(cCont);
		btnRemoverCurso.addActionListener(cCont);
		
		//inicialização InscricaoController e ação dos respectivos botões da tela curso
		InscricaoController iCont = new InscricaoController(tfCodProcesso, tfCpfCandidato, tfDisciplinaInscricao, tfPontuacao, taInscricoesLista);
		btnCadastrarInscricao.addActionListener(iCont);
		btnBuscarInscricao.addActionListener(iCont);
		btnAtualizarInscricao.addActionListener(iCont);
		btnDeletarInscricao.addActionListener(iCont);		
		
	}
}
