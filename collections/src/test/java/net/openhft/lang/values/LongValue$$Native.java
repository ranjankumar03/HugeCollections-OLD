/*
 * Copyright 2013 Peter Lawrey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.openhft.lang.values;

import static net.openhft.lang.Compare.*;

import net.openhft.lang.io.Bytes;
import net.openhft.lang.io.serialization.BytesMarshallable;
import net.openhft.lang.model.Byteable;
import net.openhft.lang.model.Copyable;

public class LongValue$$Native implements LongValue, BytesMarshallable, Byteable, Copyable<net.openhft.lang.values.LongValue> {
    private static final int VALUE = 0;

    private Bytes _bytes;
    private long _offset;

    public void setOrderedValue(long $) {
        _bytes.writeOrderedLong(_offset, $);
    }

    public long getVolatileValue() {
        return _bytes.readVolatileLong(_offset);
    }

    public void setValue(long $) {
        _bytes.writeLong(_offset + VALUE, $);
    }

    public long getValue() {
        return _bytes.readLong(_offset + VALUE);
    }

    public long addValue(long $) {
        return _bytes.addLong(_offset + VALUE, $);
    }

    public long addAtomicValue(long $) {
        return _bytes.addAtomicLong(_offset + VALUE, $);
    }

    public boolean compareAndSwapValue(long _1, long _2) {
        return _bytes.compareAndSwapLong(_offset + VALUE, _1, _2);
    }

    @Override
    public void copyFrom(net.openhft.lang.values.LongValue from) {
        setOrderedValue(from.getVolatileValue());
        setValue(from.getValue());
    }

    @Override
    public void writeMarshallable(Bytes out) {
        out.writeLong(getVolatileValue());
        out.writeLong(getValue());
    }

    @Override
    public void readMarshallable(Bytes in) {
        setOrderedValue(in.readLong());
        setValue(in.readLong());
    }

    @Override
    public void bytes(Bytes bytes, long offset) {
        this._bytes = bytes;
        this._offset = offset;
    }

    @Override
    public Bytes bytes() {
        return _bytes;
    }

    @Override
    public long offset() {
        return _offset;
    }

    @Override
    public int maxSize() {
        return 16;
    }

    public int hashCode() {
        long lhc = longHashCode();
        return (int) ((lhc >>> 32) ^ lhc);
    }

    public long longHashCode() {
        return (calcLongHashCode(getVolatileValue())) * 10191 +
                calcLongHashCode(getValue());
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LongValue)) return false;
        LongValue that = (LongValue) o;

        if (!isEqual(getVolatileValue(), that.getVolatileValue())) return false;
        if (!isEqual(getValue(), that.getValue())) return false;
        return true;
    }

    public String toString() {
        if (_bytes == null) return "bytes is null";
        StringBuilder sb = new StringBuilder();
        sb.append("LongValue{ ");
        sb.append("__vol__Value= ").append(getVolatileValue());
        sb.append(", ")
        ;
        sb.append("value= ").append(getValue());
        sb.append(" }");
        return sb.toString();
    }
}