package entidades;

import entidadesenum.OrdemStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ordem {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date momento;
    private OrdemStatus status;
    private Cliente cliente;
    private List<OrdemPedido> items = new ArrayList<OrdemPedido>();

    public Ordem(){
    }

    public Ordem(Date momento, OrdemStatus status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public OrdemStatus getStatus() {
        return status;
    }

    public void setStatus(OrdemStatus status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(OrdemPedido pedido){
        items.add(pedido);
    }

    public void removeItem(OrdemPedido pedido){
        items.remove(pedido);
    }

    public double total(){
        double soma = 0.0;
        for (OrdemPedido ped : items){
            soma += ped.subTotal();
        }
        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Momento do pedido: ");
        sb.append(sdf.format(momento) + "\n");
        sb.append("Status do pedido: ");
        sb.append(status + "\n");
        sb.append("Cliente: ");
        sb.append(cliente + "\n");
        sb.append("Ordem de pedido:\n");
        for (OrdemPedido item : items){
            sb.append(item + "\n");
        }
        sb.append("Preço total: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
