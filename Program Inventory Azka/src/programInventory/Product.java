package programInventory;
import java.util.*;

public class Product {
    int maxSize = -1;
    String[] NamaProduk;
    int[] jumlahProduk;
    int[] harga;
    int[] kode;
    
    Scanner input = new Scanner(System.in);

    public void setInventory() {

        try {
            System.out.print("Masukkan jumlah produk : ");
            maxSize = input.nextInt();
            if (maxSize == 0) {
                System.out.println("Tidak ada produk yang dibutuhkan!");
            } else {
                NamaProduk(maxSize);
                JmlProduk(maxSize);
                HargaProduk(maxSize);
                NoProduk(maxSize);
            }
        }catch (Exception e) {
            System.err.println("Nilai Salah dimasukkan");
            input.nextLine();
            System.out.println("");
            setInventory();
        }
    }

    public void getInventory(){
        OpenData(maxSize);
    }

    public void NamaProduk(int batas) {

        String buffer;
        NamaProduk = new String[batas];

        for (int i = 0; i < batas; i++) {
            System.out.printf("Produk %d (input 0 to exit) : ", i + 1);
            buffer = input.next();

            if (buffer.equals("0")) {
                break;
            }else {
                NamaProduk[i] = buffer;
            }
        }
    }

    public void JmlProduk(int batas) {

        int buffer;
        jumlahProduk = new int[batas];
        try {
            for (int i = 0; i < batas; i++) {
                for (int j = 0; j < 1; ) {

                    if (NamaProduk[i] == null){
                        throw new NullPointerException();
                    }

                    System.out.printf("Jumlah %s : ", NamaProduk[i]);
                    buffer = input.nextInt();

                    if (buffer >= 0) {
                        jumlahProduk[i] = buffer;
                        break;
                    } else {
                        System.out.println("Inputkan Angka!");
                    }
                }
            }
        } catch (NullPointerException npe){

        } catch (InputMismatchException e){
            System.err.println("Tipe data yang dimasukkan salah!");
            input.nextLine();
            System.out.println("");
            JmlProduk(maxSize);
        }
    }

    public void HargaProduk(int batas) {
        int buffer;
        harga = new int[batas];
        try {
            for (int i = 0; i < batas; i++) {
                for (int j = 0; j < 1; ) {

                    if (NamaProduk[i] == null) {
                        throw new NullPointerException();
                    }

                    System.out.printf("Harga %s : ", NamaProduk[i]);
                    buffer = input.nextInt();

                    if (buffer >= 0) {
                        harga[j] = buffer;
                        break;
                    } else {
                        System.out.println("Inputkan Angka!");
                    }
                }
            }
        } catch (NullPointerException npe){

        } catch (InputMismatchException e){
            System.err.println("Tipe data yang dimasukkan salah!");
            input.nextLine();
            System.out.println("");
            HargaProduk(maxSize);
        }
    }

    public void NoProduk(int batas) {

        int buffer;
        kode = new int[batas];

        try {
            for (int i = 0; i < batas; i++) {
                for (int j = 0; j < 1; ) {

                    if (NamaProduk[i] == null) {
                        throw new NullPointerException();
                    }

                    System.out.printf("Code %s : ", NamaProduk[i]);
                    buffer = input.nextInt();

                    if (buffer >= 0) {
                        kode[j] = buffer;
                        break;
                    } else {
                        System.out.println("Inputkan Angka!");
                    }
                }
            }
        } catch (NullPointerException npe){

        } catch (InputMismatchException e){
            System.err.println("Tipe data yang dimasukkan salah!");
            input.nextLine();
            System.out.println("");
            NoProduk(maxSize);
        }
    }

    public void OpenData(int batas){
        for (int i = 0; i < batas; i++) {
            boolean Status = true;
            if (jumlahProduk[i] == 0) {
                Status = false;
            }

            try {
                if (NamaProduk[i] == null) {
                    throw new NullPointerException();
                }

                System.out.printf("----- Produk %d -----\n", i + 1);
                System.out.println("Nomor Barang  : " + kode[i]);
                System.out.println("Nama Produk   : " + NamaProduk[i]);
                System.out.println("Jumlah Stok   : " + jumlahProduk[i]);
                System.out.println("Harga Produk  : " + harga[i]);
                System.out.println("Nilai Saham   : " + harga[i] * jumlahProduk[i]);
                System.out.println("Status Produk : " + Status);

            } catch (NullPointerException npe){

            }
        }
    }
}