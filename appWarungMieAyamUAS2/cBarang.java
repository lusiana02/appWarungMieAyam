package pkgFinalProjectUAS;
public class cBarang {
    String nama;
    int harga;
    cBarang(String n, int h){//konstruktor
        nama=n; harga=h;
    }//konstruktor dipakai di class aplikasi, di class aplikasi akan create object dari class barang untuk dimasukkan dalam transaksi
    public String getNama(){//getter
        return nama;
    }
    public int getHarga(){//getter
        return harga;
    }
    public void setHarga(int hrgBaru){   //setter
        harga=hrgBaru;
    }
}

