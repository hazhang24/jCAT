package negocio.ejb.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import negocio.interfaces.Cadastro;
import negocio.interfaces.Pesquisa;
import negocio.vo.CadastroAlunoVO;
import negocio.vo.CadastroAplicadorVO;
import negocio.vo.CadastroClassificacaoVO;
import negocio.vo.CadastroElaboradorVO;
import negocio.vo.CadastroEscolaVO;
import negocio.vo.CadastroInepVO;
import negocio.vo.CadastroSecretariaVO;
import negocio.vo.CadastroTipoUsuarioVO;
import negocio.vo.CadastroTurmaVO;
import negocio.vo.SecretariaListVO;
import negocio.vo.TurmaListVO;
import util.dto.ServiceDTO;
import util.exception.LayerException;
import util.locator.ServiceLocatorException;

public class Client
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ServiceLocatorException,
			LayerException, NamingException, FileNotFoundException, IOException
	{
		Hashtable<String, String> prop = new Hashtable<String, String>();
		prop.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		prop.put(Context.PROVIDER_URL, "jnp://localhost:1099");

		Context ctx = new InitialContext(prop);

		Cadastro cad = (Cadastro) ctx.lookup("CadastroBean/remote");
		Pesquisa pesq = (Pesquisa) ctx.lookup("PesquisaBean/remote");

		ServiceDTO request = new ServiceDTO();

		CadastroClassificacaoVO cl1 = new CadastroClassificacaoVO(
				0,
				1,
				4,
				"Neste n�vel, encontram-se alunos que est�o em um est�gio muito inicial em rela��o � aprendizagem da linguagem escrita. "
						+ "Est�o come�ando a se apropriar das habilidades referentes ao dom�nio das regras que orientam "
						+ "o uso do sistema alfab�tico para ler e escrever. Sabem, por exemplo:\nidentificar o valor sonoro das partes iniciais "
						+ "e/ou finais de palavras (algumas letras ou s�labas), para �adivinhar� e �ler� o restante da palavra;"
						+ "\nidentificar rela��o entre grafemas e fonemas (letra/som) com correspond�ncia sonora �nica ou com mais de uma correspond�ncia sonora;"
						+ "\nreconhecer algumas letras do alfabeto e iniciar a distin��o das letras de desenhos e outros sinais gr�ficos;"
						+ "\nler palavras formadas por s�labas simples (consoante monog�mica + vogal).");
		CadastroClassificacaoVO cl2 = new CadastroClassificacaoVO(
				0,
				2,
				9,
				"Os alunos que se encontram neste n�vel, al�m de j� terem consolidado as habilidades do n�vel anterior, "
						+ "referentes ao conhecimento e uso do sistema de escrita, j� associam adequadamente letras e sons. Embora ainda apresentem "
						+ "algumas dificuldades na leitura de palavras com ortografia mais complexa, neste n�vel, demonstram ser capazes de ler palavras "
						+ "com v�rios tipos de estrutura sil�bica. Eles demonstram habilidades de:\nler algumas palavras compostas por s�labas formadas "
						+ "por consoante/vogal/consoante ou por consoante/consoante/vogal;\nreconhecer letras escritas de diferentes formas;"
						+ "\nidentificar o n�mero de s�labas de uma palavra formada por s�labas simples e com letras com um �nico som;"
						+ "\nreconhecer a finalidade do texto com apoio das caracter�sticas gr�ficas;\nreconhecer o valor sonoro de uma s�laba;"
						+ "\nreconhecer o assunto de g�neros textuais mais pr�prios do contexto escolar com base em suas caracter�sticas gr�ficas.");
		CadastroClassificacaoVO cl3 = new CadastroClassificacaoVO(
				0,
				3,
				15,
				"Neste n�vel, os alunos demonstram que consolidaram a capacidade de ler palavras de diferentes tamanhos "
						+ "e padr�es sil�bicos, conseguem ler frases com sintaxe simples (sujeito + verbo + objeto) e utilizam algumas estrat�gias "
						+ "que permitem ler textos de curta extens�o. As capacidades reveladas neste n�vel s�o:\nler palavras mais complexas, "
						+ "constitu�das por letras que representam mais de um som e por s�labas formadas por d�grafos, encontros consonantais ou "
						+ "encontros voc�licos;\nler frases curtas;\nlocalizar informa��es expl�citas por meio da leitura silenciosa em uma frase ou "
						+ "em textos de aproximadamente cinco linhas;\nreconhecer o assunto do texto com base na leitura de informa��es evidentes no "
						+ "t�tulo;\nidentificar finalidade de g�neros (convite, an�ncio publicit�rio), apoiando-se ou n�o em suas caracter�sticas "
						+ "gr�ficas como imagens e em seu modo de apresenta��o.");
		CadastroClassificacaoVO cl4 = new CadastroClassificacaoVO(
				0,
				4,
				18,
				"Neste n�vel, os alunos leem textos simples e s�o capazes de interpret�-los, localizando informa��es, "
						+ "realizando infer�ncias e reconhecendo o assunto ou a finalidade a partir da leitura aut�noma desses textos. S�o exemplos "
						+ "de habilidades demonstradas pelos alunos deste n�vel:\nlocalizar informa��es expl�citas e evidentes a partir da leitura de "
						+ "textos como bilhetes e convites, sem apoio das caracter�sticas gr�ficas;\ninferir informa��o em textos curtos;\nidentificar "
						+ "finalidade de textos de g�neros diversos, como bilhetes, sum�rio, convite, cartazes;\nreconhecer o assunto de um texto sem apoio "
						+ "das caracter�sticas gr�ficas do suporte;\nlocalizar informa��o expl�cita, em menor evid�ncia, em textos informativos ou "
						+ "narrativos um pouco mais longos.");
		CadastroClassificacaoVO cl5 = new CadastroClassificacaoVO(
				0,
				5,
				20,
				"Neste n�vel, os alunos demonstram ter alcan�ado o dom�nio do sistema de escrita e a compreens�o do princ�pio "
						+ "alfab�tico, apresentando um excelente desempenho, tendo em vista as habilidades que definem o aluno como alfabetizado e "
						+ "considerando as que s�o desej�veis para o fim do segundo ano de escolariza��o. Demonstram compreender textos informativos "
						+ "e narrativos de vocabul�rio complexo, estabelecendo rela��es entre as partes que o comp�em, inferindo o assunto principal "
						+ "e localizando informa��es que n�o s�o evidentes. Assim, as crian�as que atingiram este n�vel j� avan�aram expressivamente "
						+ "no processo de alfabetiza��o e letramento inicial.");

		request.set("classificacaoVO", cl1);
		cad.cadastrarClassificacao(request);
		request.set("classificacaoVO", cl2);
		cad.cadastrarClassificacao(request);
		request.set("classificacaoVO", cl3);
		cad.cadastrarClassificacao(request);
		request.set("classificacaoVO", cl4);
		cad.cadastrarClassificacao(request);
		request.set("classificacaoVO", cl5);
		cad.cadastrarClassificacao(request);

		CadastroTipoUsuarioVO tu1 = new CadastroTipoUsuarioVO(0, "Aplicador");
		CadastroTipoUsuarioVO tu2 = new CadastroTipoUsuarioVO(0, "Elaborador");
		CadastroTipoUsuarioVO tu3 = new CadastroTipoUsuarioVO(0, "Secretaria");
		CadastroTipoUsuarioVO tu4 = new CadastroTipoUsuarioVO(0, "INEP");

		request.set("tipoUsuarioVO", tu1);
		cad.cadastrarTipoUsuario(request);
		request.set("tipoUsuarioVO", tu2);
		cad.cadastrarTipoUsuario(request);
		request.set("tipoUsuarioVO", tu3);
		cad.cadastrarTipoUsuario(request);
		request.set("tipoUsuarioVO", tu4);
		cad.cadastrarTipoUsuario(request);

		List<CadastroTipoUsuarioVO> tiposUsuario = (ArrayList<CadastroTipoUsuarioVO>) pesq
				.listarTiposUsuario().get("resposta");

		tu1 = tiposUsuario.get(0);
		tu2 = tiposUsuario.get(1);
		tu3 = tiposUsuario.get(2);
		tu4 = tiposUsuario.get(3);

		CadastroEscolaVO es = new CadastroEscolaVO(0, 12345678, "FTT");
		request.set("escolaVO", es);
		cad.cadastrarEscola(request);

		es = ((ArrayList<CadastroEscolaVO>) pesq.listarEscolas()
				.get("resposta")).get(0);

		CadastroSecretariaVO sec = new CadastroSecretariaVO(0, tu3.getId(),
				es.getId(), "Jorge", "Amado", "secretaria@teste.com",
				"secretaria");
		request.set("secretariaVO", sec);
		cad.cadastrarSecretaria(request);

		SecretariaListVO secAux = ((ArrayList<SecretariaListVO>) pesq
				.listarSecretarias().get("resposta")).get(0);

		CadastroTurmaVO t1 = new CadastroTurmaVO(0, secAux.getId(), "Turma 1");
		CadastroTurmaVO t2 = new CadastroTurmaVO(0, secAux.getId(), "Turma 2");

		request.set("turmaVO", t1);
		cad.cadastrarTurma(request);
		request.set("turmaVO", t2);
		cad.cadastrarTurma(request);

		List<TurmaListVO> turmas = (ArrayList<TurmaListVO>) pesq.listarTurmas()
				.get("resposta");

		CadastroAplicadorVO p1 = new CadastroAplicadorVO(0, "Maria",
				"Antonieta", "aplicador1@teste.com", "aplicador1", tu1.getId(),
				turmas.get(0).getId());
		CadastroAplicadorVO p2 = new CadastroAplicadorVO(0, "Antonio", "Maria",
				"aplicador2@teste.com", "aplicador2", tu1.getId(), turmas
						.get(1).getId());

		request.set("aplicadorVO", p1);
		cad.cadastrarAplicador(request);
		request.set("aplicadorVO", p2);
		cad.cadastrarAplicador(request);

		List<CadastroAplicadorVO> aplicadores = (ArrayList<CadastroAplicadorVO>) pesq
				.listarAplicadores().get("resposta");

		p1 = aplicadores.get(0);
		p2 = aplicadores.get(1);

		t1.setAplicadorId(p1.getId());
		t2.setAplicadorId(p2.getId());

		request.set("turmaVO", t1);
		cad.alterarTurma(request);
		request.set("turmaVO", t2);
		cad.alterarTurma(request);

		CadastroInepVO inep = new CadastroInepVO(0, "Matheus", "Fernandes",
				"inep@teste.com", "inep", tu4.getId());
		request.set("inepVO", inep);
		cad.cadastrarInep(request);

		CadastroAlunoVO a1 = new CadastroAlunoVO(0, turmas.get(1).getId(),
				false, Calendar.getInstance().getTime(), "Antonio");
		CadastroAlunoVO a2 = new CadastroAlunoVO(0, turmas.get(1).getId(),
				false, Calendar.getInstance().getTime(), "Carlos");
		CadastroAlunoVO a3 = new CadastroAlunoVO(0, turmas.get(1).getId(),
				false, Calendar.getInstance().getTime(), "Jobim");
		CadastroAlunoVO a4 = new CadastroAlunoVO(0, turmas.get(0).getId(),
				false, Calendar.getInstance().getTime(), "Douglas");

		request.set("alunoVO", a1);
		cad.cadastrarAluno(request);
		request.set("alunoVO", a2);
		cad.cadastrarAluno(request);
		request.set("alunoVO", a3);
		cad.cadastrarAluno(request);
		request.set("alunoVO", a4);
		cad.cadastrarAluno(request);

		CadastroElaboradorVO elab = new CadastroElaboradorVO(0, "Manoel",
				"Bandeira", "elaborador@teste.com", "elaborador", tu2.getId());
		request.set("elaboradorVO", elab);
		cad.cadastrarElaborador(request);
		elab = ((ArrayList<CadastroElaboradorVO>) pesq.listarElaboradores()
				.get("resposta")).get(0);
	}
}