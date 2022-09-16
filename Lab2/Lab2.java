import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Lab2 {
    // TODO : Silahkan menambahkan struktur data yang diperlukan
    private static InputReader in;
    private static PrintWriter out;
    private static Deque<Stack<Integer>> daftarToples;

    /**
     * Menggeser toples sekali ke kanan  
     * @return rasa kue paling atas dari toples di depan sofita
     */
    static int geserKanan() {
        // TODO : Implementasi fitur geser kanan conveyor belt
        if (daftarToples.size() == 1) {
            int rasaKueTeratas = daftarToples.getLast().peek();
            return rasaKueTeratas;
        }
        
        // todo
        // menggeser sekali toples pertama
        // sehingga dia berada di depan sofita (terakhir dalam antrian)

        // ide
        // Membuang toples paling depan dan memasukkannya ke paling akhir
        Stack<Integer> toplesTerdepan = daftarToples.removeFirst();
        daftarToples.add(toplesTerdepan);
        
        int rasaKueTeratas = daftarToples.getLast().peek();
        return rasaKueTeratas;
    }

    /**
     * Memindahkan toples yang berisi rasa kue yang diinginkan Sofita
     * ke depan Sofita (paling belakang dalam antrian)
     * lalu mengambil kue tersebut (dihilangkan dari tumpukan kue)
     * @param rasaYangDiinginkan integer rasa kue yang ingin dibeli
     * @return posisi toples dari Sofita sebelum digeser ke kanan (0-based)
     */
    static int beliRasa(int rasaYangDiinginkan) {
        // TODO : Implementasi fitur beli rasa, manfaatkan fitur geser kanan

        // cari tahu posisi toples yang berisi kue yg diinginkan -> simpan sementara posisinya (0-based)
            // return -1 kalo kuenya tidak ada di toples manapun
        int posisiToples = -1;
        int rasaKueTeratas = -1;

        Deque<Stack<Integer>> daftarToplesBayangan = new LinkedList<Stack<Integer>>();

        do {
            posisiToples += 1;
            // Stack<Integer> toples = daftarToples.getLast();
            // rasaKueTeratas = toples.peek();
            
        } while (rasaKueTeratas != rasaYangDiinginkan);

        //  {
        //     Stack<Integer> toplesTerdepan = daftarToples.removeFirst();
        //     daftarToples.add(toplesTerdepan);

        //     if (rasaKueTeratas == rasaYangDiinginkan) {
        //         posisiToples = 0;
        //         return 
        //     }
        // }

        // geser toples yang berisi kue yg diinginkan hingga ke depan Sofita (terakhir dalam antrian) 
        // ambil dan hapus kue dari tumpukan kue
        // -> return posisi toples tsb sebelum digeser

        return -1;
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        in = new InputReader(inputStream);
        OutputStream outputStream = System.out;
        out = new PrintWriter(outputStream);
        
        int banyakToples = in.nextInt(); // banyak toples
        int banyakKueTiapToples = in.nextInt(); // banyak kue dalam toples
        int banyakQuery = in.nextInt(); // banyak query

        // inisiasi antrian toples
        daftarToples = new LinkedList<Stack<Integer>>();

        for (int i = 0; i < banyakToples; ++i) {

            // TODO: Inisiasi toples ke-i
            Stack<Integer> toples = new Stack<Integer>();
            daftarToples.add(toples);
        
            for (int j = 0; j < banyakKueTiapToples; j++) {

                int rasaKeJ = in.nextInt(); // angka merepresentasikan rasa kue

                // TODO: Inisiasi (memasukkan) kue ke-j ke dalam toples ke-i
                toples.push(rasaKeJ);
            }
        }

        for (int i = 0; i < banyakQuery; i++) {
            String perintah = in.next();
            if (perintah.equals("GESER_KANAN")) {
                out.println(geserKanan());
            } else if (perintah.equals("BELI_RASA")) {
                int namaRasa = in.nextInt();
                out.println(beliRasa(namaRasa));
            }
        }
        out.close();
    }

    // taken from https://codeforces.com/submissions/Petr
    // together with PrintWriter, these input-output (IO) is much faster than the usual Scanner(System.in) and System.out
    // please use these classes to avoid your fast algorithm gets Time Limit Exceeded caused by slow input-output (IO)
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}