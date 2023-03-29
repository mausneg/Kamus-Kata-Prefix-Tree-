package Tree;

import java.util.Scanner;

public class Operation {
    private Scanner scanner;
    private Tree tree;

    public Operation(){
        scanner = new Scanner(System.in);
        tree = new Tree();
        createDefaultData();
        clear();
        start();
    }
    public void start(){
        System.out.println("==KAMUS KATA BY KELOMPOK 9==");
        System.out.println("1. Cari kata \n2. Tampilkan semua kata \n3. Hapus kata \n4. Exit");
        System.out.print("Masukan pilihan anda: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                clear();
                findWord();
                break;
            case 2:
                clear();
                showAllWord();
                start();
                break;
            case 3:
                clear();
                delete();
                start();
                break;
            case 4:
                System.out.println("\nTerima Kasih");
                System.exit(0);
            default:
                clear();
                System.out.println("Pilihan anda tidak terdapat di menu!\n");
                start();
                break;
        }
    }
    public void delete(){
        System.out.print("Masukan kata yang ingin anda hapus: ");
        String input = scanner.next();
        if (tree.delete(input)) System.out.println("Data berhasil dihapus\n");
        else System.out.println("Data tidak ditemukan\n");
    }
    public void findWord(){
        System.out.print("Masukan kata yang ingin anda cari: ");
        String input = scanner.next();
        input = input.toLowerCase();
        boolean containsNumbersOrPunctuation = input.matches(".*\\d+.*") || input.matches(".*\\W+.*");
        if(containsNumbersOrPunctuation){
            System.out.println("\nKata yang diinput salah\n");
            start();
        }
        else {
            System.out.println("Mencari data: " + input);
            if (tree.search(input).size() == 1){
                tree.printAsc(input);
                start();
            }
            else if (tree.search(input).size() == 0){
                System.out.println();
                tree.printAsc(input);
                inputWord(input);
                System.out.println();
                start();
            }
            else print(input);
        }
    }
    public void inputWord(String word){
        System.out.print("Apakah kata ingin dimasukkan dalam kamus kata? [y/n] :  ");
        char yn = scanner.next().charAt(0);
        if (Character.compare(yn, 'y') == 0){
            tree.insert(word);
            System.out.println("\nData " + word + " berhasil dimasukkan");
        }
        else if (Character.compare(yn, 'n')==0) start();
        else start();
    }
    public void showAllWord(){
        clear();
        print("");
    }   
    private void print(String data){
        System.out.println("Pilih metode print berikut");
        System.out.println("1. Ascending \n2. Descending");
        System.out.print("Masukan pilihan anda: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                clear();
                asc(data);
                System.out.println(" ");
                start();
                break;
            case 2:
                clear();
                desc(data);
                System.out.println(" ");
                start();
                break;
            default:
                clear();
                System.out.println("Masukan pilihan dengan benar!\n");
                start();
                break;
        }
    }
    private void asc(String data){
        System.out.println("Menampilkan data secara ascending: \n");
        tree.printAsc(data);
    }
    private void desc(String data){
        System.out.println("Menampilkan data secara descending: \n");
        tree.printDesc(data);
    }
    public void clear(){
        System.out.println("\033\143");
    }
    public void createDefaultData(){
        String kamusKata[] = {"Alvionita","Surya","Angie","Novi","Ayub", "Nurul","abjad","absorpsi","actual","adab","adhesi","adjektif","administrator","advokat","aktivitas","analisis","antena","antre","asas","atlet","atmosfer","auditorium",
                              "balig","balsam","batalion","baterai","bazar","belum","berfikir","besok","binasa","biosfer","blangko","blender","bolpoin","brankas","bujer","bus","cabai","capai","capcai","cedera","cendikia","cendikiawan",
                              "cenderamata","cengkeram","cengkerama","cengkih","cokelat","daftar","dakwah","debit","dektret","depot","deputi","derajat","desain","detail","deterjen","diagnosis","dispenser","distilasi","divigen","dolar",
                              "donatur","dramatisi","efektif","ekosistem","ekspor","ekstra","ekstrakurikuler","ekstrem","ekstremis","ekstrover","elektrode","ekuivalen","elips","emas","ensiklopedia","episode","esai","etanol","faksimile",
                              "familier","favorit","februari","film","filsuf","finis","flat","folio","fondasi","formal","foto","fotokopi","fotosintetis","frasa","frekuensi","zaman","zamrud","zamzam","zigot","ziter","zona","zuhur",
                              "sabar","suka","sadar","suara","sahabat","sedikit","salah","soal","siang","sumpah","sejak","santai","salam","sensasi","sulit","segar","sehat","sopan","sisa","taat","tabel","tabiat","tabung","tafsir","tahap","tahun",
                              "tajam","takdir","takluk","takut","takwa","talak","tamat","tambah","tanam","tanding","tangkap","uang","ubah","udara","ujung","ukur","ulang","umpama","umum","umur","unggul","ungkap","usaha","usul","utama","urut","utuh",
                              "uzur","variabel","varian","variasi","ventilasi","verba","virus","vitamin","vokal","vaksin","valid","vegetarian","vektor","vena","vendor","venus","vakum","wacana","wajah","wajib","wakaf","waktu","wali","wangi","waralaba",
                              "warga","warna","wartawan","wasiat","wayang","wujud","wilayah","wawancara","xilograf","xerosis","xiloid","xenokrasi","xenograf","xenofili","xenia","xantena","xantat","xenon","xerofit","xilem","xilofon","xenoglosia","xenofobia",
                              "gadis","galak","gemar","gentar","gelar","gundah","gubris","girang","goyah","gegabah","gagap","gugur","gagah","gotong","harum","haus","hanyut","hilang","hidup","hisap","heran","hendak","hujat","humor","hutang","horor","hormon",
                              "hormat","indah","ingkar","induk","implisit","impulsif","impas","imitasi","iri","ironis","irama","idealis","identik","idiil","idaman","jago","jahat","jahil","jauh","jalur","jijik","jinjing","jiplak","jejak","jeda","jenaka","jompo",
                              "jorok","judes","juling","juara","kabar","kabur","keras","kering","kembar","kecewa","kecil","kualitas","kualifikasi","kuat","kukuh","koefisien","kognitif","kokoh","laba","labil","lajang","lawas","landai","lancip","legalitas","lelang",
                              "lokal","liberal","lusuh","luwes","liang","licik","yakin","yatim","yayasan","yudikatif","yodium","yudisial","yudisium","yurisdiksi","yurisprudensi","yoyo","yoghurt","yoga","yakut","yasan","mahar","mandi","mahkota","main","majalah","majelis",
                              "malas","majikan","maju","majemuk","makalah","makan","malaikat","malam","malas","nabati","nabu","nabi","nada","nafka","nafsu","nada","nagara","naik","naif","najis","nakal","nakoda","naluri","nama","nanas","oasis","obat","obeng","obrol","obral",
                              "observasi","obsesi","obsedian","obyek","odol","odoran","ofset","ogah","oksida","ojek","oknum","pabrik","pacar","pacak","pacuk","pacul","pada","padahal","padang","pedas","padat","padi","padri","padu","padudan","paduk","pajak","qaf","qari","qariah",
                              "qasar","qi","qiamulail","qiraah","qiraat","qudsi","quran","quasy","query","quarts","qabul","qiamulail","quick","raba","rabak","rabi","rabies","rabik","rabit","rabu","rabun","radar","radang","radas","radikal","radikula","radio","radis","radium"};
        // String kamusKata[] = {"tabung","tabungan","tabu", "tempat", "tampar", "tabah", "tidak"};
        for(int i = 0; i<kamusKata.length; i++ ){
            tree.insert(kamusKata[i]);
        }
    }
}
