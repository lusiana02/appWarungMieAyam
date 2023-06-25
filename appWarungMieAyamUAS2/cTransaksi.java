package pkgFinalProjectUAS;
public class cTransaksi {   
    String kode;    //kode transaksi
    String pembeli; //data pembeli
    cBarang barang; //barang
    int jumlahbrg;  //jumlah barang
    int status;     //status transaksi (sudah diproses atau belum)
    cTransaksi next;    //tautan untuk simpul transaksi single linked list
    cTransaksi(String k, String p, cBarang b, int j, int s){   //konstruktor yg akan digunakan di class aplikasi
        kode=k; pembeli=p; barang=b; jumlahbrg=j; status=s;
        next=null;
    }
    public void setStatus(int s){   //setter
        status=s;
    }
    public String getKode(){    //getter
        return kode;
    }
    public String getPembeli(){ //getter
        return pembeli;
    }
    public cBarang getBarang(){ //getter
        return barang;
    }
    public int getJumlah(){ //getter digunakan saat penghitungan biaya total (hargabrg*jumlahbrg)
        return jumlahbrg;
    }
    public int getStatus(){ //getter
        return status;
    }
}
