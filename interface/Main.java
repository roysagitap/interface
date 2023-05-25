interface DapatDibayar {
    double getJumlahDibayarkan();
}

class Tagihan implements DapatDibayar {
    private String namaProduk;
    private Integer jumlah;
    private Integer hargaPerItem;

    public Tagihan(String namaProduk, Integer jumlah, Integer hargaPerItem) {
        this.namaProduk = namaProduk;
        this.jumlah = jumlah;
        this.hargaPerItem = hargaPerItem;
    }

    public double getJumlahDibayarkan() {
        return jumlah * hargaPerItem;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public Integer getHargaPerItem() {
        return hargaPerItem;
    }
}

class Karyawan implements DapatDibayar {
    private Integer nomorRegistrasi;
    private String nama;
    private double gajiPerBulan;
    private Tagihan[] tagihan;

     public Karyawan(Integer nomorRegistrasi, String nama, Double gajiPerBulan, Tagihan[] tagihan) {
        this.nomorRegistrasi = nomorRegistrasi;
        this.nama = nama;
        this.gajiPerBulan = gajiPerBulan;
        this.tagihan = tagihan;
    }

    public double getJumlahDibayarkan() {
        double totalJumlahTagihan = 0.0;
        for (Tagihan t : tagihan) {
            totalJumlahTagihan += t.getJumlahDibayarkan();
        }
        return gajiPerBulan - totalJumlahTagihan;
    }

    public Integer getNomorRegistrasi() {
        return nomorRegistrasi;
    }

    public String getNama() {
        return nama;
    }

    public double getGajiPerBulan() {
        return gajiPerBulan;
    }

    public Tagihan[] getTagihan() {
        return tagihan;
    }
}

public class Main {
    public static void main(String[] args) {
        Tagihan tagihan1 = new Tagihan("Produk A", 1, 100000);
        Tagihan tagihan2 = new Tagihan("Produk B", 1, 300000);
        Tagihan[] tagihan = {tagihan1, tagihan2};

        Karyawan karyawan = new Karyawan(12345, "Roy Sagita Putra", 1000000.0, tagihan);
        

        System.out.println("Informasi Karyawan:");
        System.out.println("Nomor Registrasi: " + karyawan.getNomorRegistrasi());
        System.out.println("Nama: " + karyawan.getNama());
        System.out.println("Gaji per Bulan: Rp" + karyawan.getGajiPerBulan());

        System.out.println("\nTagihan:");
        for (Tagihan t : karyawan.getTagihan()) {
            System.out.println("Produk: " + t.getNamaProduk());
            System.out.println("Jumlah: " + t.getJumlah());
            System.out.println("Harga per Item: Rp" + t.getHargaPerItem());
            System.out.println("Jumlah Total: Rp" + t.getJumlahDibayarkan());
            System.out.println();
        }

        System.out.println("Total Gaji setelah Potongan: Rp" + karyawan.getJumlahDibayarkan());
    }
}
