package com.masbed.libcommerce.util;

import java.util.Collection;

public class StandardError {

    private Collection<String> messages;

    public StandardError(Collection<String> messages){
        this.messages = messages;
    }

    public Collection<String> getMessages() {
        return messages;
    }
}
