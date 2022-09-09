import java.io.*;
import java.util.StringTokenizer;

public class Lab0 {
    private static InputReader in;
    private static PrintWriter out;

    static long multiplyMod(int N, int Mod, int[] x) {

        // Variabel untuk menampung hasil operasi hitung antar angka yang diinput
        long hasil_hitung = 1;

        // Mengalikan antar angka yang diinput kemudian di modulo 1000000007
        for (int i = 0; i < N; ++i) {
            hasil_hitung = ((hasil_hitung % Mod) * (x[i] % Mod)) % Mod;
        }

        return hasil_hitung;
    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        in = new InputReader(inputStream);
        OutputStream outputStream = System.out;
        out = new PrintWriter(outputStream);

        // Read value of N
        int N = in.nextInt();

        // Read value of x
        int[] x = new int[N];
        for (int i = 0; i < N; ++i) {
            x[i] = in.nextInt();
        }

        // TODO: implement method multiplyMod(int, int, int[]) to get the answer
        long ans = multiplyMod(N, (int) (1e9+7), x);
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