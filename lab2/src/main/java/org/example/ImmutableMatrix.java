package org.example;

import java.util.Arrays;

public final class ImmutableMatrix extends matrix {
    public ImmutableMatrix(int rows, int columns) {
        super(rows, columns);
    }

    public ImmutableMatrix(matrix old) {
        super(old);
    }

    public ImmutableMatrix(double[][] old) {
        super(old);
    }

    @Override
    public void fill_one(int i, int j, double value) {
        throw new UnsupportedOperationException("ImmutableMatrix is immutable, and its contents cannot be modified.");
    }

    // Оператори змінення об'єкта matrix перекриваються та піднімають виняткову ситуацію UnsupportedOperationException.
    @Override
    public void fill(double[][] values) {
        throw new UnsupportedOperationException("ImmutableMatrix is immutable, and its contents cannot be modified.");
    }

    @Override
    public void fillRandom() {
        throw new UnsupportedOperationException("ImmutableMatrix is immutable, and its contents cannot be modified.");
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ImmutableMatrix)) return false;
        return false;
    }
}
