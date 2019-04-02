package main;

public class Tarefa {

    public enum Situacao {
          NAO_INICIADO, EM_PROGRESSO, TERMINADA, BLOQUEADA;
    }

    public int id;
    public String descricao;
    public String dataCriacao;
    public Situacao situacao;
    public String responsavel;
    public float horasEstimadas;

    public Tarefa(int id, String descricao, String dataCriacao, Situacao situacao, String responsavel, float horasEstimadas ) {
        this.id = id;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.situacao = situacao;
        this.responsavel = responsavel;
        this.horasEstimadas = horasEstimadas;

    }

    public int getId() {
        return id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public String getDataCriacao() {
        return dataCriacao;
    }
    
    public Situacao getSitucao() {
        return situacao;
    }
    
    public String getResponsavel() {
        return responsavel;
    }
    
    public float getHorasEstimada() {
        return horasEstimadas;
    }
    
}