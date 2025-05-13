public class Problema1_EjecutorProducto {
    public static void main(String[] args) {
        Producto productoX = new Producto(1000, 10);
        productoX.calcularDescuento(productoX.precioP, productoX.cantidadP);
        productoX.calcularPrecioFinal();
        System.out.println(productoX);
    }
}

class Producto{
    public double precioP;
    public int cantidadP;
    public double descuento;
    public double precioFinal;
    public double montoDescuento;
    
    public Producto(){}

    public Producto(double precioP, int cantidadP) {
        this.precioP = precioP;
        this.cantidadP = cantidadP;
        this.descuento = descuento;
        this.precioFinal = precioFinal;
    }
    
    public double calcularDescuento(double precioP, int cantidadP){
        if ((this.precioP >= 1000) && (this.cantidadP >= 10)){
            descuento = 10;
        } else {
            descuento = 5;
        }
        
        this.montoDescuento = (this.cantidadP * this.precioP)*(this.descuento/100);
        return this.montoDescuento;
    }
    
    public double calcularPrecioFinal(){
        this.precioFinal = (this.cantidadP * this.precioP) - (this.montoDescuento);
        return this.precioFinal;
    }

    @Override
    public String toString() {
        return "Producto{" + "precioP=" + precioP + ", cantidadP=" + cantidadP + ", descuento=" + descuento + ", precioFinal=" + precioFinal + ", montoDescuento=" + montoDescuento + '}';
    }
}
