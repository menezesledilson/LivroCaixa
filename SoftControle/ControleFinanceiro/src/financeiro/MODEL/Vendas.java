package financeiro.MODEL;

 import java.sql.Timestamp;

public class Vendas {
    private Long id;
    private Timestamp dataHora;
    private String nomeCliente;
    private String celular;
    private String dataVenda;
    private String modelCarro;
    private int anoCarro;
    private String placaCarro;
    private String chassi;
    private String Status;
    private Double comissao;
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getModelCarro() {
        return modelCarro;
    }

    public void setModelCarro(String modelCarro) {
        this.modelCarro = modelCarro;
    }

    public int getAnoCarro() {
        return anoCarro;
    }

    public void setAnoCarro(int anoCarro) {
        this.anoCarro = anoCarro;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String plcaCarro) {
        this.placaCarro = plcaCarro;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
