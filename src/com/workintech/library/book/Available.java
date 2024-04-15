package com.workintech.library.book;

import com.workintech.library.person.Reader;

public interface Available {
    boolean isAvailable();
    boolean canBorrow(Reader reader);
}
