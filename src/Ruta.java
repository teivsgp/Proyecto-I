
public class Ruta {
    
    Zona ruta;
    Zona destino;
    int modo;
    int distanciaKm;
    int timepoMin;
    double costo;
    double huellaCO2g;
    
    public Ruta(Zona ruta, Zona destino, int modo, int distanciaKm, int tiempoMin, double costo, double huellaCO2g){    // Constructor de la clase
        this.ruta = ruta;
        this.destino = destino;
        this.modo = modo;
        this.distanciaKm = distanciaKm;
        this.timepoMin = timepoMin;
        this.costo = costo;
        this.huellaCO2g = huellaCO2g;    }
    
}
