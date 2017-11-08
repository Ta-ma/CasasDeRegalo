package casas;

public class Arista {
    private int nodoO;
    private int nodoD;
    private int costo;

    public Arista(int nodoO, int nodoD, int costo) {
	super();
	this.nodoO = nodoO;
	this.nodoD = nodoD;
	this.costo = costo;
    }

    public int getNodoO() {
	return nodoO;
    }

    public void setNodoO(int nodoO) {
	this.nodoO = nodoO;
    }

    public int getNodoD() {
	return nodoD;
    }

    public void setNodoD(int nodoD) {
	this.nodoD = nodoD;
    }

    public int getCosto() {
	return costo;
    }

    public void setCosto(int costo) {
	this.costo = costo;
    }

    @Override
    public String toString() {
	return "Arista [nodoO=" + (nodoO + 1) + ", nodoD=" + (nodoD + 1) + ", costo=" + costo + "]";
    }

}
