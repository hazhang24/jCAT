package com.douglasrizzo.business.ejb.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.douglasrizzo.business.interfaces.Cadastro;
import com.douglasrizzo.business.interfaces.Pesquisa;
import com.douglasrizzo.business.vo.CadastroAlunoVO;
import com.douglasrizzo.business.vo.CadastroAplicadorVO;
import com.douglasrizzo.business.vo.CadastroClassificacaoVO;
import com.douglasrizzo.business.vo.CadastroElaboradorVO;
import com.douglasrizzo.business.vo.CadastroEscolaVO;
import com.douglasrizzo.business.vo.CadastroInepVO;
import com.douglasrizzo.business.vo.CadastroSecretariaVO;
import com.douglasrizzo.business.vo.CadastroTipoUsuarioVO;
import com.douglasrizzo.business.vo.CadastroTurmaVO;
import com.douglasrizzo.business.vo.SecretariaListVO;
import com.douglasrizzo.business.vo.TurmaListVO;
import com.douglasrizzo.util.dto.ServiceDTO;
import com.douglasrizzo.util.exception.LayerException;
import com.douglasrizzo.util.locator.ServiceLocatorException;

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
				"Neste nível, encontram-se alunos que estão em um estágio muito inicial em relação à aprendizagem da linguagem escrita. "
						+ "Estão começando a se apropriar das habilidades referentes ao domínio das regras que orientam "
						+ "o uso do sistema alfabético para ler e escrever. Sabem, por exemplo:\nidentificar o valor sonoro das partes iniciais "
						+ "e/ou finais de palavras (algumas letras ou sílabas), para \"adivinhar\" e \"ler\" o restante da palavra;"
						+ "\nidentificar relação entre grafemas e fonemas (letra/som) com correspondência sonora única ou com mais de uma correspondência sonora;"
						+ "\nreconhecer algumas letras do alfabeto e iniciar a distinção das letras de desenhos e outros sinais gráficos;"
						+ "\nler palavras formadas por sílabas simples (consoante monogâmica + vogal).");
		CadastroClassificacaoVO cl2 = new CadastroClassificacaoVO(
				0,
				2,
				9,
				"Os alunos que se encontram neste nível, além de já terem consolidado as habilidades do nível anterior, "
						+ "referentes ao conhecimento e uso do sistema de escrita, já associam adequadamente letras e sons. Embora ainda apresentem "
						+ "algumas dificuldades na leitura de palavras com ortografia mais complexa, neste nível, demonstram ser capazes de ler palavras "
						+ "com vários tipos de estrutura silábica. Eles demonstram habilidades de:\nler algumas palavras compostas por sílabas formadas "
						+ "por consoante/vogal/consoante ou por consoante/consoante/vogal;\nreconhecer letras escritas de diferentes formas;"
						+ "\nidentificar o número de sílabas de uma palavra formada por sílabas simples e com letras com um único som;"
						+ "\nreconhecer a finalidade do texto com apoio das características gráficas;\nreconhecer o valor sonoro de uma sílaba;"
						+ "\nreconhecer o assunto de gêneros textuais mais próprios do contexto escolar com base em suas características gráficas.");
		CadastroClassificacaoVO cl3 = new CadastroClassificacaoVO(
				0,
				3,
				15,
				"Neste nível, os alunos demonstram que consolidaram a capacidade de ler palavras de diferentes tamanhos "
						+ "e padrões silábicos, conseguem ler frases com sintaxe simples (sujeito + verbo + objeto) e utilizam algumas estratágias "
						+ "que permitem ler textos de curta extensão. As capacidades reveladas neste nível são:\nler palavras mais complexas, "
						+ "constituídas por letras que representam mais de um som e por sílabas formadas por dígrafos, encontros consonantais ou "
						+ "encontros vocálicos;\nler frases curtas;\nlocalizar informações explícitas por meio da leitura silenciosa em uma frase ou "
						+ "em textos de aproximadamente cinco linhas;\nreconhecer o assunto do texto com base na leitura de informações evidentes no "
						+ "título;\nidentificar finalidade de gêneros (convite, anúncio publicitário), apoiando-se ou não em suas características "
						+ "gráficas como imagens e em seu modo de apresentação.");
		CadastroClassificacaoVO cl4 = new CadastroClassificacaoVO(
				0,
				4,
				18,
				"Neste nível, os alunos leem textos simples e são capazes de interpretá-los, localizando informações, "
						+ "realizando inferências e reconhecendo o assunto ou a finalidade a partir da leitura autônoma desses textos. São exemplos "
						+ "de habilidades demonstradas pelos alunos deste nível:\nlocalizar informações explícitas e evidentes a partir da leitura de "
						+ "textos como bilhetes e convites, sem apoio das características gráficas;\ninferir informação em textos curtos;\nidentificar "
						+ "finalidade de textos de gêneros diversos, como bilhetes, sumário, convite, cartazes;\nreconhecer o assunto de um texto sem apoio "
						+ "das características gráficas do suporte;\nlocalizar informação explícita, em menor evidência, em textos informativos ou "
						+ "narrativos um pouco mais longos.");
		CadastroClassificacaoVO cl5 = new CadastroClassificacaoVO(
				0,
				5,
				20,
				"Neste nível, os alunos demonstram ter alcançado o domínio do sistema de escrita e a compreensão do princípio "
						+ "alfabético, apresentando um excelente desempenho, tendo em vista as habilidades que definem o aluno como alfabetizado e "
						+ "considerando as que são desejáveis para o fim do segundo ano de escolarização. Demonstram compreender textos informativos "
						+ "e narrativos de vocabulário complexo, estabelecendo relações entre as partes que o compõem, inferindo o assunto principal "
						+ "e localizando informações que não são evidentes. Assim, as crianças que atingiram este nível já avançaram expressivamente "
						+ "no processo de alfabetização e letramento inicial.");

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