package Entity;

public class Animal {
    
    private Integer idAnimal;
    private Integer idCliente;
    private String nome;
    private String raca;
    private String genero;
    private String tipo;
    private String observacoes;

    public Animal() {
    }

    public Animal(Integer idAnimal, String nome, String raca, String genero, String tipo, String observacoes) {
        this.idAnimal = idAnimal;
        this.nome = nome;
        this.raca = raca;
        this.genero = genero;
        this.tipo = tipo;
        this.observacoes = observacoes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\nNome " + nome + "\n"+
               "Raça " + raca + "\n"+
               "Genero " + genero + "\n"+
               "Tipo " + tipo + "\n"+
               "Observações " + observacoes;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
