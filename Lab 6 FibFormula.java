class FibFormula implements FindFib {
    @Override
    public int calculate_fib(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;
        return (int) Math.round((Math.pow(phi, n) - Math.pow(1 - phi, n)) / sqrt5);
    }
}
