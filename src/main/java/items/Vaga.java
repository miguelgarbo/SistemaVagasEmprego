package items;
import users.Candidato;
import users.Empresa;
import java.util.List;
import java.util.Set;

public class Vaga implements IVaga{
    
    private List<String> requisitos;
    private double salario;
    private List<String> beneficios;
    private ESenioridade senioridade;
    private Set<Candidato> candidatosInscritos;
    private Empresa empresa;
    private String titulo;

    public Vaga(List<String> requisitos, double salario, List<String> beneficios, ESenioridade senioridade, String titulo) {
        this.requisitos = requisitos;
        this.salario = salario;
        this.beneficios = beneficios;
        this.senioridade = senioridade;
        this.titulo = titulo;
    }

    public List<String> getRequisitos() {return requisitos;}

    public void setRequisitos(List<String> requisitos) {this.requisitos = requisitos;}

    public ESenioridade getSenioridade() {return senioridade;}

    public void setSenioridade(ESenioridade senioridade) {this.senioridade = senioridade;}

    public Set<Candidato> getCandidatosInscritos() {return candidatosInscritos;}

    public void setCandidatosInscritos(Set<Candidato> candidatosInscritos) {this.candidatosInscritos = candidatosInscritos;}
    
    public Empresa getEmpresa() {return empresa;}

    public void setEmpresa(Empresa empresa) {this.empresa = empresa;}

    public String gettitulo() {return titulo;}

    public void settitulo(String titulo) {this.titulo = titulo;}

    public double getSalario() {return salario;}

    public void setSalario(double salario) {this.salario = salario;}

    public List<String> getBeneficios() {return beneficios;}

    public void setBeneficios(List<String> beneficios) {this.beneficios = beneficios;}

    @Override
    public void criarVagas(String nome, String experiencia, String areaInteresse) {

    }

    @Override
    public void visualizarVagas() {

    }
}
