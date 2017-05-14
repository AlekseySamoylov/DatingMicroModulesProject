package com.alekseysamoylov.dating.root.util;

import com.alekseysamoylov.dating.root.model.Customer;

/**
 * Functional interface example
 */
@FunctionalInterface
public interface CustomerInfoFormatter {
    String getFormatName(Customer customer);
}
