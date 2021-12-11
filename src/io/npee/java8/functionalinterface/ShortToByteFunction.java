package io.npee.java8.functionalinterface;

@FunctionalInterface
public interface ShortToByteFunction {
    byte applyAsByte(short s);
}