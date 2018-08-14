package at.yeoman.map.rethrow;

public class Rethrow {
    public static interface ThrowingSupplier<T> {
        T call() throws Exception;
    }

    public static <T> T rethrow(ThrowingSupplier<T> supplier) {
        try {
            return supplier.call();
        } catch (RuntimeException exception) {
            throw exception;
        } catch (Exception original) {
            throw new RuntimeException(original);
        }
    }
}
