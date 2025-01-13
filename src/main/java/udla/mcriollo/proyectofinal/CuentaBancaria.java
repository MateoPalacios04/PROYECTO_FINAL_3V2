package udla.mcriollo.proyectofinal;

public class CuentaBancaria {

    private String numeroCuenta;
    private Cliente cliente;

    public CuentaBancaria(String numeroCuenta, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Cuenta: " + numeroCuenta + ", Cliente: (" + cliente + ")";
    }
}