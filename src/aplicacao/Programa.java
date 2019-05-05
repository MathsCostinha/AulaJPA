package aplicacao;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
			
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Pressione 1 para listar as pessoas cadastradas\n"
			+"Pressione 2 para buscar uma pessoa pelo ID\n"
			+"Pressione 3 para cadastrar uma nova pessoa\n"
			+"Pressione 4 para atualizar uma pessoa\n"
			+"Pressione 5 para remover uma pessoa\n"
			+"Pressione 0 para sair do Banco de Dados\n");
		int escolha = ler.nextInt();
		while(escolha != 0) {
			if(escolha==1) {
				String jpql = "SELECT p FROM Pessoa p";
				List<Pessoa>pessoas = entityManager.createQuery(jpql,Pessoa.class).getResultList();
				System.out.println(pessoas);
				System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
					+"Pressione 1 para listar as pessoas cadastradas\n"
					+"Pressione 2 para buscar uma pessoa pelo ID\n"
					+"Pressione 3 para cadastrar uma nova pessoa\n"
					+"Pressione 4 para atualizar um pessoa\n"
					+"Pressione 5 para remover uma pessoa\n"
					+"Pressione 0 para sair do Banco de Dados\n");
				escolha = ler.nextInt();
			}
			else if(escolha==2) {
				System.out.println("Digite o ID a ser procurado: ");
				int id=ler.nextInt();
				Pessoa pessoaFound= entityManager.find(Pessoa.class,id);
				if(pessoaFound != null) {
					System.out.println(pessoaFound);
					System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
						+"Pressione 1 para listar as pessoas cadastradas\n"
						+"Pressione 2 para buscar uma pessoa pelo ID\n"
						+"Pressione 3 para cadastrar uma nova pessoa\n"
						+"Pressione 4 para atualizar uma pessoa\n"
						+"Pressione 5 para remover uma pessoa\n"
						+"Pressione 0 para sair do Banco de Dados\n");
					escolha = ler.nextInt();
				}
				else if(pessoaFound==null ) {
					System.out.println("ID não encontrado!");
					System.out.println("Se deseja fazer mais alterações no Banco de Dados: \n"
						+"Pressione 1 para listar as pessoas cadastradas\n"
						+"Pressione 2 para buscar uma pessoa pelo ID\n"
						+"Pressione 3 para cadastrar uma nova pessoa\n"
						+"Pressione 4 para atualizar uma pessoa\n"
						+"Pressione 5 para remover uma pessoa\n"
						+"Pressione 0 para sair do Banco de Dados\n");
					escolha = ler.nextInt();
				}
			}
			else if (escolha==3) {
				System.out.println("Digite seu nome: ");
				String nome=ler.next();
				System.out.println("Digite seu Email: ");
				String email=ler.next();
				Pessoa pessoa = new Pessoa(null, nome, email);
				entityManager.getTransaction().begin();
				entityManager.persist(pessoa);
				entityManager.getTransaction().commit();
				System.out.println("Cadastro realizado com sucesso!");
				System.out.println("Caso deseje fazer mais alterações no Banco de Dados:\n"
					+"Pressione 1 para listar as pessoas cadastradas\n"
					+"Pressione 2 para buscar uma pessoa pelo ID\n"
					+"Pressione 3 para cadastrar uma nova pessoa\n"
					+"Pressione 4 para atualizar uma pessoa\n"
					+"Pressione 5 para remover uma pessoa\n"
					+"Pressione 0 para sair do Banco de Dados\n");
				escolha = ler.nextInt();
			}
			else if(escolha==4) {
				System.out.println("Digite o ID a ser atualizado: ");
				int id=ler.nextInt();
				Pessoa pessoaFound= entityManager.find(Pessoa.class,id);
				if(pessoaFound==null) {
					System.out.println("ID não existente!");
					System.out.println("Se deseja fazer mais alterações no Banco de Dados: \n"
						+"Pressione 1 para listar as pessoas cadastradas\n"
						+"Pressione 2 para buscar uma pessoa pelo ID\n"
						+"Pressione 3 para cadastrar uma nova pessoa\n"
						+"Pressione 4 para atualizar uma pessoa\n"
						+"Pressione 5 para remover uma pessoa\n"
						+"Pressione 0 para sair do Banco de Dados\n");
					escolha = ler.nextInt();
				}
			else if(pessoaFound!=null) {
				System.out.println("Se deseja atualizar:\n Email: Digite 1\n Nome: Digite 2\n Os dois anteriores: Digite 3");
				int escolhaDeAlteracao = ler.nextInt();
				if(escolhaDeAlteracao==1) {
					System.out.println("Alterar Email para: ");
					String novoemail= ler.next();
					pessoaFound.setEmail(novoemail);
					entityManager.getTransaction().begin();
					entityManager.persist(pessoaFound);
					entityManager.getTransaction().commit();
					System.out.println("Alteração realizada com sucesso!");
					System.out.println("Se deseja fazer mais alterações no Banco de Dados: \n"
						+"Pressione 1 para listar as pessoas cadastradas\n"
						+"Pressione 2 para buscar uma pessoa pelo ID\n"
						+"Pressione 3 para cadastrar uma nova pessoa\n"
						+"Pressione 4 para atualizar uma pessoa\n"
						+"Pressione 5 para remover uma pessoa\n"
						+"Pressione 0 para sair do Banco de Dados\n");
					escolha = ler.nextInt();
				}
				else if(escolhaDeAlteracao==2) {
					System.out.println("Alterar Nome para: ");
					String novonome= ler.next();
					pessoaFound.setNome(novonome);
					entityManager.getTransaction().begin();
					entityManager.persist(pessoaFound);
					entityManager.getTransaction().commit();
					System.out.println("Alteração realizada com sucesso!");
					System.out.println("Se deseja fazer mais alterações no Banco de Dados: \n"
						+"Pressione 1 para listar as pessoas cadastradas\n"
						+"Pressione 2 para buscar uma pessoa pelo ID\n"
						+"Pressione 3 para cadastrar uma nova pessoa\n"
						+"Pressione 4 para atualizar uma pessoa\n"
						+"Pressione 5 para remover uma pessoa\n"
						+"Pressione 0 para sair do Banco de Dados\n");
					escolha = ler.nextInt();
				}
				else if(escolhaDeAlteracao==3) {
					System.out.println("Alterar Email para: ");
					String novoemail= ler.next();
					pessoaFound.setEmail(novoemail);
					System.out.println("Alterar Nome para: ");
					String novonome= ler.next();
					pessoaFound.setNome(novonome);
					entityManager.getTransaction().begin();
					entityManager.persist(pessoaFound);
					entityManager.getTransaction().commit();
					System.out.println("Alteração realizada com sucesso!");
					System.out.println("Se deseja fazer mais alterações no Banco de Dados: \n"
						+"Pressione 1 para listar as pessoas cadastradas\n"
						+"Pressione 2 para buscar uma pessoa pelo ID\n"
						+"Pressione 3 para cadastrar uma nova pessoa\n"
						+"Pressione 4 para atualizar uma pessoa\n"
						+"Pressione 5 para remover uma pessoa\n"
						+"Pressione 0 para sair do Banco de Dados\n");
					escolha = ler.nextInt();
				}
			}
			}
			else if(escolha==5) {
				System.out.println("Digite o ID que deseja remover: ");
				int id=ler.nextInt();
				Pessoa pessoaFound= entityManager.find(Pessoa.class,id);
				if(pessoaFound!=null) {
					entityManager.getTransaction().begin();
					entityManager.remove(pessoaFound);
					entityManager.getTransaction().commit();
					System.out.println("Removido com sucesso!");
					System.out.println("Se deseja fazer mais alterações no Banco de Dados: \n"
						+"Pressione 1 para listar as pessoas cadastradas\n"
						+"Pressione 2 para buscar uma pessoa pelo ID\n"
						+"Pressione 3 para cadastrar uma nova pessoa\n"
						+"Pressione 4 para atualizar uma pessoa\n"
						+"Pressione 5 para remover uma pessoa\n"
						+"Pressione 0 para sair do Banco de Dados\n");
					escolha = ler.nextInt();
				}
				else if(pessoaFound==null) {
					System.out.println("ID não existente!");
					System.out.println("Se deseja fazer mais alterações no Banco de Dados: \n"
						+"Pressione 1 para listar as pessoas cadastradas\n"
						+"Pressione 2 para buscar uma pessoa pelo ID\n"
						+"Pressione 3 para cadastrar uma nova pessoa\n"
						+"Pressione 4 para atualizar uma pessoa\n"
						+"Pressione 5 para remover uma pessoa\n"
						+"Pressione 0 para sair do Banco de Dados\n");
					escolha = ler.nextInt();
				}
			}	
		}	
		if(escolha==0) {
			entityManager.close();
			entityManagerFactory.close();
			System.out.println("Nunca é um Adeus! Flw");
		}	
	}
}