class FibIteration implements FindFib {
    @Override
    public int calculate_fib(int n) {

        if (n <= 2)
            return 1;

        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}