import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import java.util.StringTokenizer;

public class Lab1 {
    private static InputReader in;
    private static PrintWriter out;

    static int getTotalDeletedLetters(int N, char[] x) {
        // TODO: implement method getTotalDeletedLetter(int, char[]) to get the answer
        List<Character> hurufSofita = asList('S', 'O', 'F', 'I', 'T', 'A');
        int indexCari = 0;
        int totalSofita = 0;
        int totalSofitaSekaliIterasi = 0;

        ArrayList<Character> hurufInput = new ArrayList<Character>();
        for (int i = 0; i < N; i++) {
            hurufInput.add(x[i]);
        }

        List<Integer> indexTiapHuruf = new ArrayList<Integer>();

        int index = 0;
        while (index < hurufInput.size()) {

            if (hurufInput.get(index) == hurufSofita.get(indexCari)) {
                int realIndex = index - indexTiapHuruf.size();
                indexTiapHuruf.add(realIndex);

                if (indexCari == 5) {
                    totalSofita += 1;
                    totalSofitaSekaliIterasi += 1;
                    indexCari = 0;

                    // hapus sofita yg ditemukan dari hurufInput
                    // berdasarkan indexTiapHuruf nya
                    for (int j : indexTiapHuruf) {
                        hurufInput.remove(j);
                    }

                    index = index - 6;
                    indexTiapHuruf = new ArrayList<Integer>();
                }

                else {
                    indexCari += 1;
                }
            }
            index += 1;

            // sudah sampai huruf terakhir di hurufInput
            if (index == hurufInput.size()) {

                // kembali dari awal
                if (totalSofitaSekaliIterasi > 0) {
                    totalSofitaSekaliIterasi = 0;
                    index = 0;
                }
            }
        }

        int totalHurufSofitaDitemukan = 6 * totalSofita;
        
        return N - totalHurufSofitaDitemukan;
    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        in = new InputReader(inputStream);
        OutputStream outputStream = System.out;
        out = new PrintWriter(outputStream);

        // Read value of N
        int N = in.nextInt();

        // Read value of x
        char[] x = new char[N];
        for (int i = 0; i < N; ++i) {
            x[i] = in.next().charAt(0);
        }

        int ans = getTotalDeletedLetters(N, x);
        out.println(ans);

        // don't forget to close/flush the output
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