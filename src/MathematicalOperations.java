public class MathematicalOperations {
    public static void main(String[] args) {
        MathOperations<Double> x = new MathOperations();
        System.out.println(x.add(1d,2d));
    }
}
class MathOperations<T extends Number> {

    // Method to add two numbers
    public T add(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        } else if (a instanceof Float) {
            return (T) Float.valueOf(a.floatValue() + b.floatValue());
        } else if (a instanceof Long) {
            return (T) Long.valueOf(a.longValue() + b.longValue());
        } else if (a instanceof Short) {
            return (T) Short.valueOf((short) (a.shortValue() + b.shortValue()));
        } else if (a instanceof Byte) {
            return (T) Byte.valueOf((byte) (a.byteValue() + b.byteValue()));
        } else {
            throw new UnsupportedOperationException("Unsupported numeric type");
        }
    }

    // Method to subtract two numbers
    public T subtract(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() - b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
        } else if (a instanceof Float) {
            return (T) Float.valueOf(a.floatValue() - b.floatValue());
        } else if (a instanceof Long) {
            return (T) Long.valueOf(a.longValue() - b.longValue());
        } else if (a instanceof Short) {
            return (T) Short.valueOf((short) (a.shortValue() - b.shortValue()));
        } else if (a instanceof Byte) {
            return (T) Byte.valueOf((byte) (a.byteValue() - b.byteValue()));
        } else {
            throw new UnsupportedOperationException("Unsupported numeric type");
        }
    }

    // Method to multiply two numbers
    public T multiply(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() * b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
        } else if (a instanceof Float) {
            return (T) Float.valueOf(a.floatValue() * b.floatValue());
        } else if (a instanceof Long) {
            return (T) Long.valueOf(a.longValue() * b.longValue());
        } else if (a instanceof Short) {
            return (T) Short.valueOf((short) (a.shortValue() * b.shortValue()));
        } else if (a instanceof Byte) {
            return (T) Byte.valueOf((byte) (a.byteValue() * b.byteValue()));
        } else {
            throw new UnsupportedOperationException("Unsupported numeric type");
        }
    }

}