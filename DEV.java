class DEV {

    static String Complement(String bit) {
        String newbitwise = "";
        for (int i = 0; i < bit.length(); i++) {
            if (bit.charAt(i) == '0')
                newbitwise += '1';
            else if (bit.charAt(i) == '1')
                newbitwise += '0';
        }
        return newbitwise;
    }

    static void Davison(int n) {
        String bitwise = "0";
        if (n == -1) {
            return;
        } else {

            for (int i = 0; i < n; i++) {
                bitwise += Complement(bitwise);
            }
            Davison(n - 1);
        }
        System.out.println(bitwise);

    }

    public static void main(String[] args) {
        if (args.length != 1)
            System.out.println("Usage: java Dav <number>");
        else {
            int d = Integer.parseInt(args[0]);
            Davison(d);
        }

    }
}