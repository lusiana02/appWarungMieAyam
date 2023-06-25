package pkgFinalProjectUAS;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class appToko {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        //object menu yang dijual
        cBarang brg1 = new cBarang("Mie Ayam",12000);   
        cBarang brg2 = new cBarang("Mie Ayam Ceker",14000); 
        cBarang brg3 = new cBarang("Ayam Pangsit",15000); 
        cBarang brg4 = new cBarang("Ayam Krispy",8000); 
        cBarang brg5 = new cBarang("Jamur Krispy",6000);               
        
        // data member toko
        int id1 = 2201, pin1 = 1111;
        int id2 = 2202, pin2 = 2222;
        int id3 = 2203, pin3 = 3333;
        int id, pin;
        
	//data admin dan pemilik
        int passAdmin = 9876;
        int passPemilik = 1234;

        //daftar antrian transaksi yang masuk ke toko
        cDaftarTransaksi jual = new cDaftarTransaksi(); //untuk menyimpan semua data transaksi yg dilakukan pembeli dan disimpan di object jual 
        int pilih=0, pilih2=0, pilih3=0;
        //int kode=70300, jumlah;

	//kode transaksi menurut tanggal
        DateFormat formatTanggal = new SimpleDateFormat("MMdd");
	Date tanggal = new Date();
        int urut=0, jumlah;
        
        //menyimpan pemasukan per menu
        double total1=0, total2=0, total3=0, total4=0, total5=0, total=0;
        
        do{
            System.out.println("\n=======================================================");
            System.out.println("         APLIKASI WARUNG MIE AYAM DUA JEMPOL");
            System.out.println("=======================================================");
            System.out.println("                    Pilih Pengguna");
            System.out.println("\n1.Pembeli");
            System.out.println("2.Anggota");
            System.out.println("3.Admin");
            System.out.println("4.Pemilik");
            System.out.println("5.Exit");
            System.out.print("\nPilih         : ");
            pilih=sc.nextInt();
            switch(pilih){
                case 1:
                    //pembeli
                    urut++;
                    String kode = ""+String.valueOf(formatTanggal.format(tanggal))+"0"+urut ;                    
                    cDaftarTransaksi beli = new cDaftarTransaksi();
                    System.out.print("Masukkan Nama : ");
                    String nama=sc.next();
                    System.out.println("-------------------------------------------------------");
                    do{
                        System.out.println("\n=======================================================");
                        System.out.println("                    AKUN PEMBELI");
                        System.out.println("=======================================================");
                        System.out.println("\n1.Tambah Pesanan");
                        System.out.println("2.Hapus Pesanan");
                        System.out.println("3.Lihat Pesanan");
                        System.out.println("4.Kembali");
                        System.out.print("\nPilih : ");               
                        pilih2=sc.nextInt();   
                        System.out.println("-------------------------------------------------------");
                        switch(pilih2){
                            case 1:                 
                                cTransaksi br=null;
                                cDaftarTransaksi menu = new cDaftarTransaksi();
                                System.out.println("\n           ***   DAFTAR MENU MAKANAN   ***");
                                System.out.println("\nNo. Menu              \t\t      Harga");
                                System.out.println("1.  "+brg1.getNama()+"\t\t\t  Rp "+brg1.getHarga());
                                System.out.println("2.  "+brg2.getNama()+"\t\t  Rp "+brg2.getHarga());
                                System.out.println("3.  "+brg3.getNama()+"\t\t  Rp "+brg3.getHarga());
                                System.out.println("4.  "+brg4.getNama()+"\t\t\t  Rp "+brg4.getHarga());
                                System.out.println("5.  "+brg5.getNama()+"\t\t  Rp "+brg5.getHarga());
                                System.out.print("\nPilih     : ");
                                pilih3=sc.nextInt();
                                System.out.print("Jumlah    : ");
                                jumlah=sc.nextInt();
                                if(pilih3==1){  //simpul
                                    br = new cTransaksi(String.valueOf(kode), nama, brg1, jumlah, 0);
                                }
                                else if(pilih3==2){  //simpul
                                    br = new cTransaksi(String.valueOf(kode), nama, brg2, jumlah, 0);
                                }
                                else if(pilih3==3){  //simpul
                                    br = new cTransaksi(String.valueOf(kode), nama, brg3, jumlah, 0);
                                }  
                                else if(pilih3==4){  //simpul
                                    br = new cTransaksi(String.valueOf(kode), nama, brg4, jumlah, 0);
                                }
                                else if(pilih3==5){  //simpul
                                    br = new cTransaksi(String.valueOf(kode), nama, brg5, jumlah, 0);
                                }
                                beli.tambahTransaksi(br);
                                System.out.println("-------------------------------------------------------");
                                break;
                            case 2:
                                //hapus transaksi
                                System.out.println("\n             ***   HAPUS PESANAN   ***");
                                beli.lihatTransaksi();
                                System.out.print("\nHapus Nomor : ");
                                int hapus=sc.nextInt();
                                beli.hapusTransaksi(hapus);
                                System.out.println("-------------------------------------------------------");
                                break;
                            case 3:
                                //lihat transaksi
                                System.out.println("\n             ***   LIHAT PESANAN   ***");
                                beli.lihatTransaksi();
                                System.out.println("-------------------------------------------------------");
                                break;
                            case 4:
                                //selesai. sambungkan transaksi pembeli
                                //ke antrian transaksi toko
                                jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                System.out.println("\n             ***   TERIMA KASIH   ***");
                                System.out.println("-------------------------------------------------------");
                                break;
                        }
                    }while(pilih2!=4);
                    break;
                case 2:
                    //anggota
                    boolean valid1=false, valid2=false, valid3=false;
                    System.out.println("-------------------------------------------------------");
                    do{
                       System.out.print("\nID  : ");
                        id = sc.nextInt();
                        System.out.print("PIN : ");
                        pin = sc.nextInt();
                        if(id==id1 && pin==pin1)
                            valid1=true;
                        else if(id==id2 && pin==pin2)
                            valid2=true;
                        else if(id==id3 && pin==pin3)
                            valid3=true;
                        if(valid1==false&&valid2==false&&valid3==false)
                            System.out.println("ID/PIN salah!");
                        else break;
                    }while(valid1==false&&valid2==false&&valid3==false);   
                    if(valid1==true||valid2==true||valid3==true)
                        System.out.println("\n                  ** Selamat Datang **");
                        System.out.println("-------------------------------------------------------");
                        urut++;
                        kode = ""+String.valueOf(formatTanggal.format(tanggal))+"0"+urut ;
                        beli = new cDaftarTransaksi();
                        do{
                            System.out.println("\n=======================================================");
                            System.out.println("                    AKUN MEMBER");
                            System.out.println("=======================================================");
                            System.out.println("\n1.Tambah Pesanan");
                            System.out.println("2.Hapus Pesanan");
                            System.out.println("3.Lihat Pesanan");
                            System.out.println("4.Ubah PIN Akun");
                            System.out.println("5.Kembali");
                            System.out.print("\nPilih : ");
                            pilih2=sc.nextInt();
                            System.out.println("-------------------------------------------------------");
                            switch(pilih2){
                                case 1:
                                    cTransaksi br=null;                        
                                    System.out.println("\n           ***   DAFTAR MENU MAKANAN   ***");
                                    System.out.println("\nNo. Menu              \t\t      Harga");
                                    System.out.println("1.  "+brg1.getNama()+"\t\t\t  Rp "+brg1.getHarga());
                                    System.out.println("2.  "+brg2.getNama()+"\t\t  Rp "+brg2.getHarga());
                                    System.out.println("3.  "+brg3.getNama()+"\t\t  Rp "+brg3.getHarga());
                                    System.out.println("4.  "+brg4.getNama()+"\t\t\t  Rp "+brg4.getHarga());
                                    System.out.println("5.  "+brg5.getNama()+"\t\t  Rp "+brg5.getHarga());                         
                                    System.out.print("\nPilih  : ");
                                    pilih3=sc.nextInt();
                                    System.out.print("Jumlah : ");
                                    jumlah=sc.nextInt();
                                    if(pilih3==1){  //simpul
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg1, jumlah, 0);
                                    }
                                    else if(pilih3==2){  //simpul
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg2, jumlah, 0);
                                    }
                                    else if(pilih3==3){  //simpul
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg3, jumlah, 0);
                                    }  
                                    else if(pilih3==4){  //simpul
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg4, jumlah, 0);
                                    }
                                    else if(pilih3==5){  //simpul
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg5, jumlah, 0);
                                    } 
                                    beli.tambahTransaksi(br);
                                    System.out.println("-------------------------------------------------------");
                                    break;
                                case 2:
                                    //hapus transaksi
                                    System.out.println("\n             ***   HAPUS PESANAN   ***");
                                    beli.lihatTransaksiMember();
                                    System.out.print("\nHapus Nomor : ");
                                    int hapus=sc.nextInt();
                                    beli.hapusTransaksi(hapus);
                                    System.out.println("-------------------------------------------------------");
                                    break;
                                case 3:
                                    //menampilkan daftar belanja dan diskon
                                    System.out.println("\n             ***   LIHAT PESANAN   ***");
                                    beli.lihatTransaksiMember();
                                    System.out.println("-------------------------------------------------------");
                                    break;
                                case 4:
                                    System.out.println("\n               ***   UBAH PIN   ***");
                                    System.out.print("\nMasukkan PIN Baru : ");
                                    int pinBaru = sc.nextInt();
                                    if (valid1==true){
                                        pin1=pinBaru;
                                    }else if (valid2==true){
                                        pin2=pinBaru;
                                    }else if (valid3==true){
                                        pin3=pinBaru;
                                    }
                                    System.out.println("PIN berhasil diubah");
                                    System.out.println("-------------------------------------------------------");
                                    break;
                                case 5:
                                    //selesai. sambungkan transaksi pembeli
                                    //ke antrian transaksi toko
                                    jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                    System.out.println("\n             ***   TERIMA KASIH   ***");
                                    System.out.println("-------------------------------------------------------");
                                    break;
                            }
                        }while(pilih2!=5);                 
                    break;
                case 3:
                    //admin
                    boolean cekPassAdmin = false;
                    do{
                    System.out.print("\nMasukkan Password Admin : ");
                    int inPassAdmin = sc.nextInt();
                    if(inPassAdmin==passAdmin){
                        cekPassAdmin=true;
                    }
                    if(cekPassAdmin==true){
                    System.out.println("-------------------------------------------------------");
                    System.out.println("\n=======================================================");
                    System.out.println("                    AKUN ADMIN");
                    System.out.println("=======================================================");                    
                    System.out.println("\nTransaksi Belum Diproses : "+jual.lihatBelumDiproses());
                    System.out.println("Pemasukan Belum Diproses : "+jual.lihatPemasukanYangBelumDiproses());
                    //memproses setiap transaksi yg belum diproses
                    cTransaksi t=jual.getFront();
                    do{
                        if(t.getStatus()==0){
                            System.out.println("\n            ***   Proses Transaksi   ***");
                            System.out.println("\nKode    : "+t.getKode());
                            System.out.println("Pembeli : "+t.getPembeli());
                            System.out.println("Pesanan : "+t.getBarang().getNama());
                            System.out.println("Jumlah  : "+t.getJumlah());
                            System.out.println("\n               ***   Pilih Aksi   ***");
                            System.out.println("\n1.Diproses");
                            System.out.println("2.Selesai");
                            System.out.print("Pilih : ");
                            int aksi=sc.nextInt();
                            if(aksi==1){
                                jual.prosesTransaksi(t);
                                System.out.println("Berhasil diproses");                               
                                if(t.getBarang().getNama().equalsIgnoreCase(brg1.getNama())){
                                    total=total+brg1.getHarga()*t.getJumlah();
                                    if(t.getPembeli().compareToIgnoreCase("2201")==0||t.getPembeli().compareToIgnoreCase("2202")==0||t.getPembeli().compareToIgnoreCase("2203")==0){
                                        total=total-(0.05*total);
                                    }
                                    total1=total1+total;
                                    total=0;
                                }else if(t.getBarang().getNama().equalsIgnoreCase(brg2.getNama())){
                                    total=total+brg2.getHarga()*t.getJumlah();
                                    if(t.getPembeli().compareToIgnoreCase("2201")==0||t.getPembeli().compareToIgnoreCase("2202")==0||t.getPembeli().compareToIgnoreCase("2203")==0){
                                        total=total-(0.05*total);
                                    }
                                    total2=total2+total;
                                    total=0;
                                }else if(t.getBarang().getNama().equalsIgnoreCase(brg3.getNama())){
                                    total=total+brg3.getHarga()*t.getJumlah();
                                    if(t.getPembeli().compareToIgnoreCase("2201")==0||t.getPembeli().compareToIgnoreCase("2202")==0||t.getPembeli().compareToIgnoreCase("2203")==0){
                                        total=total-(0.05*total);
                                    }
                                    total3=total3+total;
                                    total=0;
                                }else if(t.getBarang().getNama().equalsIgnoreCase(brg4.getNama())){
                                    total=total+brg4.getHarga()*t.getJumlah();
                                    if(t.getPembeli().compareToIgnoreCase("2201")==0||t.getPembeli().compareToIgnoreCase("2202")==0||t.getPembeli().compareToIgnoreCase("2203")==0){
                                        total=total-(0.05*total);
                                    }
                                    total4=total4+total;
                                    total=0;
                                }else if(t.getBarang().getNama().equalsIgnoreCase(brg5.getNama())){
                                    total=total+brg5.getHarga()*t.getJumlah();
                                    if(t.getPembeli().compareToIgnoreCase("2201")==0||t.getPembeli().compareToIgnoreCase("2202")==0||t.getPembeli().compareToIgnoreCase("2203")==0){
                                        total=total-(0.05*total);
                                    }
                                    total5=total5+total;
                                    total=0;
                                }
                            }
                            else{
                                break;
                            }
                        }
                        t=t.next;
                    }while(t!=null);
		      }else{
                        System.out.println("Password Admin salah!");
                    }
                    }while(cekPassAdmin == false);
                    System.out.println("-------------------------------------------------------");
                    break;
                case 4:
                    //pemilik
		    boolean cekPassPemilik = false;
                    do{
                    System.out.print("\nMasukkan Password Pemilik : ");
                    int inPassPemilik = sc.nextInt();
                    if(inPassPemilik==passPemilik){
                        cekPassPemilik=true;
                    }
                    if(cekPassPemilik==true){
                        int menuPemilik=0;
                        do{
                            System.out.println("-------------------------------------------------------");
                            System.out.println("\n=======================================================");
                            System.out.println("                    AKUN PEMILIK");
                            System.out.println("=======================================================");
                            System.out.println("\n1. Total penjualan Yang Sudah Diproses");
                            System.out.println("2. Total penjualan Yang Belum Diproses");
                            System.out.println("3. Ubah harga menu");
                            System.out.println("4. Laporan Transaksi Member");
                            System.out.println("5. Laporan Penjualan Harian");
                            System.out.println("6. Kembali ke menu utama");
                            System.out.print("\nPilih : ");
                            menuPemilik = sc.nextInt();
                            System.out.println("-------------------------------------------------------");
                            switch (menuPemilik){
                                case 1:
                                    System.out.println("\n    ***   TOTAL PENJUALAN YANG SUDAH DIPROSES   ***");
                                    System.out.println("\nTransaksi Diproses : "+jual.lihatDiproses());
                                    double totalPemasukan = total1+total2+total3+total4+total5;
                                    System.out.println("Pemasukan Diproses : "+totalPemasukan); 
                                    System.out.println("-------------------------------------------------------");
                                    break;
                                case 2:
                                    System.out.println("\n    ***   TOTAL PENJUALAN YANG BELUM DIPROSES   ***");
                                    System.out.println("\nTransaksi Belum Diproses : "+jual.lihatBelumDiproses());
                                    System.out.println("Pemasukan Belum Diproses : "+jual.lihatPemasukanYangBelumDiproses()); 
                                    System.out.println("-------------------------------------------------------");
                                    break;
                                case 3:
                                    System.out.println("\n             ***   UBAH HARGA MENU   ***");
                                    System.out.print("\nMasukkan menu yang akan diubah harga : ");
                                    String ubah1 = sc.next();
                                    String ubah2 = sc.nextLine();
                                    String ubahHrg = ubah1+ubah2;
                                    if(ubahHrg.equalsIgnoreCase(brg1.getNama())){
                                        System.out.print("Masukkan harga baru : Rp ");
                                        int hrgBaru = sc.nextInt();
                                        brg1.setHarga(hrgBaru);
                                        System.out.println("Ubah harga berhasil");
                                    }else if(ubahHrg.equalsIgnoreCase(brg2.getNama())){
                                        System.out.print("Masukkan harga baru : Rp ");
                                        int hrgBaru = sc.nextInt();
                                        brg2.setHarga(hrgBaru);
                                        System.out.println("Ubah harga berhasil");
                                    }else if(ubahHrg.equalsIgnoreCase(brg3.getNama())){
                                        System.out.print("Masukkan harga baru : Rp ");
                                        int hrgBaru = sc.nextInt();
                                        brg3.setHarga(hrgBaru);
                                        System.out.println("Ubah harga berhasil");
                                    }else if(ubahHrg.equalsIgnoreCase(brg4.getNama())){
                                        System.out.print("Masukkan harga baru : Rp ");
                                        int hrgBaru = sc.nextInt();
                                        brg4.setHarga(hrgBaru);
                                        System.out.println("Ubah harga berhasil");
                                    }else if(ubahHrg.equalsIgnoreCase(brg5.getNama())){
                                        System.out.print("Masukkan harga baru : Rp ");
                                        int hrgBaru = sc.nextInt();
                                        brg5.setHarga(hrgBaru);
                                        System.out.println("Ubah harga berhasil");
                                    }else{
                                        System.out.println("Menu tidak ada!");
                                    }
                                    System.out.println("-------------------------------------------------------");
                                    break;
                                case 4:
                                    System.out.println("\n         ***   LAPORAN TRANSAKSI MEMBER   ***");
                                    System.out.println("\nNo"+"\t"+"ID"+"\t"+"Total Transaksi");
                                    System.out.println("1."+"\t"+"2201"+"\t"+jual.lihatPemasukanMember2201());
                                    System.out.println("2."+"\t"+"2202"+"\t"+jual.lihatPemasukanMember2202());
                                    System.out.println("3."+"\t"+"2203"+"\t"+jual.lihatPemasukanMember2203());
                                    System.out.println("-------------------------------------------------------");
                                    break;
                                case 5:
                                    System.out.println("\n        ***   LAPORAN PENJUALAN HARIAN   ***");
                                    System.out.println("\nMenu\t\tGrafik\t\tTotal Transaksi");
                                    double xPemasukan1 = total1/10000, xPemasukan2 = total2/10000, xPemasukan3 = total3/10000,
                                            xPemasukan4 = total4/10000, xPemasukan5 = total5/10000;
                                    System.out.print(brg1.getNama()+"\t");
                                    for (int i = 0; i < xPemasukan1; i++) {
                                        System.out.print("X");
                                    }
                                    System.out.println("\t\t"+total1);
                                    System.out.print(brg2.getNama()+"\t");
                                    for (int i = 0; i < xPemasukan2; i++) {
                                        System.out.print("X");
                                    }
                                    System.out.println("\t\t"+total2);
                                    System.out.print(brg3.getNama()+"\t");
                                    for (int i = 0; i < xPemasukan3; i++) {
                                        System.out.print("X");
                                    }
                                    System.out.println("\t\t"+total3);
                                    System.out.print(brg4.getNama()+"\t");
                                    for (int i = 0; i < xPemasukan4; i++) {
                                        System.out.print("X");
                                    }
                                    System.out.println("\t\t"+total4);
                                    System.out.print(brg5.getNama()+"\t");
                                    for (int i = 0; i < xPemasukan5; i++) {
                                        System.out.print("X");
                                    }
                                    System.out.println("\t\t"+total5);
                                    System.out.println("-------------------------------------------------------");
                                    break;
                                case 6:
                                    System.out.println("-------------------------------------------------------");
                                    break;
                            }
                        }while(menuPemilik!=6);
                    }else{
                        System.out.println("Password Pemilik salah!");
                    }
                    }while(cekPassPemilik == false);
                    break;
                case 5:
                    System.out.println("\n                ***   TERIMA KASIH   ***");
                    System.out.println("-------------------------------------------------------");
                    break;
            }
        }while(pilih!=5);
    }
}